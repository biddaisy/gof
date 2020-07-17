package com.mr.gof.behavioral.strategy;

/**
 * Created by Ramanovich on 8/9/2017.
 */
public class SmsNotificator implements Notificator {

  private String cell;

  public SmsNotificator(String cell) {
    this.cell = cell;
  }

  @Override public void notify(Notification notification) {
    System.out.println(notification.getSubject() + ": " + notification.getMessage() + " sent to " + cell);
  }
}
