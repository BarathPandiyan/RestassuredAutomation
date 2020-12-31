package com.test.pojos;
import java.util.Objects;

public class Users {
	private Data data;
	private Link support;
	
	public Users(Data _data, Link _link) {
		this.data = _data;
		this.support = _link;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Link getSupport() {
		return support;
	}

	public void setSupport(Link support) {
		this.support = support;
	}
	
	@Override
	public String toString() {
		return "Users [data=" + data + ", support=" + support + "]";
	}
	
	@Override
	public boolean equals( Object _obj ) {
		Users obj = (Users) _obj;
		if( this.data.equals(obj.data) &&
				this.support.equals(obj.support) ) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(data, support);
	}

}
