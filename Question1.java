/*
USER NAME AND PASSWORD VALIDATION SYSTEM
Author: NAMAN KABADI
USN:2SD20CS058
PROBLEM STATEMENT:
Write a Java program to build the GUI application using JavaFX for the following requirements:
a) Read user name and password using appropriate JavaFX controls.
b) Validate the input. If user name and password are matched with the assumed values, then
display the welcome scene with proper text.
c) If user name and password don’t match, then raise appropriate exception.

 */


package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Question1 extends Application {
	//Here we are assuming the user name and password as admin and proceeding further
    private String adminUsername = "admin";
    private String adminPassword = "admin";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Login Example Demo");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Login");
        sceneTitle.setTextAlignment(TextAlignment.CENTER);
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField passwordBox = new PasswordField();
        grid.add(passwordBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String username = userTextField.getText().toString();
                String password = passwordBox.getText().toString();

                if(userTextField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Form Error!",
                            "Please enter your correct user name");
                    return;
                }
                if(passwordBox.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Form Error!",
                            "Please enter a valid password");
                    return;
                }

                if(adminUsername.equals(username) && adminPassword.equals(password)){
                    infoBox("Login Successful!\n\nWELCOME TO THIS GUI INTERFACE", null, "Success");
                } else{
                    infoBox("Please enter correct User Name and Password", null, "Failed");
                }
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
}