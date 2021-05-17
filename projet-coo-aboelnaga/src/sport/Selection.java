package sport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import util.MapUtil;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public abstract class Selection {
	/**
	 * selects Challengers from competitions
	 * @param groups List of Competitions to select players from
	 * @return List of players chosen
	 */
	public  abstract List <? extends Challenger > selectFrom(List <? extends CompetitionInfo> groups) ;
	
	/**
	 * allows to have the list of players in the map in the same order
	 * @param map a linkedHashMap where players have to be extracted 
	 * @return List of Challengers present in the map
	 */
	protected   List<  Challenger> mapLSorted (Map<? extends  Challenger, Integer> map) {
		return new ArrayList<>(map.keySet());
	}
	/**
	 * allows to choose best players at a specific rank from all competitions  
	 * @param groups List of competitions to choose from
	 * @param nb numbers of players to select from all the best
	 * @param pos rank of players ( zero indexed)
	 * @throws NullPointerException if the rank is greater than the number of players in any competition or if nb is greater than the size of groups
	 * @return List of Challengers selected for groups have a rank pos
	 */
	protected List < Challenger> bestFrom(List <? extends CompetitionInfo> groups,int nb,int pos) throws IndexOutOfBoundsException{
		List < Challenger> selected =new ArrayList<>();
			Map<Challenger, Integer> best = new LinkedHashMap<>();
			for (CompetitionInfo comp :groups) {
				Challenger player=this.mapLSorted(comp.ranking()).get(pos);  // Exception if pos > 
				best.put(player,player.getPoints());
			}
			
			best=MapUtil.sortByDescendingValue(best);
			
			selected= this.mapLSorted(best);
			return selected.subList(0,nb); // Exception if nb > 

			
	}
	/**
	 * allows to choose all players at rank pos from all groups
	 * @param groups  groups to choose from
	 * @param pos rank of players to be choosen must be less than the size of a single group (zero indexed)
	 * @return List of Challengers selected for groups have a rank pos
	 * @throws NullPointerException List of Challengers selected for groups have a rank pos
	 */
	protected List <  Challenger> iFromAll(List <? extends CompetitionInfo> groups,int pos)throws IndexOutOfBoundsException{
		List < Challenger> selected =new ArrayList<>();
		for (CompetitionInfo comp :groups) selected.add(this.mapLSorted(comp.ranking()).get(pos));  //Exception if pos > 
		return selected;
	}
}
