package kali.dao.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.repository.TagSub1Repository;

@Service
public class TagSub1ServiceImpl implements TagSub1Service {

	@Autowired TagSub0Service tagSub0Service;
	
	@Autowired TagSub1Repository tagSub1Repo;
	
	
	@Transactional
	public ArrayList<String> getAllSubTag1NameOfSubTag0Id(String subTag0Name) {
		long subTag0Id=tagSub0Service.getSub0IdByName(subTag0Name);
		return tagSub1Repo.getAllBySub0Id(subTag0Id);
	}


	public long getIdByName(String sub1Name) {
		return tagSub1Repo.getIdByName(sub1Name);
	}
}
