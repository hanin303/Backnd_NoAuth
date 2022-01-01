package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Competance;

public interface CompetanceRepository extends JpaRepository<Competance,Long> {

	@Transactional
	@Modifying
	@Query("delete Competance u where u.idCompetance=:code")
	void deleteCompetance(@PathVariable("code") long code);
}
