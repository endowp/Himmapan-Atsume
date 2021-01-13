package logic;

import java.util.ArrayList;
import animals.Animal;
import ui.Field;

public class Random {

	static Animal KarinPaksa;
	static Animal Kilen;
	static Animal Kodchasee;
	static Animal KarawakeBird;
	static Animal HadsadinBird;
	static Animal NilMangkornHorse;
	static Animal WareeKunchorn;
	static Animal Vetala ;
	static Animal SakoonaKraisorn;
	static Animal Hong ;
	static ArrayList<Animal> ani;
	static ArrayList<AnimalRandomNum> aniNum;
	static int sumProb;
	static ArrayList<Animal> list;
	
	public Random() {
		ani = new ArrayList<Animal>();
		aniNum = new ArrayList<AnimalRandomNum>();
		KarinPaksa = new Animal("KarinPaksa","An ebony-skinned elephant. Its wings and tail are bird-like and as red as a bird's blood.",
					5, "normalSugerCane",8);
		Kilen = new Animal("Kilen","Its body is as graceful as a deer, it has a cow's tail, and a dragon's head. Its feet have hooves.",
				2, "yummyHay", 5);
		Kodchasee = new Animal("Kodchasee","It has a lion's body but it has a trunk.",
					3, "yummyHay", 5);
		KarawakeBird = new Animal("KarawakeBird","A bird that flies higher than the clouds. If it sings, all animals will stop to listen to its beautiful voice.",
						2, "blessedWorm", 7);
		HadsadinBird = new Animal("HadsadinBird","It is bird-like, but there is a trunk where a beak is supposed to be",
						5,"blessedWorm",4);
		NilMangkornHorse = new Animal("NilMangkornHorse","It has a dragon's head, but every part below its neck is a horse's. It has a naka's tail.",
							5, "superMeat", 5);
		WareeKunchorn = new Animal("WareeKunchorn","Its upper part of the body is elephant-like, but its lower part is of a fish. It can swim and dive.",
						1, "holyFish", 3);
		Vetala = new Animal("Vetala","It's not a human. It looks ike a bat, its eyes are protuding, its tail is short.",
				1, "blessedWorm", 6);
		SakoonaKraisorn = new Animal("SakoonaKraisorn","A brown-bodied hybrid, a bird-like head, a lion-like body.",
							4, "cuteMice",5);
		Hong = new Animal("Hong","A divine bird with an elegant body and a heavenly singing voice.",
						5, "blessedWorm", 5);
		
		ani.add(KarinPaksa);
		ani.add(Kilen);
		ani.add(Kodchasee);
		ani.add(KarawakeBird);
		ani.add(HadsadinBird);
		ani.add(NilMangkornHorse);
		ani.add(WareeKunchorn);
		ani.add(Vetala);
		ani.add(SakoonaKraisorn);
		ani.add(Hong);
		randomInit();
		list = new ArrayList<Animal>();
	}
	public static void randomInit(){
		sumProb=0;
		for(Animal e : allAnimals()) {
			aniNum.add(new AnimalRandomNum(e, sumProb, e.getRarity()+ sumProb));
			sumProb+=e.rarity;			
		}		
	}
	public ArrayList<Animal> random(int slots){
		
		for(int i=0;i<slots;i++) {
            int rand = (int)(Math.random() * sumProb); 
            Animal pos = null;
            for(AnimalRandomNum e:aniNum) {
				if(e.getStart()<=rand && rand<e.getEnd()) {
					pos = e.getAnimal();
				}
			}
            while(list.contains(pos) || Field.animalField.aniList.contains(pos)) {
            	rand = (int)(Math.random() * sumProb); 
                pos = null;
                for(AnimalRandomNum e:aniNum) {
    				if(e.getStart()<=rand && rand<e.getEnd()) {
    					pos = e.getAnimal();
    				}
                }
            }			
			list.add(pos);
		}
		return list;
	}
	public static ArrayList<Animal> allAnimals(){

		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(KarinPaksa);
		animals.add(Kilen);
		animals.add(Kodchasee);
		animals.add(KarawakeBird);
		animals.add(HadsadinBird);
		animals.add(NilMangkornHorse);
		animals.add(WareeKunchorn);
		animals.add(Vetala);
		animals.add(SakoonaKraisorn);
		animals.add(Hong);
		return animals;
	}
	public void gotItem(String item) {
		for(Animal a:allAnimals()) {
			if(item == a.getItem() ) {
				a.rarity= a.rarity+1>5? 5 : a.rarity+1;
				sumProb+=1;
			//	System.out.println(item + a.getName() + a.rarity);
			}
			
		randomInit();
		}		
	}
}


