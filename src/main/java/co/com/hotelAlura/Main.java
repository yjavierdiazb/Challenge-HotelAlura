package co.com.hotelAlura;

import co.com.hotelAlura.views.Login;

import java.awt.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true); // Esto muestra la ventana de login
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
