package mybatis.guest.service;

import java.util.*;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService {
	
	private static CommentService service;
	
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}
	

}