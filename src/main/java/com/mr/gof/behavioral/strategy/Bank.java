package com.mr.gof.behavioral.strategy;

/**
 * Created by Ramanovich on 8/10/2017.
 */
public class Bank {

    public static void main(String[] args){

        Recipient recipient1 = new Recipient("recipient1", "recipient1@email.com", "+375291234561", "recipient1", "1234567890123456789012345670", "BIC1");
        recipient1.setNotificationStrategy(NotificationStrategy.EMAIL);

        Recipient recipient2 = new Recipient("recipient2", "recipien21@email.com", "+375291234562", "recipient2", "1234567890123456789012345671", "BIC2");
        recipient2.setNotificationStrategy(NotificationStrategy.SKYPE);

        Recipient recipient3 = new Recipient("recipient3", "recipien31@email.com", "+375291234563", "recipient3", "1234567890123456789012345672", "BIC3");
        recipient3.setNotificationStrategy(NotificationStrategy.SMS);

        Payment payment = new Payment();
        payment.pay(1, recipient1);
        payment.pay(2, recipient2);
        payment.pay(3, recipient3);
    }

}
