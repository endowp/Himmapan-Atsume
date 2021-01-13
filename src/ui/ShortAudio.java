package ui;

import java.io.File;

import javafx.scene.media.AudioClip;

public class ShortAudio implements Playable {
	
	String name;
	File audioFile;
	public ShortAudio(String name) {
		this.name = name;		
		audioFile = new File("res/" + name);
	}
	public void play() {
		AudioClip audio = new AudioClip(audioFile.toURI().toString());		
		audio.play();
	}

}
