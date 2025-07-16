import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceShipTest {

    @Test
    void testMoveUpWithinBounds() {
        SpaceShip ship = new SpaceShip(2, 2);
        ship.move("z", 5);
        assertEquals(1, ship.getY(), "Le vaisseau devrait monter de 1 case.");
    }

    @Test
    void testMoveDownWithinBounds() {
        SpaceShip ship = new SpaceShip(2, 2);
        ship.move("s", 5);
        assertEquals(3, ship.getY(), "Le vaisseau devrait descendre de 1 case.");
    }

    @Test
    void testMoveLeftWithinBounds() {
        SpaceShip ship = new SpaceShip(2, 2);
        ship.move("q", 5);
        assertEquals(1, ship.getX(), "Le vaisseau devrait aller à gauche de 1 case.");
    }

    @Test
    void testMoveRightWithinBounds() {
        SpaceShip ship = new SpaceShip(2, 2);
        ship.move("d", 5);
        assertEquals(3, ship.getX(), "Le vaisseau devrait aller à droite de 1 case.");
    }

    @Test
    void testMoveDoesNotExitGridTopLeft() {
        SpaceShip ship = new SpaceShip(0, 0);
        ship.move("z", 5);
        ship.move("q", 5);
        assertEquals(0, ship.getX(), "Le vaisseau ne devrait pas sortir par la gauche.");
        assertEquals(0, ship.getY(), "Le vaisseau ne devrait pas sortir par le haut.");
    }

    @Test
    void testMoveDoesNotExitGridBottomRight() {
        SpaceShip ship = new SpaceShip(4, 4);
        ship.move("s", 5);
        ship.move("d", 5);
        assertEquals(4, ship.getX(), "Le vaisseau ne devrait pas sortir par la droite.");
        assertEquals(4, ship.getY(), "Le vaisseau ne devrait pas sortir par le bas.");
    }

    @Test
    void testInvalidMoveCommand() {
        SpaceShip ship = new SpaceShip(2, 2);
        ship.move("x", 5);
        assertEquals(2, ship.getX(), "Le vaisseau ne doit pas bouger.");
        assertEquals(2, ship.getY(), "Le vaisseau ne doit pas bouger.");
    }
}