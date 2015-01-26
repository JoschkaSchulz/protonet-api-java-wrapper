package de.thathalas.protonet;

import org.json.JSONObject;

import de.thathalas.protonet.objects.UserDevice;

public class APIExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProtonetWrapper protonet = new ProtonetWrapper("http://127.0.0.1:3001");
		protonet.getToken("joschka@protonet.info", "123456789", "ProtonetJava Wrapper Test");
		
		System.out.println("--[ Me");
		System.out.println("Me me                      : " + protonet.getMe().me());
		System.out.println("Me login_tokens            : " + protonet.getMe().login_tokens());
		
		System.out.println("--[ Devices");
		UserDevice device = protonet.getDevices().create("aaaaaaab", "android");
		System.out.println("Devices create             : " + device);
		System.out.println("Devices update_device      : " + protonet.getDevices().update_active(
				protonet.getUserId(), 
				device.getId()
		));
		System.out.println("Devices delete             : " + protonet.getDevices().destroy(
				protonet.getUserId(), 
				device.getId()
		));
		
		System.out.println("--[ Users");
		System.out.println("Users index                : " + protonet.getUsers().index());
		System.out.println("Users show                 : " + protonet.getUsers().show(1));
		
		System.out.println("--[ Projects");
		System.out.println("Projects index             : " + protonet.getProjects().index());
		System.out.println("Projects show              : " + protonet.getProjects().show(1));
		System.out.println("Projects create            : " + protonet.getProjects().create("APITestGroup"+(int)(Math.random()*1000000)));
	
		System.out.println("--[ Meeps");
		System.out.println("Meeps index projects       : " + protonet.getMeeps().indexProjects(4));
		System.out.println("Meeps index topics         : " + protonet.getMeeps().indexTopics(3));
		System.out.println("Meeps index private chats  : " + protonet.getMeeps().indexPrivateChats(1));
		System.out.println("Meeps create projects      : " + protonet.getMeeps().createProjects(4, "Hallo alle"));
		System.out.println("Meeps create topics        : " + protonet.getMeeps().createTopics(3, "Hier kommen mehr..."));
		System.out.println("Meeps create private chats : " + protonet.getMeeps().createPrivateChats(1, "moin"));
		System.out.println("Meeps show projects        : " + protonet.getMeeps().showProjects(4, 167));
		System.out.println("Meeps show topics          : " + protonet.getMeeps().showTopics(3, 168));
		System.out.println("Meeps show private chats   : " + protonet.getMeeps().showPrivateChats(1, 170));
	}

}
