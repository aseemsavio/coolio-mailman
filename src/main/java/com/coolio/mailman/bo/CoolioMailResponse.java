package com.coolio.mailman.bo;

/**
 * @author Aseem Savio
 * A business object for creating response
 */
public class CoolioMailResponse {

    private String message;
    private boolean status;

    public CoolioMailResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public CoolioMailResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CoolioMailResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
