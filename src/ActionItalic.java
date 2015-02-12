import java.awt.event.ActionEvent;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.StyledTextAction;


public class ActionItalic extends StyledTextAction
{
	public ActionItalic()
	{
		super("i");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		   JTextPane editor = (JTextPane) getEditor(e);
		    if (editor != null)
		    {
		      StyledEditorKit kit = getStyledEditorKit(editor);
		      MutableAttributeSet attr = kit.getInputAttributes();
		      boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
		      SimpleAttributeSet attribute = new SimpleAttributeSet();
		      StyleConstants.setItalic(attribute, italic);
		      setCharacterAttributes(editor, attribute, false);
		      int i = editor.getSelectionStart();
		      int j = editor.getSelectionEnd() - i;
		      editor.getStyledDocument().setCharacterAttributes(editor.getSelectionStart(), j, attribute, false);
		    }
		
	}
}
