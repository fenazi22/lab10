package com.example.jobseeking.Repository;

import com.example.jobseeking.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository  extends JpaRepository<JobPost,Integer> {
}
