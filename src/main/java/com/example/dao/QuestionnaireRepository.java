package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Questionnaire;


public interface QuestionnaireRepository extends JpaRepository<Questionnaire,Long> {

}
