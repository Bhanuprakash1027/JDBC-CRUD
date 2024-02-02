package bhanu.prakash.controlle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bhanu.prakash.model.FoodOrder;
import bhanu.prakash.service.Ondcservice;

@RestController
@RequestMapping("/ONDC")
public class Ondccontroller {

	@Autowired
	private Ondcservice service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveorder(
			@RequestBody FoodOrder food
			)
	{
		ResponseEntity<String> resp = null;
		try {
			if(food.getOrderid()!=null && service.isexistorder(food.getOrderid()))
			{
				resp = new ResponseEntity<String>("Data Existed", HttpStatus.BAD_REQUEST);
			}else
			{
				resp = new ResponseEntity<String>("New Record Created", HttpStatus.CREATED);
				service.saveorder(food);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	///***************************************************************************************
	
	//GetAll
	@GetMapping("/get")
	public ResponseEntity<String> getall(
			@RequestBody FoodOrder food
			)
	{ 
		ResponseEntity<String> resp = null;
		try {
			if(service.isexistorder(food.getOrderid())) {
				
				resp = new ResponseEntity<String>("data base empty", HttpStatus.BAD_REQUEST);
			}
			else
			{
				resp = new ResponseEntity<String>("data is:", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("internal error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resp;
				
	}
	///***************************************************************************************
	// update
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(
			@RequestBody FoodOrder f
			)
	{
		ResponseEntity<String> resp = null;
		try {
			if(f.getOrderid()!=null && service.isexistorder(f.getOrderid()))
			{
				service.updateorder(f);
				resp = new ResponseEntity<String>("data updated", HttpStatus.OK);
			}else
			{
				resp = new ResponseEntity<String>("Record not Exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	//Delete 
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> cancelorder(
			@PathVariable Integer id
			)
	{
		ResponseEntity<?> resp = null;
		try {
			if(service.isexistorder(id))
			{
				service.deleteorder(id);
				resp = new ResponseEntity<String>("data deleted", HttpStatus.OK);
			}
			else
			{
				resp = new ResponseEntity<String>("data not exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Internal server issue", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	// find by id
	
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getoneorder(
			@PathVariable Integer id
			)
	{
		ResponseEntity<?> resp = null;
		try {
			Optional<FoodOrder> opt=service.getoneorder(id);
			if(opt.isPresent()) {
			resp= new ResponseEntity<FoodOrder>(opt.get(), HttpStatus.OK);
			 service.getoneorder(id);
			}else {
			resp=	new ResponseEntity<String>("product not exist", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	//Get ALL
	@GetMapping("/all")
	public ResponseEntity<?> getall()
	{
		ResponseEntity<?> resp = null;
		try {
			List<FoodOrder> list = service.Getallorders();
			resp = new ResponseEntity<List<FoodOrder>>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
