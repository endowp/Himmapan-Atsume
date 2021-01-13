package item;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import item.ItemIcon;

public class ItemButton extends Button{
	
	private String name;
	//private String url;
	
	public ItemButton(String name, String url) {
		
		super();
		this.name = name;
		this.setPrefSize(70, 70);
		this.setStyle("-fx-background-color: transparent;");
		this.setGraphic(new ItemIcon(url));
		this.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Clicked on " + name);
				//Text.setText("Clicked on " + name);
			}
		});
	}
	
	public String getName() {
		return this.name;
	}
	
}
