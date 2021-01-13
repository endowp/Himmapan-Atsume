package logic;

import animals.Animal;

public class AnimalRandomNum {
	Animal animal;
	int start;
	int end;
	
	public AnimalRandomNum(Animal animal, int start, int end) {
		super();
		this.animal = animal;
		this.start = start;
		this.end = end;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

}
