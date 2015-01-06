package de.thathalas.protonet;

public class Users {
	private ProtonetWrapper protonet;
	
	public Users(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public String index() {
		return protonet.get("/api/v1/users");
	}
	
	public String show(int userId) {
		return protonet.get("/api/v1/users/" + userId);
	}
}
