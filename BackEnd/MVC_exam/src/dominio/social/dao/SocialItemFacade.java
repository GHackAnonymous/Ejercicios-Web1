package dominio.social.dao;

import java.util.ArrayList;

import dominio.social.model.SocialItem;

public class SocialItemFacade {
	DaoSocialItem daoSocialItem;
	public SocialItemFacade(){
		daoSocialItem = new DaoSocialtemMySQL();
	}

	public boolean insertSocialItem(SocialItem socialItem){
		return daoSocialItem.insertSocialItem(socialItem);
	}
	public SocialItem loadSocialItem(int socialId){
		return daoSocialItem.loadSocialItem(socialId);
	}
	public ArrayList<SocialItem> loadAllSocialItems(){
		return daoSocialItem.loadAllSocialItems();
	}

	public boolean saveSocialItem(SocialItem socialItem) {
		if(socialItem.getSocialItemId()==null || socialItem.getSocialItemId()==0){
			return daoSocialItem.insertSocialItem(socialItem);
		}else{
			return daoSocialItem.updateSocialItem(socialItem);
		}
	}

	public boolean deleteSocialItem(Integer socialItemId) {
		return daoSocialItem.deleteSocialItem(socialItemId);
	}
}
