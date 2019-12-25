package com.coolio.mailman.bo.thirdparty;

public class NewMessageAlert {

    private String firstName;
    private String from;
    private String to;
    private String subject;
    private String messageID;
    private String name;
    private String email;
    private String phone;
    private String message;
    private String createdTSindia;
    private String responded;
    private String clientIP;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedTSindia() {
        return createdTSindia;
    }

    public void setCreatedTSindia(String createdTSindia) {
        this.createdTSindia = createdTSindia;
    }

    public String getResponded() {
        return responded;
    }

    public void setResponded(String responded) {
        this.responded = responded;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public NewMessageAlert(String firstName, String from, String to, String subject, String messageID, String name, String email, String phone, String message, String createdTSindia, String responded, String clientIP) {
        this.firstName = firstName;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.messageID = messageID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.createdTSindia = createdTSindia;
        this.responded = responded;
        this.clientIP = clientIP;
    }

    public NewMessageAlert() {
    }

    @Override
    public String toString() {
        return "NewMessageAlert{" +
                "firstName='" + firstName + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", messageID='" + messageID + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", message='" + message + '\'' +
                ", createdTSindia='" + createdTSindia + '\'' +
                ", responded='" + responded + '\'' +
                ", clientIP='" + clientIP + '\'' +
                '}';
    }
}
