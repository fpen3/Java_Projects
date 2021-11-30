/*Frank Pena
COMP-269-001RL
Lab 8A*/

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.geometry.Insets;

public class RedBlueCircle extends Application {
	
	public void start(Stage primaryStage) {
		
		
		//new ARC(posX, posY, radiusX, radiusY, startAngle, length)
		Arc arc1 = new Arc(100, 100, 100, 100, 90, 180); // Create an arc
		arc1.setFill(Color.RED);	// Set fill color
		arc1.setType(ArcType.OPEN);
		arc1.setStroke(Color.BLACK); // Set fill color
		
		
		//new ARC(posX, posY, radiusX, radiusY, startAngle, length)
		Arc arc2 = new Arc(100, 100, 100, 100, 90, -180); // Create an arc
		arc2.setFill(Color.BLUE);	// Set fill color
		arc2.setType(ArcType.OPEN);
		arc2.setType(ArcType.ROUND); // Set fill color
		
		
		Group group = new Group();
		group.getChildren().addAll(arc1, arc2);
		
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(new BorderPane(group), 300, 300);
		primaryStage.setTitle("RedBlueCircle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	
	
	public static void main(String[] args) {
		launch(args); 
	}
}
