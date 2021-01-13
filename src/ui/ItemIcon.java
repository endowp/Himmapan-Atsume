package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemIcon extends ImageView {
	
	private static final int MAX_FIT_HEIGHT = 80;
	private static final int MAX_FIT_WIDTH = 80;
	
	public ItemIcon(String imagePath) {
		super();
		Image itemImage = new Image(imagePath);
		this.setImage(itemImage);
		this.setFitHeight(MAX_FIT_HEIGHT);
		this.setFitWidth(MAX_FIT_WIDTH);

		this.setPreserveRatio(true);
	}
}
