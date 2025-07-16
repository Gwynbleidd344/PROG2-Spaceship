import java.util.Random;

public class SpaceGrid {
    private final int size;
    private final char[][] grid;
    private final char EMPTY = '.';
    private final char DEBRIS = 'J';
    private final char SHIP = 'S';
    private int debrisRemaining;

    public SpaceGrid(int size, int debrisCount, SpaceShip ship) {
        this.size = size;
        this.debrisRemaining = debrisCount;
        this.grid = new char[size][size];
        initializeGrid(debrisCount, ship);
    }

    private void initializeGrid(int debrisCount, SpaceShip ship) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = EMPTY;
            }
        }

        Random random = new Random();
        int placedDebris = 0;
        while (placedDebris < debrisCount) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (grid[y][x] == EMPTY && !(x == ship.getX() && y == ship.getY())) {
                grid[y][x] = DEBRIS;
                placedDebris++;
            }
        }

        updateShipPosition(ship);
    }

    public void updateShipPosition(SpaceShip ship) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == SHIP) {
                    grid[i][j] = EMPTY;
                }
            }
        }
        grid[ship.getY()][ship.getX()] = SHIP;
    }

    public boolean collectDebrisAt(int x, int y) {
        if (grid[y][x] == DEBRIS) {
            debrisRemaining--;
            System.out.println(" Débris collecté !");
            return true;
        }
        return false;
    }

    public boolean allDebrisCollected() {
        return debrisRemaining == 0;
    }

    public void printGrid() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
