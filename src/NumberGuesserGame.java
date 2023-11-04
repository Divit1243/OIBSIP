package MyProjectPackage;
import java.util.Scanner;

class Guesser {
    int Guesser_num;

    public int takeNumberGuesser(Scanner sc) {
        System.out.println("Guesser guess a number");
        Guesser_num = sc.nextInt();
        return Guesser_num;
    }
}

class Player {
    int Player_num;

    public int takeNumberPlayer(Scanner sc) {
        System.out.println("Player guess a number");
        Player_num = sc.nextInt();
        return Player_num;
    }
}

class Umpire {
    int numfromGuesser;
    int[] numfromPlayers;

    Umpire() {
        numfromPlayers = new int[3];
    }

    void collectfromGuesser(Scanner sc) {
        Guesser g = new Guesser();
        numfromGuesser = g.takeNumberGuesser(sc);
    }

    void collectfromPlayers(Scanner sc) {
        Player[] players = new Player[3];
        for (int i = 0; i < 3; i++) {
            players[i] = new Player();
            numfromPlayers[i] = players[i].takeNumberPlayer(sc);
        }
    }

    void compare() {
        int numWinners = 0;
        for (int i = 0; i < 3; i++) {
            if (numfromPlayers[i] == numfromGuesser) {
                numWinners++;
            }
        }

        if (numWinners == 3) {
            System.out.println("All Players won the game");
        } else if (numWinners == 2) {
            System.out.println("Only " + numWinners + " Players won the game");
        } else if (numWinners == 1) {
            System.out.println("Only Player" + (findWinner() + 1) + " won the game");
        } else {
            System.out.println("No Player won the game");
        }
    }

    int findWinner() {
        for (int i = 0; i < 3; i++) {
            if (numfromPlayers[i] == numfromGuesser) {
                return i;
            }
        }
        return -1;
    }
}

public class NumberGuesserGame {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (Scanner sc = new Scanner(System.in)) {
            Umpire U = new Umpire();
            U.collectfromGuesser(sc);
            U.collectfromPlayers(sc);
            U.compare();
        }
    }
}




