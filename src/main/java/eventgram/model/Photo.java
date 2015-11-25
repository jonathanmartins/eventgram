package eventgram.model;

public class Photo {
	private String link;
	private String subtitle;
	private String ownerUsername;
	
	public Photo(String link, String subtitle, String ownerUsername){
		this.link = link;
		this.subtitle = subtitle;
		this.ownerUsername = ownerUsername;
	}
	
	public String getOwnerUsername() {
		return ownerUsername;
	}
	
	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
