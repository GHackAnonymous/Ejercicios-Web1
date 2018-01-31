package domain.news.dao;
import java.util.ArrayList;

import domain.news.model.NewsItem;

public interface DaoNewsItem {
	public boolean insertNewsItem(NewsItem newsItem);
	public NewsItem loadNewsItem(int newsId);
	public ArrayList<NewsItem> loadAllNewsItems();
	public boolean updateNewsItem(NewsItem newsItem);
	public boolean deleteNewsItem(Integer newsItemId);
}
