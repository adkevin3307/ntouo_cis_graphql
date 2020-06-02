package com.entity;

public class Course {
    private CourseInformation information;
    private CourseGuideline guideline;

    public Course(CourseInformation information, CourseGuideline guideline) {
        this.information = information;
        this.guideline = guideline;
    }

    public CourseInformation getInformation() {
        return this.information;
    }

    public void setInformation(CourseInformation information) {
        this.information = information;
    }

    public CourseGuideline getGuideline() {
        return this.guideline;
    }

    public void setGuideline(CourseGuideline guideline) {
        this.guideline = guideline;
    }

    @Override
    public String toString() {
        return "{" +
            " information='" + information + "'" +
            ", guideline='" + guideline + "'" +
            "}";
    }

}