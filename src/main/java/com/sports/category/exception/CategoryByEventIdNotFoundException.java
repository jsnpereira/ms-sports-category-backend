package com.sports.category.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryByEventIdNotFoundException extends Exception{
    public CategoryByEventIdNotFoundException(String id){
        super(String.format("Event ID %s not found category list in our database",id));
    }
}
