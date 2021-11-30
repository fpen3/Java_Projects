import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class prgmAssignment7A extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//TEXT AREA DECLARATIONS
		TextArea textArea = new TextArea();
		TextArea textArea1 = new TextArea();
		
		//TEXT AREA DEFAULTS
		textArea.setWrapText(true);
		textArea.setEditable(false);
		textArea1.setEditable(true);
		
		//SCROLL PANE
		ScrollPane scrollPane = new ScrollPane(textArea);
		
		//BUTTON
		Button btView = new Button("View");
	
		//HBOX & TEXT AREA SIZES
		textArea.setPrefSize(460, 240);
		textArea1.setPrefSize(340, 100);
		
		HBox paneForFileName = new HBox(10);
		paneForFileName.getChildren().addAll(new Label("FileName:"),textArea1, btView);	
		paneForFileName.setPrefSize(25, 1);
		
		//VBOX
		VBox vbox = new VBox(); 
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(scrollPane, paneForFileName);
		

		//SCENE
		Scene scene = new Scene(vbox, 475,275);
		primaryStage.setTitle("Programming Assignment #7A");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//ACTION EVENT
		btView.setOnAction(e -> {
			
			File file = new File(textArea1.getText());
							
	        try{
	        Scanner input = new Scanner(file);
	        
	        while(input.hasNext()){	        	
	            textArea.setText(input.nextLine());
	            }
	        }
	        catch(Exception f){
	            textArea.setText("File Read Error");
	    }
        });
	
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}
