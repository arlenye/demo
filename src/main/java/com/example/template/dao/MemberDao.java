package com.example.template.dao;

import com.example.template.JdbcTemplate;
import com.example.template.RowMapper;
import com.example.template.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by James on 2018/7/15.
 */
public class MemberDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null) ;


    public List<?> query()throws Exception{
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setTelephone(rs.getString("telephone"));
                return member;
            }
        }, null);
    }

}
