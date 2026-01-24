package com.mr.gof.behavioral.strategy;

import com.mr.gof.Logger;

/**
 * Created by Ramanovich on 8/9/2017.
 */
public class EmailNotificator implements Notificator {

  private String email;

  public EmailNotificator(String email) {
    this.email = email;
  }

  @Override
  public void notify(Notification notification) {
    Logger.log(notification.getSubject() + ": " + notification.getMessage() + " emailed to " + email);
  }

}
