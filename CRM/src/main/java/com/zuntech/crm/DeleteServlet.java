package com.zuntech.crm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		CrmDao crmDao=CrmDao.getCrmDao();

		HttpSession session=request.getSession();
		
		boolean b=crmDao.removeCustomer(id);
		if(b) 
		{
			session.setAttribute("succMsg", "1 Customer detail deleted succesfully..");
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errorMsg", "Something went wrong...");
			response.sendRedirect("index.jsp");
		}
	}
}
