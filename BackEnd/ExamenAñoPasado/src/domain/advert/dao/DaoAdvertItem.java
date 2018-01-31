package domain.advert.dao;
import java.util.ArrayList;

import modelo.AdvertModelo;

public interface DaoAdvertItem {
	public boolean insertAdvertItem(AdvertModelo advertItem);
	public AdvertModelo loadAdvertItem(int advertId);
	public ArrayList<AdvertModelo> loadAllAdvertItems();
	public boolean updateAdvertItem(AdvertModelo advertItem);
	public boolean deleteAdvertItem(Integer advertItemId);
}
