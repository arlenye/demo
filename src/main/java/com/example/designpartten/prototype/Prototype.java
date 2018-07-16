package com.example.designpartten.prototype;

import java.io.*;

/**
 * Created by wb-yejian on 2018/7/13.
 */
public class Prototype implements Cloneable,Serializable{
    private String name;
    private Email email;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }

    public Prototype deepClone() {
        Prototype prototype =null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            prototype =  (Prototype) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return prototype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
