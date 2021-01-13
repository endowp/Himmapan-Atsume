package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import logic.AnimalField;
import logic.Random;
import java.util.ArrayList;
import item.BuyItemFailedException;
import item.ItemButton;

public class ItemBar extends HBox {
		ArrayList<ItemButton> itemButtons;
	
	public ItemBar() {
		itemButtons = new ArrayList<ItemButton>();
		
		ItemButton holyFishbt = new ItemButton("holyFish", "file:res/fish.png");
		ItemButton blessedWormbt = new ItemButton("blessedWorm", "file:res/worm.png");
		ItemButton superMeatbt = new ItemButton("superMeat", "file:res/meat.png");
		ItemButton cuteMicebt = new ItemButton("cuteMice", "file:res/mice.png");
		ItemButton yummyHaybt = new ItemButton("yummyHay", "file:res/hay.png");
		ItemButton normalSugarCanebt = new ItemButton("normalSugerCane", "file:res/sugarCane.png");

		setAlignment(Pos.CENTER);
		itemButtons.add(holyFishbt);
		itemButtons.add(blessedWormbt);
		itemButtons.add(superMeatbt);
		itemButtons.add(cuteMicebt);
		itemButtons.add(yummyHaybt);
		itemButtons.add(normalSugarCanebt);
		
		for(ItemButton i: itemButtons) {

			i.setStyle("-fx-pref-height: 90px;"
					+  "-fx-background-color:transparent;");
			i.setOnAction(new EventHandler<ActionEvent>() {			
				@Override
				public void handle(ActionEvent arg0) {
					try {
						if(buyItem(i.getName(),10)) {
							ShortAudio audio = new ShortAudio("itemPickUp.mp3");
							audio.play();
							Random random = AnimalField.random;
							random.gotItem(i.getName());
							i.setDisable(true);
							i.setStyle("-fx-pref-height: 90px;"
									+  "-fx-background-color:black;");
						}					
					}
					catch (BuyItemFailedException e) {
				//		System.out.println(e.getMessage());	
						Alert info = new Alert(AlertType.WARNING);
						info.setTitle(e.getMessage());
						info.setHeaderText("You need more money!");
						info.setContentText("Please click Balance+1!");
						info.showAndWait();
					}				
				}
			});			
		}

		Button backbt = new Button("back");
		Button infobt = new Button("?");
		Label info = new Label("Click any item to buy it! (10 $ each) ");
		
		info.setPrefHeight(70);
		info.setStyle("-fx-text-fill: black; -fx-font-size: 16px; -fx-font-family:Arial Black");
		infobt.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family:Arial Black ;-fx-background-color:black");
		backbt.setStyle("-fx-text-fill: white; -fx-font-size: 20px; -fx-font-family:Arial Black ;-fx-background-color:black");
		
		backbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				getChildren().clear();
				getChildren().addAll(holyFishbt,blessedWormbt,
						superMeatbt,cuteMicebt,yummyHaybt,normalSugarCanebt,infobt);
			}
		});
		backbt.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				backbt.setStyle("-fx-text-fill: black; -fx-font-size: 20px; "
						+ "-fx-font-family:Arial Black ;-fx-background-color:gold");
			}
		});
		
		backbt.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				backbt.setStyle("-fx-text-fill: white; -fx-font-size: 20px; "
						+ "-fx-font-family:Arial Black ;-fx-background-color:black");
			}
		});
		infobt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getChildren().clear();
				getChildren().addAll(info, backbt);
			}
		});
		infobt.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				infobt.setStyle("-fx-text-fill: black; -fx-font-size: 20px;"
						+ " -fx-font-family:Arial Black ;-fx-background-color:gold");
			}
		});		
		infobt.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				infobt.setStyle("-fx-text-fill: white; -fx-font-size: 20px; "
						+ "-fx-font-family:Arial Black ;-fx-background-color:black");
			}
		});
		this.getChildren().addAll(holyFishbt,blessedWormbt,
				superMeatbt,cuteMicebt,yummyHaybt,normalSugarCanebt,infobt);
		this.setPadding(new Insets(5));
		this.setStyle("-fx-background-color:#F6D55C;"+"-fx-pref-height: 95px;");	
	}
	
		public boolean buyItem(String name, int price) throws BuyItemFailedException {			
			if(main.Main.field.getBalance()-price>=0) {
				System.out.println("Bought "+ name +"!");				
				main.Main.field.setBalance(main.Main.field.getBalance()-price);
				main.Main.field.balanceLabel.setText("Balance : "+ Integer.toString(main.Main.field.getBalance()));
				return true;
			}
			else {
				throw new BuyItemFailedException("Not enough money!");		
			}
		}		
		
		public ArrayList<ItemButton> getItemButtons() {
			return itemButtons;
		}
}
