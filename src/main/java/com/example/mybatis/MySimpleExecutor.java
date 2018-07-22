package com.example.mybatis;

import java.sql.*;

/**
 * Created by James on 2018/7/22.
 */
public class MySimpleExecutor implements MyExecutor {
    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User test = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arlen?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setLong(1, Long.parseLong(parameter));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                test = new User();
                test.setId(rs.getLong(1));
                test.setUsername(rs.getString(2));
                test.setTelephone(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T)test;
    }
}
