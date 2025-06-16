package controller;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import model.Guarantee;

public class CronController {
  private final Timer timer = new Timer(true);
  private List<Guarantee> guarantees;
  private static final Logger logger = Logger.getLogger(CronController.class.getName());
  private static boolean loggerInitialized = false;

  public CronController() {
    if (!loggerInitialized) {
      try {
        FileHandler fh = new FileHandler("logs/cron.log", true);
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
        loggerInitialized = true;
      } catch (IOException e) {
        System.err.println("[LOGGER ERROR] Não foi possível inicializar o arquivo de log: " + e.getMessage());
      }
    }
  }
  
  public void startTenSecondSchedule(List<Guarantee> guarantees) {
    this.guarantees = guarantees;

    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        checkExpiredGuarantees();
      }
    }, 0, 30_000);
  }

  public void startDailySchedule(LocalTime time, List<Guarantee> guarantees) {
    startTenSecondSchedule(guarantees);
    long initialDelay = calculateDelayForNextTime(time);
    long interval24h = 24 * 60 * 60 * 1000L;
    this.guarantees = guarantees;
    timer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        checkExpiredGuarantees();
      }
    }, initialDelay, interval24h);
  }

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

  private long calculateDelayForNextTime(LocalTime time) {
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);
    long nowMillis = System.currentTimeMillis();

    long targetMillis = java.sql.Timestamp.valueOf(today.atTime(time)).getTime();
    if (targetMillis <= nowMillis) {
      targetMillis = java.sql.Timestamp.valueOf(tomorrow.atTime(time)).getTime();
    }

    return targetMillis - nowMillis;
  }
}
