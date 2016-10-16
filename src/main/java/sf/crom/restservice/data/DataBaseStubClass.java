package sf.crom.restservice.data;

import java.util.HashMap;
import java.util.Map;

import sf.crom.restservice.model.Messege;
import sf.crom.restservice.model.Profile;



public class DataBaseStubClass {
	
	private static Map<Long,Messege> messegesMap=new HashMap<>();
	private static Map<String,Profile> profilesMap=new HashMap<>();
	
	public static Map<Long,Messege> getMesseges(){
		return messegesMap;
	}
	
	public static Map<String,Profile> getProfiles(){
		return profilesMap;
	}

}
