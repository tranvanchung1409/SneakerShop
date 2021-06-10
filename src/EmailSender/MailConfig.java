/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailSender;

import candproject1.Customer;

/**
 *
 * @author ADMIN
 */
public class MailConfig {

    public static final String HOST_NAME = "smtp.gmail.com";

    public static final int SSL_PORT = 465; // Port for SSL

    public static final int TSL_PORT = 587; // Port for TLS/STARTTLS

    public static final String APP_EMAIL = "kenhchay01@gmail.com"; // your email

    public static final String APP_PASSWORD = "tcmldhivnloapuwi"; // your password

    public static String RECEIVE_EMAIL = "";

    static void setmail() {
         Customer customer = new Customer();
 //        RECEIVE_EMAIL = customer.it.getData();
    }
    public static void main(String[] args) {    
        setmail();
        Customer customer = new Customer();
        System.out.println(RECEIVE_EMAIL);
    }
}
