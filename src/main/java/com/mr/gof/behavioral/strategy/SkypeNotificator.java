package com.mr.gof.behavioral.strategy;

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
        System.out.println(notification.getSubject()  + ": " + notification.getMessage() + " sent to " + skype);
    }
}
