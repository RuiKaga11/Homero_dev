package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SignUpLogic;
import model.User;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String confirmPass = request.getParameter("confirmPass");
		
		if(!pass.equals(confirmPass)) {
			request.setAttribute("errorMsg","パスワードが一致しません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
			dispatcher.forward(request, response);
		}
		SignUpLogic registerUserLogic = new SignUpLogic();
		if(!registerUserLogic.isValidUserId(userId)) {
		request.setAttribute("errorMsg", "ユーザー名は英数字で4〜20字です");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
		dispatcher.forward(request, response);
		}
		if(!registerUserLogic.isValidPass(pass)){
		request.setAttribute("errorMsg","パスワードは8〜16字です");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/signUp.jsp");
		dispatcher.forward(request, response);
		}
        
	//DBへ送信
		
	   //セッションスコープへ保存	
		User user = new User(userId,pass);
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);
      //ホーム画面へフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        dispatcher.forward(request, response);		
		}
	}


