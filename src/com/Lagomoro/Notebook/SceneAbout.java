package com.Lagomoro.Notebook;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*; 

public class SceneAbout extends JFrame{

	private JLabel text1, text2;
	private JButton btn1;
	
	public SceneAbout(){
		this.initialize();
		this.create();
	}
	
	private void initialize(){
		this.setTitle("关于");
		this.setResizable(false);
		this.setSize(420, 323);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setLayout(null);
	}
	
	private void create() {
		SceneAbout that = this;
		
		this.text1 = new JLabel("Notebook V0.0.1");
		this.text1.setBounds(140, 60, 140, 30);
		this.add(this.text1);
		
		this.text2 = new JLabel("Powered By Lagomoro");
		this.text2.setBounds(140, 120, 140, 30);
		this.add(this.text2);
		
		this.btn1 =new JButton("了解");
		this.btn1.setBounds(140, 240, 140, 30);
		this.btn1.addMouseListener(new MouseAdapter() {
			private boolean moveIn = false;
            @Override
            public void mouseReleased(MouseEvent e) {
            	if(this.moveIn) {
            		that.deactive();
            	}
            }
            public void mouseEntered(MouseEvent e) {
            	this.moveIn = true;
            }
            public void mouseExited(MouseEvent e) {
            	this.moveIn = false;
            }
        });
		this.add(this.btn1);
	}
	
	public void active() {
		this.setVisible(true);
	}
	
	public void deactive() {
		this.setVisible(false);
	}
}