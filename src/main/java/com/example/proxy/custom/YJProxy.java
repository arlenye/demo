package com.example.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by James on 2018/7/14.
 */
public class YJProxy {
    public static String ln = "\r\n";

    /**
     * 1. 动态生成源代码.java文件
     * 2. java文件输出到磁盘
     * 3. 把生成的java文件编译成。class文件
     * 4. 编译生成的class文件加载到JVM
     * 5. 返回字节码重组以后的性的代理对象
     *
     * @param classLoader
     * @param interfaces
     * @param handler
     * @return
     */
    public static Object newProxyInstance(YJClassLoader classLoader, Class<?>[] interfaces, YJInvocationHandler handler) {

        try {
// 1. 动态生成源代码.java文件
            String src = generateSrc(interfaces);
            // 2. java文件输出到磁盘
            String filePath = YJProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
            //3. 把生成的java文件编译成。class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task  =compiler.getTask(null,manage,null,null,null,iterable);
            task.call();
            manage.close();
            // 4. 编译生成的class文件加载到JVM
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(YJInvocationHandler.class);

            f.delete();
            // 5. 返回字节码重组以后的性的代理对象
            return c.newInstance(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.example.proxy.customs;").append(ln);
        sb.append("import com.example.proxy.Person;").append(ln);
        sb.append("import java.lang.reflect.Method;").append(ln);
        sb.append("import com.example.proxy.custom.YJInvocationHandler;").append(ln);
        sb.append("public class $Proxy0 implements ").append(interfaces[0].getName()).append("{").append(ln);
        sb.append("private YJInvocationHandler h;").append(ln);
        sb.append("public $Proxy0(YJInvocationHandler h){").append(ln);
        sb.append("this.h=h;");
        sb.append("}").append(ln);

        for (Method m : interfaces[0].getMethods()) {
            sb.append("public ").append(m.getReturnType().getName()).append(" ")
                    .append(m.getName()).append("() {").append(ln);
            sb.append("try{").append(ln);
            sb.append("Method m=" + interfaces[0].getName()).append(".class.getMethod(\"").append(m.getName()).append("\"").append(",new Class[]{});").append(ln);
            sb.append("this.h.invoke(this,m,null);").append(ln);
            sb.append("}catch(Throwable e){").append(ln);
            sb.append("e.printStackTrace();").append(ln);
            sb.append("}");
            sb.append("}");
        }

        sb.append("}").append(ln);

        return sb.toString();
    }
}
