package com.example.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2018/7/15.
 */
public class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws Exception{
        return this.dataSource.getConnection();
    }

    private List<?>  parseResultSet(ResultSet rs, RowMapper rowMapper) throws Exception{
        List<Object> result = new ArrayList<>();
        int rownum=1;
        while(rs.next()){
            result.add(rowMapper.mapRow(rs,rownum++));
        }
        return result;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper,Object[] values) throws Exception{
        List<?> result = null;
        try {
            //1.获取数据库连接
            Connection conn = this.getConnection();
            //2. 创建语句集
            PreparedStatement pstmt = createPreparedStatement(sql, conn);
            //3. 执行语句集，并且或得结果集
            ResultSet rs = executeQuery(pstmt,values);
            //4. 解析结果集
            result = this.parseResultSet(rs,rowMapper);
            //5. 关闭结果集
            closeResultSet(rs);
            //6. 关闭语句集
            closeStatement(pstmt);
            //7. 关闭连接
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return result;
    }

    private void closeStatement(PreparedStatement pstmt) throws SQLException {
        pstmt.close();
    }

    private void closeResultSet(ResultSet rs) throws SQLException {
        rs.close();
    }

    private ResultSet executeQuery(PreparedStatement pstmt,Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i,values[i]);
        }
        return pstmt.executeQuery();
    }

    private PreparedStatement createPreparedStatement(String sql, Connection conn) throws SQLException {
        return conn.prepareStatement(sql);
    }

   // public  abstract Object processResult(ResultSet rs,int rownum) throws Exception;

}
