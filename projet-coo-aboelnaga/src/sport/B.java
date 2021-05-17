package sport;

import java.util.ArrayList;
import java.util.List;

public class B extends Selection{

	@Override
	public List<? extends Challenger> selectFrom(List<? extends CompetitionInfo> groups) {
		List <Challenger> selected=new ArrayList<>();
		selected.addAll(this.iFromAll(groups, 0));
		selected.addAll(this.iFromAll(groups, 1));
		selected.addAll(this.bestFrom(groups, 2, 2));
		return selected;
	}



}
