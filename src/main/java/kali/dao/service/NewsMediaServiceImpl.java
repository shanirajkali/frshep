package kali.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kali.dao.entity.NewsMedia;
import kali.dao.repository.NewsMediaRepository;

@Service
public class NewsMediaServiceImpl implements NewsMediaService {

	@Autowired
	NewsMediaRepository nmr;

	@Transactional
	public boolean save(NewsMedia newsMedia) {
		if(nmr.save(newsMedia)) return true;
		return false;
	}

	public NewsMedia getByUrl(String url) {
		return nmr.getByUrl(url);
	}


	public NewsMedia saveAndGet(NewsMedia newsMedia) {
		nmr.save(newsMedia);
		return nmr.getByUrl(newsMedia.getUrl());
	}
}