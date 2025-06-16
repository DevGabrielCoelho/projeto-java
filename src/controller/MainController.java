package controller;

import javafx.scene.web.WebEngine;
import model.DataFactory;
import model.Service;
import model.Guarantee;

import java.util.List;
import java.util.ArrayList;

public class MainController {
    private final WebController webController = new WebController();
    private List<Service> services;

    public void setEngine(WebEngine engine) {
        webController.setEngine(engine);
    }

    public void loadHtmlWithData() {
        Service[] servicesArray = DataFactory.createSampleServices();
        services = java.util.Arrays.asList(servicesArray);
        webController.setServices(services);
        webController.loadHtmlWithData();
    }

    public void injectJavaScriptBridge() {
        webController.injectJavaScriptBridge();
    }

    public List<Guarantee> getGuarantee(){
      List<Guarantee> guarantees = new ArrayList<Guarantee>();
      for(Service service : services){
        guarantees.add(service.getLastGuarantee());
      }
      return guarantees;
    }
}
