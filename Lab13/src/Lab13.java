//Frank Pena
//Comp 271-001RL
//Class Lab Chapter 13

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lab13 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextArea textArea = new TextArea(getText());
		
		//TEXT AREA DEFAULTS
		textArea.setEditable(false);
		textArea.setWrapText(false);
		
		//SCROLL PANE
		ScrollPane scrollPane = new ScrollPane(textArea);
		
		//CHECK BOXES
		CheckBox chkEditable = new CheckBox("Editable");
		CheckBox chkWrap = new CheckBox("Wrap");
		
		//HANDLERS
		chkEditable.setOnAction(e ->{
			textArea.setEditable(chkEditable.isSelected());
		});
		
		chkWrap.setOnAction(e ->{
			textArea.setWrapText(chkWrap.isSelected());
		});
		
		//HBOX
		HBox paneForCheckBoxes = new HBox(10);
		
		paneForCheckBoxes.getChildren().addAll(chkEditable, chkWrap);
		paneForCheckBoxes.setAlignment(Pos.CENTER);
		paneForCheckBoxes.setPadding(new Insets(10));
		
		BorderPane borderPane = new BorderPane(); 
		borderPane.setCenter(scrollPane);
		borderPane.setBottom(paneForCheckBoxes);
		
			
		//SCENE
		Scene scene = new Scene(borderPane, 500,300);
		primaryStage.setTitle("Text Area Lab");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private String getText() {
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
