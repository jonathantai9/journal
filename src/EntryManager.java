import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public abstract class EntryManager implements MouseListener
{
	public static void addEntry()
	{
		final Color grey = new Color(240,240,240);
		final Color white = new Color(255,255,255);
		JFrame entryFrame = new JFrame();
		entryFrame.setSize(1400, 700);
		entryFrame.setResizable(false);
		entryFrame.setTitle("New Entry");
		
		JTextArea titleArea = new JTextArea("Insert Title Here");
		titleArea.setLineWrap(true);
		titleArea.setPreferredSize(new Dimension(1190, 30));
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Courier New", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(1190, 620));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel textPanel = new JPanel(new BorderLayout());
		textPanel.setPreferredSize(new Dimension(1150, 700));
		textPanel.setBackground(Color.WHITE);
		textPanel.add(titleArea, BorderLayout.NORTH);
		textPanel.add(scrollPane, BorderLayout.SOUTH);
		textPanel.setBorder(new LineBorder(Color.BLACK));
		
		final JButton save = new JButton("Save Entry");
		save.setPreferredSize(new Dimension(180, 50));
		save.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		save.setBorder(new LineBorder(Color.BLACK));
		save.setCursor(new Cursor(Cursor.HAND_CURSOR));
		save.setFocusPainted(false);
		save.setContentAreaFilled(false);
		
		save.addActionListener(new Save());
		save.addMouseListener(new MouseAdapter(){
	         public void mouseEntered(MouseEvent e) {
	            save.setForeground(grey);
	           
	         } 
	        			
	      });
		save.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
		            save.setForeground(new Color(0,0,0));
		           
		         } 
		  
	      });
				
		JButton pictures = new JButton("Pictures");
		pictures.setPreferredSize(new Dimension(180, 50));
		pictures.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		pictures.setBorder(new LineBorder(Color.BLACK));
		pictures.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pictures.setFocusPainted(false);
		pictures.setContentAreaFilled(false);
		
		Action actionBold = new ActionBold();
		Action actionItalic = new ActionItalic();
		Action actionUnderline = new ActionUnderline();
		Action actionStrike = new ActionStrike();
		Action actionSubscript = new ActionSubscript();
		Action actionSuperscript = new ActionSuperscript();
		Action actionColor = new ActionColor();
		Action actionHighlight = new ActionHighlight();
		//Action actionFont = new ActionFont();
		
		JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setBorder(new LineBorder(Color.BLACK));
		separator.setPreferredSize(new Dimension(200, 1));
		
		JButton bold = new JButton("B");
		bold.setFont(new Font("Century Gothic", Font.BOLD, 18));
		bold.setAction(actionBold);
		bold.setFocusable(false);
		
		JButton italics = new JButton("i");
		italics.setFont(new Font("Century Gothic", Font.ITALIC, 18));
		italics.setAction(actionItalic);
		italics.setFocusable(false);
		
		JButton underline = new JButton("<html><a style='text-decoration:underline'>U</a></html>");
		underline.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		underline.setAction(actionUnderline);
		underline.setFocusable(false);
		
		JButton strike = new JButton("<html><a style='text-decoration:line-through'>A</a></html>");
		strike.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		strike.setAction(actionStrike);
		strike.setFocusable(false);
		
		JButton subscript = new JButton("<html>X<sub>2</sub></html>");
		subscript.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		subscript.setAction(actionSubscript);
		subscript.setFocusable(false);
		
		JButton superscript = new JButton("<html>X<sup>2</sup></html>");
		superscript.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		superscript.setAction(actionSuperscript);
		superscript.setFocusable(false);
		
		JButton color = new JButton("Color");
		color.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		color.setAction(actionColor);
		color.setFocusable(false);
		
		JButton highlight = new JButton("<html><span style='background-color: #FFFF00'>A</span><html>");
		highlight.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		highlight.setAction(actionHighlight);
		highlight.setFocusable(false);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(200, 700));
		menuPanel.setLayout(new FlowLayout());
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setBorder(new LineBorder(Color.BLACK));
		menuPanel.add(pictures);
		menuPanel.add(save);
		menuPanel.add(separator);
		menuPanel.add(bold);
		menuPanel.add(italics);
		menuPanel.add(underline);
		menuPanel.add(strike);
		menuPanel.add(subscript);
		menuPanel.add(superscript);
		menuPanel.add(color);
		menuPanel.add(highlight);
		
		entryFrame.getContentPane().add(textPanel, BorderLayout.WEST);
		entryFrame.getContentPane().add(menuPanel, BorderLayout.EAST);
		entryFrame.setVisible(true);
	}

	
	
	
	
}
//Implements a save dialogue box
class Save implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JFileChooser c = new JFileChooser();
		int sVal = c.showSaveDialog(null);
		
		if(sVal == JFileChooser.APPROVE_OPTION)
		{
			//TODO
			//Implement Save action
		}
	}
}