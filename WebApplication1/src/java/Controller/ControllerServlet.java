package Controller;

import helperClasses.Building;
import helperClasses.Comment;
import helperClasses.Date;
import helperClasses.Firm;
import helperClasses.Report;
import helperClasses.ReportPage;
import java.io.IOException;
import java.util.ArrayList;
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
                    forward(request, response, "/BuildingJSP.jsp");

                } else
                {
                    Building building = new Building(request.getParameter("buildAddress"),
                            request.getParameter("buildZip"),
                            request.getParameter("buildFirmID"),
                            request.getParameter("buildName"),
                            request.getParameter("buildYear"),
                            request.getParameter("buildSize"),
                            request.getParameter("buildUsage"));
                    request.setAttribute("saveInfo", building);
                    facade.buildingDM.addBuildingToDB(building);
                    request.setAttribute("clearAll", true);
                    
                    forward(request, response, "/BuildingJSP.jsp");
                }
                break;
            case "showBuild":

                request.setAttribute("printBuild", facade.buildingDM.printBuildings());
                forward(request, response, "/BuildingJSP.jsp");

            case "createFirm":
                Firm firm = new Firm(request.getParameter("contactNumber"),
                        request.getParameter("contactMail"));
                facade.firmDM.addFirmToDB(firm);

                forward(request, response, "/index.html");

                break;

            case "useButton":
                String button = "";
                button += request.getParameter("button");
                if (button.equals("null")) {
                    forward(request, response, "/index.html");
                }
                switch (button) {
                    case "createReport":

                        Report report = null;
                        int[] info = new int[3];
                        //skal nok fås fra database
                        info[0] = (int)request.getAttribute("reportNRtext");
                        info[1] = logic.BuildingNameToBuildingID((String)request.getAttribute("buildingNameText"));
                        if((boolean)request.getAttribute("state0Check")){
                            info[2] =0;
                        }else if((boolean)request.getAttribute("state1Check")){
                            info[2]=1;
                        }else if((boolean)request.getAttribute("state2Check")){
                            info[2] = 2;
                        }else if((boolean)request.getAttribute("state3Check")){
                            info[2] = 3;
                        }
                        
                        ArrayList<ReportPage> reportpage = new ArrayList<>();
                        for (int i = 0; i < (int)request.getAttribute("numberOfPages"); i++) {
                            java.sql.Date date;
                            date = (java.sql.Date)request.getAttribute("damageDate");
                            boolean previouslydamaged = false;
                            if((boolean)request.getAttribute("damageCheckYes")!=false)
                                previouslydamaged = true;
                            String[] str = new String[4];
                            str[0] = (String)request.getAttribute("damagePlaceText");
                            str[1] = (String)request.getAttribute("damageCauseText");
                            str[2] = (String)request.getAttribute("reperationText");
                            str[3] = (String)request.getAttribute("otherDamageText");
                            Boolean[] bools= new Boolean[5];
                            bools[0] = (Boolean)request.getAttribute("moistCheck");
                            bools[1] = (Boolean)request.getAttribute("rotCheck");
                            bools[2] = (Boolean)request.getAttribute("moldCheck");
                            bools[3] = (Boolean)request.getAttribute("fireCheck");
                            Comment[] comments = new Comment[0];
                            //find ud af hvor reportpage nummber skal komme fra nok fra database
                            reportpage.add(new ReportPage(info[0], i, previouslydamaged, new Date(date), str[0], str[1], str[2], bools[0], bools[1], bools[2], bools[3], str[3], true, comments));
                        }
                        java.sql.Date date;
                        date = (java.sql.Date)request.getAttribute("dateDate");
                        Comment outerWalls = new Comment((String)request.getAttribute("wallCommentText"),"Wall" );
                        Comment roof = new Comment((String)request.getAttribute("ceilingCommentText"),"Ceiling" );

                        report = new Report(info[0], info[1], new Date(date), info[2], (ReportPage[])reportpage.toArray(), outerWalls, roof);
                        facade.reportDM.addReportToDB(report);
                        break;
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

    private void saveReportInformation(HttpServletRequest request, HttpSession session)
    {
        String[] listOfAttributes = {"reportNRtext","buildingNameText","dateDate","adressText","zipText"};
        for (String attribute : listOfAttributes)
        {
            String saveThis = "";
            try{
            saveThis += ( String )request.getParameter(attribute);
            }
            catch ( Exception ex)
            {
                System.out.println(ex.toString());
            }
            if (!saveThis.equals("")) {
                session.setAttribute(attribute, saveThis);
            } 
        }
        
    }
}
