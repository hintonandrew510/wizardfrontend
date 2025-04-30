package web.page.clientobjectivesonepage;

import java.util.Comparator;

public class ClientObjectivesSortOrder implements Comparator<ClientObjectivesOnePageTwoModel> {
	// Used for sorting in ascending order of
	// roll number
	public int compare(ClientObjectivesOnePageTwoModel a, ClientObjectivesOnePageTwoModel b) {
		return a.getSortOrder() - b.getSortOrder();
	}
}
