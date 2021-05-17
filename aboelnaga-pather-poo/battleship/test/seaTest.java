import pack1.*;
import pack1.util.*;
import org.junit.*;
import static org.junit.Assert.*;
public class seaTest{
    @Test
    public void checkSeaCreation(){
        Sea sea=new Sea(10,10);
        assertNotNull(sea);
    }
    @Test
    public void testAllCellsAreNotContainingShipsInCreation(){
      Sea sea=new Sea(5,5);
      for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
          Position p=new Position(j,i);
          assertEquals(sea.getCellAtPos(p).getShip(),null);
        }
      }
    }
    @Test
    public void checkShootWhenCellNotContainigShip(){
      Sea sea=new Sea(10,10);
      Position p=new Position(0,0);
      Answer ans=sea.shoot(p);
      assertSame(Answer.MISSED,ans);
    }
    @Test
    public void checkAnswerWhenACellIsAttackedTwice(){
      Sea sea=new Sea(10,10);
      Position p=new Position(0,0);
      Ship ship =new Ship(2,1);
      sea.addShipHorizontally(ship,p);
      Answer ans1=sea.shoot(p);
      assertSame(Answer.HIT,ans1);
      Answer ans2=sea.shoot(p);
      assertSame(Answer.MISSED,ans2);
    }
    @Test
    public void checkAnswerWhenShipSunk(){
      Sea sea=new Sea(10,10);
      Position p=new Position(0,0);
      Ship ship =new Ship(1,1);
      sea.addShipVertically(ship,p);
      Answer ans1=sea.shoot(p);
      assertSame(Answer.SUNK,ans1);
      Answer ans2=sea.shoot(p);
      assertSame(Answer.MISSED,ans2);
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetCellWithBadPosition(){
      Sea sea=new Sea(5,5);
      Position p=new Position(10,10);
      Cell cell =sea.getCellAtPos(p);
    }
    @Test
    public void testGetCellWithGoodPosition(){
      Sea sea=new Sea(5,5);
      Position p=new Position(2,3);
      Cell cell =sea.getCellAtPos(p);
      assertNotNull(cell);
      assertSame(cell,sea.getCellAtPos(p));
    }
    @Test
    public void checkAddingShipVertically(){
        Sea sea=new Sea(2,2);
        Position p=new Position(0,0);
        Cell cell =sea.getCellAtPos(p);
        Ship ship =new Ship(10,2);
        sea.addShipVertically(ship,p);
        Position p1=new Position(0,0);
        Position p2=new Position(0,1);
        Cell cell1=sea.getCellAtPos(p1);
        Cell cell2=sea.getCellAtPos(p2);
        assertSame(cell1.getShip(),cell2.getShip());
    }
    @Test (expected =IllegalStateException.class)
    public void testAddShipVerticallyWithBadPosition(){
      Sea sea=new Sea(2,2);
      Position p=new Position(10,10);
      Ship ship =new Ship(10,2);
      sea.addShipVertically(ship,p);
    }
    @Test (expected =IllegalStateException.class)
    public void testAddShipWithDimensionGreaterThanBoard(){
      Sea sea=new Sea(2,2);
      Position p=new Position(0,0);
      Ship ship =new Ship(10,3);
      sea.addShipVertically(ship,p);
      sea.addShipHorizontally(ship,p);
    }
    @Test (expected =IllegalStateException.class)
    public void testAddShipHorizontallyWithBadPosition(){
      Sea sea=new Sea(2,2);
      Position p=new Position(10,10);
      Ship ship =new Ship(10,2);
      sea.addShipHorizontally(ship,p);
    }
    @Test (expected =IllegalStateException.class)
    public void testAddShipInOccupiedPosition(){
      Sea sea=new Sea(2,2);
      Position p=new Position(0,0);
      Ship ship =new Ship(10,1);
      sea.addShipHorizontally(ship,p);
      Ship ship2=new Ship(5,1);
      sea.addShipVertically(ship2,p);
    }
    @Test
    public void checkAddingShipHorizontallyInSea(){
        Sea sea=new Sea(10,10);
        Position p=new Position(0,0);
        Cell cell =sea.getCellAtPos(p);
        Ship ship =new Ship(10,2);
        sea.addShipHorizontally(ship,p);
        Position p1=new Position(0,0);
        Position p2=new Position(1,0);
        Cell cell1=sea.getCellAtPos(p1);
        Cell cell2=sea.getCellAtPos(p2);
        assertSame(cell1.getShip(),cell2.getShip());
    }
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(seaTest.class);
        }

}
