package com.go.sports.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Setter
@Getter
public class CategoryDTO {
    private String id;
    @NotNull @NotEmpty @Size(min = 5, max = 20)
    private String title;
    @NotNull @NotEmpty @Size(min = 5, max = 40)
    private  String description;
    @NotEmpty @NotNull
    private String eventId;
}
