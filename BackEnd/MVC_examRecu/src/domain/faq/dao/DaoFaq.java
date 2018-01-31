package domain.faq.dao;
import java.util.ArrayList;

import domain.faq.model.FaqModelo;



public interface DaoFaq {
	public FaqModelo loadFaq(String question,String answer);
	public FaqModelo loadFaq(int faqId);
	public ArrayList<FaqModelo> loadFaqs();
	public boolean insertFaq(FaqModelo faqModelo);
	public boolean updateFaq(FaqModelo faqModelo);
	public boolean deleteFaq(int faqId);
}
