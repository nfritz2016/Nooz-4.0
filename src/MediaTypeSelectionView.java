import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Nathan Fritz - 113294199
 * @author Alex Kloppenburg - 113388722
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 * @author Dean Hougen
 *
 */
public class MediaTypeSelectionView extends JPanel {
	
	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    JCheckBox jcbNewspaper = new JCheckBox(NewsMedia.NEWSPAPER.toString());
    
    /**
     * 
     */
    JCheckBox jcbTVNews = new JCheckBox(NewsMedia.TV.toString());
    
    /**
     * 
     */
    JCheckBox jcbOnline = new JCheckBox(NewsMedia.ONLINE.toString());

    /**
     * 
     */
    private JLabel jlblMediaType = new JLabel("Display news stories from which media type(s)?");
    
    /**
     * 
     */
    private JPanel jpMediaType = new JPanel(new GridLayout(0, 1));
    
    /**
     * 
     */
    private JButton jbBlank = new JButton();
    
    /**
     * 
     */
    JButton jbCancel = new JButton("Cancel");
    
    /**
     * 
     */
    JButton jbOkay = new JButton("OK");
    
    /**
     * 
     */
    private JPanel jpCompletionButtons = new JPanel(new GridLayout(1, 0));
    
    
    /**
     * @author Dean Hougen
     */
    public MediaTypeSelectionView() {
    	
    	//set button visiblity, text, and commands
        this.jbBlank.setVisible(false);
        this.jbOkay.setActionCommand("OK");
        this.jbOkay.setSelected(true);
        this.jbCancel.setActionCommand("Cancel");
        
        //add buttons to button panel
        this.jpCompletionButtons.add(this.jbBlank);
        this.jpCompletionButtons.add(this.jbCancel);
        this.jpCompletionButtons.add(this.jbOkay);
        
        //add everything to button panel
        this.jpMediaType.add(this.jlblMediaType);
        this.jpMediaType.add(this.jcbNewspaper);
        this.jpMediaType.add(this.jcbTVNews);
        this.jpMediaType.add(this.jcbOnline);
        this.jpMediaType.add(this.jpCompletionButtons);
        this.jpMediaType.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //add the panel to the class JFrame
        this.add(this.jpMediaType);
    }
}