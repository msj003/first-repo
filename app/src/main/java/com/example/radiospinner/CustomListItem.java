package com.example.radiospinner;

public class CustomListItem {

	String companyName;
	int image;
	String url;
	boolean selected;
	public CustomListItem(String companyName, int image, String url,boolean status) {
		super();
		this.companyName = companyName;
		this.image = image;
		this.url = url;
		this.selected = status;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
}
