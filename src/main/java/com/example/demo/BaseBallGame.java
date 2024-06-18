package com.example.demo;

import java.util.Scanner;


/**
 * do to list
 * <p>
 * [ ] 1 ~ 9까지의 랜덤 숫자 만들기
 * [ ] 서로 다른 3자리의 숫자 만들기
 * [ ] ball 판별
 * [ ] strike 판별
 */
public class BaseBallGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Computer computer = new Computer();
            Player player = new Player(scanner);
            Game game = new Game(computer, player);

            game.play();

            if (!askForReplay(scanner)) {
                scanner.close();
                break;
            }
        }
    }

    private static boolean askForReplay (Scanner scanner){
        System.out.print("다시 하시겠습니까? (다시 하기 1) (그만 하기 2): ");
        String repeat = scanner.nextLine();
        return repeat.equals("1");
    }

//    public static int getRandomNumber() {
//        return (int) (Math.random() * 9) + 1;
//    }
}



