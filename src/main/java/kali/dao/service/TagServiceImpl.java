package kali.dao.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.repository.TagSuperRepository;

@Service
public class TagServiceImpl implements TagService{

	@Autowired TagSuperRepository tagSuperReapo;
	
	
	@Transactional
	public String getTags(String search) {
		
		
		return null;
	}

}
