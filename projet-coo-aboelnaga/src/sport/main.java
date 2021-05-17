package sport;

import java.util.*;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public class main {

	public static void main(String[] args) {
            Scanner choice = new Scanner(System.in);
			System.out.println("Enter 0 or 1\n1 : starts a League\n0 : starts a Tournament");
			int des = choice.nextInt();
		    List <Competitor> comps=new ArrayList<>(8);
			comps.add(new Competitor("Bayern"));
			comps.add(new Competitor("Realmadrid"));
			comps.add(new Competitor("ManU"));
			comps.add(new Competitor("Chelsea"));
			comps.add(new Competitor("Ajax"));
			comps.add(new Competitor("Spurs"));
			comps.add(new Competitor("juventos"));
			comps.add(new Competitor("Inter"));
			Competition comp;
			if (des==1)comp=new LeagueCompetition(comps,new LeagueMatch(1,0,0));
			else comp=new KnockoutStage(comps,new LeagueMatch());
			comp.setDisplayer(new StdDisplayer());
			comp.addLooker(new Reporter("Bob"));
			comp.addLooker(new Reporter("Alice"));
			comp.addLooker(new Bookmaker());
			comp.play();
	}

}
