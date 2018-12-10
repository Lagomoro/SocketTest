package com.Lagomoro.MoroChat.Server;

public class Server_Main {
	
	public static void main(String[] args){
		
		System.out.println("Server Created.");
		
		ServerEntry entryServer = new ServerEntry();
		
		ServerManager manager = new ServerManager(entryServer);
		
		entryServer.setManager(manager);
		
		manager.start();
		
	}
	
}
