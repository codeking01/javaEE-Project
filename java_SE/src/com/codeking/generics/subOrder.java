package com.codeking.generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : codeking
 * @date : 2022/11/10 16:45
 */
public class subOrder<Integer> extends Order<Integer> {

    public static<E> @NotNull List<E> copyArrayList(E @NotNull [] i){
        ArrayList<E> list = new ArrayList<>();
        for (E item : i) {
            list.add(item);
        }
        return list;
    }
}
