package com.codeking.DataStructure;

/**
 * @author CodeKing
 * @since 2023/4/10  10:03
 */
public class Result<T> {
    public static void main(String[] args) {
        Result<String> result = new Result<>();
        result.setName("成功");
        System.out.println("result = " + result);
    }
    private String name;

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Result() {
    }

    public Result(String name) {
        this.name = name;
    }



    public static <T> Result<T> ok(String stat) {
        Result<T> res = new Result<>();
        res.setName(stat);
        return res;
    }
}
