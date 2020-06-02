package com.entity;

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

        // try {
        //     this.handler.initialize();
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
    }

    // public DataFetcher getPharmaciesDataFetcher() {
    //     return dataFetchingEnvironment -> {
    //         Map<String, Object> argument = dataFetchingEnvironment.getArguments();
    //         if (argument.containsKey("filter")) {
    //             String filter_string = argument.get("filter").toString().replace('=', ':');
    //             JSONObject filter = new JSONObject(filter_string);

    //             Stream<Pharmacy> result = pharmacies.stream();

    //             if (filter.has("id")) {
    //                 result = result.filter(pharmacy -> pharmacy.getId().contains(filter.get("id").toString()));
    //             }
    //             if (filter.has("name")) {
    //                 result = result.filter(pharmacy -> pharmacy.getName().contains(filter.get("name").toString()));
    //             }

    //             return result.toArray();
    //         }

    //         return pharmacies;
    //     };
    // }

    public DataFetcher getCourseIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");

            return this.handler.getCourse(id);
        };
    }

    // public DataFetcher getPharmacyNameDataFetcher() {
    //     return dataFetchingEnvironment -> {
    //         String name = dataFetchingEnvironment.getArgument("name");
    //         return this.courses.stream().filter(course -> course.getName().equals(name)).findFirst().orElse(null);
    //     };
    // }

    // public DataFetcher updatePharmacyDataFetcher() {
    //     return dataFetchingEnvironment -> {
    //         String id = dataFetchingEnvironment.getArgument("id");
    //         String input_string = dataFetchingEnvironment.getArgument("input").toString().replace('=', ':');
    //         JSONObject input = new JSONObject(input_string);

    //         for (int i = 0; i < pharmacies.size(); i++) {
    //             if (pharmacies.get(i).getId().equals(id)) {
    //                 pharmacies.get(i).setName(input.get("name").toString());
    //             }
    //         }

    //         return pharmacies.stream().filter(pharmacy -> pharmacy.getId().equals(id)).findFirst();
    //     };
    // }
}