package com.example.mybatis.v1;

/**
 * Created by James on 2018/7/21.
 */
public interface UserMapper {
    User selectByPrimaryKey(Long id);
}
