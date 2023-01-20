package work1;

import java.util.Arrays;

public class workTest {
    public static void main(String[] args) {
        Student[] arrStudents = new Student[6];
        arrStudents[0] = new Student(10001, "sum", 23, "西安");
        arrStudents[1] = new Student(10020, "li", 11, "北京");
        arrStudents[2] = new Student(10012, "wang", 24, "成都");
        arrStudents[3] = new Student(10013, "hung", 77, "武汉");
        arrStudents[4] = new Student(10017, "fu", 43, "上海");
        arrStudents[5] = new Student(10015, "zhao", 12, "西安");
        System.out.println("排序前");
        for (int i = 0; i < 6; i++) {
            System.out.println(arrStudents[i].toString());
        }
        Arrays.sort(arrStudents);
        System.out.println("排序后");
        for (int i = 0; i < 6; i++) {
            System.out.println(arrStudents[i].toString());
        }
    }
}
