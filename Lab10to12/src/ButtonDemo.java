//Frank Pena
//Comp 271-001RL
//Class Lab Chapters 10 -> 12

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonDemo extends Application{

	Text text = new Text("Programming is required");
	CheckBox chkBold = new CheckBox("Bold");
	CheckBox chkItalic = new CheckBox("Italic");
	
	RadioButton rbRed = new RadioButton("Red");
	RadioButton rbYellow = new RadioButton("Yellow");
	RadioButton rbBlack = new RadioButton("Black");
	RadioButton rbOrange = new RadioButton("Orange");
	RadioButton rbGreen = new RadioButton("Green");
	
	ComboBox<String> cbFontFamilies = new ComboBox<>();
	ComboBox<Integer> cbFontSize = new ComboBox<>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//FONT TYPE COMBO BOX
		cbFontFamilies.getItems().addAll(Font.getFamilies());
		cbFontFamilies.setValue(text.getFont().getFamily());
		
		//LABEL FOR FONT TYPE
		Label lblFontFamilies = new Label("Font Name ", cbFontFamilies);
		lblFontFamilies.setContentDisplay(ContentDisplay.RIGHT);
		
		//FONT SIZE
		cbFontSize.getItems().addAll(getSizes());
		cbFontSize.setValue((int)text.getFont().getSize());
		
		//LABEL FOR FONT SIZE
		Label lblFontSize = new Label("Font Size", cbFontSize);
		lblFontSize.setContentDisplay(ContentDisplay.RIGHT);
		
		//PANE FOR COMBO BOXES
		HBox comboBoxPane = new HBox(lblFontFamilies, lblFontSize);
		comboBoxPane.setSpacing(20);
		comboBoxPane.setPadding(new Insets(15));
		
		//LISTENERS
		cbFontFamilies.setOnAction(e-> update());
		cbFontSize.setOnAction(e-> update());
		
		//BUTTON
		chkBold.setOnAction(e -> update());
		chkItalic.setOnAction(e -> update());
		
		//HBOX
		HBox checkBoxPane = new HBox(chkBold, chkItalic);
		checkBoxPane.setSpacing(30);
		checkBoxPane.setPadding(new Insets(15));
		checkBoxPane.setAlignment(Pos.CENTER);
		
		//HBOX FOR RADIO BUTTONS
		HBox paneForRadioButtons = new HBox(20);
		
		paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		paneForRadioButtons.setAlignment(Pos.CENTER);
		paneForRadioButtons.setPadding(new Insets(10));
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		
		rbBlack.setSelected(true);
		
		radioButtonHandlers();
		
		//VBOX FOR CHECKBOX AND RADIO BUTTONS
		VBox paneForAllButtons = new VBox(10);
		paneForAllButtons.getChildren().addAll(checkBoxPane, paneForRadioButtons);
		
		StackPane centerPane = new StackPane(text);
		update();
		
		BorderPane borderPane = new BorderPane(centerPane);
		borderPane.setTop(comboBoxPane);
		borderPane.setBottom(paneForAllButtons);
		
		//SCENE
		Scene scene = new Scene(borderPane, 500, 500);
		primaryStage.setTitle("Select a Font type");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Integer[] getSizes() {
		Integer[] sizes = new Integer[100];
		
		for(int i =0; i<100; i++) {
			sizes[i] = i + 1;
		}
		
		return sizes;
	}
	
	private void radioButtonHandlers() {
		rbRed.setOnAction(e -> {
			if(rbRed.isSelected()) {
				text.setFill(Color.RED);
			}		
	});
		rbBlack.setOnAction(e -> {
			if(rbBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}		
	});
		rbYellow.setOnAction(e -> {
			if(rbYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}		
	});
	
		rbOrange.setOnAction(e -> {
			if(rbOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}		
	});
	
		rbGreen.setOnAction(e -> {
			if(rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}	
		});
	}

	
	private void update() {
		FontWeight fontWeight = (chkBold.isSelected()) ? FontWeight.BOLD : FontWeight.NORMAL;
		
		FontPosture fontPosture = (chkItalic.isSelected()) ? FontPosture.ITALIC : FontPosture.REGULAR;
		
		String fontFamily = cbFontFamilies.getValue();
		double size = cbFontSize.getValue();
		
		text.setFont(Font.font(fontFamily, fontWeight, fontPosture, size));
	}
	
			
	public static void main(String[] args) {
		Application.launch(args);
	}
}
