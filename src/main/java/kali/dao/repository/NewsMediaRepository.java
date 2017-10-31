package kali.dao.repository;

import kali.dao.entity.NewsMedia;

public interface NewsMediaRepository {
	public boolean save(NewsMedia newsMedia);
	public boolean deleteById(long id);
	public boolean deleteByObject(NewsMedia newsMedia);
	public NewsMedia getByUrl(String url);
}
