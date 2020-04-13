/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Sitth
 */
public class RunStage {

    public static void method(Stage stage,Thread timer,Scene scene){
        
        stage.setTitle("Titles");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
        timer.start();
        stage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
            System.exit(0);
        });
    
    }
    
}
