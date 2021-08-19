package src;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Test {
    public static void main(String[] args) throws JRException {
        @SuppressWarnings("unchecked")
        String sourceFileName =
                "C:\\Users\\xiao\\JaspersoftWorkspace\\MyReports\\bin\\Blank_A4.jasper";
        String printFileName = null;
        BeanList BeanList = new BeanList();
        ArrayList dataList = BeanList.getBeanList();

        JRBeanCollectionDataSource beanColDataSource =
                new JRBeanCollectionDataSource(dataList);

        Map parameters = new HashMap();
        try {
            printFileName = JasperFillManager.fillReportToFile(
                    sourceFileName,
                    parameters,
                    beanColDataSource);
            if (printFileName != null) {
                JasperPrintManager.printReport(
                        printFileName, true);
            }
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}

class Bean {
    private String name;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

class BeanList {
    public ArrayList<Bean> getBeanList() {
        ArrayList<Bean> BeanList = new ArrayList<Bean>();

        BeanList.add(produce("Manisha", "India"));
        BeanList.add(produce("Dennis Ritchie", "USA"));
        BeanList.add(produce("V.Anand", "India"));
        BeanList.add(produce("Shrinath", "California"));

        return BeanList;
    }

    /**
     * This method returns a DataBean object,
     * with name and country set in it.
     */
    private Bean produce(String name, String country) {
        Bean dataBean = new Bean();
        dataBean.setName(name);
        dataBean.setCountry(country);
        return dataBean;
    }
}
