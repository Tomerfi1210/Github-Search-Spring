package com.hadassah.demo.utils;

public class JSONResponse {
    private int code;
    private String message;

    public JSONResponse(int c, String m){
        setCode(c);
        setMessage(m);
    }

    /**
     * Sets new code.
     *
     * @param code New value of code.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Sets new message.
     *
     * @param message New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets code.
     *
     * @return Value of code.
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }
}
