package com.test.pojos;
import java.util.Objects;

public class Link {
	private String url;
	private String text;
	
	public Link ( String _url, String _text ) {
		this.url = _url;
		this.text = _text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Link [url=" + url + ", text=" + text + "]";
	}
	
	@Override
	public boolean equals( Object _obj ) {
		Link obj = (Link) _obj;
		if( this.url == obj.url &&
				this.text == obj.text ) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.url, this.text);
	}
	
}

