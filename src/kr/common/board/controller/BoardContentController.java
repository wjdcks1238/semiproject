package kr.common.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.getRequestDispatcher("/WEB-INF/view/board/boardcontent.jsp").forward(request, response);
		
		int bid = Integer.parseInt(request.getParameter("id").trim());
		System.out.println(bid);
		
		BoardVo vo = new BoardVo();
		
		//vo = new BoardService().getBoardContent(bid);
		
		//request.setAttribute("btitle", vo.getTitle());
		//request.setAttribute("bcontent", vo.getBoardContent());
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardcontent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
