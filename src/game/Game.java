package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import dice.Dice;
import player.Player;
import player.VirtualPlayer;

public class Game {
	Dice[] dice = new Dice[4];
	Player[] player = new Player[4];
	int numRealPlayer;
	int winner;
	
	public Game(int numRealPlayer) {
		this.numRealPlayer = numRealPlayer;
		for (int i = 0; i < 4; i++) {
			dice[i] = new Dice(i + 1);
		}
		setPlayer();
	}
	
	private void setPlayer() {
		for (int i = 0; i < this.numRealPlayer; i++) {
			player[i] = new Player(getNamePlayer(i + 1), 0);
		}
		for (int i = this.numRealPlayer; i < 4; i++) {
			String name = VirtualPlayer.getRandomName();
			String emotion = VirtualPlayer.getRandomEmotion();
			player[i] = new VirtualPlayer(name,0 ,  emotion);
		}
	}
	private String getNamePlayer(int i) {
		String strLine = "";
		System.out.print("Nhập tên người chơi thứ " + i + ": ");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    strLine = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return strLine;
	}
	private void showStatusGame() {
		for (int i = 0; i < this.numRealPlayer; i++) {
			System.out.println("Tên người chơi số " + i + ": " + player[i].getName());
		}
		for (int i = this.numRealPlayer; i < 4; i++) {
			System.out.println("Tên người chơi ảo số " + i + ": " + player[i].getName());
		}
	}
	public void startGame() {
		showStatusGame();
		Random rd = new Random();
		@SuppressWarnings("unused")
		int turn;
		int round = 1;
		while(true) {
			System.out.println("--------------- Round " + round + " ---------------");
			turn = rd.nextInt(4);
			System.out.println("Người chơi thứ " + (turn + 1) + " được chọn. Điểm hiện tại là: " + player[turn].getScore());
			for (int i = 0; i < 4; i++) {
				player[turn].addScore(dice[i].roll());
			}
			System.out.println("Người chơi thứ " + (turn + 1) + " có điểm sau khi chơi là: " + player[turn].getScore());
			if (player[turn].getScore() > 21) {
				player[turn].setScore(0);
			} else if (player[turn].getScore() == 21) {
				this.winner = turn;
				return;
			}
			round += 1;
		}
	}
	public void endGame() {
		System.out.println("Người chiến thắng trong Game này là: " + player[winner].getName());
		for (int i = this.numRealPlayer; i < 4; i++) {
			if (i != winner) {
				VirtualPlayer vp = (VirtualPlayer) player[i];
				System.out.println(vp.getName() + ": " + vp.getEmotion());
			}
		}
	}
	
}
