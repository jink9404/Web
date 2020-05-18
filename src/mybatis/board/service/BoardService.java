package mybatis.board.service;

import java.text.DecimalFormat;
import java.util.List;


import mybatis.board.model.BoardRec;
import mybatis.board.session.BoardRepository;

public class BoardService {
	private static BoardService borBoardService;
	private BoardRepository repo = new BoardRepository();
	private int totalRecCount;		// 전체 레코드 수	
	private int pageTotalCount;		// 전체 페이지 수
	private int countPerPage = 5;	// 한페이지당 레코드 수
	
	public int getCountPerPage() {
		return countPerPage;
	}
	private BoardService(){};
	public static BoardService getInstance() {
		if(borBoardService==null) {
			return new BoardService();
		}
		return borBoardService;
	}
	
	public List<BoardRec> selectBoard(){
		return repo.seleteBoard();
	}
	
	public List <BoardRec> selectBoard(String pNum)
	{
		int pageNum = 1;
		if(pNum != null) pageNum = Integer.parseInt(pNum);
		
		int firstRow = (pageNum-1)*countPerPage+1; 
		int endRow = pageNum*countPerPage;
		
		 List <BoardRec> mList = repo.seleteBoard(firstRow,endRow);			
		return mList;
	}
	
	public int getTotalCount(){
		totalRecCount = repo.getTotalCount();
		pageTotalCount = totalRecCount/countPerPage 
				+ ((totalRecCount%countPerPage!=0)?1:0);
		return pageTotalCount;
	}
	
	public BoardRec selectBoardById(String id) {
		int article_id = 0;
		if( id != null ) article_id = Integer.parseInt(id);
		BoardRec rec = repo.seleteBoardById(article_id);		
		repo.increaseReadCount(article_id);
		return rec;
	}
	
	public int delete(String id, String password) {
		int article_id = 0;
		if(id != null) article_id = Integer.parseInt(id);
		return repo.delete(article_id, password);
	}
	
	public int write(BoardRec rec) {
		int groupId = repo.getGroupId();
		rec.setGroupId(groupId);
		
		DecimalFormat dformat = new DecimalFormat("0000000000");
		rec.setSequenceNo(dformat.format(groupId)+"999999");
		int article_id = repo.insert(rec);
		return article_id;
	}
}
