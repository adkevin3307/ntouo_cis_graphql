package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.entity.Course;
import com.entity.CourseGuideline;
import com.entity.CourseInformation;
import com.google.common.base.Predicate;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Component;

@SuppressWarnings("unchecked")
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
        result.put("class_schedule", "schedule");
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

    public List<Course> getCourses(Map<String, Object> filter) {
        Stream<Course> result = this.courses.stream();

        if (filter.containsKey("id")) {
            result = result.filter(
                course -> course.getInformation().getId().contains(filter.get("id").toString())
            );
        }
        if (filter.containsKey("name")) {
            Predicate<Course> condition_1 = course -> course.getInformation().getName().get("english")
                .contains(filter.get("name").toString());
            Predicate<Course> condition_2 = course -> course.getInformation().getName().get("chinese")
                .contains(filter.get("name").toString());

            result = result.filter(
                condition_1.or(condition_2)
            );
        }
        if (filter.containsKey("facultyName")) {
            result = result.filter(
                course -> course.getInformation().getFacultyName().contains(filter.get("facultyName").toString())
            );
        }
        if (filter.containsKey("professor")) {
            result = result.filter(
                course -> course.getInformation().getProfessor().contains(filter.get("professor").toString())
            );
        }
        if (filter.containsKey("mainField")) {
            result = result.filter(
                course -> course.getInformation().getMainField().contains(filter.get("mainField").toString())
            );
        }
        if (filter.containsKey("subField")) {
            result = result.filter(
                course -> course.getInformation().getSubField().contains(filter.get("subField").toString())
            );
        }
        if (filter.containsKey("description")) {
            result = result.filter(
                course -> course.getInformation().getDescription().contains(filter.get("description").toString())
            );
        }
        if (filter.containsKey("grade")) {
            result = result.filter(
                course -> course.getInformation().getGrade().contains(filter.get("grade").toString())
            );
        }
        if (filter.containsKey("category")) {
            result = result.filter(
                course -> course.getInformation().getCategory().contains(filter.get("category").toString())
            );
        }
        if (filter.containsKey("schedule")) {
            ArrayList<String> schedules = (ArrayList<String>) filter.get("schedule");

            List<Course> temp = result.collect(Collectors.toList());
            ArrayList<Course> output = new ArrayList<Course>();

            for (int i = 0; i < temp.size(); i++) {
                for (String schedule : schedules) {
                    if (temp.get(i).getInformation().getSchedule().contains(schedule)) {
                        output.add(temp.get(i));
                        break;
                    }
                }
            }

            result = output.stream();
        }
        if (filter.containsKey("classroom")) {
            ArrayList<String> classrooms = (ArrayList<String>) filter.get("classroom");

            List<Course> temp = result.collect(Collectors.toList());
            ArrayList<Course> output = new ArrayList<Course>();

            for (int i = 0; i < temp.size(); i++) {
                for (String classroom : classrooms) {
                    if (temp.get(i).getInformation().getSchedule().contains(classroom)) {
                        output.add(temp.get(i));
                        break;
                    }
                }
            }

            result = output.stream();
        }

        return result.collect(Collectors.toList());
    }
}