package com.example.mybatis;

/**
 * Created by James on 2018/7/21.
 */
public class MySqlSession {
    private MyConfiguration configuration;
    private MyExecutor  executor;

    public MySqlSession(MyConfiguration configuration, MyExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }


    public <T> T getMapper(Class clazz,MySqlSession sqlSession){
        return configuration.getMapper(clazz,sqlSession);
    }
    public  <T> T selectOne(String statement,String parameter){
        return executor.query(statement,parameter);
    }
}
