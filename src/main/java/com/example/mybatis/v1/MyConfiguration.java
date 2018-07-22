package com.example.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by James on 2018/7/21.
 */
public class MyConfiguration {

    public <T> T getMapper(Class clazz,MySqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MyMapperProxy(sqlSession));
    }

    static class UserMapperXml{
        public static final String namespace="com.example.mybatis.v1.UserMapper";
        public  static final Map<String,String> methodSqlMapping = new HashMap<>();
        static{
            methodSqlMapping.put("selectByPrimaryKey","SELECT * FROM USER WHERE id = ?");
        }
    }
}
