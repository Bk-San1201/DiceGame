package player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class VirtualPlayer extends Player{
	String emotion;
	
	public VirtualPlayer(String name) {
		super(name);
	}
	public VirtualPlayer(String name, int score) {
		super(name, score);
		this.emotion = getRandomEmotion();
	}
	public VirtualPlayer(String name, int score, String emotion) {
		super(name, score);
		if (emotion != null)
			this.emotion = emotion;
	}
	private static String getString(String dir) {
		String str;
		ArrayList<String> arr = new ArrayList<>();
		try {
			FileReader fr = new FileReader(dir);
			BufferedReader br = new BufferedReader(fr);
			while ((str = br.readLine()) != null) {
				arr.add(str);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException f) {
			f.printStackTrace();
		}
		Random rd = new Random();
		int out = rd.nextInt(arr.size() - 1);
		return arr.get(out);
	}
	public static String getRandomName() {
		return getString("./Data/name.txt");
	}
	public static String getRandomEmotion() {
		return getString("./Data/emotion.txt");
	}
	public String getEmotion() {
		return emotion;
	}
	
}
