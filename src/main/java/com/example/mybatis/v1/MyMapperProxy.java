package com.example.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by James on 2018/7/21.
 */
public class MyMapperProxy implements InvocationHandler {
    private MySqlSession sqlSession;

    public MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(MyConfiguration.UserMapperXml.namespace)){
            String sql = MyConfiguration.UserMapperXml.methodSqlMapping.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
