import java.awt.*;
import javax.swing.*; 

public class QQ_login extends JFrame{
	
	public static void main(String args[]){ 
	    new QQ_login();
	}

	private JLabel background1, text1, text2, image1;
	private JButton btn1;
	private JTextField input1;
	private JPasswordField password1;
	private JCheckBox checkbox1, checkbox2;
	private final Color mainColor = new Color(0,129,187);
	private final Font bigFont = new Font("Microsoft YaHei UI Light",Font.TYPE1_FONT,40); 
	
	public QQ_login(){
		this.initialize();
		this.create();
	}
	
	private void initialize(){
		this.setTitle("QQ 2018");
		this.setResizable(false);
		this.setSize(420, 323);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
	}
	
	private void create() {
		this.background1 = new JLabel("I'm QQ", JLabel.CENTER);
		this.background1.setBounds(0, 0, 420, 140);
		this.background1.setBackground(mainColor);
		this.background1.setForeground(Color.WHITE);
		this.background1.setFont(bigFont);
		this.background1.setOpaque(true);
		this.add(this.background1);
		
		this.image1 = new JLabel();
		this.image1.setBackground(mainColor);
		this.image1.setBounds(20, 150, 100, 100);
		this.image1.setOpaque(true);
		this.add(image1);
		
		this.text1 = new JLabel("◊¢≤·’À∫≈");
		this.text1.setBounds(330, 150, 80, 30);
		this.text1.setForeground(mainColor);
		this.add(this.text1);
		
		this.text2 = new JLabel("’“ªÿ√‹¬Î");
		this.text2.setBounds(330, 180, 80, 30);
		this.text2.setForeground(mainColor);
		this.add(this.text2);
		
		this.input1 = new JTextField("«Î ‰»ÎQQ∫≈");
		this.input1.setBounds(140, 150, 180, 30);
		this.add(this.input1);
		
		this.password1 = new JPasswordField("«Î ‰»Î√‹¬Î");
		this.password1.setBounds(140, 180, 180, 30);
		this.add(this.password1);
		
		this.checkbox1 = new JCheckBox("º«◊°√‹¬Î");
		this.checkbox1.setBounds(140, 215, 90, 20);
		this.add(this.checkbox1);
		
		this.checkbox2 = new JCheckBox("◊‘∂Øµ«¬º");
		this.checkbox2.setBounds(250, 215, 90, 20);
		this.add(this.checkbox2);
		
		this.btn1 =new JButton("∞≤  »´  µ«  ¬º");
		this.btn1.setBounds(140, 240, 180, 30);
		this.add(this.btn1);
	}

}