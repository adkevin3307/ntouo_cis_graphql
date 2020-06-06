package com.entity;

import java.util.HashMap;
import java.util.Map;

import com.model.CourseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

@SuppressWarnings("rawtypes")
@Component
public class GraphQLDataFetchers {
    @Autowired
    private CourseHandler handler;

    public GraphQLDataFetchers(CourseHandler handler) {
        this.handler = handler;
    }

    public DataFetcher getCourseDataFetcher() {
        return dataFetchingEnvironment -> {
            return this.handler.getCourse(
                dataFetchingEnvironment.getArgument("id"),
                dataFetchingEnvironment.getArgument("grade")
            );
        };
    }

    public DataFetcher getCoursesDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, Object> filter = new HashMap<String, Object>();
            
            if (dataFetchingEnvironment.containsArgument("filter")) {
                filter = dataFetchingEnvironment.getArgument("filter");
            }

            return this.handler.getCourses(filter);
        };
    }
}