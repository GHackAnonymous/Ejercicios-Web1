package dominio.social.model;

import java.util.Date;
import java.util.Locale;

import domain.user.model.User;

public class SocialItem implements java.io.Serializable{
	private static final long serialVersionUID = 7927744272163377158L;
	private Integer socialItemId;
	private String name;
	private String logoUrl;
	private String socialUrl;
	
	public SocialItem(){}

	public Integer getSocialItemId() {
		return socialItemId;
	}

	public void setSocialItemId(Integer socialItemId) {
		this.socialItemId = socialItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getSocialUrl() {
		return socialUrl;
	}

	public void setSocialUrl(String socialUrl) {
		this.socialUrl = socialUrl;
	}	
}
