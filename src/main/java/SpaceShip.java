import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpaceShip {
    private int x;
    private int y;


    public void move(String direction, int gridSize) {
        switch (direction) {
            case "H": if (y > 0) y--; break;
            case "B": if (y < gridSize - 1) y++; break;
            case "G": if (x > 0) x--; break;
            case "D": if (x < gridSize - 1) x++; break;
            default: System.out.println("Mouvement invalide !");
        }
    }
}
