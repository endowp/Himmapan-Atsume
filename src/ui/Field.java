package ui;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import animals.Animal;
import item.ItemButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import logic.AnimalField;
import logic.Random;
import main.Main;


public class Field extends GridPane{
	public static AnimalField animalField;
	private int balance = 0;
	Label balanceLabel;
	public Field() {
		super();
		HBox hb = new HBox();
		String image_path = ClassLoader.getSystemResource("background.jpg").toString();
		Image img = new Image(image_path);
        BackgroundSize size = new BackgroundSize(430, 500, false, false, true, false);
        BackgroundImage background = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,size);
        this.setBackground(new Background(background));
		this.setPrefSize(430, 500);
		String baseStyle = " -fx-text-fill: white;"
				+ " -fx-font-size: 20px;"
				+ " -fx-pref-height: 45px;"
				;
		String balanceLabelStyle = baseStyle
				+ " -fx-pref-width: 125px;"
				+ " -fx-border-radius: 0 0 10 0;"
				+ " -fx-background-radius: 0 0 10 0;"
				;
		balanceLabel = new Label("Balance : " + getBalance());
		balanceLabel.setAlignment(Pos.CENTER);
		balanceLabel.setStyle(balanceLabelStyle	+ " -fx-background-color: #173F5F;");
		animalField= new AnimalField();
		
		Button refreshButton= new Button();
		refreshButton.setText("Refresh");
		refreshButton.setStyle(baseStyle +" -fx-background-color: #20639B;"
										+ " -fx-border-radius: 0 0 10 10;"
										+ " -fx-background-radius: 0 0 10 10;");		
		refreshButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				animalField.update();
				ShortAudio audio = new ShortAudio("itemPickUp.mp3");
				audio.play();
			}
		});
		refreshButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				refreshButton.setStyle(" -fx-text-fill: white;"
									+ " -fx-font-size: 20px;"
									+ " -fx-background-color: #206370;");
				}
		});
		refreshButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				refreshButton.setStyle(" -fx-text-fill: white; -fx-font-size: 20px; -fx-background-color: #20639B;");
				}
		});
		
		String balanceButtonStyle = baseStyle
									+ " -fx-border-radius: 0 0 10 10;"
									+ " -fx-background-radius: 0 0 10 10;";
		Button balanceButton= new Button();
		balanceButton.setStyle(balanceButtonStyle
								+ " -fx-background-color: #20639B;");
		balanceButton.setText("Balance+1");
		balanceButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				balanceButton.setStyle(balanceButtonStyle
										+ " -fx-background-color: #206370;");
				}
		});
		balanceButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				balanceButton.setStyle(balanceButtonStyle
										+ " -fx-background-color: #20639B;");
				}
		});
		balanceButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				balance+=1;
				balanceLabel.setText("Balance : "+ Integer.toString(balance));
				ShortAudio audio = new ShortAudio("money.mp3");
				audio.play();
			
			}
		});
			
		Button animalInfobt = new Button("Animals information");
		animalInfobt.setStyle("-fx-text-fill: white; -fx-font-size: 18px; "
					+ "-fx-font-family:Arial Black; -fx-background-color: #3CAEA3;"
					+ " -fx-border-radius: 0 0 10 10;");
		
		animalInfobt.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				animalInfobt.setStyle("-fx-text-fill: white; -fx-font-size: 18px; "
						+ "-fx-font-family:Arial Black; -fx-background-color: #349B91;");
			}
		});		
		animalInfobt.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				animalInfobt.setStyle("-fx-text-fill: white; -fx-font-size: 18px; "
						+ "-fx-font-family:Arial Black; -fx-background-color: #3CAEA3;");
			}
		});
		
		Button KarinPaksabt = new Button("KarinPaksa");
		Button Kilenbt = new Button("Kilen");
		Button Kodchaseebt = new Button("Kodchasee");
		Button KarawakeBirdbt = new Button("KarawakeBird");
		Button HadsadinBirdbt = new Button("HadsadinBird");
		Button NilMangkornHorsebt = new Button("NilMangkornHorse");
		Button WareeKunchornbt = new Button("WareeKunchorn");
		Button Vetalabt = new Button("Vetala");
		Button SakoonaKraisornbt = new Button("SakoonaKraisorn");
		Button Hongbt = new Button("Hong");
		List<Button> animalButton = Arrays.asList( KarinPaksabt,  Kilenbt, Kodchaseebt, KarawakeBirdbt, HadsadinBirdbt, NilMangkornHorsebt, WareeKunchornbt, Vetalabt,
				SakoonaKraisornbt,Hongbt);
		for(Button bt: animalButton) {
			bt.setStyle("-fx-text-fill: white; -fx-font-size: 14px; "
					+ "-fx-font-family:Arial Black; -fx-background-color: #20639B;"
					+ " -fx-border-radius: 0 10 10 0;");			
		}
		Button cheatButton = new Button("");
		cheatButton.setStyle("-fx-text-fill: white; -fx-font-size: 14px; " +
							"-fx-border-color: transparent;" + 
							"-fx-pref-height: 40px;" +
							" -fx-pref-width: 27px;" +
							"-fx-border-width: 0;" + 
							"-fx-background-radius: 0;" + 
							"-fx-background-color: transparent;");
		cheatButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cheatButton.setDisable(true);
				for(ItemButton i:Main.itemBar.getItemButtons()) {
					File audioFile = new File("res/itemPickUp.mp3");
					AudioClip audio = new AudioClip(audioFile.toURI().toString());		
					audio.play();
					Random random = AnimalField.random;
					random.gotItem(i.getName());
					i.setDisable(true);
					i.setStyle("-fx-pref-height: 90px;"
							+  "-fx-background-color:black;");
				}
				balance+=100;
				balanceLabel.setText("Balance : "+ Integer.toString(balance));			
			}
		});
		
		hb.getChildren().addAll(balanceLabel, balanceButton,
								refreshButton, cheatButton , animalInfobt);
		animalField.setAlignment(Pos.BASELINE_CENTER);
		animalField.setTranslateY(200);
		this.add(animalField, 0, 1);
		this.add(hb, 0, 0);		
		
		animalInfobt.setOnAction(new EventHandler<ActionEvent>() {
			Boolean clicked = true;
			@Override
			public void handle(ActionEvent event) {

				VBox info = new VBox();
				for(int i=0; i<animalButton.size(); i++) {
					info.getChildren().add(animalButton.get(i));
				
				}
				if(clicked) {
					add(info,0,1);
					clicked = false;
				}
				else {
					hb.getChildren().clear();
					getChildren().clear();
				/*	add(balanceLabel,0,0);
					add(text, 1, 0);
					add(refreshButton, 2, 0);
					add(balanceButton, 3, 0);
					add(animalInfobt, 4, 0); */
					hb.getChildren().addAll(balanceLabel, balanceButton, 
											refreshButton, cheatButton , animalInfobt);
					animalField.setAlignment(Pos.BASELINE_CENTER);
					animalField.setTranslateY(200);
					add(animalField, 0, 1);
					add(hb, 0, 0);
					clicked = true;
				}						
			}
		}); 
		
		for(Button bt: animalButton) {
			bt.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					for(Animal ani: Random.allAnimals()) {
						if(ani.getName()==bt.getText()) {
							ShortAudio audio = new ShortAudio("popUp.mp3");
							audio.play();
							Alert info = new Alert(AlertType.INFORMATION);
							info.setTitle("Animals information");
							info.setHeaderText(ani.getName());
							info.setContentText("Name : " + ani.getName() + "\n"
									+ "Description : " + ani.getDescription() + "\n" 
									+ "Rarity : " + String.valueOf(ani.getRarity()) +"\n"
									+ "Item : " + ani.getItem() +"\n"
									+ "Duration : " + String.valueOf(ani.getDuration()) );
							String image_path = ClassLoader.getSystemResource( ani.getName() +".png").toString();
							ImageView image = new ImageView(new Image(image_path));
							image.setFitWidth(70);
							image.setFitHeight(70);
							image.setPreserveRatio(true);
							info.setGraphic(image);
							info.showAndWait();
						}
					}
					
				}
			});			
			bt.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					bt.setStyle("-fx-text-fill: white; -fx-font-size: 14px; "
							+ "-fx-font-family:Arial Black; -fx-background-color: #206370;");
				}
			});			
			bt.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					bt.setStyle("-fx-text-fill: white; -fx-font-size: 14px; "
							+ "-fx-font-family:Arial Black; -fx-background-color: #20639B;");
				}
			});
		}
	}

	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Label getBalanceLabel() {
		return balanceLabel;
	}

}