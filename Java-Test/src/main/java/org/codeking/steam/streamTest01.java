package org.codeking.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : codeking
 * @date : 2023/3/15 21:02
 */

public class streamTest01 {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setAge(11);
        student1.setName("codeking");
        Student student2 = new Student();
        student1.setAge(12);
        student1.setName("codeking");
        Student student3 = new Student();
        student1.setAge(13);
        student1.setName("codeking");
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        List<Integer> list1 = list.stream().map(Student::getAge).collect(Collectors.toList());
        System.out.println(list1);
        // 转化这个为数组(1,8,-1,5,55,2,3,4,6,7,8)
        // 定义长度为10 的数组，并添加10个元素
        int[] arr = {1, 8, -1, 5, 55, 2, 3, 4, 6, 7, 8};
        int[] bubbleSort = BubbleSort.bubbleSort(arr);

        System.out.println("bubbleSort:" + Arrays.toString(bubbleSort));
    }
}

class Student {
    private int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 定义一个冒泡排序
class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    // 写一个弗洛伊德求最短路径的算法
    public static int[] floyd(int[][] graph) {
        int n = graph.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        return graph[0];
    }
}
