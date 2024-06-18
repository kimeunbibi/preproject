package com.example.demo;

import java.util.List;

public class Game {

    private Computer computer;
    private Player player;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void play() {
        List<Integer> comList = computer.getNumbers();
        System.out.println("컴퓨터 수 : " + comList);
        
        while (true) {
            List<Integer> playerList = player.getNumbers();
            
            int strike = getStrike(playerList, comList);
            int ball = getBall(playerList, comList);
            
            displayResult(strike, ball);
        }
    }

    private int getBall(List<Integer> playerList, List<Integer> comList) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (!playerList.get(i).equals(comList.get(i)) && playerList.contains(comList.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int getStrike(List<Integer> playerList, List<Integer> comList) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (playerList.get(i).equals(comList.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private void displayResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
