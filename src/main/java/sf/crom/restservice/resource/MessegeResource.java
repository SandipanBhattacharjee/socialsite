package sf.crom.restservice.resource;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import sf.crom.restservice.bean.MessageParamBean;
import sf.crom.restservice.model.Messege;
import sf.crom.restservice.service.MessegeService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/messeges")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessegeResource{

	MessegeService messegeService=new MessegeService();

	/*------------------------------------------
	 * 1. http://localhost:8080/socialsite/webapi/messeges/1  --> individual messeges
	 * 2. http://localhost:8080/socialsite/webapi/messeges?year=2016 --> messeges for a year.
	 *    GET: http://localhost:8080/socialsite/webapi/messeges?start=2&size=1  --> filtering
	 * 3. POST
	 *     Content-Type  application/json
	 *     {
    			"author": "Sandy",
    			"createdDate": "2016-10-13T13:33:00.626-05:00",
    			"messege": "This is Sandy again1"
			}
	 *   4. PUT same as above change the messege.
	 *   5. DELETE: 1
	 */
	
	// using beans class using annotations
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messege> getJSONMessege(@BeanParam MessageParamBean bean){

		int year=bean.getYear();
		int start=bean.getStart();
		int size=bean.getSize();
		if(year>0){
			return messegeService.getAllMessegesForAYear(year);
		}else if(start>=0 && size>0){
			return messegeService.getAllMessegePaginated(start, size);
		}
			return messegeService.getAllMesseges();
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	//Application  text/xml
	public List<Messege> getXMLMessege(@BeanParam MessageParamBean bean){

		int year=bean.getYear();
		int start=bean.getStart();
		int size=bean.getSize();
		if(year>0){
			return messegeService.getAllMessegesForAYear(year);
		}else if(start>=0 && size>0){
			return messegeService.getAllMessegePaginated(start, size);
		}
			return messegeService.getAllMesseges();
	}

	@GET
	@Path("/{messegeId}")
	public Messege getMessegeUsingId(@PathParam("messegeId") long messegeId,@Context UriInfo uriInfo){
		Messege messege=messegeService.getMessegeUsingId(messegeId);
		//return messege; // after this comes the HATEOS implementation
		String selfUrl=uriInfo.getAbsolutePathBuilder().build().toString();
//		String url=uriInfo.getBaseUriBuilder()
//				.path(MessegeResource.class)
//				.path(String.valueOf(messege.getId()))
//				.build().toString();
		String profileUrl=uriInfo.getBaseUriBuilder()
				.path(ProfileResources.class)
				.path(messege.getAuthor())
				.toString();
		
		
		messege.addLink(selfUrl, "self");
		messege.addLink(profileUrl, "profile");
		
		
		return messege;
	}


	@POST
	public Response postMessege(Messege messege, @Context UriInfo uriInfo){
		Messege newMessege=messegeService.addMessege(messege);
		URI newUri=uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessege.getId())).build();
		//status(Status.CREATED) //201
		return Response.created(newUri)				
				.entity(newMessege)
				.build();
		
	}
	
	@PUT
	@Path("/{messegeId}")
	public Messege putMessege(@PathParam("messegeId") long id,Messege messege){
		messege.setId(id);
		return messegeService.updateMessege(messege);
	}

	@DELETE
	@Path("/{messegeId}")
	public void deleteMessege(@PathParam("messegeId") long id){
		messegeService.removeMessegeUsingId(id);
	}
	
	@GET
	@Path("/{messegeId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
	
	
	//--------------------------------- Uncomment for various other functions -----------
	
	
	

	
//	@GET
	//	@Produces(MediaType.TEXT_PLAIN) Application_xml
	//	public String getMessege(){
	//		return messegeService.getAllMesseges().get(0).getMessege();
	//	}

	     // usage of query param
//	@GET
//	public List<Messege> getMessege(@QueryParam(value = "year") int year,
//			@QueryParam(value = "start") int start,
//			@QueryParam(value = "size") int size){
//		System.out.println("inside method");
//		if(year>0){
//			return messegeService.getAllMessegesForAYear(year);
//		}else if(start>=0 && size>=0){
//			return messegeService.getAllMessegePaginated(start, size);
//		}else{
//			System.out.println("all messeges");
//			return messegeService.getAllMesseges();
//		}
//	}
	
//  /**
//  * This method will get all messeges if uncommented.
//  * @return
//  */
//	
//	@GET
//	public List<Messege> getAllMessege(){
//		return messegeService.getAllMesseges();
//	}
//	
	// this method shows response builder
	
//		@POST
//		public Response addMessege(Messege messege){
//			Messege newMessege=messegeService.addMessege(messege);
//			return Response.status(Status.CREATED)
//					.entity(newMessege)
//					.build();
//		}
		
//	@POST
//	public Messege postMessege(Messege messege){
//		return messegeService.addMessege(messege);
//	}
		
}
