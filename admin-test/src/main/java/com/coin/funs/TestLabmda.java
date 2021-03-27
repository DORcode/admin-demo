package com.coin.funs;

/**
 * @ClassName TestLabmda
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/27 10:23
 * @Version V1.0
 **/
public class TestLabmda {

    public static void main(String[] args) {
        StudentDao studentDao = student -> System.out.println("student = " + student);
        StudentDao studentDao1 = (student) -> System.out.println("student1 = " + student);
        StudentDao studentDao2 = (Student student) -> { System.out.println("student2 = " + student); };

        studentDao.insert(new Student());
        studentDao1.insert(new Student());
        studentDao2.insert(new Student());
    }

    static class Student {

    }

    @FunctionalInterface
    interface StudentDao {
        void insert(Student student);
    }
}
