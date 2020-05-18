package mybatis.guest.session;

import java.io.*;
import java.util.*;

import mybatis.guest.model.Comment;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

public class CommentRepository 
{
	//	private final String namespace = "CommentMapper";

	private SqlSessionFactory getSqlSessionFactory() {
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	
	// 연결객체 	- JDBC 		: Connection
	//			- Mybatis 	: sqlSession
	public List<Comment> selectComment() {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		
		try {
			return sqlSess.selectList("CommentMapper.selectComment");
		}finally {
			sqlSess.close();		//연결을 끊는게 아니라 반납 개념
		}
	}
	
	public int insertComment(Comment comment) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		int result;
		try {
			result = sqlSess.insert("CommentMapper.insertComment",comment);
			if(result > 0) sqlSess.commit();
			else sqlSess.rollback();
		}finally {
			sqlSess.close();
		}
		return result;
	}
	public Comment selectCommentByPrimaryKey(int primaryNo) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		
		try {
			HashMap map = new HashMap();
			map.put("primaryNo",primaryNo);
			Comment comment = sqlSess.selectOne("CommentMapper.selectCommentByPrimaryKey", map);
				return comment;
		}finally {
			sqlSess.close();
		}
	}
	public int deleteCommentByNo(int primaryNo) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		int result=0;
		try {
			HashMap map = new HashMap();
			map.put("primaryNo", primaryNo);
			result = sqlSess.delete("CommentMapper.deleteComment", primaryNo);
			if (result>0){
				sqlSess.commit();
			}else {
				sqlSess.rollback();
			}
		}finally{
			sqlSess.close();
		}
		return result;
	}
	public int updateComment(Comment comment) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			
			result = sqlSess.update("CommentMapper.updateComment", comment);
			if(result>0) {
				sqlSess.commit();
			}else {
				sqlSess.rollback();
			}
		}finally {
			sqlSess.close();
		}
		return result;
	}
}
