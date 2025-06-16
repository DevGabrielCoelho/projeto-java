package controller;

import javafx.scene.web.WebEngine;
import model.Service;
import netscape.javascript.JSObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WebController {
    private WebEngine engine;
    private List<Service> services;
    private int range = 5;

    public void setEngine(WebEngine engine) {
        this.engine = engine;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void switchTableRange(String val) {
        try {
            range = Integer.parseInt(val);
            loadHtmlWithData();
        } catch (NumberFormatException e) {
            System.err.println("Valor inválido: " + val);
        }
    }

    public void loadHtmlWithData() {
        try {
            String htmlContent = Files.readString(Paths.get("./src/view/page.html"));
            StringBuilder list = new StringBuilder();

            for (int i = 0; i < Math.min(range, services.size()); i++) {
                Service svc = services.get(i);

                String valorFormatado = String.format("R$ %,.2f", svc.getValue()).replace('.', ',');
                String jsArray = String.format(
                        "['%d','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'], %s",
                        i + 1,
                        svc.getClient().getName(), 
                        svc.getClient().getCpf(), 
                        svc.getClient().getAddress(), 
                        svc.getClient().getPhone(),
                        svc.getDevice().getType().getName(), 
                        svc.getDevice().getBrand(), 
                        svc.getDevice().getModel(), 
                        svc.getDevice().getSerialNumber(),
                        svc.getDevice().getDefect(), 
                        svc.getFormatedServiceDate(), 
                        svc.getDefect(), 
                        svc.getLastGuarantee().getTime(),
                        svc.getLastGuarantee().isEnd()
                );

                list.append(String.format("""
                    <tr>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td><button class="btn btn-sm" style="background-color: #18a689; color: #fff;" onclick="openModal(%s)">Detalhes</button></td>
                    </tr>
                """, 
                i + 1, 
                svc.getClient().getName(), 
                svc.getClient().getCpf(), 
                svc.getDevice().getBrand() + " - " +svc.getDevice().getModel(),
                valorFormatado, 
                svc.getLastGuarantee().getStatus(), 
                jsArray));
            }

            htmlContent = htmlContent.replace("%responsive-clients-tbody", list.toString());
            htmlContent = htmlContent.replace("%client-item-index-init", "1");
            htmlContent = htmlContent.replace("%client-item-index-final", String.valueOf(Math.min(range, services.size())));
            htmlContent = htmlContent.replace("%client-total-items", String.valueOf(services.size()));
            htmlContent = htmlContent.replace("%selected_5%", range == 5 ? "selected" : "");
            htmlContent = htmlContent.replace("%selected_10%", range == 10 ? "selected" : "");
            htmlContent = htmlContent.replace("%selected_25%", range == 25 ? "selected" : "");

            engine.loadContent(htmlContent);

        } catch (Exception e) {
            e.printStackTrace();
            engine.loadContent("<html><body><h2>Erro ao carregar HTML</h2></body></html>");
        }
    }

    public String notifyUser(int id) {
        services.get(id).getLastGuarantee().setNotificated(true);
        return String.format("O cliente %s foi notificado pelo email: %s", services.get(id).getClient().getName(), services.get(id).getClient().getEmail());
    }

    public void injectJavaScriptBridge() {
        JSObject window = (JSObject) engine.executeScript("window");
        window.setMember("app", this);
        engine.executeScript("""
            window.switchTableRange = function(value) {
                if (window.app && typeof window.app.switchTableRange === 'function') {
                    window.app.switchTableRange(value);
                } else {
                    alert('Método switchTableRange não disponível');
                }
            };

            const select = document.querySelector("select");
            if (select && !select.dataset.bound) {
                select.dataset.bound = "true";
                select.addEventListener("change", function() {
                    switchTableRange(this.value);
                });
            }
        """);
    }
}
