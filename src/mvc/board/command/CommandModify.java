package mvc.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.model.BoardDao;
import mvc.board.model.BoardException;
import mvc.board.model.BoardRec;



public class CommandModify implements Command{
	private String next;
	
	public CommandModify(String next) {
		this.next = next;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		try {
			BoardRec rec = BoardDao.getInstance().selectById(Integer.parseInt(request.getParameter("articleId")));
			rec.setTitle(request.getParameter("title"));
			rec.setPassword(request.getParameter("password"));
			rec.setContent(request.getParameter("content"));
			request.setAttribute("updateResult", BoardDao.getInstance().update(rec));
			request.setAttribute("articleId", rec.getArticleId());
		}catch (BoardException e) {
			throw new CommandException("CommandModify.java < 목록보기시 > " + e.toString());
		}
		return next;
	}

}
