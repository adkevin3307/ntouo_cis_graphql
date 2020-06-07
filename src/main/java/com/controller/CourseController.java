package com.controller;

import java.net.URI;

import com.entity.Course;
import com.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping("/api")
    public ResponseEntity<Course> createCourse(@RequestBody(required = true) String data) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/api").buildAndExpand().toUri();

        return ResponseEntity.created(location).body(this.service.createCourse(data));
    }

    @PutMapping("/api")
    public ResponseEntity<Course> replaceCourse(@RequestBody(required = true) String data) {
        return ResponseEntity.ok(this.service.replaceCourse(data));
    }

    @DeleteMapping("/api")
    public ResponseEntity<Course> deleteCourse(@RequestBody(required = true) String data) {
        this.service.deleteCourse(data);

        return ResponseEntity.noContent().build();
    }

}