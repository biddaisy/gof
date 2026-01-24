package com.mr.gof.behavioral.strategy;

import com.mr.gof.Logger;

/**
 * Created by Ramanovich on 8/9/2017.
 */
public class SmsNotificator implements Notificator {

  private String cell;

  public SmsNotificator(String cell) {
    this.cell = cell;
  }

  @Override
  public void notify(Notification notification) {
    Logger.log(notification.getSubject() + ": " + notification.getMessage() + " sent to " + cell);
  }
}
