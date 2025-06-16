package model;

import java.time.LocalDateTime;

public class DataFactory {

  private static final Type[] types = {
    new Type("Notebook"),
    new Type("Smartphone"),
    new Type("Tablet"),
    new Type("Desktop"),
    new Type("Impressora")
  };

  private static final Client[] clients = {
    new Client("João Silva", "joao.silva@email.com", "123.456.789-00", "Rua A, 123", "(11) 99999-1111"),
    new Client("Maria Souza", "maria.souza@email.com", "987.654.321-00", "Rua B, 456", "(11) 99999-2222"),
    new Client("Carlos Lima", "carlos.lima@email.com", "111.222.333-44", "Rua C, 789", "(11) 99999-3333"),
    new Client("Ana Paula", "ana.paula@email.com", "555.666.777-88", "Rua D, 101", "(11) 99999-4444"),
    new Client("Pedro Santos", "pedro.santos@email.com", "999.888.777-66", "Rua E, 202", "(11) 99999-5555"),
    new Client("Fernanda Costa", "fernanda.costa@email.com", "333.444.555-66", "Rua F, 303", "(11) 99999-6666"),
    new Client("Lucas Rocha", "lucas.rocha@email.com", "222.333.444-55", "Rua G, 404", "(11) 99999-7777"),
    new Client("Juliana Alves", "juliana.alves@email.com", "444.555.666-77", "Rua H, 505", "(11) 99999-8888"),
    new Client("Rafael Dias", "rafael.dias@email.com", "666.777.888-99", "Rua I, 606", "(11) 99999-9999"),
    new Client("Patricia Melo", "patricia.melo@email.com", "888.999.000-11", "Rua J, 707", "(11) 99999-0000")
  };

  private static final Device[] devices = {
    new Device(types[0], "Dell", "Inspiron 15", "SN123", "pass1", "Não liga", clients[0]),
    new Device(types[1], "Samsung", "Galaxy S21", "SN124", "pass2", "Tela quebrada", clients[1]),
    new Device(types[2], "Apple", "iPad Air", "SN125", "pass3", "Bateria não carrega", clients[2]),
    new Device(types[3], "HP", "Pavilion", "SN126", "pass4", "Superaquecendo", clients[3]),
    new Device(types[4], "Epson", "L3150", "SN127", "pass5", "Não imprime", clients[4]),
    new Device(types[0], "Lenovo", "ThinkPad", "SN128", "pass6", "HD com defeito", clients[5]),
    new Device(types[1], "Apple", "iPhone 13", "SN129", "pass7", "Sem áudio", clients[6]),
    new Device(types[2], "Samsung", "Galaxy Tab", "SN130", "pass8", "Wi-Fi não conecta", clients[7]),
    new Device(types[3], "Dell", "Optiplex", "SN131", "pass9", "Placa mãe queimada", clients[8]),
    new Device(types[4], "HP", "DeskJet", "SN132", "pass10", "Atolamento de papel", clients[9])
  };

  private static final Service[] services = new Service[10];
  private static final Guarantee[] guarantees = new Guarantee[10];

  static {
    for (int i = 0; i < 10; i++) {
      services[i] = new Service(
        clients[i],
        devices[i],
        "Oxidação na Placa Mãe",
        10 + Math.random() * (1000 - 10),
        LocalDateTime.now().minusDays(i + 1)
      );
      devices[i].service = services[i];
      clients[i].services.add(services[i]);

      guarantees[i] = new Guarantee(
        LocalDateTime.now().minusDays(10 - i),
        i % 2 == 0 ? LocalDateTime.now().plusDays(30 - i) : LocalDateTime.now().minusDays(9 - i),
        "Garantia padrão",
        services[i]
      );

      if(i % 4 == 0){
        guarantees[i].notificated = true;
      }
      services[i].guarantees.add(guarantees[i]);
    }
  }

  public static Service[] createSampleServices() {
    return services;
  }
  
}