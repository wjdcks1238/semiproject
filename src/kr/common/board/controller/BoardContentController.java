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
import kr.common.comment.service.CommentService;

/**
 * Servlet implementation class BoardContentController
 */
@WebServlet("/boardcontent")
public class BoardContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CommentService service = new CommentService();
       
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
		
		//댓글란
		String pg = request.getParameter("pg");
		int cnt = 0;
		System.out.println("게시글 번호 : " + boardid);
		cnt = service.getCountComment(boardid);
		
		int pageSize = 5;
		
		int pageBlock = 5;
		
		int currentPage = 1;
		
		try {
			currentPage = Integer.parseInt(pg);
		} catch(Exception e) {
			
		}
		
		int startRnum = 0;
		int endRnum = 0;
		
		startRnum = ((currentPage -1) * pageSize) + 1;
		endRnum = (startRnum + pageSize -1 > cnt)? cnt : startRnum + pageSize - 1;
		
		System.out.println("시작 : " + startRnum +"끝 : " + endRnum + " id"+ boardid);
		request.setAttribute("commentlist", service.getCommentList(startRnum, endRnum, boardid));
		
		int startPageNum = 0;
		int endPageNum = 0;
		
		startPageNum = (currentPage % pageBlock == 0)
				? ((currentPage/pageBlock -1) * pageBlock + 1)
				: ((currentPage/pageBlock) * pageBlock + 1);
		int pageCnt = (cnt/pageSize);
		
		if(cnt%pageSize != 0) {
			pageCnt++;
		}
		
		endPageNum = (startPageNum + pageBlock -1 > pageCnt) ? pageCnt : startPageNum + pageBlock -1;
		
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCnt", pageCnt);
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/board/boardcontent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
