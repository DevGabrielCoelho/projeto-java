package model;

public class Device {
    public int id;
    public Type type;
    public String brand, model, serialNumber, password, defect;
    public Service service;
    public Client client;

    public Device(Type type, String brand, String model, String serialNumber, String password, String defect, Client client) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.password = password;
        this.defect = defect;
        this.client = client;
    }

    public Type getType() {
      return type;
    }

    public String getBrand() {
      return brand;
    }

    public String getModel() {
      return model;
    }

    public String getSerialNumber() {
      return serialNumber;
    }

    public String getDefect(){
      return defect;
    }
}