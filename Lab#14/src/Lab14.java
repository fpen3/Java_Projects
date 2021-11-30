import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//Frank Pena
//Comp 271-001RL
//Lab #14

public class Lab14 extends Application {
	
	private ObservableList<String> items = FXCollections.observableArrayList("Australia", "South Korea", "Taiwan", "Germany", 
			"United States of America", "France", "England", "Spain", "Portugal", "Belgium");
	
	private ListView<String> lv = new ListView<>(items);
	
	private ComboBox<String> cbo = new ComboBox<>();
	
	private Label lblSelectedItems = new Label("Selected Items Are");
	
	  @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) throws Exception{
		  
		  //SET LISTVIEW SIZE
		  lv.setPrefSize(300, 240);
		  
		  //SET DEFAULT LIST VIEW MODE TO SINGLE
		  lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		  
		  //LISTENER
		  lv.getSelectionModel().selectedItemProperty().addListener(
				  ov -> {
					  setMode();
					  setText();
					  
				  });
		  
		  //LABEL FOR COMBOBOX
		  Label lblSelectionMode = new Label("Chosoe Selection Mode:", cbo);
		  lblSelectionMode.setContentDisplay(ContentDisplay.RIGHT);
		  
		  //COMBOBOX PROPERTIES
		  cbo.getItems().addAll("SINGLE", "MULTIPLE");
		  cbo.setValue("SINGLE");
		  
		  //COMBOBOX LISTENER
		  cbo.setOnAction(e -> {
			  setMode();
			  setText();
		  });
		  
		  
		  //HBOX FOR COMBO BOX
		  HBox paneForComboBox = new HBox(5);
		  paneForComboBox.setAlignment(Pos.CENTER);
		  paneForComboBox.getChildren().addAll(lblSelectionMode, cbo);
		  
		  //BORDERPANE
		  BorderPane pane = new BorderPane();
		  pane.setTop(paneForComboBox);
		  pane.setCenter(new ScrollPane(lv));
		  pane.setBottom(lblSelectedItems);
		  
		  //SCENE
		  Scene scene = new Scene(pane, 300, 200);
		  primaryStage.setTitle("Select Countries");
		  primaryStage.setScene(scene);
		  primaryStage.show();
	  }
	
	
	private void setText() {
		String items = "Selected items are ";
		for(String i: lv.getSelectionModel().getSelectedItems()) {
			items += i + " ";			
		}
		
		lblSelectedItems.setText(items);
		
	}


	private void setMode() {
		if(cbo.getValue().equals("SINGLE")) {
			lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		}else {
			lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}
		
	}


	public static void main(String[] args) {
	    launch(args);
	  }
}
