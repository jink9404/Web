package mvc.board.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.command.Command;
import mvc.board.command.CommandDelete;
import mvc.board.command.CommandException;
import mvc.board.command.CommandInput;
import mvc.board.command.CommandList;
import mvc.board.command.CommandModify;
import mvc.board.command.CommandNull;
import mvc.board.command.CommandReply;
import mvc.board.command.CommandView;




public class BoardControl extends HttpServlet {
	
	private HashMap commandMap;
	private String	jspDir = "/05_mvc_class/3_mvcBoard/";
	private String  error = "error.jsp";
	

    public BoardControl() {
        super();       
		initCommand();
	}

	private void initCommand(){
		commandMap = new HashMap();

		commandMap.put("main-page",	new CommandNull("main.jsp") );
		commandMap.put("list-page",	new CommandList("BoardList.jsp") );
		
		commandMap.put("reply-form",new CommandNull("BoardReplyForm.jsp"));
		commandMap.put("reply-page",new CommandReply("BoardReply.jsp"));
		
		commandMap.put("modify-form",new CommandView("BoardModifyForm.jsp"));
		commandMap.put("modify-page",new CommandModify("BoardModify.jsp"));
		
		commandMap.put("delete-form",new CommandNull("BoardDeleteForm.jsp"));
		commandMap.put("delete-page",new CommandDelete("BoardDelete.jsp"));
		
		commandMap.put("view-page",new CommandView("BoardView.jsp"));
		
		commandMap.put("input-form", new CommandNull("BoardInputForm.jsp"));
		commandMap.put("input-page", new CommandInput("BoardSave.jsp"));
		
		
		// 나머지도 추가하기		
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String nextPage = "";
		String cmdKey	= request.getParameter("cmd");
		if( cmdKey == null ){
			cmdKey = "main-page";
		}

		
		Command cmd = null;

		try{
			
			if( commandMap.containsKey( cmdKey ) ){
				cmd = (Command)commandMap.get( cmdKey);
			}else{
				throw new CommandException("지정할 명령어가 존재하지 않음");
			}

			nextPage = cmd.execute( request, response  );

		}catch( CommandException e ){
			request.setAttribute("javax.servlet.jsp.jspException", e );
			nextPage = error;
			System.out.println("오류 : " + e.getMessage() );
		}

		RequestDispatcher reqDp = getServletContext().getRequestDispatcher( jspDir + nextPage);
		reqDp.forward( request, response );
		
	}

}
