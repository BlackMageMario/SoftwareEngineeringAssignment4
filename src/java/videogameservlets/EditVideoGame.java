/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogameservlets;

import java.io.IOException;
import javax.validation.ConstraintViolationException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import mysqldatabase.Videogames;
import mysqldatabase.VideogamesFacade;

/**
 *
 * @author Eamonn Hannon
 */
@WebServlet(name = "EditVideoGame", urlPatterns = {"/EditVideoGame"})
public class EditVideoGame extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private VideogamesFacade vmf;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id"));
        //Videogames findhelper = new Videogames(Integer.parseInt(request.getParameter("id")));
        Videogames videogame = vmf.find(Integer.parseInt(request.getParameter("id")));
        String prodName = request.getParameter("prodName");
        String pubName = request.getParameter("pubName");
        String devName = request.getParameter("devName");
        DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        Date releDate = null;
        System.out.println(prodName);
        try
        {
            System.out.println(request.getParameter("releDate"));
            releDate = df.parse(request.getParameter("releDate"));
        }
        catch(ParseException e)
        {
            System.err.println(e.getMessage());
        }
        int rrPrice = Integer.parseInt(request.getParameter("rrPrice"));
        String platform = request.getParameter("platform");
        videogame.setProdName(prodName);
        videogame.setDevName(devName);
        videogame.setPubName(pubName);
        videogame.setReleDate(releDate);
        videogame.setRrPrice(rrPrice);
        videogame.setPlatform(platform);
        try
        {
            vmf.edit(videogame);
        }
        catch (ConstraintViolationException e) {
            //log.log(Level.SEVERE,"Exception: ");
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            Iterator it = violations.iterator();
            ConstraintViolation<?> violation;
            while(it.hasNext())
            {
                violation = (ConstraintViolation<?>) it.next();
                System.out.println(violation.getMessage());
            }
            
        }
        RequestDispatcher rd = request.getRequestDispatcher("ListVideoGame");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
