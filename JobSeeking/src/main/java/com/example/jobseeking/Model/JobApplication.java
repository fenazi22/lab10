package com.example.jobseeking.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @NotNull(message = "must be Enter  ID")
    private Integer id;

    @NotNull(message = "must be Enter  userId")

    private Integer userId;

    @NotNull(message = "must be Enter  jobPostId")
    private Integer jobPostId;



}
