package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Condidats;

public interface CondidatRepository extends JpaRepository<Condidats,Long> {

}
