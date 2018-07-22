package com.example.mybatis;

/**
 * Created by James on 2018/7/21.
 */
public interface MyExecutor {
     <T> T query(String statement, String parameter);
}
