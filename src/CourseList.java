
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
        courses = new Course[i];
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
        int index = -1;
        // Find the index of the course to remove
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }
        for (int j = index; j < count - 1; j++) {
            courses[j] = courses[j + 1];
        }

        courses[count - 1] = null;
        count--;

        return true;
    }

    //find course by Id
    public Course findCourseById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    //find course by Title
    public Course findCourseByTitle(String title){
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equals(title)) {
                return courses[i];
            }
        }
        return null;
    }


    //find course by Department
    public Course findCourseByDepartment(String department){
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equals(department)) {
                return courses[i];
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
        int[] countDepartment = new int[count];
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                if(courses[i].getDepartment().equals(courses[j].getDepartment())){
                    countDepartment[i]++;
                }
            }
        }
        int max = 0;
        int index = 0;
        for(int i = 0; i < count; i++){
            if(countDepartment[i] > max){
                max = countDepartment[i];
                index = i;
            }
        }

        return courses[index].getDepartment();

    }
    //find course with highest credit
    public Course findCourseWithHighestCredit(){
        int max = 0;
        int index = 0;
        for(int i = 0; i < count; i++){
            if(courses[i].getCredit() > max){
                max = courses[i].getCredit();
                index = i;
            }
        }
        return courses[index];
    }
    //get all courses
    public Course[] getCourse() {
        return courses;
    }
}
