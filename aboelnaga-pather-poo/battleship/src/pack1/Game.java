package pack1;
import pack1.util.*;
import io.*;
public class Game{
    private Sea sea;
    public Game(Sea sea){
        this.sea=sea;
    }
    public Answer shoot(){
        while (sea.getLifePoints()>0){
            int ligne;
            int colone;
            try{
		sea.display(true);
                System.out.print(" enter ligne coordinate : ");
                ligne = Input.readInt();
                System.out.print(" enter colone coordinate : ");
                colone = Input.readInt();
                Position p=new Position(colone,ligne);
                Cell cell=this.sea.getCellAtPos(p);
                Answer ans=cell.hit();
                sea.display(true);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println("invalide ligne or colone index");
                return this.shoot();
        }
    }
    return Answer.MISSED;   
}
}
