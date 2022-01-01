package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Role;
import com.example.metier.InterRoleMetier;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RoleRestService {
	
	@Autowired
	private InterRoleMetier roleMetier;
	
	@RequestMapping(value="/role",method = RequestMethod.GET)
	public List<Role> getRole(){
		return roleMetier.getRole();
	}
	
	@RequestMapping(value="/role/{idrole}",method = RequestMethod.GET)
    public Role getRole(@PathVariable long idrole) {
		return roleMetier.getOneRole(idrole);
	}
	
	
	@RequestMapping(value="/role/{idrole}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRole(@PathVariable long idrole) {
			roleMetier.deleteRole(idrole);
	}
	
	@RequestMapping(value="/role",method = RequestMethod.POST)
	public Role AddRole(@RequestBody Role role){
    	return roleMetier.AddRole(role);
	}
	
	
	@RequestMapping(value="/role/{idrole}",method = RequestMethod.PUT)
	public ResponseEntity<Role> EditRole(@PathVariable long idrole, @RequestBody Role role){
		 return ResponseEntity.ok(roleMetier.EditRole(idrole, role));
    }


}
