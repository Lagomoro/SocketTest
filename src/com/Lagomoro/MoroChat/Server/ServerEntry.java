package com.Lagomoro.MoroChat.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEntry {
	
	ServerManager manager;
	
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	String tempLine;
	
	public ServerEntry(){
		this.initialize();
	}
	
	private void initialize(){
		this.create();
	}
	
	public void setManager(ServerManager manager) {
    	this.manager = manager;
    }
	
	private void create(){
		try {
			this.createEntrySocket();
			this.createBuffers();
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
    private void createEntrySocket() throws IOException {
    	this.serverSocket = new ServerSocket(20000);
	}
    
    private void createBuffers() throws IOException {
    	this.socket = this.serverSocket.accept();
    	this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    	this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }
    
    public void update() {
    	try {
    		while (true) {
    			this.tempLine = this.bufferedReader.readLine();
    			if(this.tempLine != null) {
    				System.out.println("New request: " + this.tempLine);
        			System.out.println("Request Created: " + manager.newServer(bufferedWriter));
        			this.releaseTemp();
        			this.createBuffers();
    			}
    		}
		}catch(IOException e){
			System.out.println(e);
		}
	}

    public void releaseTemp() {
    	try {
        	this.socket.close();
        	this.bufferedReader.close();
        	this.bufferedWriter.close();
		}catch(IOException e){
			System.out.println(e);
		}
    }
    
    public void release() {
    	try {
    		this.serverSocket.close();
        	this.socket.close();
        	this.bufferedReader.close();
        	this.bufferedWriter.close();
		}catch(IOException e){
			System.out.println(e);
		}
    }

}
