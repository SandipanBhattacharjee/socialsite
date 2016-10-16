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


import sf.crom.restservice.model.Comment;
import sf.crom.restservice.service.CommentService;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	 private CommentService commentService =new CommentService();
	 
	
	
	@GET
	public List<Comment> getAllComments(@PathParam("messegeId") long messegeId){
	 return commentService.getAllComments(messegeId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getMessege(@PathParam("messegeId") long messegeId, @PathParam("commentId") long commentId){
		return commentService.getComment(messegeId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messegeId") long messegeId, Comment comment){
		System.out.println(messegeId+"  "+comment.getAuthor()+"  "+comment.getMessage());
		return commentService.addComment(messegeId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateCommentId(@PathParam("messegeId") long messegeId, 
			 @PathParam("commentId") long commentId, Comment comment){
		comment.setId(commentId);
		return commentService.updateComment(messegeId, comment);
	}
	
	@DELETE
	@Path("{/commentId}")
	public void deleteComment(@PathParam("messegeId") long messegeId, @PathParam("commentId") long commentId){
		commentService.removeComment(messegeId, commentId);
	}
	
	
	
}
