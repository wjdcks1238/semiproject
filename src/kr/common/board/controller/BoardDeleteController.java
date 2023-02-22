package kr.common.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.board.service.BoardService;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/deleteboard")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardid = Integer.parseInt(request.getParameter("id").trim());
		System.out.println(boardid);
		
		int result = new BoardService().deleteContent(boardid);
		
		if(result == 1) {
			System.out.println("게시글 삭제 성공");
			response.sendRedirect(request.getContextPath()+"/");
		} else {
			System.out.println("게시글 삭제 실패");
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

}
