package org.jenkinsci.plugins.scrumwise;

import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * Created by rob on 10/4/14.
 */
public class ScrumwiseResults {
    private HashMap<String, JSONObject> personTable;
    private HashMap<String, JSONObject> backlogItemTable;
    private JSONObject currentSprint;

    public ScrumwiseResults(){
        personTable = new HashMap<String, JSONObject>();
        backlogItemTable = new HashMap<String, JSONObject>();
        currentSprint = null;
    }

    public HashMap<String, JSONObject> getPersonTable() {
        return personTable;
    }

    public void setPersonTable(HashMap<String, JSONObject> personTable) {
        this.personTable = personTable;
    }

    public HashMap<String, JSONObject> getBacklogItemTable() {
        return backlogItemTable;
    }

    public void setBacklogItemTable(HashMap<String, JSONObject> backlogItemTable) {
        this.backlogItemTable = backlogItemTable;
    }

    public JSONObject getCurrentSprint() {
        return currentSprint;
    }

    public void setCurrentSprint(JSONObject currentSprint) {
        this.currentSprint = currentSprint;
    }
}
