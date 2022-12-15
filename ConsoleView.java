package Sem3;

import Sem3.Units.*;
import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view(){
        if (step++ == 0) {
            System.out.println(AnsiColors.ANSI_RED+"First turn!"+AnsiColors.ANSI_RESET);
        } else {
            System.out.println(AnsiColors.ANSI_RED + "Turn: "+step+AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.GANG_SIZE-1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2D(i, j)));
            }
            System.out.println("|");
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2D(10, j)));
        }
        System.out.println("|");
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2D position){
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.greenTeam.get(i).getPosition().isEqual(position)) str ="|"+AnsiColors.ANSI_GREEN+Main.greenTeam.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
            if (Main.blueTeam.get(i).getPosition().isEqual(position)) str ="|"+AnsiColors.ANSI_BLUE+Main.blueTeam.get(i).getName().toUpperCase().charAt(0)+AnsiColors.ANSI_RESET;
        }
        return str;
    }
    private static String formatDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}