package controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import dao.BookingDao;
import dao.RoomDao;
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
import model.Rooms;
import org.apache.commons.io.FilenameUtils;

public class RoomController1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RoomDao r = new RoomDao();
        BookingDao bd = new BookingDao();
        String act = request.getParameter("act");

        if (act.equals("uproom")) {

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
                String location = mrequest.getParameter("location");
                String price = mrequest.getParameter("price");
                
                try {
                    r.fileupload(request, owner, location, price, filename);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

            response.sendRedirect("welcome.jsp?msg=successful");
        }
        if (act.equals("location")) {
            String location = request.getParameter("location");
            try {
                List<Rooms> list = r.getRooms(location);
                System.out.println(list);
                //System.out.println(request.getSession().getAttribute("username"));
                RequestDispatcher rd = request.getRequestDispatcher("listofrooms.jsp");
                request.setAttribute("list", list);
                rd.forward(request, response);

            } catch (Exception ex) {

            }
        }
        if(act.equals("book"))
        {
            int id = Integer.parseInt(request.getParameter("x")); 
            String username = (String) request.getSession().getAttribute("username");
            
            try {
                bd.book("room",id,username);//booking table ma naya booking set gareko
                r.bookedRoom(id);// room table ko booked field set to 1;
                response.getWriter().print("la vayo");
            } catch (SQLException ex) {
                response.getWriter().print("already booked");

            }
            
        }

    }

}
