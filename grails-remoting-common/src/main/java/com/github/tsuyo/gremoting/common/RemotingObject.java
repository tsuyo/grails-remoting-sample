package com.github.tsuyo.gremoting.common;

public class RemotingObject implements java.io.Serializable {
	private static final long serialVersionUID = 9131568080970019630L;
	private long id;
	private String protocol;

	public RemotingObject(long i, String p) {
		this.id = i;
		this.protocol = p;
	}

	public Long getId() {
		return id;
	}

	public void setId(long i) {
		this.id = i;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String p) {
		this.protocol = p;
	}

    @Override
	public String toString() {
		return "id: " + id + ", protocol: " + protocol;
	}
	
}