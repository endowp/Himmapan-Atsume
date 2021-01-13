package ui;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Song implements Playable {

	String name;
	File audioFile;
	public Song(String name) {
		this.name = name;		
		audioFile = new File("res/" + name);
	}

	@Override
	public void play() {
		Media song = new Media(audioFile.toURI().toString());
		MediaPlayer songPlayer = new MediaPlayer(song);
		songPlayer.setAutoPlay(true);
		songPlayer.setVolume(0.4);
		songPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		songPlayer.play();

	}

}
