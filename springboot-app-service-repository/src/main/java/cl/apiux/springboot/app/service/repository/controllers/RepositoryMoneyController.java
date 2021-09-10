package cl.apiux.springboot.app.service.repository.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.apiux.springboot.app.service.repository.models.Money;
import cl.apiux.springboot.app.service.repository.services.IRepositoryMoneyService;

@RestController
@RequestMapping("/api/money")
public class RepositoryMoneyController {
	
	@Autowired
	private IRepositoryMoneyService moneyService;

	@CrossOrigin
	@GetMapping("/list")
	public ResponseEntity<List<Money>> listCustomer(){
		List<Money> result = moneyService.getMoneyList();
		if (result != null) {
			return new ResponseEntity<List<Money>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

}
