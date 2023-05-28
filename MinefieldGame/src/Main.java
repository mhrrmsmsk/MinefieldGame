import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Minefield Game...");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Chose the row size :");
        int row=scanner.nextInt();
        System.out.print("Chose the column size :");
        int column=scanner.nextInt();

        Game game=new Game(row,column);
game.run();
    }
}