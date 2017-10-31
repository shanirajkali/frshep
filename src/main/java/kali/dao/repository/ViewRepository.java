package kali.dao.repository;

import kali.dao.entity.News;
import kali.dao.entity.UserAccount;

public interface ViewRepository {
	public boolean isView(News newsId,UserAccount userId);
	public boolean doView(News newsId);
	public long getTotalView(News newsId);
	public boolean updateView(News newsId,UserAccount userId);
}
