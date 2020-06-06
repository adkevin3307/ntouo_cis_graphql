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

    public DataFetcher getCoursesDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> filter = new HashMap<String, String>();
            
            if (dataFetchingEnvironment.containsArgument("filter")) {
                filter = dataFetchingEnvironment.getArgument("filter");
            }

            return this.handler.getCourses(filter);
        };
    }
}