package com.lh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lh.dao.UserDao;
import com.lh.model.UserInfo;

/**
 * �����˺ŵ�¼��Servlet��
 * @author lh
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    public UserServlet() {
        super(); 
    }
    /**
     * ����"Post"��ʽ������
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doLogin(request, response);
	}
	/**
	 * �����½����ķ���
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	
	private void doLogin(HttpServletRequest request,HttpServletResponse response) 
		throws IOException,ServletException{
		String name=request.getParameter("name");//��ȡ�����е��û���
		String pwd=request.getParameter("pwd");  //��ȡ�����е�����	
		Cookie cookie= new Cookie("LoginUserName", name); //���û������浽Cookie������	
		cookie.setMaxAge(60*1);                  //���ô�Cookie����󱣴�ʱ�䣨�����ʾ��
		response.addCookie(cookie);              //�ѱ����û�����Cookie������ӵ�Response��			
		UserInfo user = new UserInfo();          //��װ�û���Ϣ��ʵ����
		user.setName(name);                      //��װ�û���
		user.setPwd(pwd);                        //��װ����
		boolean res=UserDao.getInstance().checkUserLog(user); //��֤�û�������
		if(res){//��֤�ɹ���ת��ok.jsp
			response.sendRedirect("/15.1/usermanager/ok.jsp");
		}else{
			response.sendRedirect("/15.1/usermanager/error.jsp");
		}
	}
}
