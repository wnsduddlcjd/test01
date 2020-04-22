package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.pkcs11.Secmod.DbMode;

public class LoginServlet extends HttpServlet {
	
	String id="jang" , pwd="1234";
	
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet....");
		
		this.doPost(req, resp);
		
	}
   
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	   
	   System.out.println("doPost......");
	   
	   //post방식인 경우 한글인코딩 설정 필요
		request.setCharacterEncoding("UTF-8");
	   
		//넘어오는 3개으ㅣ정보를 받아서 화면에 출력
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head><title>SerlvetLogin</title></head>");
//		out.println("<body>");
//		
//		out.println("이름 : " + userName+"<br>");
//		out.println("아이디 : " + userId+"<br>");
//		out.println("비밀번호 : " + userPwd+"<br>");
//		
//		out.println("</body>");
//		out.println("</html>");
		
		if(id.equals(userId) && pwd.equals(userPwd)) {
			
			// service --> dao 에서 DB에 데이터를 가져와서 뷰쪽으로 전달.
			List<String> list = new ArrayList<String>();
			list.add("등산"); list.add("수영");
			list.add("낚시"); list.add("골프");
			
			request.setAttribute("list", list);
			
			//이동
			//1) forward
			 request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
			
			
			//2) redirect
			  //response.sendRedirect("LoginOk.jsp?userName="+URLEncoder.encode(userName,"UTF-8"));
			
		}else {
			//메시지 출력
			//뒤로가기
			out.println("<script>");
			out.println("alert('"+userName+"님 정보를 확인해주세요...')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
	}
}













