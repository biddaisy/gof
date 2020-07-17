package com.mr.gof.behavioral.strategy;

/**
 * Created by Ramanovich on 8/9/2017.
 */
public class Payment {

  public void pay(int amount, Recipient recipient) {
    transfer(amount, recipient.getBic(), recipient.getIban(), recipient.getName());
    Notification notification = new Notification();
    notification.setSubject("credit account");
    notification.setMessage(amount + " transferred  in " + recipient.getBic() + " on " + recipient.getIban());
    recipient.getNotificator().notify(notification);
  }

  private void transfer(int amount, String bic, String iban, String name) {
    System.out.println(amount + " transferred to " + name + " in " + bic + " on " + iban);
  }
}
