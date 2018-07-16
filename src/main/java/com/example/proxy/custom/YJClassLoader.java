package com.example.proxy.custom;


import java.io.*;

/**
 * Created by James on 2018/7/14.
 */
public class YJClassLoader extends ClassLoader {
    private File classPathFile;

    public YJClassLoader() {
        String classPath = YJClassLoader.class.getResource("").getPath();
        System.out.println("classpath is;"+classPath);
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = YJClassLoader.class.getPackage().getName() + "." + name;
        System.out.println("class name is:"+className);
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            System.out.println("classfile to string:"+classFile.toString());
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    Class<?> clazz = defineClass(className, out.toByteArray(), 0, out.size());
                    System.out.println(clazz);
                    return clazz;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != in) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != out) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
        return null;
    }
}
