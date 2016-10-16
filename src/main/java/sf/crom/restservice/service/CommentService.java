package sf.crom.restservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sf.crom.restservice.data.DataBaseStubClass;
import sf.crom.restservice.model.Comment;
import sf.crom.restservice.model.Messege;



public class CommentService {

	 private Map<Long, Messege> messegeMap=DataBaseStubClass.getMesseges();
	
	 public List<Comment> getAllComments(long messegeId){
		 Map<Long, Comment> commentMap=messegeMap.get(messegeId).getCommentMap();
		 return new ArrayList<Comment>(commentMap.values());
	 }
	 
	 public Comment getComment(long messegeId,long commentId){
		 Map<Long,Comment> commentsMap=messegeMap.get(messegeId).getCommentMap();
		 return commentsMap.get(commentId);
	 }
	 
	 public Comment addComment(long messegeId,Comment comment){
		 Map<Long,Comment> commentMap=messegeMap.get(messegeId).getCommentMap();
		 comment.setId(commentMap.size()+1);
		 commentMap.put(comment.getId(), comment);
		 return comment;
	 }
	 
	 public Comment updateComment(long messegeId,Comment comment){
		 Map<Long,Comment> commentMap=messegeMap.get(messegeId).getCommentMap();
		 if(comment.getId()<=0){
			 return null;
		 }
		 commentMap.put(comment.getId(), comment);
		 return comment;
	 }
	 
	 public Comment removeComment(long messegeId,long commentId){
		Map<Long,Comment> commentMap=messegeMap.get(messegeId).getCommentMap();
		return commentMap.remove(commentId);
	 }
	 
}
