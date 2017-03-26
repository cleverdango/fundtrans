package com.mybank.fundtrans.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionCounter implements HttpSessionListener {
    private static int activeSessions = 0;

    /**
     * Default constructor.
     */
    public SessionCounter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
        activeSessions++;
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
        if (activeSessions > 0)
            activeSessions--;
    }

    // 获取活动的session个数(在线人数)
    public static int getActiveSessions() {
        return activeSessions;
    }
}