package com.entity;

import java.util.Map;

public class CourseGuideline {
    private Map<String, String> objective;
    private Map<String, String> preCourse;
    private Map<String, String> outline;
    private Map<String, String> teachingMethod;
    private Map<String, String> reference;
    private Map<String, String> syllabus;
    private Map<String, String> evaluation;
    private String referenceLink;

    public Map<String, String> getObjective() {
        return this.objective;
    }

    public void setObjective(Map<String, String> objective) {
        this.objective = objective;
    }

    public Map<String, String> getPreCourse() {
        return this.preCourse;
    }

    public void setPreCourse(Map<String, String> preCourse) {
        this.preCourse = preCourse;
    }

    public Map<String, String> getOutline() {
        return this.outline;
    }

    public void setOutline(Map<String, String> outline) {
        this.outline = outline;
    }

    public Map<String, String> getTeachingMethod() {
        return this.teachingMethod;
    }

    public void setTeachingMethod(Map<String, String> teachingMethod) {
        this.teachingMethod = teachingMethod;
    }

    public Map<String, String> getReference() {
        return this.reference;
    }

    public void setReference(Map<String, String> reference) {
        this.reference = reference;
    }

    public Map<String, String> getSyllabus() {
        return this.syllabus;
    }

    public void setSyllabus(Map<String, String> syllabus) {
        this.syllabus = syllabus;
    }

    public Map<String, String> getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(Map<String, String> evaluation) {
        this.evaluation = evaluation;
    }

    public String getReferenceLink() {
        return this.referenceLink;
    }

    public void setReferenceLink(String referenceLink) {
        this.referenceLink = referenceLink;
    }

    @Override
    public String toString() {
        return "{" +
            " objective='" + objective + "'" +
            ", preCourse='" + preCourse + "'" +
            ", outline='" + outline + "'" +
            ", teachingMethod='" + teachingMethod + "'" +
            ", reference='" + reference + "'" +
            ", syllabus='" + syllabus + "'" +
            ", evaluation='" + evaluation + "'" +
            ", referenceLink='" + referenceLink + "'" +
            "}";
    }

}