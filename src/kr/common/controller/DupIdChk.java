package kr.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.member.model.service.MemberService;

/**
 * Servlet implementation class DupIdChk
 */
@WebServlet("/dupId")
public class DupIdChk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdChk() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mservice = new MemberService();
		String id = request.getParameter("id");
		System.out.println(id);
		int result = mservice.dupIdChk(id);
		System.out.println(result);
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.append("fail");
		} else {
			out.append("ok");
		}
		out.flush();
		out.close();
	}

}
