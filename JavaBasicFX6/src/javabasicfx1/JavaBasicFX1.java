/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasicfx1;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Sitth
 */
public class JavaBasicFX1 extends Application {
    
    private final Text txtTime = new Text();

    // this is timer thread which will update out time view every millisecond
    Thread timer;
    
    public JavaBasicFX1() {
        this.timer = new Thread(() -> {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            TimeFX.time(txtTime);
        });
        //TimeFX.time(timer, enough, txtTime);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(Screen.getPrimary().getBounds());
        //Create Pane
        Insets box = new Insets(10, 10, 10, 10);
            //BTN1        
        
        
        
        
        
        
        //scene.setFill(Color.rgb(223, 237, 250, 1.0));
        
        ToolBar toolBar = new ToolBar();
        toolBar.setOrientation(Orientation.HORIZONTAL);
        toolBar.setStyle("-fx-background-color:rgb(255, 99, 71);");

        
        
        
        //ADD
        //Create Scene
        //FileInputStream input = new FileInputStream("backGround.jpg");
        //Image backGroungImage = new Image(input);
        //ImageView backGroungImageView = new ImageView(backGroungImage);
        Rectangle buttonShape = new Rectangle();
        //buttonShape.setX(50);
        //buttonShape.setY(50);
        buttonShape.setWidth(txtTime.getLayoutBounds().getWidth());
        //System.out.println("Rec" + txtTime.getText().getLayoutBounds().getWidth());
        buttonShape.setHeight(50);
        buttonShape.setFill(Color.BLUE);
        buttonShape.setArcHeight(25);
        buttonShape.setArcWidth(25);
        
        StackPane paneTopTime = new StackPane();
        //paneTopTime.setMinSize(200, 40);
        paneTopTime.setLayoutX(1400);
        paneTopTime.setLayoutY(100);
        paneTopTime.setStyle(CustomColor.C5);
        //paneTopTime.setPadding(box); 
        //txtTime.setLayoutY(30);
        paneTopTime.getChildren().addAll(buttonShape, txtTime);
        
        System.out.println(txtTime.getText());
        System.out.println(paneTopTime.getLayoutBounds());
        
        Image backGroungImage = new Image("backGround.jpg");
        //ImageView backGroungImageView = new ImageView(backGroungImage);
        
        Cell cell = new Cell();
        //cell.setGraphic(backGroungImageView);
        
        Pane paneTop1 = new Pane();
        paneTop1.setMinHeight(200);
        paneTop1.setStyle(CustomColor.C2);
        paneTop1.getChildren().add(paneTopTime);
        
        Pane paneLeft1 = new Pane();
        paneLeft1.setStyle(CustomColor.C3);
        paneLeft1.setMinWidth(300);
        paneLeft1.getChildren().addAll(cell);
        
        BorderPane borderPane1 = new BorderPane();
        borderPane1.setTop(paneTop1);
        borderPane1.setLeft(paneLeft1);
        
        
        //StackPane backGround = new StackPane();
        
        
        Scene scene = new Scene(borderPane1);
        //backGround.getChildren().add(backGroungImageView);
        //borderPane.getChildren().add(pane);
        RunStage.method(stage, timer, scene);
        
    }
    
}
