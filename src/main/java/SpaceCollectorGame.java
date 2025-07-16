import java.util.Scanner;

public class SpaceCollectorGame {
    private static final int gridSize = 5;
    private static final int maxMoves = 20;
    private static final int fixedDebris = 6;

    private int score = 0;
    private int movesLeft = maxMoves;
    private SpaceShip ship;
    private SpaceGrid grid;

    public SpaceCollectorGame() {
        ship = new SpaceShip(0, 0);
        grid = new SpaceGrid(gridSize, fixedDebris, ship);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===  Vaisseau Collecteur de Débris ===");
        System.out.println("Commandes : z (haut), s (bas), q (gauche), d (droite)");
        System.out.println("Collectez les " + fixedDebris + " débris en " + maxMoves + " mouvements.\n");

        while (movesLeft > 0 && !grid.allDebrisCollected()) {
            grid.printGrid();
            System.out.println("Score : " + score + " | Mouvements restants : " + movesLeft);
            System.out.print("Déplacer le vaisseau (z/q/s/d) : ");
            String input = scanner.nextLine().toLowerCase();

            if (input.matches("[zqsd]")) {
                ship.move(input, gridSize);
                if (grid.collectDebrisAt(ship.getX(), ship.getY())) {
                    score++;
                }
                grid.updateShipPosition(ship);
                movesLeft--;
            } else {
                System.out.println(" Commande invalide !");
            }
        }

        endGame();
        scanner.close();
    }

    private void endGame() {
        grid.printGrid();
        if (grid.allDebrisCollected()) {
            System.out.println("Bravo ! Tous les débris ont été collectés !");
            System.out.println(" Score final : " + score);
        } else {
            System.out.println(" Game Over !");
            System.out.println("Débris restants : " + (fixedDebris - score));
            System.out.println("Score final : " + score);
        }
    }
}
