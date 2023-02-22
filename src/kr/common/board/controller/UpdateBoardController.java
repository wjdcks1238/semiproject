package kr.common.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.board.service.BoardService;
import kr.common.board.vo.BoardVo;
import kr.common.member.model.service.MemberService;

/**
 * Servlet implementation class UpdateBoardController
 */
@WebServlet("/updateboard")
public class UpdateBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardid = Integer.parseInt(request.getParameter("id").trim());
		
		BoardVo vo = new BoardVo();
		
		vo = new BoardService().getBoardContent(boardid);
		
		String title = vo.getTitle();
		String content = vo.getBoardContent();
		
		request.setAttribute("boardid", boardid);
		request.setAttribute("btitle", title);
		request.setAttribute("bcontent", content);
		
		request.getRequestDispatcher("/WEB-INF/view/board/updateboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardid = Integer.parseInt(request.getParameter("boardid").trim());
		
		BoardVo vo = new BoardVo();
		vo.setBoardId(boardid);
		vo.setTitle(request.getParameter("btitle"));
		vo.setBoardContent(request.getParameter("bcontent"));
		
		int result = new BoardService().updateBoardContent(vo);
		
		if(result == 1) {
			System.out.println("게시글 수정 성공");
			response.sendRedirect(request.getContextPath()+"/boardcontent?id="+boardid);
		} else {
			System.out.println("게시글 수정 실패");
			response.sendRedirect(request.getContextPath()+"/boardcontent?id="+boardid);
		}
	}

}
