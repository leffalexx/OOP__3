package Sem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Sem3.Units.*;

public class Main {
    public static final int GANG_SIZE = 10;
    public static List<BaseHero> blueTeam;
    public static List<BaseHero> greenTeam;
    public static void main(String[] args) {
        init();

        Scanner scanner = new Scanner(System.in);

        while (true){
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
        }
        
    }
    private static void init(){
        blueTeam = new ArrayList<>();
        greenTeam = new ArrayList<>();

        int x=1;
        int y=1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)){
                case 0: blueTeam.add(new Peasant(blueTeam, x++, y)); break;
                case 1: blueTeam.add(new Rogue(blueTeam, x++, y)); break;
                case 2: blueTeam.add(new Sharpshooter(blueTeam, x++, y)); break;
                default: blueTeam.add(new Enchanter(blueTeam, x++, y));
            }
        }

        x=1;
        y=10;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)){
                case 0: greenTeam.add(new Peasant(greenTeam, x++, y)); break;
                case 1: greenTeam.add(new Pikeman(greenTeam, x++, y)); break;
                case 2: greenTeam.add(new Archer(greenTeam, x++, y)); break;
                default: greenTeam.add(new Monk(greenTeam, x++, y));
            }
        }
    }
}