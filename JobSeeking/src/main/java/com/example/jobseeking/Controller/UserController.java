package com.example.jobseeking.Controller;

import com.example.jobseeking.Model.User;
import com.example.jobseeking.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")

public class UserController {
    private  final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }


        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully added");
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid @RequestBody User user,Errors errors){
        if (errors.hasErrors()){
            String message= Objects.requireNonNull(errors.getFieldError()).getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

    Boolean isupdated=userService.updateUser(id,user);
        if (isupdated==true){
            return ResponseEntity.status(HttpStatus.OK).body(" Successfully Updated");

        } else{
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).body("sorry Not Updated");
        }

    }


@DeleteMapping("/delete/{id}")
    public ResponseEntity deletUser(@PathVariable Integer id){
    Boolean isDeleted=userService.deletUser(id);
    if (isDeleted==false){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry cannot found ID");
    }else {
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted");
    }

}


@GetMapping("/verifyUsers/{id}")
    public ResponseEntity VerifyUser(@PathVariable Integer id){
        Boolean isExists=userService.VerifyUser(id);
        if (isExists){
            return ResponseEntity.status(HttpStatus.OK).body("isExists");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Exist ");
}


}
