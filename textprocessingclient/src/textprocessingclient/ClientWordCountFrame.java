package textprocessingclient;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//This code made by Muhammad Imran B032120025
public class ClientWordCountFrame extends JFrame{
private static final long serialVersionUID = 1L;
	
	private JLabel lblServerCount;
	private JLabel lblStatusValue;
	

	private int width = 700;
	private int height = 200;


	public ClientWordCountFrame () {
		
		// Default frame setting
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Word Count Application: Client Side");
		this.setSize(width, height);
		
		
		// Center the frame on the screen
        this.setLocationRelativeTo(null);
		
		// Initialize default value for label
		lblServerCount = new JLabel("-");
		lblStatusValue = new JLabel("-");
		
		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Organize components
		loadComponent();
		
	}
	
	
	public void updateServerWordCount (String serverWordCount) {
		
		this.lblServerCount.setText(serverWordCount);
		
	}
	

	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		
				
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	

	private JPanel getConnectionStatusPanel(Font font) {
		
		// Create component
		JPanel panel = new JPanel();
		JLabel lblConnStatus = new JLabel ("Connection status: ");
		
		// Style the component
		lblConnStatus.setFont(font);
		lblStatusValue.setFont(font);
		lblConnStatus.setBackground(Color.WHITE);
		lblConnStatus.setOpaque(true);
		lblStatusValue.setBackground(Color.WHITE);
		lblStatusValue.setOpaque(true);
		
		// Organize components into panel
		panel.add(lblConnStatus);
		panel.add(lblStatusValue);
		
		return panel;
		
	}
	

	private JPanel getServerWordCountPanel(Font font) {
		
		// Create component to display word count retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblCount = new JLabel ("Word Count (from Server): ");

		// Style the component
		lblCount.setFont(font);
		lblServerCount.setFont(font);
		lblCount.setBackground(Color.WHITE);
		lblCount.setOpaque(true);
		lblServerCount.setBackground(Color.WHITE);
		lblServerCount.setOpaque(true);

		// Organize components into panel
		panel.add(lblCount);
		panel.add(lblServerCount);
		
		return panel;
	} 
	
	
	private void loadComponent() {
		
		// Get font
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.getConnectionStatusPanel(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		// Get server word count panel and add to frame
		JPanel center = getServerWordCountPanel(font);
		this.add(center, BorderLayout.CENTER);
		
	}
	
	
	private Font getFontStyle() {
		
		Font font = new Font ("Serif", Font.PLAIN, 30);
		
		return font;
		
	}
}
