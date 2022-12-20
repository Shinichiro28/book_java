package com.chappy.portfolio2.book.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat {
    @NotBlank
    @Size(max = 20)
    private String name;

}
