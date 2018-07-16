package com.example.singleton;

/**
 * Created by James on 2018/7/12.
 */
public class LazyThree {
    public static final LazyThree getInstance(){
        return LazyHolder.LAZY;
    }
    private static class LazyHolder{
        private static final LazyThree LAZY = new LazyThree();
    }
}
