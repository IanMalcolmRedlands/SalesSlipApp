package salesapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SalesApp extends Application {
	SalesSlip slip;
	
	private TextField itemIn, costIn, quantIn;
	private Button button;
	private Text result;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) {
		slip = new SalesSlip();
		
		VBox box = new VBox();
		
		Label itemLabel = new Label("Name:");
		itemIn = new TextField();
		Label costLabel = new Label("Cost:");
		costIn = new TextField();
		Label quantLabel = new Label("Quantity:");
		quantIn = new TextField();
		
		button = new Button("Add Item");
		
		result = new Text();
		result.setWrappingWidth(600);
		
		setButtonListener();
		box.getChildren().addAll(itemLabel, itemIn, costLabel, costIn, quantLabel, quantIn, button, result);

        Scene scene = new Scene(box, 640, 480);
        
        stage.setTitle("Sales Tally");
        stage.setScene(scene);
        stage.show();
	}
	
	/**
	 * Sets up button logic.
	 */
	private void setButtonListener() {
		EventHandler<ActionEvent> listener = new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent e) {
    			try {
	    			SalesItem item = new SalesItem(
	    				itemIn.textProperty().get(),
	    				Double.parseDouble(costIn.textProperty().get()),
	    				Integer.parseInt(quantIn.textProperty().get())
	    			);

	    			
	    			slip.addItem(item);
	    			
	    			result.setText(slip.toString());
    			} catch (NumberFormatException ex) {
    				result.setText("Invalid input");
    			}
    		}
    	};
    	
    	button.setOnAction(listener);
	}

}
