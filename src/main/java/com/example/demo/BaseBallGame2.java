package com.example.demo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame2 {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;
    private static final SecureRandom random = new SecureRandom();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Car> cars = inputCarNames();
        int rounds = inputRounds();

        runRace(cars, rounds);
        announceWinners(cars);

    }

    private static void announceWinners(List<Car> cars) {
        int maxStep = cars.stream().mapToInt(Car::getStep).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for(Car car : cars){
            if(car.getStep() == maxStep) {
                winners.add(car.getCarName());
            }
        }
        System.out.println(String.join(", ", winners) + " 가 우승하였습니다.");
    }

    private static int inputRounds() {
        System.out.println("시도할 횟수는 몇회인가요?");
        while (true) {
            try {
                int rounds = Integer.parseInt(scanner.nextLine().trim());
                if (rounds > 0) {
                    return rounds;
                } else {
                    System.out.println("시도할 횟수는 1번 이상이여야 합니다. 다시 입력해 주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력해 주세요.");
            }
        }
    }

    private static List<Car> inputCarNames() {
        List<Car> cars = new ArrayList<>();
        while(true){
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = scanner.nextLine();
            String[] names = input.split(",");

            if(areValidNames(names)) {
                for(String name : names) {
                    cars.add(new Car(name.trim()));
                }
                break;
            } else {
                System.out.println("자동차 이름은 5글자 이하로 입력해 주세요.");
            }
        }
        return cars;
    }

    private static boolean areValidNames(String[] names) {
        for(String name : names) {
            if (name.trim().length() > 5) {
                return false;
            }
        }
        return true;
    }

    private static void runRace(List<Car> cars, int rounds) {
        System.out.println("\n실행 결과");
        printInitialPositions(cars);
        for(int i = 0; i < rounds; i ++) {
            moveCars(cars);
            printPositions(cars);
        }
    }

    private static void printInitialPositions(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private static void moveCars(List<Car> cars) {
        for(Car car : cars) {
            if(shouldMove()) {
                car.moveForward();
            }
        }
    }

    private static void printPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private static boolean shouldMove(){
        return random.nextInt(RANDOM_BOUND) >= MOVE_THRESHOLD;
    }
}
