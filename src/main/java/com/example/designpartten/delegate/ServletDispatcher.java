package com.example.designpartten.delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2018/7/17.
 */
public class ServletDispatcher {
    private List<Handler> handlerMapping = new ArrayList<>();

    public ServletDispatcher(){
        try {
            Class<?> memberActionClass = MemberAction.class;
            handlerMapping.add(new Handler()
                    .setController(memberActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getmemberById",new Class[]{String.class} ))
                    .setUrl("web/getMemberById.json"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response){
        doDispatch(request,response);
    }
    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
        //1.获取用户请求URL（原来J2EE的标准是，每个url对应一个servlet，url由浏览器输入）
        //2.servlet拿到url以后，要权衡判断做选择
        //根据用户请求的url，去找某个Java类的某个方法。
        //3.通过拿到的URl去handlerMapping去找，把它认为是一个策略常量
        //4. 将具体的任务分发给method,通过反射区调用其对应的方法
        //5.获取到method的执行结果，通过response返回
    }
    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
