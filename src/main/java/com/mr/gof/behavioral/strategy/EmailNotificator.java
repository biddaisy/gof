package com.mr.gof.behavioral.strategy;

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
    System.out.println(notification.getSubject() + ": " + notification.getMessage() + " emailed to " + email);
  }

}
