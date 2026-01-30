package com.github.biddaisy.gof.behavioral.strategy;

import com.github.biddaisy.gof.Logger;

/**
 * Created by Ramanovich on 8/9/2017.
 */
public class SkypeNotificator implements Notificator {

  private String skype;

  public SkypeNotificator(String skype) {
    this.skype = skype;
  }

  @Override
  public void notify(Notification notification) {
    Logger.log(notification.getSubject() + ": " + notification.getMessage() + " sent to " + skype);
  }
}
