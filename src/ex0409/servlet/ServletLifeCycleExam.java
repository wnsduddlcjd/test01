package ex0409.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.activation.Repository;

/**
 *  ���������� ����Ǵ� servlet���� �ۼ�
 *   1) �ݵ�� public Ŭ����
 *   2) �ݵ�� HttpServlet ���
 *   3) �ʿ��� �޼ҵ�� �������Ѵ�.
 *   
 *   4) servlet�� ����Ѵ�
 *       (���� + url���� ��� ��û������ ������ ������� ����)
 *       
 *       - web.xml���
 *       - @annotion���
 * */
public class ServletLifeCycleExam extends HttpServlet {
	
	public ServletLifeCycleExam() {
		System.out.println("ServletLifeCycleExam�� ������ ȣ���....");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() ȣ���.....");
	}
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("service�� ȣ��Ǿ���......");
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� â�� �ѱ� ���ڵ� �����ϱ�
		
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("doGet() ȣ���....");
		
		//�������� ����(ȭ�鱸��)
		//��½�Ʈ�� �ʿ��ϴ�.
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello ~~~ �ȳ�</h1>");
		
		out.println("<script>");
		out.println("alert('�ߵǳ׿�')");
		out.println("</script>");
		
		//���尴ü�� ����Ѵ�.
		HttpSession session = request.getSession();
		
		ServletContext apllication = request.getServletContext();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() ȣ���....");
	}


	@Override
	public void destroy() {
		System.out.println("destroy() ȣ���....");
		
	}

	
  
}










