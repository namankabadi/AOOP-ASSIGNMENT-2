package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Q4 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			String state[] = {  "Maharashtra","Kerala","Karnataka","Haryana", "Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh",
		    "Goa","Gujarat","PUNJAB"};
			VBox cBox = new VBox();
			
			Scene scene = new Scene(cBox,450,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			Label headingLabel = new Label("Employee Registration Form");
			headingLabel.setFont(Font.font(26));
			Label nameLabel = new Label("Enter Your Name:");
			Label genderLabel = new Label("Enter Your Gender");
			Label dobLabel = new Label("Enter Date of Birth");
			Label stateLabel = new Label("Select Your State");
			
			TextField nameField = new TextField();
			nameField.setPrefWidth(250);
			nameField.setPromptText("Enter Your Name");
			nameField.setFocusTraversable(false);

			RadioButton maleButton = new RadioButton("Male");
			RadioButton femaleButton = new RadioButton("Female");
			
			ToggleGroup genderGroup = new ToggleGroup();
			maleButton.setToggleGroup(genderGroup);
			femaleButton.setToggleGroup(genderGroup);
			
			DatePicker dobDatePicker = new DatePicker();
			
			
			
			ComboBox<String> stateComboBox = new ComboBox<>();
			stateComboBox.setPrefWidth(130);
			stateComboBox.getItems().addAll(state);			
			Button registerButton = new Button("Register");
			
			registerButton.setOnAction((ae)->{
				
				Alert registerDialog = new Alert(AlertType.INFORMATION);
				registerDialog.setTitle("Registration Successful");
				
				registerDialog.setHeaderText("Registration Status");
				registerDialog.setContentText("Employee Registration Successful!!");			
				registerDialog.showAndWait();
				
			} );
			cBox.setAlignment(Pos.CENTER);
			cBox.setSpacing(20);
			cBox.setPadding(new Insets(0, 0, 0, 20));
			
			
			GridPane cPane = new GridPane();
			cPane.setHgap(10);
			cPane.setVgap(10);
			
			cPane.setAlignment(Pos.CENTER);
			
			cPane.add(nameLabel, 0, 0);
			
			GridPane.setHalignment(nameLabel, HPos.RIGHT);
			cPane.add(nameField, 1, 0);			
			
			cPane.add(genderLabel, 0, 1);
			GridPane.setHalignment(genderLabel, HPos.RIGHT);
			
			HBox genderBox = new HBox();
			genderBox.setSpacing(10);
			genderBox.getChildren().addAll(maleButton,femaleButton);
			
			cPane.add(genderBox, 1, 1);
			
			cPane.add(dobLabel,	 0, 2);
			GridPane.setHalignment(dobLabel, HPos.RIGHT);
			
			cPane.add(dobDatePicker, 1, 2);
			
			cPane.add(stateLabel, 0, 3);
			GridPane.setHalignment(stateLabel, HPos.RIGHT);
			
			cPane.add(stateComboBox, 1, 3);
			
		
			
			
			cBox.getChildren().addAll(headingLabel,cPane,registerButton);
			
			
			
			
			primaryStage.show();		
			
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}