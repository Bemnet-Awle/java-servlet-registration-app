/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hrs.bemni.proj.studentapp;



public class Student {
    private int id;
    private String name;
    private String email;
    private int year;

    public Student(int id, String name, String email, int year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.year = year;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getYear() { return year; }
}