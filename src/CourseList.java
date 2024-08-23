
/*
 * @ (#) CourseList.java   1.0 21/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version 1.0
 * @description
 * @author: Trong Men
 * @date: 21/08/2024
 */
public class CourseList {
    private Course[] courses;
    private int count;

    public CourseList(int i) {
        courses = new Course[10];
        count = 0;
    }
    //add course
   public boolean addCourse(Course course){
        //check if course if null
        if(course == null){
            return false;
        }
        //check if course already exists
       if(isExists(course)){
           return false;
       }
         //check if the array is full
        if(count == courses.length) {
            return false;
        }
        courses[count++] = course;
        return true;
   }
    //check if course already exists
    private boolean isExists(Course course) {
        for (int i = 0; i < count; i++) {
            if(courses[i].getId().equals(course.getId())){
                return true;
            }
        }
        return false;
    }



    //remove course
    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }

    //search course by Id
    public Course findCourseById(String id) {
        for (Course c : courses) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    //search course by Title
    public Course findCourseByTitle(String title){
        for(Course c: courses){
            if(c.getTitle().equals(title)){
                return c;
            }
        }
        return null;
    }


    //search course by Department
    public Course findCourseByDepartment(String department){
        for(Course c:courses){
            if(c.getDepartment().equals(department)){
                return c;
            }
        }
        return null;
    }

    //sort course by Title
    public Course[] sortCourse(){
        Course[] sortC = Arrays.copyOf(courses, count);
        Arrays.sort(sortC, (course1,course2) -> course1.getTitle().compareToIgnoreCase(course2.getTitle()));
        return sortC;
    }

    //find Department with most courses
    public String findDepartmentWithMostCourses(){
        return null;
    }
    //get all courses
    public Course[] getCourse() {
        return courses;
    }
}
