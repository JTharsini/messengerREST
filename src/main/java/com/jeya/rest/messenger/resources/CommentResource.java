package com.jeya.rest.messenger.resources;

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

import com.jeya.rest.messenger.model.Comment;
import com.jeya.rest.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService commentService = new CommentService();
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId)
	{
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId)
	{
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(Comment comment,
			@PathParam("messageId") long messageId)// parent's path param can be accessible from child
	{
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId, Comment comment)
	{
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteMessage(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId)
	{
		return commentService.deleteComment(messageId, commentId);
	}
}
