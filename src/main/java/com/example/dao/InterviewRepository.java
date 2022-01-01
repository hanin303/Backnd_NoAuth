package com.example.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Condidats;
import com.example.entities.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long>{

	@Query("select o from Interview o")
	public Collection<Interview> findAllInterviews();

	@Transactional
	@Modifying
	@Query("delete Interview u where u.id_Interview=:code")
	void deleteInterview(@PathVariable("code") long code);
	
}
