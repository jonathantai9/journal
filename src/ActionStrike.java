import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.StyledTextAction;


public class ActionStrike extends StyledTextAction
{
	public ActionStrike()
	{
		super("<html><a style='text-decoration:line-through'>A</a></html>");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		   JTextPane editor = (JTextPane) getEditor(e);
		    if (editor != null)
		    {
		      StyledEditorKit kit = getStyledEditorKit(editor);
		      MutableAttributeSet attr = kit.getInputAttributes();
		      boolean strike = (StyleConstants.isStrikeThrough(attr)) ? false : true;
		      SimpleAttributeSet attribute = new SimpleAttributeSet();
		      StyleConstants.setStrikeThrough(attribute, strike);
		      setCharacterAttributes(editor, attribute, false);
		      int i = editor.getSelectionStart();
		      int j = editor.getSelectionEnd() - i;
		      editor.getStyledDocument().setCharacterAttributes(editor.getSelectionStart(), j, attribute, false);
		    }
		
	}
}
