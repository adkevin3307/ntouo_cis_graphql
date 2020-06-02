package com.entity;

import java.util.ArrayList;
import java.util.Map;

public class CourseInformation {
    private String id;
    private String yearSemester;
    private String facultyName;
    private String professor;
    private Map<String, String> name;
    private String grade;
    private int credit;
    private int hour;
    private int maxStudents;
    private int minStudents;
    private int students;
    private String category;
    private String duration;
    private String internship;
    private ArrayList<String> classSchedule;
    private ArrayList<String> classroom;
    private String mainField;
    private String subField;
    private String description;
    private ArrayList<String> coProfessors;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYearSemester() {
        return this.yearSemester;
    }

    public void setYearSemester(String yearSemester) {
        this.yearSemester = yearSemester;
    }

    public String getFacultyName() {
        return this.facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Map<String,String> getName() {
        return this.name;
    }

    public void setCourseName(Map<String,String> courseName) {
        this.name = courseName;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCredit() {
        return this.credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getMinStudents() {
        return this.minStudents;
    }

    public void setMinStudents(int minStudents) {
        this.minStudents = minStudents;
    }

    public int getStudents() {
        return this.students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getInternship() {
        return this.internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }

    public ArrayList<String> getClassSchedule() {
        return this.classSchedule;
    }

    public void setClassSchedule(ArrayList<String> classSchedule) {
        this.classSchedule = classSchedule;
    }

    public ArrayList<String> getClassroom() {
        return this.classroom;
    }

    public void setClassroom(ArrayList<String> classroom) {
        this.classroom = classroom;
    }

    public String getMainField() {
        return this.mainField;
    }

    public void setMainField(String mainField) {
        this.mainField = mainField;
    }

    public String getSubField() {
        return this.subField;
    }

    public void setSubField(String subField) {
        this.subField = subField;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getCoProfessors() {
        return this.coProfessors;
    }

    public void setCoProfessors(ArrayList<String> coProfessors) {
        this.coProfessors = coProfessors;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", yearSemester='" + yearSemester + "'" +
            ", facultyName='" + facultyName + "'" +
            ", professor='" + professor + "'" +
            ", courseName='" + name + "'" +
            ", grade='" + grade + "'" +
            ", credit='" + credit + "'" +
            ", hour='" + hour + "'" +
            ", maxStudents='" + maxStudents + "'" +
            ", minStudents='" + minStudents + "'" +
            ", students='" + students + "'" +
            ", category='" + category + "'" +
            ", duration='" + duration + "'" +
            ", internship='" + internship + "'" +
            ", classSchedule='" + classSchedule + "'" +
            ", classroom='" + classroom + "'" +
            ", mainField='" + mainField + "'" +
            ", subField='" + subField + "'" +
            ", description='" + description + "'" +
            ", coProfessors='" + coProfessors + "'" +
            "}";
    }

}