package com.zuntech.crm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CrmDao crmDao;
    
    public UpdateServlet() {
        super();
        this.crmDao=CrmDao.getCrmDao();
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("id");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		int id = Integer.parseInt(idStr);
		
		Customer customer=new Customer();
		customer.setId(id);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		
		HttpSession session=request.getSession();
		
		boolean b=crmDao.updateCustomer(customer);
		
		if(b) 
		{
			session.setAttribute("succMsg", "Customer details updated succesfully..");
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("errorMsg", "Something went wrong...");
			response.sendRedirect("index.jsp");
		}
	}

}
