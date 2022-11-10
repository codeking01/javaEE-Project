package com.codeking.assemblages;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author : codeking
 * @date : 2022/11/9 15:25
 */
public class TreeSetExercise {
    @Test
    public void testEmployees() {
        Employee employee1 = new Employee("张三", 18, new MyDate(1999, 5, 30));
        Employee employee2 = new Employee("张四", 18, new MyDate(1998, 6, 30));
        Employee employee3 = new Employee("张五", 18, new MyDate(2000, 6, 28));
        Employee employee4 = new Employee("张六", 18, new MyDate(1997, 5, 28));
        Employee employee5 = new Employee("张七", 18, new MyDate(1995, 7, 30));
        TreeSet set = new TreeSet();
        // 自然排序
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);
        for (Object employee : set) {
            System.out.println(employee);
        }
    }

    @Test
    public void testBirthday() {
        // 定制排序 按照日期排 通过重写Comparator()接口
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    return b1.compareTo(b2);
                }
                throw new RuntimeException("类型不一致");
            }
        });
        Employee employee1 = new Employee("张三", 18, new MyDate(1999, 5, 30));
        Employee employee2 = new Employee("张四", 18, new MyDate(1998, 6, 30));
        Employee employee3 = new Employee("张五", 18, new MyDate(2000, 6, 28));
        Employee employee4 = new Employee("张六", 18, new MyDate(1997, 5, 28));
        Employee employee5 = new Employee("张七", 18, new MyDate(1995, 7, 30));
        // 自然排序
        set.add(employee1);
        set.add(employee2);
        set.add(employee3);
        set.add(employee4);
        set.add(employee5);
        for (Object employee : set) {
            System.out.println(employee);
        }
    }
}

class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyDate myDate = (MyDate) o;

        if (year != myDate.year) {
            return false;
        }
        if (month != myDate.month) {
            return false;
        }
        return day == myDate.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate other = (MyDate) o;
            //  比较年
            int minYear = this.getYear() - other.getYear();
            if (minYear != 0) {
                return minYear;
            }
            // 比较月
            int minMonth = this.getMonth() - other.getMonth();
            if (minMonth != 0) {
                return minMonth;
            }
            return this.getDay() - other.getDay();
        }
        throw new RuntimeException("比较对象的类型不一致！");
    }
}


class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        if (age != employee.age) {
            return false;
        }
        if (name != null ? !name.equals(employee.name) : employee.name != null) {
            return false;
        }
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        // 按照name排序
        if (o instanceof Employee) {
            Employee other = (Employee) o;
            return this.name.compareTo(other.name);
        }
        throw new RuntimeException("比较对象的类型不一致！");
    }
}
