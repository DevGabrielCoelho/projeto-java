## 📑 Logs do Cron

Este diretório (`logs/`) armazena os arquivos de log gerados pelas execuções automáticas do sistema, coordenadas pela classe `CronController.java`.

### 🔍 Visão Geral

O sistema possui uma rotina automatizada (cron job) implementada em Java, que é responsável por:

* Gerar logs de execução com marcação de horário.
* Simular ou registrar atividades programadas.
* Armazenar os logs localmente em formato de texto, dentro da pasta `logs/`.

### 🧠 Funcionamento Interno

A classe `CronController` é responsável por disparar tarefas agendadas. No exemplo atual, sua principal função é **escrever logs** para depuração e acompanhamento da execução automática da aplicação.

#### ✏️ Exemplo de saída no log:

```log
Jun 16, 2025 12:40:48 AM controller.CronController checkExpiredGuarantees
INFO: [CRON] Verifying expired guarantees on 2025-06-16
```

Cada linha representa uma execução com data e hora formatada, facilitando o rastreamento da rotina.

#### 📄 Local padrão dos arquivos de log:

```
projeto-java/logs/cron.log
```

> ⚠️ O nome do arquivo pode variar conforme o código da classe `CronController`.

### 🔁 Gatilho de Execução

A rotina do `CronController` pode ser acionada:

* Manualmente através do código no `App.java`.
* Periodicamente, caso seja integrada futuramente a uma `ScheduledExecutorService` ou outro mecanismo de agendamento (não implementado até o momento).
* Como simulação de um cron Unix, sendo executada em intervalos definidos por você.

---

### 📌 Observações

* O sistema atual **não depende de um agendador externo (cron do sistema operacional)**, mas você pode configurá-lo para chamar a execução do `App` em intervalos desejados.
* Os logs são importantes para depuração, principalmente quando a aplicação é executada em segundo plano ou embutida em outras interfaces.

### 📁 Estrutura relevante

```
logs/
└── cron.log         # Arquivo de log de execução do cron (gerado automaticamente)
```

---

### 🧪 Exemplo de código relacionado (`CronController.java`)

```java
public class CronController {
    private void checkExpiredGuarantees() {
        LocalDate today = LocalDate.now();

        logger.info("[CRON] Verifying expired guarantees on " + today + "\n");

        for (Guarantee guarantee : guarantees) {
            if ("Vencida".equals(guarantee.getStatus())) {
                logger.info("[CRON] Expired guarantee: " + guarantee.getService().getDefect() + " - Expired on: " + guarantee.getFormatedEnd() + "\n");
                logger.info("[CRON] Client notified: " + guarantee.getService().getClient().getEmail() + "\n");
            }
        }
    }
}
```