package com.example.jobseeking.Service;

import com.example.jobseeking.Model.JobPost;
import com.example.jobseeking.Model.User;
import com.example.jobseeking.Repository.JobPostRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class JobPostService {
private  final JobPostRepository jobPostRepository;

public List<JobPost> getAllJobPosts(){
    return jobPostRepository.findAll();
}

public void addJobPost(JobPost  jobPost){
 jobPostRepository.save(jobPost);
}

public  Boolean updateJobPost(Integer id,JobPost jobPost){
    JobPost jobPost1=jobPostRepository.getById(id);
    if (jobPost1==null){
        return  false;
    }
    jobPost1.setTitle(jobPost.getTitle());
    jobPost1.setDescription(jobPost.getDescription());
    jobPost1.setLocation(jobPost.getLocation());
    jobPost1.setPostingDate(jobPost.getPostingDate());
    jobPost1.setSalary(jobPost.getSalary());
    jobPostRepository.save(jobPost1);
    return true;
}



public  Boolean deleteJonPosts(Integer id){
    JobPost jobPost=jobPostRepository.getById(id);
    if (jobPost==null){
        return  false;
    }else{
        jobPostRepository.delete(jobPost);

    return  true;
    }

}


    public  Boolean verifyJobPost(String title){
        for (JobPost x:jobPostRepository.findAll()) {
            if (x.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

}

