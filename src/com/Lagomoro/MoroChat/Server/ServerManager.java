package com.Lagomoro.MoroChat.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServerManager {
	
	private int serverID = 20001;
	
	ServerEntry entryServer;
	ArrayList<ServerChat> chatList = new ArrayList<ServerChat>();
	
	public ServerManager(){
		this.initialize();
	}
	
	public ServerManager(ServerEntry entryServer){
		this.initialize(entryServer);
	}
	
	private void initialize(){
		this.create();
	}
	
	private void initialize(ServerEntry entryServer){
		this.initialize();
		this.setEntryServer(entryServer);
	}
	
	private void create(){
		
	}
	
    public void setEntryServer(ServerEntry entryServer) {
    	this.entryServer = entryServer;
    }
    
    public void start() {
    	while(true) {
    		this.entryServer.update();
    	}
    }
	
    public void send(String text) {
    	for(ServerChat chatServer : this.chatList) {
    		chatServer.send(text);
    	}
    }
    
    public int newServer(BufferedWriter bufferedWriter){
		int id = this.serverID ++;
		try {
			bufferedWriter.write(Integer.toString(id));
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ServerChat chatServer = new ServerChat();
		chatServer.create(id);
		chatServer.setManager(this);
		this.chatList.add(chatServer);
		
		new Thread() {
            @Override
            public void run() {
            	chatServer.update();
            }
        }.start();
		
		return id;
	}
}
