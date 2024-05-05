import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Prog7.PotholeReport;
public class GUI implements ActionListener {
	JFrame frame = new JFrame();
    JTextField text1 = new JTextField(20);
    JTextField text2 = new JTextField(20);
    JTextField text3 = new JTextField(20);
    JTextField text4 = new JTextField(20);

    JButton button = new JButton("Submit"); //Changes the button text
    JLabel message1 = new JLabel("Address of Pothole:");
    JLabel message2 = new JLabel("Location in Street:");
    JLabel message3 = new JLabel("Size of Pothole:");
    JLabel message4 = new JLabel("Type of Repair Needed:");
    JLabel messagetest = new JLabel("1");
    JPanel panel = new JPanel();
    String phAddress;
    String phStreetLocation;
    Integer phSize;
    String phRepairType;
    public static void main(String[] args) {
        
    }

    public GUI() {

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        
        panel.add(message1);
        panel.add(text1);
        
        panel.add(message2);
        panel.add(text2);
      
        
        panel.add(message3);
        panel.add(text3);
  
        
        panel.add(message4);
        panel.add(text4);
  
        
        button.addActionListener(this);
        
        
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pothole Reporting System");
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == button)
		{ 
    		PotholeReport.setPhAddress(text1.getText());
    		PotholeReport.setPhStreetLocation(text2.getText());
    		PotholeReport.setPhSize(Integer.parseInt(text3.getText()));
    		PotholeReport.setPhRepairType(text4.getText());
    		
    		System.out.println("\nPothole Report Details:");
            System.out.println("Citizen Report ID: " + PotholeReport.getReportID());
            System.out.println("Address: " + PotholeReport.getPhAddress());
            System.out.println("Street Location: " + PotholeReport.getPhStreetLocation());
            System.out.println("Size: " + PotholeReport.getPhSize());
            System.out.println("Repair Type: " + PotholeReport.getPhRepairType());
    		
		}
    	else if (e.getSource()== button)
		{
			System.exit(0);
		} 
			
    }

	
}

