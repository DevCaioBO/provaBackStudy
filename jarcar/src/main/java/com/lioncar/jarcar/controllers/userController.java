package com.lioncar.jarcar.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lioncar.jarcar.RequestUser;
import com.lioncar.jarcar.models.userModel;
import com.lioncar.jarcar.repositorys.userRepository;

import jakarta.persistence.Id;



@RestController
@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userRepository repository;
	@GetMapping
	public List<userModel> getUsers( RequestUser data) throws SQLException {

        List<userModel> teste = repository.findAll();
		return teste;
	}
	
	@PostMapping
	public ResponseEntity<?> postUsers( @RequestBody RequestUser data)  {
  
        
        userModel user = new userModel();
        
        user.setEmail(data.email());
        user.setSenha(data.senha());
   
        repository.save(user);
        
       
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
	@DeleteMapping("/{iduser}")
	public ResponseEntity<?> deleteUsers( @PathVariable Long iduser,   RequestUser data )  {
  
        
        userModel user = new userModel();
        
        
        var tarefasDelete = repository.findById(iduser);
        var tarefasGet = repository.findAll();
       // user.setEmail(data.email());
        //user.setSenha(data.senha());
        if(tarefasDelete.isPresent()) {
        repository.deleteById(iduser);
        }else {
        	
        	return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(tarefasGet) ;
        }
        
       
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tarefasGet);
	}
}
