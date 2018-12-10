package com.Lagomoro.MoroChat.Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientChat {
	
	Socket socket;
	BufferedReader inputReader;
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	public ClientChat(){
		this.initialize();
	}
	
	private void initialize(){
		this.create();
	}
	
	private void create(){
		try {
			this.createBuffers();
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
    private void createBuffers() throws IOException {
    	this.socket = new Socket("127.0.0.1", 20000);
    	this.inputReader = new BufferedReader(new InputStreamReader(System.in));
    	this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    	this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }
    
    private void createBuffers(int id) throws IOException {
    	this.socket = new Socket("127.0.0.1", id);
    	this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    	this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
   
    	this.update();
    }
    
    public void start() {
    	this.startRequest();
    	this.waitRequest();
	}
    
    private void startRequest() {
    	try {
    		bufferedWriter.write("request");
			bufferedWriter.newLine();
			bufferedWriter.flush();
        } catch (IOException e) {
    		e.printStackTrace();
    	}
	}
    
    private void waitRequest() {
    	try {
    		while (true) {
    			String reserver = bufferedReader.readLine();
    			if(reserver != null) {
    				System.out.println("Linked To Server: " + reserver);
    				this.releaseTemp();
    				this.createBuffers(Integer.parseInt(reserver));
    				break;
    			}
    		}
        } catch (IOException e) {
    		e.printStackTrace();
    	}
	}

    private void update() {
    	try {
        	ClientChat that = this;
        	new Thread() {
                @Override
                public void run() {
                	try {
                    	String reserver = null;
                    	while (true) {
                			reserver = that.bufferedReader.readLine();
    						if(reserver != null) {
    	            			System.out.println(reserver);
    	            		}
                		}
                	} catch (IOException e) {
						e.printStackTrace();
					}
                }
                
            }.start();
            
            String line = null;
    		while (true) {
    			line = this.inputReader.readLine();
    			if("886".equals(line)) {
    				break;
    		    }else if(line != null) {
    				this.bufferedWriter.write(line);
    				this.bufferedWriter.newLine();
    				this.bufferedWriter.flush();
    			}
    			
    		}
    		this.release();
        } catch (IOException e) {
    		e.printStackTrace();
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
    		this.socket.close();
    		this.inputReader.close();
        	this.bufferedReader.close();
        	this.bufferedWriter.close();
		}catch(IOException e){
			System.out.println(e);
		}
    }
}
