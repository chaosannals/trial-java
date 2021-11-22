package trial.java.jasperreport.view;

import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.swing.JRViewer;

public class DemoViewer extends JRViewer {

    public DemoViewer(InputStream is, boolean isXML) throws JRException {
        super(is, isXML);
        
    }
    
}
