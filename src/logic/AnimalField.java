package logic;

import java.util.ArrayList;

import animals.Animal;
import javafx.scene.layout.HBox;

public class AnimalField extends HBox{
	public static final int FIELD_WIDTH = 5;
	public static final int FIELD_HEIGHT = 2;
	
	//public static final AnimalField instance = new AnimalField();

	public ArrayList<Animal> aniList;
	public static Random random;
	
	public AnimalField() {
		super();
		random = new Random();
		aniList=new ArrayList<Animal>();
	}
			
	public void update() {		
		
		this.getChildren().clear();
		ArrayList<Animal> toBeRemoved = new ArrayList<Animal>();
		int space = 5 -aniList.size();
		for(Animal a: aniList) {
			if(a.isStaying()) {
				a.setStayed(a.getStayed()+1);		
			}
			else {
				toBeRemoved.add(a);			
			}
		}
		for(Animal a: toBeRemoved) 
			aniList.remove(a);
		toBeRemoved.clear();

		space = 5 -aniList.size();
		
		if(space>0)
		aniList = random.random(space);
		for(Animal a: aniList) 
			a.render(this);
	
	}
	
}
