
/*
 * @ (#) Main.java   1.0 21/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

/**
 * @version 1.0
 * @description
 * @author: Trong Men
 * @date: 21/08/2024
 */
public class Main {
    public static void main(String[] args) {
        CourseList courseList = new CourseList(10);
        initData(courseList);
        System.out.printf("%-10s%-10s %-10s %-10s\n", "ID", "Title", "Department", "Credit");
        Course[] temp = courseList.getCourse();
        for (Course c : temp) {
            if(c != null) {
                System.out.println(c);
            }
        }
    }

    private static void initData(CourseList courseList) {
        Course c1 = new Course("C01", "Java", "IT", 3);
        Course c2 = new Course("C02", "C#", "IT", 3);

        courseList.addCourse(c1);
        courseList.addCourse(c2);
    }


}
