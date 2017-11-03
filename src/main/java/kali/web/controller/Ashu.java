package kali.web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kali.dao.repository.TagRepository;

@RestController
@RequestMapping("/au")
public class Ashu {
	
	@Autowired
	TagRepository tr;
	@GetMapping("")
	public String getData(){
		return tr.getRecord("GENESISNOIDA");
		
	}
}
