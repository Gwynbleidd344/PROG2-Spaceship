import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SpaceShip {
    private int x;
    private int y;


    public void move(String direction, int gridSize) {
        switch (direction) {
            case "z": if (y > 0) y--; break;
            case "s": if (y < gridSize - 1) y++; break;
            case "q": if (x > 0) x--; break;
            case "d": if (x < gridSize - 1) x++; break;
            default: System.out.println("Mouvement invalide !");
        }
    }
}
