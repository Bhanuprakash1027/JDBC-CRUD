package Bhanu.Prakash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class StdController {

	
	
	@PostMapping("/saved")
	public ResponseEntity<String> savestudent()
	{
		return new ResponseEntity<String>("data saved sucessfull", HttpStatus.OK);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatestudent()
	{
		return new ResponseEntity<String>("Record updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletestudent()
	{
		return new ResponseEntity<String>("Record delete sucessfull",HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<String> getall()
	{
		return new ResponseEntity<String>("getting all data", HttpStatus.OK);
	}
}
