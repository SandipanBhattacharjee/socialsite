package sf.crom.restservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sf.crom.restservice.data.DataBaseStubClass;
import sf.crom.restservice.model.Profile;



public class ProfileService {
	private Map<String, Profile> profiles=DataBaseStubClass.getProfiles();

		public ProfileService(){
			profiles.put("Sandy", new Profile(1L,"Sandy","Sandipan","Bhattacharjee"));
			profiles.put("Naru", new Profile(2L,"Naru","Narayan","Bhattacharjee"));
			profiles.put("Ruch", new Profile(3L,"Ruch","Ruchi","Shivhare"));
			profiles.put("JP", new Profile(4L,"JP","Jagadeesh","Shivhare"));
		}


	public List<Profile> getAllProfiles(){
		System.out.println("+++++++++++++++++++"+profiles.get("Sandy").getId());
		return new ArrayList<Profile>(profiles.values());
	}


	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		System.out.println("+++++++++++++"+profile.getId());
		profiles.put(profile.getProfileName(),profile);
		System.out.println(profiles);
		return profile;
	}

	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public void removeProfileUsingProfileName(String profileName){
		profiles.remove(profileName);

	}


}
