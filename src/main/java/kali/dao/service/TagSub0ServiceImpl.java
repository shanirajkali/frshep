package kali.dao.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.repository.TagSub0Repository;

@Service
public class TagSub0ServiceImpl implements TagSub0Service {

	@Autowired TagSuperService tagSuperService;
	
	@Autowired TagSub0Repository tagSub0Repo;
	
	@Transactional
	public ArrayList<String> allSub0OfSuper(String superTagName) {
		long superTagId=tagSuperService.getIdByName(superTagName);
		return tagSub0Repo.getAllSub0BySuperTagId(superTagId);
	}

	public long getSub0IdByName(String tagSub0Name) {
		return tagSub0Repo.getIdByName(tagSub0Name);
	}

}
