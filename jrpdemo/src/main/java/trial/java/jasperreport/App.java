/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trial.java.jasperreport;

import java.util.*;
import java.io.*;

import com.google.gson.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.*;

public class App {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println("jasperreport");
        try {
            // 这个必须独立的文件，不能被打包到 jar 里面。
            JasperReport jr = JasperCompileManager.compileReport("./src/main/resources/demo.jrxml");
            
            Gson gson = new Gson();
            // 使用中文键要注意字符集， GSON 的字符集是由读入的留决定的。
            String jt = DemoUtil.readResourceString("/demo.json");
            HashMap<String, Object> d = gson.fromJson(jt, HashMap.class);
            
            Map<String, Object> gy = (Map)d.get("概要"); // 作为参数传入 $P{XXXX}
            // gy.put("时间", new Date(System.currentTimeMillis()));
            List<HashMap> a = (List)d.get("数据列表"); // 作为数据源 $F{XXX}
            JRDataSource ds = new JRBeanCollectionDataSource(a);
            JasperPrint jp = JasperFillManager.fillReport(jr, gy, ds);
            // JasperExportManager.exportReportToPdfFile(jp, "demo.pdf");
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.pack();
        }
         catch (JRException | JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
