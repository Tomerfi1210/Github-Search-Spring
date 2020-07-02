package com.hadassah.demo.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * class that handle session.
 * this class act as bean and shared between the controllers.
 */
@Component
public class MySession implements Serializable {
    private static final long serialVersionUID = -4651197264625870537L;
    private boolean session;

    /**
     * ctor that build the Bean.
     */
    public MySession() {
        this.session = false;
    }

    /**
     * boolean function that return boolean member.
     * @return boolean if session was created.
     */
    public boolean isSession() {
        return this.session;
    }

    /**
     * function that set the boolean member.
     * @param session - boolean type.
     */
    public void setSession(boolean session) {
        this.session = session;
    }
}
