/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailSender;

import candproject1.Customer;
import candproject1.Event;

/**
 *
 * @author ADMIN
 */
public class MailConfig {

    public static final String HOST_NAME = "smtp.gmail.com";

    public static final int SSL_PORT = 465; // Port for SSL

    public static final int TSL_PORT = 587; // Port for TLS/STARTTLS

    public static final String APP_EMAIL = "kenhchay01@gmail.com"; // your email

    public static final String APP_PASSWORD = "prkjjjgvrdizouhd"; // your password
    
    public static String RECEIVE_EMAIL = " ";

    public static String ALL_RECEIVE_EMAIL = " ";
    
//vuanh2k0@gmail.com,ngoctran74122@gmail.com,datduocdayy2k@gmail.com
    static void setAllmail() {
         Event event = new Event();
        ALL_RECEIVE_EMAIL = event.it.getData();
    }
   public static  String setmail() {
         Event event = new Event();
        RECEIVE_EMAIL = event.it.getEmail();
        return RECEIVE_EMAIL;
    }
}
