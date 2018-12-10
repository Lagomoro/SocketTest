package com.Lagomoro.MoroChat.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
    ServerManager manager;
	
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	int id;
	
	String tempLine;
	
	public ServerChat(){
		this.initialize();
	}
	
	private void initialize(){
		
	}
	
	public void setManager(ServerManager manager) {
    	this.manager = manager;
    }
	
	public void create(int id){
		try {
			this.createSocket(id);
			this.createBuffers();
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
    private void createSocket(int id) throws IOException {
    	this.id = id;
    	this.serverSocket = new ServerSocket(id);
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
    				System.out.println("From " + this.id + ": " + this.tempLine);
        			this.manager.send("From " + this.id + ": " + this.tempLine);
    			}
    		}
		}catch(IOException e){
			System.out.println(e);
		}
	}
    
    public void send(String text) {
    	try {
    		this.bufferedWriter.write(text);
        	this.bufferedWriter.newLine();
        	this.bufferedWriter.flush();
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
