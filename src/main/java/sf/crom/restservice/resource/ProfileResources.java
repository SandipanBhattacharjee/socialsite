package sf.crom.restservice.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sf.crom.restservice.model.Profile;
import sf.crom.restservice.service.ProfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResources {
	/**
	 * GET: http://localhost:8080/socialsite/webapi/profiles  --> all
	 * GET: http://localhost:8080/socialsite/webapi/profiles/Sandy --> specific
	 * POST: http://localhost:8080/socialsite/webapi/profiles/
	 * {"firstName": "Sandipan",
    	"lastName": "Bhattacharjee",
    	"profileName": "Sandy1"
		}
		PUT: http://localhost:8080/socialsite/webapi/profiles/JP
		{
    		"createdDate": "2016-10-15T09:00:36.303-05:00",
    		"firstName": "Jagadeesh Prasad",
    		"id": 4,
    		"lastName": "Shivhare",
    		"profileName": "JP"
		}
		
		DELETE: http://localhost:8080/socialsite/webapi/profiles/Sandy1
	 */
	
	
	
	
	
	private ProfileService profileService=new ProfileService();
	

	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfileUsingId(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile postProfile(Profile profile){
	    return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile putProfile(@PathParam("profileName") String profileName ,Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName){
		profileService.removeProfileUsingProfileName(profileName);
	}
}
