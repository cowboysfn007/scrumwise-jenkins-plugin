package org.jenkinsci.plugins.scrumwise;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

import java.util.HashMap;

/**
 * Created by rob on 10/3/14.
 */
public class ScrumwiseConverter {

    public ScrumwiseConverter(){

    }

    public ScrumwiseResults convert(JSONObject jsonObject){

        ScrumwiseResults results = new ScrumwiseResults();
        HashMap<String, JSONObject> personTable = new HashMap<String, JSONObject>();
        HashMap<String, JSONObject> backlogItemTable = new HashMap<String, JSONObject>();
        JSONObject currentSprint = null;

        //Create a hashmap of the people objects for referencing later
        JSONArray people = jsonObject.getJSONObject("result").getJSONArray("persons");
        for(int i = 0; i < people.size(); i++){
            personTable.put(people.getJSONObject(i).getString("id"), people.getJSONObject(i));
        }

        //Loop through all projects, should only have one
        JSONArray projects = jsonObject.getJSONObject("result").getJSONArray("projects");
        for(int i = 0; i < projects.size(); i++){

            //Create a hashmap of the backlog items for referencing later
            JSONArray backlogItems = projects.getJSONObject(i).getJSONArray("backlogItems");
            for(int j = 0; j < backlogItems.size(); j++){
                backlogItemTable.put(backlogItems.getJSONObject(j).getString("id"), backlogItems.getJSONObject(j));
            }

            //Get the current sprint
            JSONArray sprints = projects.getJSONObject(i).getJSONArray("sprints");
            for(int j = 0; j < sprints.size(); j++){
                if("In progress".equals(sprints.getJSONObject(j).getString("status"))){
                    currentSprint = sprints.getJSONObject(j);
                }
            }
        }

        /*
        for(String key:backlogItemTable.keySet()){
            listener.getLogger().println(backlogItemTable.get(key).getString("name"));
        }
        */

        results.setPersonTable(personTable);
        results.setCurrentSprint(currentSprint);
        results.setBacklogItemTable(backlogItemTable);
        return results;
    }
}
