package com.example.jobseeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "Cannot be  name null. ")
    @Column(columnDefinition = "varchar(20) not null unique")
    @Size(min = 4, message = "Length must be more than 4 characters.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Must contain only characters (no numbers). ")
    private String name;

    @Email(message = "Must be a valid email format. ")
    @Column(columnDefinition = "varchar(30) unique")
    private String email;

    @Column(columnDefinition = "varchar(30) not null")
    @NotNull(message = "Cannot be null. \n")
    private String password;


    @NotNull(message = "must be Enter yuor age")
    @Min(value = 21, message = "Must be more than 21. \n")
    @Column(columnDefinition = "int")
    @Positive(message = "Must be a number")
    private Integer age;


  @NotEmpty(message = "Cannot be  role null. ")
    @Column(columnDefinition = "varchar(20) check(role = 'JOB_SEEKER' or role = 'EMPLOYER' )")
    private String role;


}
