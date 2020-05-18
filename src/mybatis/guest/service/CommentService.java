package mybatis.guest.service;

import java.util.*; 

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService {
	
	private static CommentService service;
	private CommentRepository repo = new CommentRepository();
	
	private CommentService(){}
	
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	
	public List<Comment> selectComment() {
		return repo.selectComment();
	}
	public int insertComment(Comment comment) {
		return repo.insertComment(comment);
	}
	
	public Comment selectCommentByPrimaryKey(int primaryNo) {
		return repo.selectCommentByPrimaryKey(primaryNo);
	}
	
	public int deleteCommentByNo(int primaryNo) {
		return repo.deleteCommentByNo(primaryNo);
	}
	
	public int updateComment(Comment comment) {
		return repo.updateComment(comment);
	}
}