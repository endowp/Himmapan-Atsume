package animals;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.AnimalField;

public class Animal {
	
	public String name, description;
	public int rarity;	//5 common, 4 uncommon, 3 rare, 2 epic, 1 legendary
	String item;	//item that attracts this animal
	int duration;	// animal will stay for this many cycles
	int stayed;
	Image image;
	
	public Animal(String name, int rarity, String item) {
		this.name=name;
		this.rarity=rarity;
		this.item=item;
		this.description=null;
		this.duration=1;
		this.stayed=0;
		image = new Image(ClassLoader.getSystemResource(name+".png").toString());
	}
	public Animal(String name, String description, int rarity, String item, int duration) {
		this.name=name;
		this.rarity=rarity;
		this.item=item;
		this.description=description;
		this.duration=duration;
		this.stayed=0;
		image = new Image(ClassLoader.getSystemResource(name+".png").toString());
	}
	
	public boolean isStaying() {
		if(0 <= this.stayed && this.stayed < this.duration)
			return true;
		return false;
	}
	public void setStayed(int stayed) {
		this.stayed=stayed;
	}
	public int getStayed() {
		return this.stayed;
	}
	public void render(AnimalField target) {
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(100);
		imageView.setFitHeight(150);
		imageView.setPreserveRatio(true);
		target.getChildren().add(imageView);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Image getImage() {
		return this.image;
	}
}
