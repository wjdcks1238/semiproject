package kr.common.board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import kr.common.board.service.BoardService;
import kr.common.board.vo.BoardVo;

/**
 * Servlet implementation class BoardContentController
 */
@WebServlet("/boardcontent")
public class BoardContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardContentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardid = Integer.parseInt(request.getParameter("id").trim());
		System.out.println(boardid);
		
		BoardVo vo = new BoardVo();
		
		vo = new BoardService().getBoardContent(boardid);
		
		System.out.println(vo);
		
		String title = vo.getTitle();
		String content = vo.getBoardContent();
		Date date = vo.getSubmitDate();
		int readCount = vo.getReadCount();
		String buser = vo.getBoardUser();
		
		request.setAttribute("btitle", title);
		request.setAttribute("bcontent", content);
		request.setAttribute("submitdate", date);
		request.setAttribute("readcount", readCount);
		request.setAttribute("buser", buser);
		request.setAttribute("boardid", boardid);
		
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardcontent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
