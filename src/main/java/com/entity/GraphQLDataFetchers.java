package com.entity;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.base.Predicate;
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
            if (dataFetchingEnvironment.containsArgument("filter")) {
                Map<String, String> filter = dataFetchingEnvironment.getArgument("filter");

                Stream<Course> result = this.handler.getCourses().stream();

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

                return result.collect(Collectors.toList());
            }

            return this.handler.getCourses();
        };
    }
}