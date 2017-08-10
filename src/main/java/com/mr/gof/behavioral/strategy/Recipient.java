package com.mr.gof.behavioral.strategy;

/**
 * Created by Ramanovich on 8/9/2017.
 */
public class Recipient {

    private String name;
    private String email;
    private String cell;
    private String skype;

    private String iban;
    private String bic;

    private NotificationStrategy notificationStrategy;

    public Recipient(String name, String email, String cell, String skype, String iban, String bic) {
        this.name = name;
        this.email = email;
        this.cell = cell;
        this.skype = skype;
        this.iban = iban;
        this.bic = bic;
        this.notificationStrategy = NotificationStrategy.SMS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public NotificationStrategy getNotificationStrategy() {
        return notificationStrategy;
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public Notificator getNotificator(){
        switch (notificationStrategy){
            case EMAIL: return new EmailNotificator(email);
            case SMS: return new SmsNotificator((cell));
            case SKYPE: return new SkypeNotificator(skype);
            default:
                throw new IllegalArgumentException("unknown notification strategy " + notificationStrategy);
        }
    }

}
