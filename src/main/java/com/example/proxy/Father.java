package com.example.proxy;

/**
 * Created by James on 2018/7/14.
 */
public class Father {
    private Son son;
    public Father(Son son){
      this.son = son;
    }

    public void findLove(){
        System.out.println("根据要求找到");
        this.son.findLove();
        System.out.println("双方父母意见");
    }
}
