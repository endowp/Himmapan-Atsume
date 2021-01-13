package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.Field;
import ui.ItemBar;
import ui.ShortAudio;
import ui.Song;

public class Main extends Application{

	public static Field field;
	public static ItemBar itemBar;

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		field = new Field();
		itemBar = new ItemBar();
		root.getChildren().addAll(field, itemBar);
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		VBox gameOpenRoot = new VBox();
		Song winterTheme = new Song("winterTheme.mp3");
		winterTheme.play();
		gameOpenRoot.setAlignment(Pos.CENTER);
		
		String image_path = ClassLoader.getSystemResource("HimmapanAtsume.jpg").toString();
		Image image = new Image(image_path);
        BackgroundSize size = new BackgroundSize(500, 500, false, false, true, false);
        BackgroundImage background = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,
        		BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,size);
		gameOpenRoot.setBackground(new Background(background));
		Button startbt = new Button("Start Game!");
		startbt.setStyle("-fx-text-fill: brown; -fx-font-size: 32px; "
				+ "-fx-font-family:Arial Black;-fx-fill: #600; -fx-background-color: orange;");
		startbt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				ShortAudio audio = new ShortAudio("itemPickUp.mp3");
				audio.play();
				primaryStage.setScene(scene);
			}
		});
		
		startbt.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startbt.setStyle("-fx-text-fill: white; -fx-font-size: 32px; "
						+ "-fx-font-family:Arial Black;-fx-fill: #600; -fx-background-color: gold;");
			}
		});
		startbt.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startbt.setStyle("-fx-text-fill: brown; -fx-font-size: 32px; "
						+ "-fx-font-family:Arial Black;-fx-fill: #600; -fx-background-color: orange;");
			}
		});
		
		
		gameOpenRoot.setPrefSize(500, 500);
		gameOpenRoot.getChildren().addAll(startbt);
		Scene gameOpenScene = new Scene(gameOpenRoot);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(gameOpenScene);
		primaryStage.show();
		primaryStage.setTitle("Himmapan Atsume");
	
	}
	
	public static void main (String [] args) {
		launch(args);
	}


}
