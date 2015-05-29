package com.gabriel.servlets.mail;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SessionCreator {
    private String smtpHost;
    private String smtpPort;
    private String userName;
    private String userPassword;
    private Properties sessionProperties;

    public SessionCreator(Properties configProperties) {
        this.smtpHost = configProperties.getProperty("mail.smtp.host");
        this.smtpPort = configProperties.getProperty("mail.smtp.port");
        this.userName = configProperties.getProperty("mail.user.name");
        this.userPassword = configProperties.getProperty("mail.user.password");
        // загрузка параметров почтового сервера в свойства почтовой сессии
        sessionProperties = new Properties();
        sessionProperties.setProperty("mail.transport.protocol", "smtp");
        sessionProperties.setProperty("mail.host", smtpHost);
//      sessionProperties.setProperty("mail.smtp.auth", "true");
        sessionProperties.setProperty("mail.smtp.auth", "true");
        sessionProperties.setProperty("mail.smtp.port", smtpPort);
        sessionProperties.setProperty("mail.smtp.socketFactory.port", smtpPort);
//      sessionProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        sessionProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        sessionProperties.setProperty("mail.smtp.socketFactory.fallback", "false");
        sessionProperties.setProperty("mail.smtp.quitwait", "false");
    }

    public Session createSession() {
        return Session.getDefaultInstance(sessionProperties,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, userPassword);
                    }
                });
    }
}
