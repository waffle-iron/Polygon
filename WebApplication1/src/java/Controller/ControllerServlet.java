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
        String do_this = "";
        do_this += request.getParameter("do_this");
        if (do_this.equals(""))
        {
            forward(request, response, "/index.html");
        }

        switch (do_this)
        {

            case "createBuild":
                if (request.getParameter("buildAddress").trim().compareTo("") == 0
                        || request.getParameter("buildZip").trim().compareTo("") == 0
                        || request.getParameter("buildFirmID").trim().compareTo("") == 0
                        || request.getParameter("buildName").trim().compareTo("") == 0
                        || request.getParameter("buildYear").trim().compareTo("") == 0
                        || request.getParameter("buildSize").trim().compareTo("") == 0
                        || request.getParameter("buildUsage").trim().compareTo("") == 0)
                {

                } else
                {
                    Building building = new Building(request.getParameter("buildAddress"),
                            request.getParameter("buildZip"),
                            request.getParameter("buildFirmID"),
                            request.getParameter("buildName"),
                            request.getParameter("buildYear"),
                            request.getParameter("buildSize"),
                            request.getParameter("buildUsage"));
                    facade.buildingDM.addBuildingToDB(building);

                    forward(request, response, "/BuildingJSP.jsp");
                }

            case "showBuild":

                request.setAttribute("printBuild", facade.buildingDM.printBuildings());
                forward(request, response, "/BuildingJSP.jsp");

            case "createFirm":
                Firm firm = new Firm(request.getParameter("contactNumber"),
                        request.getParameter("contactMail"));
                facade.firmDM.addFirmToDB(firm);

                forward(request, response, "/index.html");
                
                break;
            case "createReport":
                break;

            case "useButton":
                String button = "";
                button += request.getParameter("button");
                if (button.equals("null"))
                {
                    forward(request, response, "/index.html");
                }
                switch (button)
                {
                    case "updatePageNr":

                        request.setAttribute("numberOfPages", "" + request.getParameter("numberOfReportPages"));
                        forward(request, response, "/reportJSP.jsp");
                        break;
                    default:
                        forward(request, response, "/BuildJSP.jsp");
                        break;
                }
                break;
            case "Building":
                forward(request, response, "/BuildingJSP.jsp");
                break;
            case "Firm":
                forward(request, response, "/FirmJSP.jsp");
                break;
            case "Report":
                request.setAttribute("numberOfPages", "" + 1);
                forward(request, response, "/reportJSP.jsp");
                break;
            default:
                System.out.println("Not valid command" + do_this);
                break;
            case "Login":

                forward(request, response, "/LoginJSP.jsp");

                break;

            case "CheckLogin":
//                if(facade.loginDM.userExists(request.getParameter("username"), request.getParameter("password"), request.getParameter(firmID), do_this))
//                {
//                    forward(request, response, "/PostLoginJSP.jsp");
//                }
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
