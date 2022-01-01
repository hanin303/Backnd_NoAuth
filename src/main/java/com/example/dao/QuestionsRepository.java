package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long>{

}
