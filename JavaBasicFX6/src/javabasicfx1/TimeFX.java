/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Sitth
 */
public class TimeFX {
    
    private static volatile boolean enough = false;
    
    public static void time(Text txtTime) {
        
    
                SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss:SSS a XXX");
                
                while (!enough) {
                    try {
                        // running "long" operation not on UI thread
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                    final String time = dt.format(new Date());
                    Platform.runLater(() -> {
                        // updating live UI object requires JavaFX App Thread
                        txtTime.setText(time);
                        txtTime.setTextAlignment(TextAlignment.CENTER);
                        txtTime.setFont(new Font(20));
                        System.out.println(time);
                        System.out.println(txtTime.getLayoutBounds());
                    });
                }
            }

}

