package kali.dao.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.repository.TagSub3Repository;

@Service
public class TagSub3ServiceImpl implements TagSub3Service {

	@Autowired TagSub3Repository tagSub3Repo;
	
	@Autowired TagSub3Service tagSub2Service;
	
	@Transactional
	public long getIdByName(String name) {
		return tagSub3Repo.getIdByName(name);
	}

	public ArrayList<String> getAllBySub2Name(String sub2Name) {
		long sub2Id =tagSub2Service.getIdByName(sub2Name);
		return tagSub3Repo.getAllBySub2Id(sub2Id);
	}

}
