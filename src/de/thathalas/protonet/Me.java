package de.thathalas.protonet;

public class Me {
	private ProtonetWrapper protonet;
	
	public Me(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public String me() {
		return protonet.get("/api/v1/me");
	}
	
	public String login_tokens() {
		return protonet.get("/api/v1/me/login_token");
	}
}
