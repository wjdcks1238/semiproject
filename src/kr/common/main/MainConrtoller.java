package kr.common.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.board.service.BoardService;

/**
 * Servlet implementation class MainConrtoller
 */
@WebServlet({"/","/home","/main"})
public class MainConrtoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainConrtoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pg = request.getParameter("pg");
		int cnt = 0;
		cnt = service.getCountBoard();
		
		int pageSize = 5;
		
		int pageBlock = 3;
		
		int currentPage = 1;
		
		try {
			currentPage = Integer.parseInt(pg);
		} catch(Exception e) {
			
		}
		
		int startRnum = 0;
		int endRnum = 0;
		
		startRnum = ((currentPage -1) * pageSize) + 1;
		endRnum = (startRnum + pageSize -1 > cnt)? startRnum + pageSize - 1 : cnt;
		request.setAttribute("boardlist", service.getBoardList(startRnum, endRnum));
		
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
		
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}
}
