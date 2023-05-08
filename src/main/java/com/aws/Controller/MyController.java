package com.aws.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.Model.Model;
import com.aws.Service.Aws_Service;

@RestController
public class MyController {
	
	@Autowired
	private Aws_Service aws_Service;
	
	@GetMapping("/getModel")
	public List<Model> getModels(){
		 return this.aws_Service.getModel();
	}
	
	@PostMapping("/add")
	public Model addModel(@RequestBody Model model) {
		return this.aws_Service.addModel(model);
	}
	
	@PutMapping("/update")
	public Model updatModel(@RequestBody Model model) {
		return this.aws_Service.updateModel(model);
	}
	
	@DeleteMapping("/roll/{roll}")
	public ResponseEntity<Object> deleteModel(@PathVariable int roll) {
		try {
			this.aws_Service.deleteModel(roll);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
