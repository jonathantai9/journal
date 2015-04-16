import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;


public class Main extends JFrame
{
	public static JPanel titlePanel, entryPanel, newEntryPanel, menuPanel;
	public static JLabel title, menu;
	public static JButton newEntry;
	private static ImageIcon splash;
	private static boolean entryOpen = false;
	
	public Main()
	{
		splash = new ImageIcon("ServiceJournal.png");
		
		JLabel jlabel = new JLabel(splash);
		JWindow splashScreen = new JWindow();
		splashScreen.getContentPane().add(jlabel);
		splashScreen.setSize(1920, 1080);
		splashScreen.setLocationRelativeTo(null);
		splashScreen.setVisible(true);
		try
		{
			Thread.sleep(100L); //4500
		}
		catch(InterruptedException interruptedexception)
		{
			interruptedexception.printStackTrace();
		}
		
		splashScreen.setVisible(false);
		splashScreen.dispose();
		setTitle("Service Journal");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setResizable(false);
		
		title = new JLabel("Service Journal");
		title.setFont(new Font("Century Gothic", Font.PLAIN, 60));
		title.setSize(new Dimension(1600, 100));
		
		newEntry = new JButton("New Entry");
		newEntry.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		newEntry.setPreferredSize(new Dimension(1600, 100));
		newEntry.setBorder(new LineBorder(Color.BLACK));
		newEntry.setFocusPainted(false);
		newEntry.setCursor(new Cursor(Cursor.HAND_CURSOR));
		newEntry.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EntryManager.addEntry();
				entryOpen = true;
			}
			
		});
		newEntry.addMouseListener(new MouseAdapter()
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt)
		    {
		        newEntry.setBackground(Color.decode("#2E64FE"));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	newEntry.setBackground(UIManager.getColor("control"));
		    }
		});
		
		menu = new JLabel("                 Menu");
		menu.setFont(new Font("Century Gothic", Font.PLAIN, 50));
		menu.setPreferredSize(new Dimension(600, 90));
		menu.setBorder(new LineBorder(Color.BLACK));
		
		titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(1600, 100));
		titlePanel.setBorder(new LineBorder(Color.BLACK));
		titlePanel.setBackground(Color.WHITE);
		titlePanel.add(title);
		
		entryPanel = new JPanel();
		entryPanel.setPreferredSize(new Dimension(1000, 900));
		entryPanel.setBorder(new LineBorder(Color.BLACK));
		entryPanel.setBackground(Color.WHITE);
		
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(600, 1100));
		menuPanel.setBorder(new LineBorder(Color.BLACK));
		menuPanel.setBackground(Color.WHITE);
		menuPanel.add(menu);
		
		newEntryPanel = new JPanel();
		newEntryPanel.setPreferredSize(new Dimension(1600, 100));
		newEntryPanel.setBorder(new LineBorder(Color.BLACK));
		newEntryPanel.setBackground(Color.BLACK);
		newEntryPanel.add(newEntry);
		
		getContentPane().add(titlePanel, BorderLayout.NORTH);
		getContentPane().add(entryPanel, BorderLayout.WEST);
		getContentPane().add(menuPanel, BorderLayout.EAST);
		getContentPane().add(newEntryPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		new Main();
	}
}
