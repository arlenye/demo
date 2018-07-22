package com.example.mybatis;

/**
 * Created by James on 2018/7/21.
 */
public interface UserMapper {
    User selectByPrimaryKey(Long id);
}
