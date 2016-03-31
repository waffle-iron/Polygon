package Controller;

import helperClasses.Building;
import helperClasses.Firm;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Facade facade = new Facade();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String do_this = request.getParameter("do_this");
        if (do_this == null)
        {
            forward(request, response, "/index.html");
        }

        switch (do_this)
        {
            case "createBuilding":
                Building building = new Building(request.getParameter("buildAddress"),
                        request.getParameter("buildZip"),
                        request.getParameter("buildFirmID"),
                        request.getParameter("buildName"),
                        request.getParameter("buildYear"),
                        request.getParameter("buildSize"),
                        request.getParameter("buildUsage"));
                facade.buildingDM.addBuildingToDB(building);

                forward(request, response, "/index.html");
          case "createFirm":
                Firm firm = new Firm(request.getParameter("contactNumber"),
                        request.getParameter("contactMail"));
                facade.firmDM.addFirmToDB(firm);

                forward(request, response, "/index.jsp");
                break;
            case "createReport":
                break;
            case "updateReportPages":
                break;
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException
    {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(path);
        rd.forward(req, res);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
package Controller;

import helperClasses.Building;
import helperClasses.Firm;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Facade facade = new Facade();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String do_this = request.getParameter("do_this");
        if (do_this == null)
        {
            forward(request, response, "/index.html");
        }

        switch (do_this)
        {
            case "createBuild":
                Building building = new Building(request.getParameter("buildAddress"),
                        request.getParameter("buildZip"),
                        request.getParameter("buildFirmID"),
                        request.getParameter("buildName"),
                        request.getParameter("buildYear"),
                        request.getParameter("buildSize"),
                        request.getParameter("buildUsage"));
                facade.buildingDM.addBuildingToDB(building);

                forward(request, response, "/index.html");
        
            break;
                
            case "showBuild":

                
                request.setAttribute("printBuild", facade.buildingDM.printBuildings(""));
                forward(request, response, "/BuildJSP.jsp");

                        
            break;
                
            case "createFirm":
                Firm firm = new Firm(request.getParameter("contactNumber"),
                        request.getParameter("contactMail"));
                facade.firmDM.addFirmToDB(firm);

                forward(request, response, "/index.jsp");

        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse res, String path) throws IOException, ServletException
    {
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(path);
        rd.forward(req, res);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
