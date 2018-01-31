package dominio.social.dao;
import java.util.ArrayList;

import dominio.social.model.SocialItem;

public interface DaoSocialItem {
	public boolean insertSocialItem(SocialItem socialItem);
	public SocialItem loadSocialItem(int newsId);
	public ArrayList<SocialItem> loadAllSocialItems();
	public boolean updateSocialItem(SocialItem socialItem);
	public boolean deleteSocialItem(Integer socialItemId);
}
