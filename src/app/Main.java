package app;

import java.util.Scanner;

import game.Game;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("---------------- Welcome to Dice Game ----------------");
		int num = -1;
		Scanner input = new Scanner(System.in);
		while (num < 0 || num > 4) {
			Thread.sleep(200);
			System.out.print("Nhập tên người chơi (Lưu ý: Số người không được quá 4 và không âm): ");
			num = input.nextInt();
		}
		Game game = new Game(num);
		game.startGame();
		game.endGame();
	}
}
