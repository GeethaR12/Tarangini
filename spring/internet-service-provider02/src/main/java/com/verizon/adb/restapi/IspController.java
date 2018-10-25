package com.verizon.adb.restapi;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.adb.model.IspModel;
import com.verizon.adb.service.IspService;

@RestController
@CrossOrigin
@RequestMapping("/abc")
public class IspController {

	
	@Autowired
	private IspService service;

	
	@GetMapping
	public ResponseEntity<List<IspModel>> getAllContacts(){
		return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{title}")
	public ResponseEntity<IspModel> getById(@PathVariable String title){
		ResponseEntity<IspModel> resp=null;
		IspModel c=service.getByTitle(title);
		if(c==null) {
			resp=new ResponseEntity<>(c,HttpStatus.NOT_FOUND);
		}
		else {
			resp=new ResponseEntity<>(c,HttpStatus.OK);
		}
		return resp;
		
	}
	
	
	
	
	@GetMapping("/{field}/{srhValue}")
	public ResponseEntity<List<IspModel>> getById(@PathVariable("field") String fieldBy,
			@PathVariable("srhValue") String searchValue){
		
		//List<Contact> results=null;
		ResponseEntity<List<IspModel>> resp;
		List<IspModel> results=null;
		switch (fieldBy) {
		case "charge":
			results=service.findAllByCharge(searchValue);		
			if(results!=null&&results.size()!=0)			
				resp=new ResponseEntity<>(results,HttpStatus.OK);		
			else			
				resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			break;	
		case "speed":
			results=service.findAllBySpeed(searchValue);		
			if(results!=null&&results.size()!=0)			
				resp=new ResponseEntity<>(results,HttpStatus.OK);		
			else			
				resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			break;	
		case "usage":
			
				 results=service.findAllByMaxUsage(searchValue);		
					if(results!=null&&results.size()!=0)			
						resp=new ResponseEntity<>(results,HttpStatus.OK);		
					else			
						resp=new ResponseEntity<>(HttpStatus.NOT_FOUND);		
					break;		
		default :
			resp=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return resp;
		
		 
	}
}
	

