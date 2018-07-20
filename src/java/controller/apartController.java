/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import dao.ApartDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Apartment;
import org.apache.commons.io.FilenameUtils;


/**
 *
 * @author Bishal Shrestha
 */
public class apartController extends HttpServlet {

  
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ApartDao s=new ApartDao();
        String msg=request.getParameter("msg");
        if(msg.equals("upload"))
        {
            String path = request.getServletContext().getRealPath("") + "/images";
            MultipartRequest mrequest = new MultipartRequest(request, path, 30000000, new DefaultFileRenamePolicy());
            String filename = null;
            Enumeration files = mrequest.getFileNames();
            if (files.hasMoreElements()) {
                filename = mrequest.getOriginalFileName(files.nextElement().toString());
            }
            String ext = FilenameUtils.getExtension(filename);
            System.out.println(filename + ext);
            if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png")) {
     
                String owner = mrequest.getParameter("owner");
                String name = mrequest.getParameter("name");
                String location = mrequest.getParameter("location");
                String price= mrequest.getParameter("price"); 
                System.out.println(owner);
                try {
                    s.fileupload(request,owner,name,filename,location,price);
                } catch (Exception ex) {
                    
                } 
                    
                
            }
            response.sendRedirect("welcome.jsp?msg=successful");
            }
        
        
    if(msg.equals("location"))
    {
        String location=request.getParameter("location");
        try {
                List<Apartment> list = s.getApart(location);
                System.out.println(list);
                RequestDispatcher rd = request.getRequestDispatcher("listofapartment.jsp");
                request.setAttribute("list", list);
                rd.forward(request, response);

            } catch (Exception ex) {
               
            }
    }
        
        
    }
}

   

