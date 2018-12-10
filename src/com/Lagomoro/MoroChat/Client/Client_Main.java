package com.Lagomoro.MoroChat.Client;

public class Client_Main {
	
	public static void main(String[] args) {
		/*SceneLogin sceneLogin = new SceneLogin();
		SceneEdit sceneEdit = new SceneEdit();
		SceneAbout sceneAbout = new SceneAbout();
		
		sceneLogin.setEditScene(sceneEdit);
		sceneEdit.setLoginScene(sceneLogin);
		sceneEdit.setAboutScene(sceneAbout);
		
		sceneLogin.active();*/
		
		ClientChat clientChat = new ClientChat();
		
		clientChat.start();
	}  
	
}
