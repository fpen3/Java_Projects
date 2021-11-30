

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class lab19 extends BorderPane {
	protected TextField tfName = new TextField();
	protected TextField tfStreet = new TextField();
	protected TextField tfCity = new TextField();
	protected TextField tfState = new TextField();
	protected TextField tfZip = new TextField();
	
	protected Button btNew = new Button("New");
	protected Button btAdd = new Button("Add");
	protected Button btUpdate = new Button("Update");
	
	protected Button btFirst = new Button("First");
	protected Button btLast = new Button("Last");
	protected Button btPrevious = new Button("Previous");
	protected Button btNext = new Button("Next");
	
	private FlowPane paneForInfo = new FlowPane(5, 5);
	private HBox paneForButtonsTop = new HBox(5);
	private HBox paneForButtonsBottom = new HBox(5);
	private VBox paneForButtons = new VBox(5);
	
	public lab19() {
		drawlab19();
	}

	private void drawlab19() {
		//SET COLUMN SIZE
		tfName.setPrefColumnCount(23);
		tfStreet.setPrefColumnCount(23);
		tfCity.setPrefColumnCount(8);
		tfState.setPrefColumnCount(2);
		tfZip.setPrefColumnCount(4);
	
		//PLACE NODES
		paneForInfo.setPadding(new Insets(10, 10, 0, 10));
		paneForInfo.getChildren().addAll(new Label("Name"), tfName, new Label("Street"), tfStreet, new Label("City   "), tfCity,
				new Label("State"), tfState, new Label("Zip"), tfZip);
		
		//BUTTON PLACEMENT
		//TOP
		paneForButtonsTop.getChildren().addAll(btNew, btAdd, btUpdate);
		paneForButtonsTop.setAlignment(Pos.CENTER);
		paneForButtonsTop.setPadding(new Insets(10, 0, 0, 0));
		
		//BOTTOM
		paneForButtonsBottom.getChildren().addAll(btFirst, btNext, btPrevious, btLast);
		paneForButtonsBottom.setAlignment(Pos.CENTER);
		paneForButtonsBottom.setPadding(new Insets(0, 0, 10, 0));
		
		//BUTTON INTO VBOX
		paneForButtons.getChildren().addAll(paneForButtonsTop, paneForButtonsBottom);
		
		//NODES INTO BORDERPANE
		setCenter(paneForInfo);
		setBottom(paneForButtons);
		
		
	}
	
}
