package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Service {
    public int id;
    public Client client;
    public Device device;
    public String defect;
    public Double value;
    public LocalDateTime serviceDate;
    public ArrayList<Guarantee> guarantees = new ArrayList<>();

    public Service(Client client, Device device, String defect, Double value, LocalDateTime serviceDate) {
        this.client = client;
        this.device = device;
        this.defect = defect;
        this.value = value;
        this.serviceDate = serviceDate;
    }

    public Client getClient(){
      return this.client;
    }

    public Double getValue(){
      return this.value;
    }

    public Device getDevice(){
      return this.device;
    }

    public String getDefect(){
      return this.defect;
    }

    public Guarantee getLastGuarantee() {
        return guarantees.isEmpty() ? null : guarantees.get(guarantees.size() - 1);
    }

    public String getFormatedServiceDate() {
        return String.format("%02d/%02d/%04d", serviceDate.getDayOfMonth(), serviceDate.getMonthValue(), serviceDate.getYear());
    }
}