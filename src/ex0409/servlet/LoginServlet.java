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
	   
	   //post����� ��� �ѱ����ڵ� ���� �ʿ�
		request.setCharacterEncoding("UTF-8");
	   
		//�Ѿ���� 3������������ �޾Ƽ� ȭ�鿡 ���
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head><title>SerlvetLogin</title></head>");
//		out.println("<body>");
//		
//		out.println("�̸� : " + userName+"<br>");
//		out.println("���̵� : " + userId+"<br>");
//		out.println("��й�ȣ : " + userPwd+"<br>");
//		
//		out.println("</body>");
//		out.println("</html>");
		
		if(id.equals(userId) && pwd.equals(userPwd)) {
			
			// service --> dao ���� DB�� �����͸� �����ͼ� �������� ����.
			List<String> list = new ArrayList<String>();
			list.add("���"); list.add("����");
			list.add("����"); list.add("����");
			
			request.setAttribute("list", list);
			
			//�̵�
			//1) forward
			 request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
			
			
			//2) redirect
			  //response.sendRedirect("LoginOk.jsp?userName="+URLEncoder.encode(userName,"UTF-8"));
			
		}else {
			//�޽��� ���
			//�ڷΰ���
			out.println("<script>");
			out.println("alert('"+userName+"�� ������ Ȯ�����ּ���...')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
	}
}













