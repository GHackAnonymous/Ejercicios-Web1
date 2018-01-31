package domain.social.model;

public class SocialItem {
	private Integer socialId;
	private String name;
	private String logoUrl;
	private  String socialUrl;
	
	
	public Integer getSocialId() {
		return socialId;
	}
	public void setSocialId(Integer socialId) {
		this.socialId = socialId;
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
