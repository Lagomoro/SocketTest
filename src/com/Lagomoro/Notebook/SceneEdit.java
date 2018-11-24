package com.Lagomoro.Notebook;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*; 

public class SceneEdit extends JFrame{

	/*
	private JLabel background1, text1, text2, image1;
	private JButton btn1;
	private JTextField input1;
	private JPasswordField password1;
	private JCheckBox checkbox1, checkbox2;
	private final Color mainColor = new Color(0,129,187);
	private final Font bigFont = new Font("Microsoft YaHei UI Light",Font.TYPE1_FONT,40); 
	*/
	private JTextArea textArea1;
	private JScrollPane scrollPane1;
	private JMenuBar menuBar;
	private JMenu fileMenu,editMenu,aboutMenu;
	private JMenuItem newMenuItem,openMenuItem,saveMenuItem;
	private JMenuItem repealMenuItem,reformMenuItem;
	private JMenuItem aboutMenuItem,exitMenuItem;
	
	private SceneLogin loginScene;
	private SceneAbout aboutScene;
	
	public SceneEdit(){
		this.initialize();
		this.create();
	}
	
	private void initialize(){
		this.setTitle("记事本-未命名.txt");
		this.setResizable(true);
		this.setSize(812, 624);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setVisible(true);
		this.setLayout(null);
	}
	
	private void create() {
		this.createMenu();
		this.createContent();
	}
	
    private void createMenu() {
    	SceneEdit that = this;
        
    	this.menuBar = new JMenuBar();
    	this.setJMenuBar(menuBar);
        
    	//this.fileMenu = new JMenu("文件");
    	//this.editMenu = new JMenu("编辑");
    	this.aboutMenu = new JMenu("关于");
        //menuBar.add(fileMenu);
        //menuBar.add(editMenu);
        menuBar.add(aboutMenu);
        /*
        this.newMenuItem = new JMenuItem("新建");
        this.openMenuItem = new JMenuItem("打开");
        this.saveMenuItem = new JMenuItem("保存");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        
        this.repealMenuItem = new JMenuItem("撤销");
        this.repealMenuItem.addMouseListener(new MouseAdapter() {
			private boolean moveIn = false;
            @Override
            public void mouseReleased(MouseEvent e) {
            	if(this.moveIn) {
            		that.commandRepeal();
            	}
            }
            public void mouseEntered(MouseEvent e) {
            	this.moveIn = true;
            }
            public void mouseExited(MouseEvent e) {
            	this.moveIn = false;
            }
        });
        this.reformMenuItem = new JMenuItem("重做");
        this.reformMenuItem.addMouseListener(new MouseAdapter() {
			private boolean moveIn = false;
            @Override
            public void mouseReleased(MouseEvent e) {
            	if(this.moveIn) {
            		that.commandReform();
            	}
            }
            public void mouseEntered(MouseEvent e) {
            	this.moveIn = true;
            }
            public void mouseExited(MouseEvent e) {
            	this.moveIn = false;
            }
        });
        editMenu.add(repealMenuItem);
        editMenu.add(reformMenuItem);
        */
        this.aboutMenuItem = new JMenuItem("关于");
        this.aboutMenuItem.addMouseListener(new MouseAdapter() {
			private boolean moveIn = false;
            @Override
            public void mouseReleased(MouseEvent e) {
            	if(this.moveIn) {
            		aboutScene.setVisible(true);
            	}
            }
            public void mouseEntered(MouseEvent e) {
            	this.moveIn = true;
            }
            public void mouseExited(MouseEvent e) {
            	this.moveIn = false;
            }
        });
        this.exitMenuItem = new JMenuItem("退出");
        this.exitMenuItem.addMouseListener(new MouseAdapter() {
			private boolean moveIn = false;
            @Override
            public void mouseReleased(MouseEvent e) {
            	if(this.moveIn) {
            		that.deactive();;
                    loginScene.active();;
            	}
            }
            public void mouseEntered(MouseEvent e) {
            	this.moveIn = true;
            }
            public void mouseExited(MouseEvent e) {
            	this.moveIn = false;
            }
        });
        aboutMenu.add(aboutMenuItem);
        aboutMenu.add(exitMenuItem);
	}
    
    private void createContent() {
    	this.textArea1 = new JTextArea();
        textArea1.setLineWrap(true);
        
        this.scrollPane1 = new JScrollPane(textArea1);
        this.setContentPane(scrollPane1);
	}

    private void commandRepeal() {
    	
    }
    
    private void commandReform() {
    	
    }
    
	protected void setLoginScene(SceneLogin loginScene) {
		this.loginScene = loginScene;
	}
	
	protected void setAboutScene(SceneAbout aboutScene) {
		this.aboutScene = aboutScene;
	}
	
	public void active() {
		this.setVisible(true);
	}
	
	public void deactive() {
		this.setVisible(false);
	}
}