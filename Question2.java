/*
Menu Control:
Author: NAMAN KABADI
USN:2SD20CS058
PROBLEM STATEMENT:
Write a Java program to build the GUI application using JavaFX for the following requirements:
a) Create a Menu control to display the menu items: File, Edit & Help.
b) Create sub menus in the order: File → New, Open & Save. Edit → Cut, Copy & Paste.
Help → Help Center, About Us
The program must use Mnemonics and Accelerators (wherever appropriate) to Menu Items.

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
public class Question2 extends Application {
	Label response;

	public static void main(String[] args) {
		// Start the JavaFX application by calling launch().
		launch(args);
	}

	// Override the start() method.
	public void start(Stage myStage) {
		
		// Give the stage a title.
		myStage.setTitle("Menu Items Demo");
		
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
		
		// Create the File menu.
		Menu fileMenu = new Menu("File");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem exit = new MenuItem("Exit");
		MenuItem close = new MenuItem("Close");
		fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);
		
		
		// Add File menu to the menu bar.
		mb.getMenus().add(fileMenu);
		
		// Create the Edit menu.
		Menu EditMenu = new Menu("Edit");
		// Create the Edit sub-menu.
		MenuItem cutSubmenu = new MenuItem("Cut");
		MenuItem copySubmenu = new MenuItem("Copy");
		MenuItem pasteSubmenu = new MenuItem("Paste");
		EditMenu.getItems().addAll(cutSubmenu,copySubmenu,pasteSubmenu);
		mb.getMenus().add(EditMenu);
		
		
		// Create the Help menu.
		Menu helpMenu = new Menu("Help");
		MenuItem helpCentre = new MenuItem("Help Centre");
		MenuItem about = new MenuItem("About Us");
		helpMenu.getItems().addAll(helpCentre,about);
		
		// Add Help menu to the menu bar.
		mb.getMenus().add(helpMenu);
		
		// Create the context menu items
		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		
		// Create a context (i.e., popup) menu that shows edit options.
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
		open.setOnAction(MEHandler);
		close.setOnAction(MEHandler);
		save.setOnAction(MEHandler);
		exit.setOnAction(MEHandler);
		about.setOnAction(MEHandler);
		cutSubmenu.setOnAction(MEHandler);
		copySubmenu.setOnAction(MEHandler);
		helpCentre.setOnAction(MEHandler);
		pasteSubmenu.setOnAction(MEHandler);
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


