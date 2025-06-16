package model;

import java.util.ArrayList;

public class Client {
    public int id;
    public String name, email, cpf, address, phone;
    public ArrayList<Service> services = new ArrayList<>();

    public Client(String name, String email, String cpf, String address, String phone) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
      return name;
    }

    public String getEmail(){
      return email;
    }

    public String getCpf() {
      return cpf;
    }

    public String getAddress() {
      return address;
    }

    public String getPhone() {
      return phone;
    }
}