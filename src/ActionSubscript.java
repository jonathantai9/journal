import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.StyledTextAction;


public class ActionSubscript extends StyledTextAction
{
	public ActionSubscript()
	{
		super("<html>X<sub>2</sub></html>");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		   JTextPane editor = (JTextPane) getEditor(e);
		    if (editor != null)
		    {
		      StyledEditorKit kit = getStyledEditorKit(editor);
		      MutableAttributeSet attr = kit.getInputAttributes();
		      if(!StyleConstants.isSuperscript(attr))
		      {
			      boolean sub = (StyleConstants.isSubscript(attr)) ? false : true;
			      SimpleAttributeSet attribute = new SimpleAttributeSet();
			      StyleConstants.setSubscript(attribute, sub);
			      setCharacterAttributes(editor, attribute, false);
			      int i = editor.getSelectionStart();
			      int j = editor.getSelectionEnd() - i;
			      editor.getStyledDocument().setCharacterAttributes(i, j, attribute, false);
		      }
		    }
		
	}
}
