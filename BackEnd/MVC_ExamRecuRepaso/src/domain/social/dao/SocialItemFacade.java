package domain.social.dao;

import java.util.ArrayList;

import domain.news.model.NewsItem;
import domain.social.model.SocialItem;

public class SocialItemFacade {
	DaoSocialItem daoSocialItem;
	public SocialItemFacade(){
		daoSocialItem = new DaoSocialItemMySQL();
	}

	public boolean insertSocialItem(SocialItem SocialItem){
		return daoSocialItem.insertSocialItem(SocialItem);
	}
	public SocialItem loadSocialItem(int socialId){
		return daoSocialItem.loadSocialItem(socialId);
	}
	public ArrayList<SocialItem> loadAllSocialItems(){
		return daoSocialItem.loadAllSocialItems();
	}

	public boolean saveSocialItem(SocialItem socialItem) {
		if(socialItem.getSocialId()==null || socialItem.getSocialId()==0){
			System.out.println("insert");
			return daoSocialItem.insertSocialItem(socialItem);
		}else{
			return daoSocialItem.updateSocialItem(socialItem);
		}
	}

	public boolean deleteNewsItem(Integer socialItemId) {
		return daoSocialItem.deleteSocialItem(socialItemId);
	}
}
