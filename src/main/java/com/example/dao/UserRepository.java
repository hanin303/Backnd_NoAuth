package com.example.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Admin;
import com.example.entities.Condidats;
import com.example.entities.Interviewer;
import com.example.entities.Recruteur;
import com.example.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	@Query(" select u from User u where u.isAdmin =0")
	List<User> getAllUsers();
	
	@Query(" select u from User u where u.username = ?1")
	Optional<User> findUserWithName(String username);
	
	@Query("select o from Admin o")
	public Collection<Admin> findAllAdmins();
	
	@Query("select o from Recruteur o")
	public Collection<Recruteur> findAllRecruteurs();
	
	
	@Query("select o from Interviewer o")
	public Collection<Interviewer> findAllInterviewers();
	
	@Query("select o from Condidats o")
	public Collection<Condidats> findAllCondidats();
	
	
	@Query("select year(o.DateEmbauche), count(o) from User o where o.DateEmbauche!=null GROUP BY year(o.DateEmbauche) ")
	public List<String> findAllUsers();
}


