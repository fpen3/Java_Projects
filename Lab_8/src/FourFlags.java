//Frank Pena
//Comp 271-001RL
//Four Flags

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

public class FourFlags extends Application{

	
	@Override
		public void start(Stage primaryStage) {
		
		//Grid
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			pane.setHgap(5.5);
			pane.setVgap(5.5);
			
		//Images
			Image flag1 = new Image("images/us.gif");
			Image flag2 = new Image("images/uk.gif");
			Image flag3 = new Image("images/ca.gif");
			Image flag4 = new Image("images/china.gif");
			
		//Image View
			ImageView view1 = new ImageView(flag1);
			ImageView view2 = new ImageView(flag2);
			ImageView view3 = new ImageView(flag3);
			ImageView view4 = new ImageView(flag4);
			
		//Show Image	
			pane.add(view1, 0, 0);
			pane.add(view2, 1, 0);
			pane.add(view3, 0, 1);
			pane.add(view4, 1, 1);
			
		//Create Scene and Stage
			Scene scene = new Scene(pane);
			primaryStage.setTitle("Four Flags");
			primaryStage.setScene(scene);
			primaryStage.show();
			
	}
	
	
	public static void main(String[] args) {
		launch(args);

	}

}
