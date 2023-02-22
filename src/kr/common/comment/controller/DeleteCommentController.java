package kr.common.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.comment.service.CommentService;

/**
 * Servlet implementation class DeleteCommentController
 */
@WebServlet("/deletecomment")
public class DeleteCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int boardid = Integer.parseInt(request.getParameter("board").trim());
    	int commid = Integer.parseInt(request.getParameter("comment").trim());
		
    	int result = new CommentService().deleteComment(boardid, commid);
    	
    	if(result == 1) {
    		System.out.println("댓글삭제성공");
    		response.sendRedirect(request.getContextPath()+"/boardcontent?id="+boardid);
    	} else {
    		System.out.println("댓글삭제실패");
    		response.sendRedirect(request.getContextPath()+"/boardcontent?id="+boardid);
    	}
    }

}
