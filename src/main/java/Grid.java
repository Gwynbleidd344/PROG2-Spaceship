public class Grid {
    int gridSize;
    char[][] grid;
    char EMPTY = '.';
    char DEBRIS = 'J';
    char SHIP = 'S';
    int debrisRemaining;

    public SpaceGrid(int size, int debrisRemaining, SpaceShip ship) {
        this.gridSize = size;
        this.debrisRemaining = debrisRemaining;
        this.grid = new char[size][size];
    }

    public void initializeGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = EMPTY;
            }
        }
        Random random = new Random();
        int placeDebris = 0;
    }
}
