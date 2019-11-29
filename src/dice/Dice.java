package dice;

import java.util.Random;

public class Dice {
	int[] face = new int[7];
	int priorityFace;
	
	public Dice(int priorityFace) {
		this.priorityFace = priorityFace;
		face[0] = 0;
		for (int i = 1; i < 7; i++) {
			if (i == priorityFace)
				face[i] = face[i - 1] + 20;
			else 
				face[i] = face[i - 1] + 16;
		}
	}
	public int roll() {
		Random rd = new Random();
		int pivot = rd.nextInt(100);
		for (int i = 1; i < 7; i++) {
			if (face[i] > pivot) {
				return i;
			}
		}
		return 0;
	}
}
