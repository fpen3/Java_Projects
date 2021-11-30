import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Frank Pena
//Comp 271-001RL
//Lab #15

public class Lab15 extends Application {

	private Text text = new Text("Programming is Fun!");
	
	private Slider slRed = new Slider();
	private Slider slGreen = new Slider();
	private Slider slBlue = new Slider();
	
	private ScrollBar slOpacity = new ScrollBar();
	
	@Override
	public void start(Stage primaryStage) {
		
		
		//SET TEXT FONT AND SIZE
		text.setFont(Font.font("Arial", FontWeight.BOLD, 28));
		
		//STACKPANE FOR TEXT
		StackPane paneForText = new StackPane(text);
		paneForText.setPadding(new Insets(20, 10 ,5, 10));
		
		//SLIDER PROPERTIES
		slRed.setMin(0.0);
		slRed.setMax(1.0);
		slGreen.setMin(0.0);
		slGreen.setMax(1.0);
		slBlue.setMin(0.0);
		slBlue.setMax(1.0);
		
		//LISTENERS FOR THE SLIDERS
		slRed.valueProperty().addListener(e -> setColor());
		slGreen.valueProperty().addListener(e -> setColor());
		slBlue.valueProperty().addListener(e -> setColor());
		
		//PROPERTIES FOR SCROLL BAR
		slOpacity.setOrientation(Orientation.HORIZONTAL);
		slOpacity.setMin(0.0);
		slOpacity.setMax(1.0);
		
		//LISTENER FOR SCROLL BAR
		slOpacity.valueProperty().addListener(e -> setColor());
		slOpacity.setValue(1);
		
		//CREATE GRID PANE FOR SLIDERS AND SCROLLBAR
		GridPane paneForSliders = new GridPane();
		paneForSliders.setAlignment(Pos.CENTER);
		paneForSliders.setVgap(5);
		paneForSliders.setHgap(5);
		
		paneForSliders.add(new Label("Red"), 0, 0);
		paneForSliders.add(slRed, 1, 0);
		paneForSliders.add(new Label("Green"), 0, 1);
		paneForSliders.add(slGreen, 1, 1);
		paneForSliders.add(new Label("Blue"), 0, 2);
		paneForSliders.add(slBlue, 1, 2);
		
		paneForSliders.add(new Label("Opacity"), 0, 3);
		paneForSliders.add(slOpacity, 1, 3);
		
		//PLACE OBJECT IN BORDER PANE
		BorderPane pane = new BorderPane();
		pane.setTop(paneForText);
		pane.setCenter(paneForSliders);
		
		//SCENE
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("Sliders and Scrollbar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	private void setColor() {
		text.setFill(new Color(slRed.getValue(), slGreen.getValue(), slBlue.getValue(), 
				slOpacity.getValue()));
		
	}


	public static void main(String[] args) {
		Application.launch(args);

	}

}
