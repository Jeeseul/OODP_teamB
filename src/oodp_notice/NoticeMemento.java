package oodp_notice;

import java.util.ArrayList;
import java.util.TreeMap;

public class NoticeMemento {
    private TreeMap<String, Notice> restoreOfTeams;
    private String restoreOfTeamName;

    NoticeMemento(TreeMap<String, Notice> state, String teamName) {
    	this.restoreOfTeams = state;
        this.restoreOfTeamName = teamName;
    }

	public TreeMap<String, Notice> getStateMap() {
		TreeMap<String, Notice> stateOfTeams = new TreeMap<String, Notice>();
		Notice temp = new Notice();
		String stateOfName = new String(restoreOfTeamName);
		ArrayList<String> copyingForMem = restoreOfTeams.get(stateOfName).getteamNotices();
		
		for(String t: copyingForMem)
				temp.addNotice(t);
		stateOfTeams.put(stateOfName, temp);

        return stateOfTeams;
    }
//
//    public void setStateMap(TreeMap<String, Notice> snapshot) {
//        this.state = snapshot;
//    }

    public String getTeamName() {
    	String restoreState = new String(restoreOfTeamName);
        return restoreState;
    }

//    public void setTeamName(String teamName) {
//        this.teamName = teamName;
//    }
//

}
