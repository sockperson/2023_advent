package questions;

import java.util.Arrays;

public class q2 {

    private static final int RED_MAX = 12;
    private static final int GREEN_MAX = 13;
    private static final int BLUE_MAX = 14;

    private static int parseGame(String line) {
        int gameNum = Integer.parseInt(line.split(":")[0].split(" ")[1]);
        String[] subGames = line.split(":")[1].split(";");
        for (String subGame : subGames) {
            String[] valueColorPairs = subGame.split(",");
            for (String valueColorPair : valueColorPairs) {
                String[] valueColorPairSplit = valueColorPair.split(" ");
                int value = Integer.parseInt(valueColorPairSplit[1]);
                String color = valueColorPairSplit[2];
                switch (color) {
                    case "red" -> {
                        if (value > RED_MAX) {
                            return 0;
                        }
                    }
                    case "green" -> {
                        if (value > GREEN_MAX) {
                            return 0;
                        }
                    }
                    case "blue" -> {
                        if (value > BLUE_MAX) {
                            return 0;
                        }
                    }
                }
            }
        }
        return gameNum;
    }

    private static int parseGameP2(String line) {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;

        int gameNum = Integer.parseInt(line.split(":")[0].split(" ")[1]);
        String[] subGames = line.split(":")[1].split(";");
        for (String subGame : subGames) {
            String[] valueColorPairs = subGame.split(",");
            for (String valueColorPair : valueColorPairs) {
                String[] valueColorPairSplit = valueColorPair.split(" ");
                int value = Integer.parseInt(valueColorPairSplit[1]);
                String color = valueColorPairSplit[2];
                switch (color) {
                    case "red" -> maxRed = Math.max(maxRed, value);
                    case "green" -> maxGreen = Math.max(maxGreen, value);
                    case "blue" -> maxBlue = Math.max(maxBlue, value);
                }
            }
        }
        return maxRed * maxGreen * maxBlue;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader("input", "2");

        int sum = 0;
        String line = in.nextLine();
        while (line != null) {
            sum += parseGame(line);
            line = in.nextLine();
        }
        System.out.println(sum);

        in = new InputReader("input", "2");

        sum = 0;
        line = in.nextLine();
        while (line != null) {
            sum += parseGameP2(line);
            line = in.nextLine();
        }
        System.out.println(sum);
    }

}
