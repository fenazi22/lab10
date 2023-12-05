package com.example.jobseeking.Controller;


import com.example.jobseeking.Model.JobApplication;
import com.example.jobseeking.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jac")
public class JobApplicationController {
    private JobApplicationService jobApplicationService;
    @GetMapping("/get")
    public ResponseEntity getAllJobApplications(){
        return ResponseEntity.status(HttpStatus.OK).body(jobApplicationService.getAllJobApplications());
    }


    @PostMapping("/add")
    public ResponseEntity applyForJob(@Valid @RequestBody JobApplication jobApplication, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        jobApplicationService.applyForJob(jobApplication);
        return ResponseEntity.status(HttpStatus.OK).body("apply job");
    }

    @DeleteMapping("/delete/{id}")
public ResponseEntity withdrawJobApplication(@PathVariable Integer id){
        Boolean isDeleted=jobApplicationService.withdrawJobApplication(id);
        if (isDeleted==true){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully Withdraw Job Application");
        }
        if (isDeleted==false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("filed Withdraw Job Application");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");

    }


    @GetMapping("/verify/{id}")
    public ResponseEntity Verify(@PathVariable Integer id){
        Boolean isExists=jobApplicationService.verify(id);
        if (isExists==true){
            return ResponseEntity.status(HttpStatus.OK).body("exist");
        }
        if (isExists==false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not exist");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
}
