package kr.common.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.board.service.BoardService;
import kr.common.board.vo.BoardVo;

/**
 * Servlet implementation class InsertBoardController
 */
@WebServlet("/insertboard")
public class InsertBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/board/insertboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVo vo = new BoardVo();
		
		vo.setBoardUser(request.getParameter("id"));
		vo.setTitle(request.getParameter("btitle"));
		vo.setBoardContent(request.getParameter("bcontent"));
		
		int result = new BoardService().insertBoard(vo);
		
		if(result == 1) {
			System.out.println("게시글 작성 성공");
			response.sendRedirect(request.getContextPath()+"/");
		} else {
			System.out.println("게시글 작성 실패");
			response.sendRedirect(request.getContextPath()+"/");
		}
		
	}

}
