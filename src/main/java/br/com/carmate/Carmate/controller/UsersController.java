package br.com.carmate.Carmate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

	@RequestMapping("/user")
	@ResponseBody
	public ResponseEntity<?> listUserInformation(){
		return ResponseEntity.ok().build();
	}
}
