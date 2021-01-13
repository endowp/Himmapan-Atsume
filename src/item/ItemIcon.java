package item;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemIcon extends ImageView {
	private static final int HEIGHT = 68;
	private static final int WIDTH = 68;
		
		public ItemIcon(String imagePath) {
			super();
			Image buildingImage = new Image(imagePath);
			this.setImage(buildingImage);
			this.setFitHeight(HEIGHT);
			this.setFitWidth(WIDTH);

			this.setPreserveRatio(true);
		}
}