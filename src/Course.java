
/*
 * @ (#) Course.java   1.0 21/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

/**
 * @version 1.0
 * @description
 * @author: Trong Men
 * @date: 21/08/2024
 */
public class Course {
    private String id;
    private String title;
    private String department;

    private int credit;

    public Course(String id, String title, String department, int credit) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.credit = credit;
    }

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id!=null || !id.matches("[a-zA-Z0-9]{3,}")){
            throw new IllegalArgumentException("ID must have at least 3 characters or ID must contain only letters or digits");
        }
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        if(credit < 0){
            throw new IllegalArgumentException("Credit must be greater than 0");
        }

        this.credit = credit;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s %-10s %-10s", id, title, department, credit);
    }
}
