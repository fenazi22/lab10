package com.example.jobseeking.Controller;

import com.example.jobseeking.Model.JobPost;
import com.example.jobseeking.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobpost")
public class JobPostController {

        private  final JobPostService jobPostService;
    @GetMapping("/get")
    public ResponseEntity getAllJobPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostService.getAllJobPosts());
    }


    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(HttpStatus.OK).body("Added Successfully");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id,@Valid@RequestBody JobPost jobPost,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated=jobPostService.updateJobPost(id,jobPost);
        if (isUpdated==false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("null");

        }
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Updated");

    }


        @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJonPosts(@PathVariable Integer id){
        Boolean isDelete=jobPostService.deleteJonPosts(id);

            if (isDelete==true)
            {
                return ResponseEntity.status(HttpStatus.OK).body("Deleted");
            }
        if (isDelete==false){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found");

        }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");

        }

    @GetMapping("/verifyJobPost/{title}")
    public ResponseEntity verifyJobPost(@PathVariable String title){

        Boolean isVerfiy=jobPostService.verifyJobPost(title);
        if (isVerfiy){
            return ResponseEntity.status(HttpStatus.OK).body("isExists");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not Exist");
    }
}
