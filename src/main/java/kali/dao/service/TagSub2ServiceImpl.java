package kali.dao.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.repository.TagSub2Repository;

@Service
public class TagSub2ServiceImpl implements TagSub2Service {

	@Autowired TagSub2Repository tagSub2Repo;
	@Autowired TagSub1Service tagSub1Service;
	
	@Transactional
	public long getIdByName(String tagSub2Name) {
		return tagSub2Repo.getIdByName(tagSub2Name);
	}

	@Transactional
	public ArrayList<String> getAllBySub1Name(String sub1Name) {
		long sub1Id=tagSub1Service.getIdByName(sub1Name);
		return tagSub2Repo.getAllBySub1Id(sub1Id);
	}

}
