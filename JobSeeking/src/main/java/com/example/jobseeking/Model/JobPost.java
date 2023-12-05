package com.example.jobseeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull(message = "must be Enter yuor ID")
    private Integer id;




    @NotEmpty(message = "Cannot be  title null. ")
    @Column(columnDefinition= "varchar(20) not null" )
    @Size(min = 4,message = "Length title must be more than 4 characters.")
    private String title;

    @NotEmpty(message = "Must be a valid description format. ")
    @Column(columnDefinition = "varchar(30) not null")
    private  String description;

    @Column(columnDefinition = "varchar(30) not null")
    @NotNull(message = "Cannot location  be null. \n")
    private  String location;


    @NotNull(message = "must be Enter yuor salary")
    @Column(columnDefinition = "int ")
    @Positive(message = "Must be salary a non-negative number. \n")
    private Integer salary;


    @Column(columnDefinition = "DATE NOT NULL ")
    private LocalDate postingDate;


}
