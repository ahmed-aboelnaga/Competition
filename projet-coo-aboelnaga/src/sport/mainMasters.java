package sport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainMasters {
	public static void main(String[] args) {
		Scanner choice = new Scanner(System.in);
		List < Competitor> comps=new ArrayList<>();
		comps.add(new Competitor("Barca"));
		comps.add(new Competitor("Realmadrid"));
		comps.add(new Competitor("ManU"));
		comps.add(new Competitor("Chelsea"));
		comps.add(new Competitor("Ajax"));
		comps.add(new Competitor("Spurs"));
		comps.add(new Competitor("juventos"));
		comps.add(new Competitor("Inter"));
		comps.add(new Competitor ("Milan"));
		comps.add(new Competitor ("Roma"));
		comps.add(new Competitor ("Porto"));
		comps.add(new Competitor ("Arsenal"));
		List <Competitor> comp=comps;
		Selection method = new A();
		Selection method2 = new B();
		System.out.println("\nChampions League with 12 participants distributed in 4 groups of 3\nfirst one of each group is selected to knockout\n");
		Masters m = new Masters(comps,4,new LeagueMatch(1,0,0),new LeagueMatch(),method);
		m.setDisplayer(new StdDisplayer());
		m.addLooker(new Reporter ("Sarah"));
		m.addLooker(new Bookmaker());
		m.play();
		for (Competitor c :comps)c.resetPoints();
		System.out.println("press Enter to see a different selection");
		String des = choice.nextLine();
		if (des.isEmpty()) {
			System.out.println("Champions League with 12 participants distributed in 3 groups of 4\n"
					+ "first two of each group is selected to knockout and 2 of best thirds\n");
			 m = new Masters(comp,3,new LeagueMatch(1,0,0),new LeagueMatch(),method2);
			m.setDisplayer(new StdDisplayer());
			 m.addLooker(new Reporter ("Sarah"));
			 m.addLooker(new Bookmaker());
			m.play();
		}else System.out.println("Bad Choice rerun it ");

	}

}
