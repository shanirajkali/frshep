package kali.dao.service;

import kali.dao.entity.NewsMedia;

public interface NewsMediaService {
	public boolean save(NewsMedia mn);
	public NewsMedia getByUrl(String url);
	public NewsMedia saveAndGet(NewsMedia url);
}
