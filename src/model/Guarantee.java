package model;

import java.time.LocalDateTime;

public class Guarantee {
    public int id;
    public LocalDateTime startDate, endDate;
    public boolean notificated = false;
    public String message;
    public Service service;

    public Guarantee(LocalDateTime startDate, LocalDateTime endDate, String message, Service service) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.message = message;
        this.service = service;
    }

    public String getStatus() {
        if (notificated) return "Notificado";
        return LocalDateTime.now().isBefore(endDate) ? "A Vencer" : "Vencida";
    }

    public String getTime() {
        var period = java.time.Period.between(startDate.toLocalDate(), endDate.toLocalDate());
        return (period.getYears() > 0 ? period.getYears() + " ano(s) " : "") +
                (period.getMonths() > 0 ? period.getMonths() + " mês(es)" :
                (period.getDays() > 0 ? period.getDays() + " dia(s)" : ""));
    }

    public String getFormatedEnd() {
        return String.format("%02d/%02d/%04d", endDate.getDayOfMonth(), endDate.getMonthValue(), endDate.getYear());
    }

    public boolean isEnd() {
        return !getStatus().equals("A Vencer");
    }

    public Service getService(){
      return service;
    }

    public void setNotificated(boolean val){
      notificated = val;
    }
}