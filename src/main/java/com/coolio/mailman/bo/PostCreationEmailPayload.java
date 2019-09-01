package com.coolio.mailman.bo;

/**
 * @author Aseem Savio
 *
 * This class is a POJO for a basic Coolio Email.
 */
public class PostCreationEmailPayload {

    private String name;
    private String fromAddress;
    private String toAddress;
    private String subject;

    public PostCreationEmailPayload(String name, String fromAddress, String toAddress, String subject) {
        this.name = name;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.subject = subject;
    }

    public PostCreationEmailPayload() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "PostCreationEmailPayload{" +
                "name='" + name + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
