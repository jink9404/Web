package board.service;

import java.util.List;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;

public class ListArticleService {
	
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 5;	// 한페이지당 레코드 수
	
	private static ListArticleService instance;
	public static ListArticleService getInstance()  throws BoardException{
		if( instance == null )
		{
			instance = new ListArticleService();
		}
		return instance;
	}
	
	public List <BoardRec> getArticleList() throws BoardException
	{
		// 
		 List <BoardRec> mList = BoardDao.getInstance().selectList();			
		return mList;
	}
	
	public List <BoardRec> getArticleList(String pNum) throws BoardException
	{
		int pageNum = 1;
		if(pNum != null) pageNum = Integer.parseInt(pNum);
		
		int firstRow = (pageNum-1)*countPerPage+1; 
		int endRow = pageNum*countPerPage;
		
		 List <BoardRec> mList = BoardDao.getInstance().selectList(firstRow,endRow);			
		return mList;
	}
	
	public int getTotalCount() throws BoardException{
		totalRecCount = BoardDao.getInstance().getTotalCount();
		pageTotalCount = totalRecCount/countPerPage 
				+ ((totalRecCount%countPerPage!=0)?1:0);
		return pageTotalCount;
	}
}
