package kr.common.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.common.member.model.service.MemberService;
import kr.common.member.model.vo.MemberVo;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVo vo = new MemberVo();
		vo.setName(request.getParameter("name"));
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setEmail(request.getParameter("email"));
		
		int result = new MemberService().join(vo);
		
		if(result < 1) {
			System.out.println("회원가입 실패");
			response.sendRedirect(request.getContextPath()+"/");
		} else {
			System.out.println("회원가입 성공");
			response.sendRedirect(request.getContextPath()+"/");
		}
		
	}

}
