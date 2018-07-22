package com.example.mybatis;

/**
 * Created by James on 2018/7/22.
 */
public class EntryMain {
    public static void main(String[] args) {
        MySqlSession sqlSession = new MySqlSession(new MyConfiguration(),new MySimpleExecutor());
        UserMapper mapper = sqlSession.getMapper(UserMapper.class,sqlSession);
        User user  = mapper.selectByPrimaryKey(1L);
        System.out.println(user.toString());
    }
}
