package com.codeking.reflection;

import java.io.Serializable;

/**
 * @author : codeking
 * @date : 2022/11/14 18:34
 */
public abstract class Creature<T> implements Serializable {
    private char gender;
    private float weight;

    public void eat(){
        System.out.println("我可以吃！");
    }

    public void breath(){
        System.out.println("我可以呼吸！");
    }
}
