package kali.dao.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.repository.TagSuperRepository;

@Service
public class TagSuperServiceImpl implements TagSuperService{

	@Autowired TagSuperRepository tagSuperRepo;
	
	@Transactional
	public ArrayList<String> getAllSuperTag() {
		return tagSuperRepo.getAll();	
	}

	@Transactional
	public long getIdByName(String superTagName) {
		return tagSuperRepo.getId(superTagName);
	}
	
	

}
