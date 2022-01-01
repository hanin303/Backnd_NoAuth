package com.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.InterviewRepository;
import com.example.dao.UserRepository;
import com.example.entities.Condidats;
import com.example.entities.Cv;
import com.example.entities.User;
import com.example.metier.InterUserMetier;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserRestService {
	@Autowired
	private InterUserMetier userMetier;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private InterviewRepository interviewRepository;
	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	public List<User> getUser(){
		return userRepository.getAllUsers();
	}
	
		
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.GET)
    public User getUser(@PathVariable long iduser) {
		return userMetier.getOneUser(iduser);
	}
	
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable long iduser) {
			userMetier.deleteUser(iduser);
	}
	
	@RequestMapping(value="/user",method = RequestMethod.POST)
	public User AddUser(@RequestBody User user){
    	return userMetier.AddUser(user);
	}
	
	@RequestMapping(value="/user/{iduser}",method = RequestMethod.PUT)
	public ResponseEntity<User> EditUser(@PathVariable long iduser, @RequestBody User user){
		 return ResponseEntity.ok(userMetier.EditUser(iduser, user));
    }

	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public int getUsers() {
		int s=0;
		s=userRepository.findAllAdmins().size()+userRepository.findAllInterviewers().size()+userRepository.findAllRecruteurs().size();
		System.out.println("size $$$$$$$ : "+s);
		return s;
	}
	
	@RequestMapping(value = "/getCondidats", method = RequestMethod.GET)
	public int getCondidats() {
		System.out.println("size $$$$$$$ : "+userRepository.findAllCondidats().size());
		return userRepository.findAllCondidats().size();
	}
	
	
	@RequestMapping(value = "/getInters", method = RequestMethod.GET)
	public int getInters() {
		System.out.println("size $$$$$$$  Inter : "+interviewRepository.findAllInterviews().size());
		return interviewRepository.findAllInterviews().size();
	}

	
	@RequestMapping(value = "/getNbUsers", method = RequestMethod.GET)
	public List<String> getNbUsers() {
		List<String>l=userRepository.findAllUsers();
		System.out.println("size $$$$$$$  Inter : "+l.size());
		
		List<String> a =new ArrayList<String> ();
		
		
		for(int i=0;i<l.size();i++) {
			String nb=l.get(i).charAt(5)+"";
			String annee=l.get(i).charAt(0)+""+l.get(i).charAt(1)+""+l.get(i).charAt(2)+""+l.get(i).charAt(3);
			a.add(annee);
			a.add(nb);
		}
		System.out.println("listaaaaaaa : "+a.toString());
		
		return a;
	}

	
	
	@RequestMapping(value = "/getClassName/{iduser}", method = RequestMethod.GET)
	 public String getClassName(@PathVariable long iduser) {
		User u=userRepository.findById(iduser).get();
		System.out.println("**********"+u.getNom());
		return u.getClass().getSimpleName();
	}
	
	
	@RequestMapping(value = "/getUserAuth/{name}", method = RequestMethod.GET)
	 public User getUserAuth(@PathVariable String name) {
		User u=userRepository.findUserWithName(name).get();
		System.out.println("**********"+u.getNom());
		return u;
	}
	

}
