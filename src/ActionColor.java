import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit.StyledTextAction;

public class ActionColor extends StyledTextAction
{
	public JColorChooser colorChooser = new JColorChooser();
	public JDialog dialog = new JDialog();
	public boolean changed = true;
	public Color color;
	
	public ActionColor()
	{
		super("<html><font color='yellow'>A</font></html>");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JTextPane editor = (JTextPane) getEditor(e);
		if (editor != null)
		{
			int i = editor.getSelectionStart();
			
			StyledDocument doc = getStyledDocument(editor);
			Element paragraph = doc.getCharacterElement(i);
			AttributeSet as = paragraph.getAttributes();
			
			color = StyleConstants.getForeground(as);
			if(color == null)
				color = Color.BLACK;
			colorChooser.setColor(color);
			
			JButton ok = new JButton("OK");
			ok.addActionListener(new ActionListener()
			{
				@Override()
				public void actionPerformed(ActionEvent e)
				{
					color = colorChooser.getColor();
					dialog.dispose();
				}
			});
			
			JButton cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener()
			{
				@Override()
				public void actionPerformed(ActionEvent e)
				{
					changed = false;
					dialog.dispose();
				}
			});
			
			JPanel panel = new JPanel();
			panel.add(ok);
			panel.add(cancel);
			
			dialog.getContentPane().setLayout(new BorderLayout());
			dialog.getContentPane().add(colorChooser, BorderLayout.CENTER);
			dialog.getContentPane().add(panel, BorderLayout.SOUTH);
			dialog.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
			dialog.pack();
			dialog.setVisible(true);
			
	        MutableAttributeSet attr = null;
	        if (editor != null)
	        {
	          if (color != null && changed)
	          {
	            attr = new SimpleAttributeSet();
	            StyleConstants.setForeground(attr, color);
	            setCharacterAttributes(editor, attr, false);
	          }
	        }
	      changed = true;
		}
	}
	
}
