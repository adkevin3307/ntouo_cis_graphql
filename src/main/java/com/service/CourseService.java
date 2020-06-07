package com.service;

import com.entity.Course;
import com.model.CourseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseHandler handler;

    public CourseService(CourseHandler handler) {
        this.handler = handler;
    }

    public Course createCourse(String data) {
        return this.handler.createCourse(data);
    }

    public Course replaceCourse(String data) {
        return this.handler.replaceCourse(data);
    }

    public void deleteCourse(String data) {
        this.handler.deleteCourse(data);
    }
}