# Sistema de Assistência Técnica em Java

Uma aplicação desktop modular em Java, construída com JavaFX, seguindo a arquitetura MVC (Model-View-Controller). O sistema permite gerenciar serviços de clientes, dispositivos, garantias e apresentar os dados em uma interface HTML interativa.

## 🛠️ Funcionalidades

* **Gerenciamento de Ordens de Serviço**: Cadastro e controle de clientes, dispositivos, serviços e status de garantia.
* **Simulação de Dados**: Geração de dados fictícios realistas para demonstração e testes.
* **WebView Integrado**: Exibe uma tabela HTML paginada e estilizada com Bootstrap 5.
* **Estrutura Modular**: Separado em camadas `app`, `controller`, `model` e `view` para maior clareza e escalabilidade.
* **Interface Responsiva**: A interface HTML se adapta a diferentes tamanhos de tela com elementos modernos.
* **Pop-ups Modais**: Abre dinamicamente visualizações detalhadas e permite notificação do usuário.
* **Comunicação entre Linguagens**: Interação Java ↔ JavaScript utilizando `JSObject`.

## 📋 Pré-requisitos

* **Java JDK 22+**
* **JavaFX SDK** (certifique-se de copiar o conteúdo da pasta `lib` do JavaFX para `dependencies/javafx`)
* (Opcional) IDE moderna como IntelliJ ou VS Code com suporte a Java

## 🚀 Instalação e Execução

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/DevGabrielCoelho/projeto-java.git
   cd projeto-java
   ```

2. **Execute usando o script shell (recomendado para sistemas Unix):**

   ```bash
   chmod +x build.sh
   ./build.sh
   ```

3. **Ou compile e execute manualmente:**

   ```bash
   javac --module-path dependencies/javafx --add-modules javafx.controls,javafx.fxml,javafx.web -d out @sources.txt

   java --module-path dependencies/javafx --add-modules javafx.controls,javafx.fxml,javafx.web \
     --enable-native-access=ALL-UNNAMED \
     -Djava.library.path=dependencies/javafx \
     -cp out app.App
   ```

## 🌐 Visão Geral da Interface

A aplicação renderiza uma página HTML (`view/page.html`) estilizada com Bootstrap. Ela inclui:

* Abas para navegação entre serviços e histórico.
* Tabelas paginadas de ordens de serviço.
* Modal dinâmico com informações detalhadas.
* Suporte a JavaScript para acionar funções e callbacks a partir do Java.

## 📂 Estrutura do Projeto

```
src/
├── app/
│   └── App.java                  # Ponto de entrada com integração WebView
├── controller/
│   ├── MainController.java       # Lógica principal para geração de dados
│   ├── WebController.java        # Ponte entre Java e JavaScript
│   └── CronController.java       # Tarefas automatizadas ou agendadas
├── model/
│   ├── Client.java
│   ├── DataFactory.java          # Geração de dados mock
│   ├── Device.java
│   ├── Guarantee.java
│   ├── Service.java
│   └── Type.java
├── view/
│   └── page.html                 # Interface HTML responsiva
build.sh                          # Script de build e execução
sources.txt                       # Lista de arquivos Java a compilar
```

## 🧪 Resumo das Principais Classes

* **App.java** – Inicializa o JavaFX WebView e carrega a interface HTML.
* **WebController.java** – Fornece métodos Java acessíveis via JavaScript (`notifyUser`, `loadHtmlWithData`).
* **MainController.java** – Controla a geração de dados via `DataFactory`.
* **CronController.java** – Reservado para rotinas automáticas ou agendadas.
* **DataFactory.java** – Popula listas de clientes, dispositivos, tipos e serviços.

## 📌 Observações

* O HTML utiliza placeholders como `%responsive-clients-tbody%`, `%client-total-items%`, que são substituídos dinamicamente por JavaScript com dados vindos do backend em Java.
* As funções JavaScript na interface acionam métodos nativos do Java por meio de `window.app`.

## 🛠️ Tecnologias Utilizadas

* **Java 22+**
* **JavaFX (WebView, FXML)**
* **HTML5, Bootstrap 5, Material Icons**
* **Shell Script (automação de build)**

## Documentação Adicional

- [Configuração do SDK JavaFX](dependencies/javafx/README.pt-BR.md)
- [Guia de Logs](logs/README.pt-BR.md)

## 📞 Contato

Para dúvidas, sugestões ou contribuições:

* **Gabriel Coelho**
* GitHub: [DevGabrielCoelho](https://github.com/DevGabrielCoelho)
* E-mail: [gabriel.coelhosousasantos.pv@gmail.com](mailto:gabriel.coelhosousasantos.pv@gmail.com)

* **Carlos Eduardo**
* E-mail: [carlosebarboza4@gmail.com](mailto:carlosebarboza4@gmail.com)

* **David Igor**
* E-mail: [igoroliveira0906@gmail.com](mailto:igoroliveira0906@gmail.com)

* **Mariana Lorena**
* E-mail: [marianalorenasilvacabral@gmail.com](mailto:marianalorenasilvacabral@gmail.com)

* **Vinícius Oliveira**
* E-mail: [mailto:viniciusoliveirab8@gmail.com](mailto:viniciusoliveirab8@gmail.com)