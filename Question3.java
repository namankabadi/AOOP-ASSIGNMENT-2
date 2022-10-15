/*
Menu Control:
Author: NAMAN KABADI
USN:2SD20CS058
PROBLEM STATEMENT:
Write a Java program to build the GUI application using JavaFX for the following requirements:
a) Create Context menu involving the menu items in the order: New & View.
b) Create sub menus for the above main context menu: New → File, Folder & Image.
View → Large, Medium & Small.
The context menu must be displayed on right-click of the mouse button.


*/
package application;

//Demonstrate Menus
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.Pos;
//Demo 2
public class Question3 extends Application {
	Label response;

	public static void main(String[] args) {
		// Start the JavaFX application by calling launch().
		launch(args);
	}

	// Override the start() method.
	public void start(Stage myStage) {
		
		// Give the stage a title.
		myStage.setTitle("Demonstrate Menus");
		
		// Use a BorderPane for the root node.
		BorderPane rootNode = new BorderPane();
		
		// Create a scene.
		Scene myScene = new Scene(rootNode, 300, 300);
		
		// Set the scene on the stage.
		myStage.setScene(myScene);
		
		// Create a label that will report the selection.
		response = new Label("Menu Demo");
		
		
		
		// Create the menu bar.
		MenuBar mb = new MenuBar();
		//Creating the context menu New
		Menu New = new Menu("New");
		MenuItem File = new MenuItem("File");
		MenuItem Folder = new MenuItem("Folder");
		MenuItem Image = new MenuItem("Image");
		New.getItems().addAll(File,Folder,Image);
		mb.getMenus().add(New);
		
		
		Menu View = new Menu("View");
		MenuItem Large = new MenuItem("Large");
		MenuItem Medium = new MenuItem("Medium");
		MenuItem Small = new MenuItem("Small");
		View.getItems().addAll(Large,Medium,Small);
		mb.getMenus().add(View);
		
		// Create the context menu items
		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		
		// Create a context (i.e., pop up) menu that shows edit options.
		final ContextMenu editMenu = new ContextMenu(cut, copy, paste);
		
		// Create one event handler that will handle menu action events.
		EventHandler<ActionEvent> MEHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				String name = ((MenuItem) ae.getTarget()).getText();
				// If Exit is chosen, the program is terminated.
				if (name.equals("Exit"))
					Platform.exit();
				response.setText(name + " selected");
			}
		};
		
		// Set action event handlers for the menu items.
		New.setOnAction(MEHandler);
		View.setOnAction(MEHandler);
		cut.setOnAction(MEHandler);
		copy.setOnAction(MEHandler);
		paste.setOnAction(MEHandler);
		
		// Create a text field and set its column width to 20.
		TextField tf = new TextField();
		tf.setPrefColumnCount(20);
		
		// Add the context menu to the text field.
		tf.setContextMenu(editMenu);
		
		// Add the menu bar to the top of the border pane and
		// the response label to the center position.
		rootNode.setTop(mb);
		
		// Create a flow pane that will hold both the response
		// label and the text field.
		FlowPane fpRoot = new FlowPane(10, 10);
		
		// Center the controls in the scene.
		fpRoot.setAlignment(Pos.CENTER);
		
		// Add both the label and the text field to the flow pane.
		fpRoot.getChildren().addAll(response, tf);
		
		// Add the flow pane to the center of the border layout.
		rootNode.setCenter(fpRoot);
		
		// Show the stage and its scene.
		myStage.show();
	}
}


