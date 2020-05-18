package mybatis.board.session;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import board.model.BoardException;
import mybatis.board.model.BoardRec;

public class BoardRepository {
	

	private SqlSessionFactory getSqlSessionFactory() {
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		}catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	
	public List<BoardRec> seleteBoard(){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			return sqlSess.selectList("BoardMapper.selectBoard");
		}finally {
			sqlSess.close();
		}
	}
	public List<BoardRec> seleteBoard(int firstRow, int endRow){
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			HashMap hashMap = new HashMap();
			hashMap.put("firstRow",firstRow);
			hashMap.put("endRow",endRow);
			return sqlSess.selectList("BoardMapper.selectBoardByRow",hashMap);
		}finally {
			sqlSess.close();
		}
	}
	
	public int getTotalCount() {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			return sqlSess.selectOne("BoardMapper.selectTotalCount");
		}finally {
			sqlSess.close();
		}
	}
	
	public BoardRec seleteBoardById(int id) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			return sqlSess.selectOne("BoardMapper.seleteBoardById",id);
		}finally {
			sqlSess.close();
		}
	}
	
	public int increaseReadCount( int article_id ) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			 if((result=sqlSess.update("BoardMapper.increaseReadCount",article_id))>0) {
				sqlSess.commit(); 
			 }else {
				 sqlSess.rollback();
			 }
		}finally {
			sqlSess.close();
		}
		return result;
	}
	
	public int delete(int article_id, String password) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			HashMap map = new HashMap();
			map.put("article_id",article_id);
			map.put("password",password);
			 if((result=sqlSess.delete("BoardMapper.DeleteBoard",map))>0) {
				sqlSess.commit(); 
			 }else {
				 sqlSess.rollback();
			 }
		}finally {
			sqlSess.close();
		}
		return result;
	}
	
	public int getGroupId() {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		try {
			return sqlSess.selectOne("BoardMapper.getGroupId");
		}finally {
			sqlSess.close();
		}
	}
	public int insert(BoardRec rec) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();
		int result=0;
		try {
			result = sqlSess.insert("BoardMapper.Insert",rec);
			if(result > 0) sqlSess.commit();
			else sqlSess.rollback();
			return sqlSess.selectOne("BoardMapper.selectId");
		}finally {
			sqlSess.close();
		}
	}
}
