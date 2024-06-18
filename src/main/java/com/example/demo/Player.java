package com.example.demo;

import java.util.*;

public class Player {
    private Scanner scanner;
    public Player(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Integer> getNumbers() {
        while (true) {
            System.out.print("숫자를 입력해 주세요: ");
            String input = scanner.nextLine();

            if (input.length() != 3) {
                System.out.println("세자리 숫자를 입력해 주세요.");
                continue;
            }

            List<Integer> playerList = new ArrayList<>();
            for (char c : input.toCharArray()) {
                playerList.add(Character.getNumericValue(c));
            }

            if (isUniqueList(playerList)) {
                return playerList;
            }
        }
    }

    private boolean isUniqueList(List<Integer> playerList) {
        Set<Integer> set = new HashSet<>(playerList);
        if (set.size() != playerList.size()) {
            System.out.println("중복되지 않는 3자리 수를 입력해 주세요");
            return false;
        }
        return true;
    }
}