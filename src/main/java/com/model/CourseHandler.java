package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import com.entity.Course;
import com.entity.CourseGuideline;
import com.entity.CourseInformation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Component;

@Component
public class CourseHandler {
    private List<Course> courses;

    @PostConstruct
    public void initialize() throws IOException {
        this.courses = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("courses.json"));
            Gson parser = new Gson();

            String raw_data = input.useDelimiter("\\A").next();
            JsonArray data = parser.fromJson(raw_data, JsonArray.class);

            Map<String, String> key_map = this.keyMap();

            for (int i = 0; i < data.size(); i++) {
                String json_string;
                JsonObject element;

                element = data.get(i).getAsJsonObject();
                json_string = element.get("basic_information").toString();

                for (String key : key_map.keySet()) {
                    json_string = json_string.replace(key, key_map.get(key));
                }

                CourseInformation information = parser.fromJson(json_string, CourseInformation.class);

                element = data.get(i).getAsJsonObject();
                json_string = element.get("curriculum_guidelines").toString();

                for (String key : key_map.keySet()) {
                    json_string = json_string.replace(key, key_map.get(key));
                }

                CourseGuideline guideline = parser.fromJson(json_string, CourseGuideline.class);

                this.courses.add(new Course(information, guideline));
            }

            if (input != null) {
                input.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Courses.json Not Found");
            System.exit(1);
        }
    }

    private Map<String, String> keyMap() {
        Map<String, String> result = new HashMap<String, String>();

        result.put("year_semester", "yearSemester");
        result.put("course_id", "id");
        result.put("faculty_name", "facultyName");
        result.put("professor", "professor");
        result.put("course_name", "name");
        result.put("grade", "grade");
        result.put("credit", "credit");
        result.put("hour", "hour");
        result.put("max_students", "maxStudents");
        result.put("min_students", "minStudents");
        result.put("students", "students");
        result.put("category", "category");
        result.put("duration", "duration");
        result.put("internship", "internship");
        result.put("class_schedule", "classSchedule");
        result.put("classroom", "classroom");
        result.put("main_field", "mainField");
        result.put("sub_field", "subField");
        result.put("description", "description");
        result.put("co_professors", "coProfessors");

        result.put("objective", "objective");
        result.put("pre_course", "preCourse");
        result.put("outline", "outline");
        result.put("teaching_method", "teachingMethod");
        result.put("reference", "reference");
        result.put("syllabus", "syllabus");
        result.put("evaluation", "evaluation");
        result.put("reference_link", "referenceLink");

        return result;
    }

    public List<Course> getCourses() {
        return this.courses;
    }
}