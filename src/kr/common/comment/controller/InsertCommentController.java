package kr.common.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.comment.service.CommentService;
import kr.common.comment.vo.CommentVo;

/**
 * Servlet implementation class InsertCommentController
 */
@WebServlet("/insertcomment")
public class InsertCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardid = Integer.parseInt(request.getParameter("id").trim());
    	CommentVo vo = new CommentVo();
    	vo.setBoardId(boardid);
    	vo.setUserName(request.getParameter("uid"));
    	vo.setCommentContent(request.getParameter("insertcomment"));
		
    	int result = new CommentService().insertComment(vo);
    	
    	if(result == 1) {
    		System.out.println("댓글 삽입 성공");
    		response.sendRedirect(request.getContextPath()+"/boardcontent?id="+vo.getBoardId());
    	} else {
    		System.out.println("댓글 삽입 실패");
    		response.sendRedirect(request.getContextPath()+"/boardcontent?id="+vo.getBoardId());
    	}
		
	}

}
