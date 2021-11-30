/*Frank Pena
COMP-269-001RL
Lab 9*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Calculator extends Application {
	private TextField number1 = new TextField();
	private TextField number2 = new TextField();
	private TextField result = new TextField();
	private Button btAdd = new Button("Add");
	private Button btSubtract = new Button("Subtract");
	private Button btMultiply = new Button("Multiply");
	private Button btDivide = new Button("Divide");
	
	
	public void start(Stage primaryStage) {
	    GridPane gridPane = new GridPane();
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	    gridPane.add(new Label("Number 1"), 0, 0);
	    gridPane.add(number1, 1, 0);
	    gridPane.add(new Label("Number 2"), 0, 1);
	    gridPane.add(number2, 1, 1);
	    gridPane.add(new Label("Result"), 0, 2);
	    gridPane.add(result, 1, 2);
	    
	    gridPane.add(btAdd, 0, 3);
	    gridPane.add(btSubtract, 0, 4);
	    
	    gridPane.add(btMultiply, 1, 3);
	    gridPane.add(btDivide, 1, 4);
	    
	    // Create a scene and place it in the stage
	    Scene scene = new Scene(gridPane, 400, 250);
	    primaryStage.setTitle("Calculator"); // Set title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
			
	    // Process events
	    btAdd.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override // Override the handle method
	    	public void handle(ActionEvent e) {
	    		calculateNumbers(0);
	    	}
	    });
	    
	    btSubtract.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override // Override the handle method
	    	public void handle(ActionEvent e) {
	    		calculateNumbers(1);
	    	}
	    });
	    
	    btMultiply.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override // Override the handle method
	    	public void handle(ActionEvent e) {
	    		calculateNumbers(2);
	    	}
	    });
	    
	    btDivide.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override // Override the handle method
	    	public void handle(ActionEvent e) {
	    		calculateNumbers(3);
	    	}
	    });
	    
	    
	}
	
	public void calculateNumbers(int mathType) {
		double num1 = Integer.parseInt(number1.getText());
		double num2 = Integer.parseInt(number2.getText());
		double rslt = 0;
		
		switch(mathType) {
		case 0: //Add
			rslt = num1 + num2;
			break;
		case 1: //Subtract
			rslt = num1 - num2;
			break;
		case 2: //Multiply
			rslt = num1 * num2;
			break;
		case 3: //Divide
			if(num2 != 0) {
				rslt = num1 / num2;
			}else {
				rslt = -999999999;
			}
			break;
		}
		
		
		result.setText(rslt + "");
		}
		
	
		public static void main(String[] args) {
			launch(args); 
		}
}
