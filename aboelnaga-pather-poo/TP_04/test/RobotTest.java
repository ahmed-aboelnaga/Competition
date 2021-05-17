import org.junit.*;
import static org.junit.Assert.*;

import example.Robot;
import example.util.*;

public class RobotTest {

    @Test
    public void testRobotTakeABox() {
        Robot robot = new Robot();
        Box box = new Box(10);
        Box box_2 = new Box(10);
        assertNull(robot.getCarriedBox());
        robot.take(box);
        assertEquals(box,robot.getCarriedBox());
        robot.take(box_2);
        assertNotSame(box_2, robot.getCarriedBox());
    }

    @Test
    public void testRobotCarryBox() {
        Robot robot = new Robot();
        Box box = new Box(10);
        assertFalse(robot.carryBox());
        robot.take(box);
        assertTrue(robot.carryBox());
    }

    @Test
    public void testRobotPutOn() {
        Robot robot = new Robot();
        Box box = new Box(10);
        Box heavy_box = new Box(100);
        ConveyerBelt belt = new ConveyerBelt(10);
        //Depôt réussi
        robot.take(box);
        assertEquals(box,robot.getCarriedBox()); // on vérifie tout de même que le robot porte bien la caisse
        assertEquals("ok",robot.putOn(belt));
        assertFalse(robot.carryBox()); // On vérifie qu'il ne porte plus la caisse
        // Robot sans box
        assertEquals("no box",robot.putOn(belt));
        // Box trop grosse
        Robot rob = new Robot();
        rob.take(heavy_box);
        assertEquals(heavy_box,rob.getCarriedBox());
        assertEquals("box too heavy",rob.putOn(belt));
        // Tapis roulant plein 
        robot.take(box);
        assertEquals("ok",robot.putOn(belt)); // On ajoute une nouvelle box sur le tapis pour atteindre sa capacité maximale qui est de 2 boxs
        assertFalse(robot.carryBox()); // On revérifie avant que le robot ne porte plus la caisse
        robot.take(box);
        assertEquals("belt full",robot.putOn(belt));
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(RobotTest.class);
        }
}