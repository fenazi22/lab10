package com.example.jobseeking.Service;

import com.example.jobseeking.Model.JobApplication;
import com.example.jobseeking.Repository.JobApplicationRepository;
import com.example.jobseeking.Repository.JobPostRepository;
import com.example.jobseeking.Repository.UserRepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class JobApplicationService {

    private  final JobApplicationRepository jobApplicationRepository;
    public final UserRepository userRepository;
    public final JobPostRepository jobPostRepository;
    public List<JobApplication> getAllJobApplications(){
        return jobApplicationRepository.findAll();
    }

public void  applyForJob(JobApplication jobApplication){
    for (int i = 0; i <userRepository.findAll().size() ; i++) {
        if(jobApplication.getUserId() == userRepository.findAll().get(i).getId()){
            for (int j = 0; j <jobPostRepository.findAll().size() ; j++) {
                if (jobApplication.getJobPostId()==jobPostRepository.findAll().get(i).getId()){
                    jobApplicationRepository.save(jobApplication);
                }
            }
        }

    }



    }



    public Boolean withdrawJobApplication(Integer id){
        JobApplication jobApplication =jobApplicationRepository.getById(id);

        if (jobApplication == null) {
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }

    public Boolean  verify(Integer id){
        for (int i = 0; i <jobApplicationRepository.findAll().size() ; i++) {
            if (jobPostRepository.findAll().get(i).getId().equals(id)){
                for (int j = 0; j <userRepository.findAll().size() ; j++) {
                if (userRepository.findAll().get(j).getId()!=null){
                  return true;
                }
                }
            }
        }
        return  false;
    }


}
