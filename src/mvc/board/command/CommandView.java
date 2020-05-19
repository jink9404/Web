package mvc.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardException;
import mvc.board.model.BoardRec;


public class CommandView implements Command{
	private String next;
	
	public CommandView( String next ){
		this.next = next;
	}
	
	public String execute( HttpServletRequest request, HttpServletResponse response  ) throws CommandException{
		try {
			request.setCharacterEncoding("UTF-8");
			BoardRec rec = BoardDao.getInstance().selectById(Integer.parseInt(request.getParameter("articleId")));	
		    request.setAttribute("rec", rec );
		    BoardDao.getInstance().increaseReadCount(Integer.parseInt(request.getParameter("articleId")));
		}catch (BoardException e) {
			throw new CommandException("CommandView.java < 목록보기시 > " + e.toString() ); 
		}catch (Exception e) {
			
		}
		return next;
	}
}
