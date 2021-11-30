import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//Frank Pena
//Comp 271-001RL
//Programming Assignment #7

public class Prgm7 extends Application {
	  private double paneWidth = 200;
	  private double paneHeight = 100;

	  RadioButton rbRed = new RadioButton("Red");
	  RadioButton rbYellow = new RadioButton("Yellow");
	  RadioButton rbGreen = new RadioButton("Green");
	  
		
	  @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) throws Exception{
	    Pane pane = new Pane();
	    Circle circleRed = new Circle(paneWidth / 2, 20, 10);
	    Circle circleYellow = new Circle(paneWidth / 2, 50, 10);
	    Circle circleGreen = new Circle(paneWidth / 2, 80, 10);
	    circleRed.setStroke(Color.BLACK);
	    circleYellow.setStroke(Color.BLACK);
	    circleGreen.setStroke(Color.BLACK);
	    circleRed.setFill(Color.WHITE);
	    circleYellow.setFill(Color.WHITE);
	    circleGreen.setFill(Color.WHITE);

	    Rectangle rectangle = new Rectangle(paneWidth / 2 - 15, 5, 30, 90);
	    rectangle.setFill(Color.WHITE);
	    rectangle.setStroke(Color.BLACK);
	    
	    pane.getChildren().addAll(rectangle, circleRed, circleYellow, circleGreen);
	        
	    
		//HBOX FOR RADIO BUTTONS
		HBox paneForRadioButtons = new HBox(20);
		
		paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbGreen);
		paneForRadioButtons.setAlignment(Pos.CENTER);
		paneForRadioButtons.setPadding(new Insets(5));
	    
		//TOGGLE GROUP FOR RADIO BUTTONS
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbGreen.setToggleGroup(group); 
		

		
		//ACTION EVENT HANDLERS
		
		rbRed.setOnAction((ActionEvent e) -> {	//Used lambda expressions as they were the easiest to work with
			if(rbRed.isSelected() ) {						
				circleRed.setFill(Color.RED); circleGreen.setFill(Color.WHITE); circleYellow.setFill(Color.WHITE); System.out.println("RED WORKED!");
			}
		});
		
		rbYellow.setOnAction((ActionEvent e) -> {
			if(rbYellow.isSelected() ) {
				circleYellow.setFill(Color.YELLOW); circleRed.setFill(Color.WHITE); circleGreen.setFill(Color.WHITE); System.out.println("YELLOW WORKED!");
			}

		});
		
		rbGreen.setOnAction((ActionEvent e) -> {
			if(rbGreen.isSelected() ) {
				circleGreen.setFill(Color.GREEN); circleRed.setFill(Color.WHITE); circleYellow.setFill(Color.WHITE); System.out.println("GREEN WORKED!");
			}

		});
		 
	    
		//VBOX FOR RADIO BUTTONS
		VBox paneForAllButtons = new VBox(10);
		paneForAllButtons.getChildren().addAll(paneForRadioButtons);
	
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(pane);
		borderPane.setBottom(paneForAllButtons);
		
		

	    // Create a scene and place it in the stage
	    Scene scene = new Scene(borderPane, paneWidth, paneHeight + 50);
	    primaryStage.setTitle("Traffic Light"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	  }



	public static void main(String[] args) {
	    launch(args);
	  }
	}

