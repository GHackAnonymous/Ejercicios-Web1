package domain.advert.dao;

import java.util.ArrayList;

import modelo.AdvertModelo;

public class AdvertItemFacade {
	DaoAdvertItem daoAdvertModelo;
	public AdvertItemFacade(){
		daoAdvertModelo = new DaoAdvertItemMySQL();
	}

	public boolean insertAdvertModelo(AdvertModelo advertModelo){
		return daoAdvertModelo.insertAdvertItem(advertModelo);
	}
	public AdvertModelo loadAdvertModelo(int newsId){
		return daoAdvertModelo.loadAdvertItem(newsId);
	}
	public ArrayList<AdvertModelo> loadAllAdvertModelos(){
		return daoAdvertModelo.loadAllAdvertItems();
	}

	public boolean saveAdvertModelo(AdvertModelo advertModelo) {
		if(advertModelo.getId()==null || advertModelo.getId()==0){
			return daoAdvertModelo.insertAdvertItem(advertModelo);
		}else{
			return daoAdvertModelo.updateAdvertItem(advertModelo);
		}
	}

	public boolean deleteAdvertModelo(Integer AdvertModeloId) {
		return daoAdvertModelo.deleteAdvertItem(AdvertModeloId);
	}
}
