package com.te.leraningmanagementsystem.mentormodulerepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.leraningmanagementsystem.mentorpojo.FinalBatch;

@Repository
public interface FinalBatchRepo extends JpaRepository<FinalBatch, Integer>{

}
