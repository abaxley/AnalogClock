
package analogclock;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.animation.*;
import javafx.util.Duration;

/**
 *
 * @author Lappy 486
 */
public class AnalogClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Circle Circle = new Circle(200);
        Circle.setFill(Color.TRANSPARENT);
        Circle.setStroke(Color.BLACK);
        Circle.setCenterX(300);
        Circle.setCenterY(300);
        
        Circle cent = new Circle(10);
        //cent.setFill();
        cent.setCenterX(300);
        cent.setCenterY(300);
        
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext g = canvas.getGraphicsContext2D();
        hand(g);
        
        
      
        root.getChildren().addAll(Circle, cent, canvas); 
       
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Analog clock");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        RotateTransition r = new RotateTransition(Duration.millis(3000), canvas);
        r.setByAngle(360);
        r.setCycleCount(4);
        r.play();
    }

    private void hand(GraphicsContext g) {
      
        double x1 = 0;
        double x2 = 0;
        double x3 = 190;
        
        for(int i = 0; i <= 60; i++){
         System.out.println("x3: " + x3);
         double x = 300 + 200*Math.cos(x1);
         double y = 300 + 200*Math.sin(x2);
         System.out.println("x3: cos/sin" + x1);
         System.out.println("x3: cos/sin" + x2);
        
         
         double tx = 300 + 1*Math.cos(x1);
         double ty = 300 + 1*Math.sin(x2);
         System.out.println("x4: cos/sin" + x1);
         System.out.println("x4: cos/sin" + x2);
         
         if(x1 == 0){
          x1 = x1 + (3.14 * 2)/60;
          x2 = x2 + (3.14 * 2)/60;
          x3 = 0;
          x3 = 170;
         }
         else if(x1 != 0) {
          x1 = x1 + (3.14 * 2)/60;
          x2 = x2 + (3.14 * 2)/60;
          x3 = 0;
          x3 = x3 = 190;
         }
         
         g.beginPath();
         g.moveTo(x,y);
         g.lineTo(tx,ty);
         g.stroke();
        
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*Keyframes are easier to use for this program*/