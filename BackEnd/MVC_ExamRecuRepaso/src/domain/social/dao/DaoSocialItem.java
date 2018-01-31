package domain.social.dao;
import java.util.ArrayList;

import domain.social.model.SocialItem;

public interface DaoSocialItem {
	public boolean insertSocialItem(SocialItem socialItem);
	public SocialItem loadSocialItem(int socialId);
	public ArrayList<SocialItem> loadAllSocialItems();
	public boolean updateSocialItem(SocialItem socialItem);
	public boolean deleteSocialItem(Integer socialItemId);
}
