import pack1.*;
import pack1.util.*;
public class battleMain{
    public static void main(String[] args){
        Sea sea=new Sea(10,10);
        Ship[] ships=new Ship[3];
        for (int i=0;i<3;i++){
            ships[i]=new Ship(3,2);
        }
        Position p0=new Position(0,0);
        sea.addShipVertically(ships[0], p0);
        Position p1=new Position(0,2);
        sea.addShipHorizontally(ships[1], p1);
        Position p2=new Position(3,6);
        sea.addShipVertically(ships[2], p2);
        Game game=new Game(sea);
        game.shoot();
    }
}
