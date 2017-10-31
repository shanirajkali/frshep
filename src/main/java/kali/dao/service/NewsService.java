package kali.dao.service;

import javax.servlet.http.HttpSession;

import kali.web.rest.validation.NewsRest;

public interface NewsService {
	public boolean save(HttpSession session,NewsRest newsRest);

}
