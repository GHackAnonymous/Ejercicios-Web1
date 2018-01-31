package domain.news.dao;

import java.util.ArrayList;

import domain.news.model.NewsItem;

public class NewsItemFacade {
	DaoNewsItem daoNewsItem;
	public NewsItemFacade(){
		daoNewsItem = new DaoNewsItemMySQL();
	}

	public boolean insertNewsItem(NewsItem newsItem){
		return daoNewsItem.insertNewsItem(newsItem);
	}
	public NewsItem loadNewsItem(int newsId){
		return daoNewsItem.loadNewsItem(newsId);
	}
	public ArrayList<NewsItem> loadAllNewsItems(){
		return daoNewsItem.loadAllNewsItems();
	}

	public boolean saveNewsItem(NewsItem newsItem) {
		if(newsItem.getNewsItemId()==null || newsItem.getNewsItemId()==0){
			return daoNewsItem.insertNewsItem(newsItem);
		}else{
			return daoNewsItem.updateNewsItem(newsItem);
		}
	}

	public boolean deleteNewsItem(Integer newsItemId) {
		return daoNewsItem.deleteNewsItem(newsItemId);
	}
}
