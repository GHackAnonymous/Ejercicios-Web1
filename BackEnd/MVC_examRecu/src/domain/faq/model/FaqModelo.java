package domain.faq.model;
/*
 * This is a Java Bean.
 * These are the unique characteristics they must have:
 *     -Default, no-argumented constructor.
 *     -It should be serializable and implement Serializable interface.
 *     -It may have a number of properties which can be read or written.
 *     -"getters" and "setters" for those properties.
 */
public class FaqModelo implements java.io.Serializable /*2nd characteristic*/{
	private static final long serialVersionUID = 3834633934831160740L;
	
	// 3rd characteristic: multiple properties.
	private Integer faqId = 0;
	private String question = null;
	private String answer = null;
	
	
	public FaqModelo(){}// 1st characteristic


	public Integer getFaqId() {
		return faqId;
	}


	public void setFaqId(Integer faqId) {
		this.faqId = faqId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
