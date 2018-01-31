package domain.faq.dao;

import java.util.ArrayList;

import domain.faq.model.FaqModelo;

public class FaqFacade {
	DaoFaq daoFaq = null;
	
	public FaqFacade(){
		//login = new DaoLoginProperties();
		daoFaq = new DaoFaqMySQL();
	}
	public FaqModelo loadFaq(String question, String answer){
		return daoFaq.loadFaq(question,answer);
	}

	public FaqModelo loadFaq(int faqId){
		return daoFaq.loadFaq(faqId);
	}
	
	public ArrayList<FaqModelo> loadFaqs(){
		return daoFaq.loadFaqs();
	}
	public boolean saveFaq(FaqModelo faqModelo) {
		boolean ret = false;
		if(faqModelo.getFaqId()!=null && faqModelo.getFaqId()!=0)
			ret=daoFaq.updateFaq(faqModelo);
		else
			ret=daoFaq.insertFaq(faqModelo);
		return ret;
	}
	public boolean updateFaq(FaqModelo faqModelo) {
		return daoFaq.updateFaq(faqModelo);
		
	}
	public boolean deleteFaq(Integer faqId) {
		return daoFaq.deleteFaq(faqId);
		
	}

}
