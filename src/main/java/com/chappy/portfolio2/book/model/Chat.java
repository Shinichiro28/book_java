package com.chappy.portfolio2.book.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chat {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String name;

}
