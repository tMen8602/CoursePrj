
/*
 * @ (#) Main.java   1.0 21/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

import java.util.Scanner;

/**
 * @version 1.0
 * @description
 * @author: Trong Men
 * @date: 21/08/2024
 */
public class Main {
    public static void main(String[] args) {
        CourseList courseList = new CourseList(10);
//        initData(courseList);

        Scanner sc = new  Scanner(System.in);
        int choice;
        do{
            System.out.println("\n-----------------MENU-----------------");
            System.out.println("1. All course");
            System.out.println("2. Add a new course");
            System.out.println("3. Remove a course");
            System.out.println("4. Find a course by ID");
            System.out.println("5. Find a course by title");
            System.out.println("6. Find a course by department");
            System.out.println("7. Sort course by title");
            System.out.println("8. Find department with most courses");
            System.out.println("9. Exit");
            System.out.println("--------------------------------------");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    displayAllCourse(courseList);
                    break;
                case 2:
                    addNewCourse(courseList, sc);
                    break;
                case 3:
                    removedCourse(courseList);

                    break;
                case 4:
                    searchCourseById(courseList);
                    break;
                case 5:
                    System.out.print("Enter course ID: ");
                    String title = sc.nextLine();
                    Course courseByTitle = courseList.findCourseByTitle(title);
                    if(courseByTitle !=null){
                        System.out.println(courseByTitle);
                    }else{
                        System.out.println("Course with title "+ title +" not found!");
                    }
                    break;
                case 6:
                    System.out.print("Enter course ID: ");
                    String department = sc.nextLine();
                    Course courseDepartment = courseList.findCourseByDepartment(department);
                    if(courseDepartment !=null){
                        System.out.println(courseDepartment);
                    }else{
                        System.out.println("Course with department "+ department +" not found!");
                    }
                    break;
                case 7:
                    Course[] sortC =  courseList.sortCourse();
                    System.out.println("Courses sorted by title:");
                    System.out.printf("%-10s%-10s %-10s %-10s\n", "ID", "Title", "Department", "Credit");
                    for(Course c : sortC){
                        System.out.println(c);
                    }
                    break;
//                case 8:
//                    findDepartmentWithMostCourses(courseList);
//                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
            }
        }while(choice !=0);

    }

    private static void searchCourseById(CourseList courseList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        String idFind = sc.nextLine();
        Course  findCourse = courseList.findCourseById(idFind);
        if(findCourse  !=null){
            System.out.printf("%-10s%-10s %-10s %-10s\n", "ID", "Title", "Department", "Credit");
            System.out.println(findCourse);
        }else{
            System.out.println("Course " + idFind +"not found");
        }

    }

    private static void removedCourse(CourseList courseList) {
        System.out.print("Enter course ID: ");
        Scanner sc = new Scanner(System.in);
        String idRemove = sc.nextLine();
        boolean result = courseList.removeCourse(idRemove);
        if(result){
            System.out.println("Remove successfully!");
        }else{
            System.out.println("Course with ID "+ idRemove +" not found!");
        }
    }

    private static void addNewCourse(CourseList courseList, Scanner sc) {
        System.out.print("Enter id:");
        String id= sc.nextLine();
        System.out.print("Enter title:");
        String title= sc.nextLine();
        System.out.print("Enter department:");
        String department= sc.nextLine();
        System.out.print("Enter credit:");
        int credit= sc.nextInt();

        Course newCourse = new Course(id,title,department,credit);
        boolean rs = courseList.addCourse(newCourse);

        if(rs){
            System.out.println("Add successfully!");

        }else{
            System.out.println("Add failed!");
        }

    }

    private static void displayAllCourse(CourseList courseList) {
        System.out.printf("%-10s%-10s %-10s %-10s\n", "ID", "Title", "Department", "Credit");
        Course[] temp = courseList.getCourse();
        for (Course c : temp) {
            if(c != null) {
                System.out.println(c);
            }
        }
    }

//    private static void initData(CourseList courseList) {
//        Course c1 = new Course("C01", "Java", "IT", 3);
//        Course c2 = new Course("C02", "C#", "IT", 3);
//
//        courseList.addCourse(c1);
//        courseList.addCourse(c2);
//    }


}
