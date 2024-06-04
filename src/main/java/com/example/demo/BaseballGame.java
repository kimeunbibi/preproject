package com.example.demo;

import java.util.*;


/**
 * do to list
 * <p>
 * [ ] 1 ~ 9까지의 랜덤 숫자 만들기
 * [ ] 서로 다른 3자리의 숫자 만들기
 * [ ] ball 판별
 * [ ] strike 판별
 */
public class BaseballGame {

    public static void main(String[] args) {

        List<Integer> comList = getComList();

        System.out.println("컴퓨터 수: " + comList);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //3자리 판별
            List<Integer> playerList = getPlayerList(scanner);

            if (!checkPlayList(playerList)) {
                continue;
            }

            int strike = 0;
            int ball = 0;

            strike = getStrike(playerList, comList, strike);
            ball = getBall(playerList, comList, ball);

            checkResult(strike, ball);

            String repeat = "";
            if (strike == 3) {
                System.out.println("정답입니다.");
                System.out.print("다시 하시겠습니까? (다시 하기 1) (그만 하기 2)");
                repeat = scanner.nextLine();
            }

            if (repeat.equals("1")) {
                comList = getComList();
                System.out.println("컴퓨터 수: " + comList);
                continue;
            }

            if (repeat.equals("2")) {
                break;
            }

        }

    }

    private static String getRepeat(Scanner scanner) {
        System.out.println("정답입니다.");
        System.out.print("다시 하시겠습니까? (다시 하기 1) (그만 하기 2)");
        String repeat = scanner.nextLine();
        return scanner.nextLine();
    }

    private static int getBall(List<Integer> playerList, List<Integer> comList, int ball) {
        for (int i = 0; i < 3; i++) {
            if (!playerList.get(i).equals(comList.get(i)) && playerList.contains(comList.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private static int getStrike(List<Integer> playerList, List<Integer> comList, int strike) {
        for (int i = 0; i < 3; i++) {
            if(playerList.get(i).equals(comList.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private static List<Integer> getPlayerList(Scanner scanner) {
        while(true){
            System.out.print("숫자를 입력해 주세요 :");
            String input = scanner.nextLine();

            if (input.length() != 3) {
                System.out.println("세자리 숫자를 입력해 주세요.");
                continue;
            }

            List<Integer> playerList = new ArrayList<>();

            for (char c : input.toCharArray()) {
                playerList.add(Character.getNumericValue(c));
            }

            return playerList;
        }

    }

    private static void checkResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("nothing");
        }

        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }

        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike != 0 && ball != 0 && strike != 3) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    // 중복 확인 (사용자 입력)
    private static boolean checkPlayList(List<Integer> playerList) {

        List<Integer> testList = new ArrayList<>();

        for(int ball : playerList) {
            if(testList.contains(ball)) {
                System.out.println("중복되지 않는 3자리 수를 입력해 주세요.");
                return false;
            }
            testList.add(ball);
        }
        return true;
    }

    private static List<Integer> getComList() {

        List<Integer> comList = new ArrayList<>();
        Random random = new Random();

        while(comList.size() < 3){

            int ball = random.nextInt(9) + 1;
            if(!comList.contains(ball)){
                comList.add(ball);
            }
        }
        return comList;
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 9) + 1;
    }
}



