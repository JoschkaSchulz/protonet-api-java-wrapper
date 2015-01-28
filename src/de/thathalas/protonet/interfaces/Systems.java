package de.thathalas.protonet.interfaces;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.ProtonetSystem;

/**
 * The Me class represents the System REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Systems {
	private ProtonetWrapper protonet;
	
	public Systems(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public ProtonetSystem index() {
		return ProtonetSystem.createSystem(protonet.get("/api/v1/system"));
	}
}
