import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//This code made by Muhammad Imran B032120025

public class TextTranslateFrameClient extends JFrame implements ActionListener{
	private JLabel title, lblAns;
	private JButton bm, arb, krn;
	private JTextField input;
	
	// Private attributes for frame size
	private int width = 750;
	private int height = 200;
	
	// private attribute for obtain input
	private String textinput = "";
	private String language = "";
	
	// private attribute for checking button is pressed or not
	private boolean pressed = false;
	
	public TextTranslateFrameClient()
	{
		// Default frame setting
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("TCP Translator: ");
		this.setSize(new Dimension(width, height));
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//center window
		this.setLocationRelativeTo(null);
		
		
		// display label to display for enter text for translate
		this.title = new JLabel("Enter text for translation: ");
		this.lblAns = new JLabel("");
		
		// settings for text field input
		this.input = new JTextField (20);
		
		// button for target language selection
		this.bm = new JButton("Malay");
		this.arb = new JButton("Arabic");
		this.krn = new JButton("Korean");
		
		// add action listener for these buttons
		bm.addActionListener(this);
		arb.addActionListener(this);
		krn.addActionListener(this);
		
		loadForm();
	}
	
	
	private JPanel topPanel(Font font)
	{
		JPanel panel = new JPanel();
		title.setFont(new Font("Serif", Font.PLAIN, 21));
		input.setFont(font);
		input.setOpaque(true);
		title.setOpaque(true);
		panel.add(title);
		panel.add(input);
		return panel;
	}
	

	private JPanel centerPanel(Font font)
	{
		JPanel panel = new JPanel();
		bm.setFont(font);
		arb.setFont(font);
		krn.setFont(font);
		bm.setOpaque(true);
		arb.setOpaque(true);
		krn.setOpaque(true);
		panel.add(bm);
		panel.add(arb);
		panel.add(krn);
		return panel;
	}
	
	
	private JPanel bottomPanel(Font font)
	{
		JPanel panel = new JPanel();
		lblAns.setOpaque(true);
		lblAns.setFont(font);
		panel.add(lblAns);
		return panel;
	}
	


	private Font getFontStyle() 
	{
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}

	// arrange the swings components to the frame
	private void loadForm()
	{
		Font font = this.getFontStyle();
		
		JPanel top = this.topPanel(font);
		getContentPane().add(top, BorderLayout.NORTH);
		
		JPanel center = this.centerPanel(font);
		getContentPane().add(center, BorderLayout.CENTER);
		
		JPanel btm = this.bottomPanel(font);
		getContentPane().add(btm, BorderLayout.SOUTH);
	}
	
	
	public void setAnsLbl(String translated)
	{
		lblAns.setText(translated);
	}
	
	public void updateConnectionStatus (boolean connStatus) 
	{
		
		// Default status. Assuming for the worst case scenario.
		this.setTitle("TCP Translator: No connection to server.");
		
		// Validate status of connection
		if (connStatus)
			this.setTitle("TCP Translator: Connection has established.");
	}
	

	public String getLanguage() 
	{
		return this.language;
	}
	

	public String getText() 
	{
		return this.textinput;
	}
	

	private void setFonttoArabic()
	{
		lblAns.setFont(new Font("Arabic",Font.PLAIN,30));
	}
	

	private void setFonttoKorean()
	{
		lblAns.setFont(new Font("Malgun Gothic", Font.PLAIN, 30));
	}
	

	public boolean ispressed()
	{
		return pressed;
	}
	

	public void updatebtn(boolean b)
	{
		pressed = b;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if(e.getSource()== bm)
		{
			updatebtn(true);
			textinput = input.getText();
			language = "malay";	
			lblAns.setFont(getFontStyle());	
			TextTranslateApplicationClient.btnPressed();

		}
		else if(e.getSource()== arb)
		{
			updatebtn(true);
			textinput = input.getText();
			language = "arab";
			setFonttoArabic();
			TextTranslateApplicationClient.btnPressed();

		}
		else
		{
			updatebtn(true);
			textinput = input.getText();
			language = "korean";
			setFonttoKorean();
			TextTranslateApplicationClient.btnPressed();
		}
		
	}
}
