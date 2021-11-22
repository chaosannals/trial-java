package trial.java.jasperreport;

import java.util.*;
import net.sf.jasperreports.engine.*;

public class EmptyDemo {
    public static void newEmptyDemoPdf() {
        try {
            JasperReport jr = JasperCompileManager.compileReport(App.class.getResourceAsStream("/empty.jrxml"));
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<>(), new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jp, "empty.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
