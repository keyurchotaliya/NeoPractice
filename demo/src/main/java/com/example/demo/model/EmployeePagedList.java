package com.example.demo.model;

import com.example.demo.entity.Employee;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class EmployeePagedList extends PageImpl<Employee> implements Serializable {

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public EmployeePagedList(@JsonProperty("content") List<Employee> content,
                         @JsonProperty("number") int number,
                         @JsonProperty("size") int size,
                         @JsonProperty("totalElements") Long totalElements,
                         @JsonProperty("pageable") JsonNode pageable,
                         @JsonProperty("last") boolean last,
                         @JsonProperty("totalPages") int totalPages,
                         @JsonProperty("sort") JsonNode sort,
                         @JsonProperty("first") boolean first,
                         @JsonProperty("numberOfElements") int numberOfElements) {

        super(content, PageRequest.of(number, size), totalElements);
    }

    public EmployeePagedList(List<Employee> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public EmployeePagedList(List<Employee> content) {
        super(content);
    }
    
}

