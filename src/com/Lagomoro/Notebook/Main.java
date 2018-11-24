package com.Lagomoro.Notebook;

public class Main {
	
	public static void main(String[] args) {
		SceneLogin sceneLogin = new SceneLogin();
		SceneEdit sceneEdit = new SceneEdit();
		SceneAbout sceneAbout = new SceneAbout();
		
		sceneLogin.setEditScene(sceneEdit);
		sceneEdit.setLoginScene(sceneLogin);
		sceneEdit.setAboutScene(sceneAbout);
		
		sceneLogin.active();
	}  
	
}
