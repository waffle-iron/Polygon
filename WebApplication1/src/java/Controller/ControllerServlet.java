package Controller;

import helperClasses.Building;
import helperClasses.Comment;
import helperClasses.Date;
import helperClasses.Firm;
import helperClasses.Login;
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
            forward(request, response, "/Fejl.jsp");
        }

        switch (do_this)
        {
            case "Building":
                forward(request, response, "/BuildingJSP.jsp");
                break;

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
                    request.setAttribute("ValidFirmID", new ArrayList<Integer>());
                    request.setAttribute("Done", true);
                    request.setAttribute("saveBuildingInfo", building);
                    facade.addBuildingToDB(building);
                    request.setAttribute("clearAll", true);

                    forward(request, response, "/BuildingJSP.jsp");
                }
                break;

            case "showBuild":

                request.setAttribute("printBuild", facade.getBuildingsFromDatabase());
                forward(request, response, "/BuildingJSP.jsp");

                break;

            case "goBackBuilding":

                forward(request, response, "/index.html");

                break;

            case "Firm":
                forward(request, response, "/FirmJSP.jsp");
                break;

            case "createFirm":
                if (request.getParameter("contactNumber").trim().compareTo("") == 0
                        || request.getParameter("contactMail").trim().compareTo("") == 0)
                {

                    forward(request, response, "/FirmJSP.jsp");
                } else
                {
                    Firm firm = new Firm(request.getParameter("contactNumber"),
                            request.getParameter("contactMail"));
                    request.setAttribute("saveFirmInfo", firm);
                    facade.addFirmToDB(firm);
                    request.setAttribute("clearAll", true);

                    forward(request, response, "/index.html");
                    break;
                }

            case "Report":
                request.setAttribute("numberOfPages", "" + 1);

                request.setAttribute("nextReportNr", facade.getNextReportNr());
                forward(request, response, "/reportJSP.jsp");
                break;
            default:
                System.out.println("Not valid command" + do_this);
                forward(request, response, "/Fejl.jsp");
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
                    case "Delete":
                        break;

                    case "createReport":
                        try
                        {
                            Report report = null;
                            int[] info = new int[3];
                            info[1] = Logic.BuildingNameToBuildingID((String) request.getAttribute("buildingNameText"));

                            if ((request.getParameter("state0Check")) != null && (request.getParameter("state0Check").equals("on")))
                            {
                                info[2] = 0;
                            }
                            if ((request.getParameter("state1Check")) != null && (request.getParameter("state1Check").equals("on")))
                            {
                                info[2] = 1;
                            }
                            if ((request.getParameter("state2Check")) != null && (request.getParameter("state2Check").equals("on")))
                            {
                                info[2] = 2;
                            }
                            if ((request.getParameter("state3Check")) != null && (request.getParameter("state3Check").equals("on")))
                            {
                                info[2] = 3;
                            }
                            String[] tempdate;
                            int[] date = new int[3];
                            tempdate = (request.getParameter("dateDate")).split("-");
                            for (int i = 0; i < 3; i++)
                            {
                                date[i] = Integer.parseInt(tempdate[i]);
                            }
                            ArrayList<ReportPage> reportpage = new ArrayList<>();
                            for (int i = 0; i < Integer.parseInt(request.getParameter("numberOfReportPages")); i++)
                            {
                                Integer.parseInt(request.getParameter("damageDate" + i));
                                boolean previouslydamaged = false;
                                if ((request.getParameter("damageCheckYes" + i)).equals("on"))
                                {
                                    previouslydamaged = true;
                                }
                                String[] str = new String[4];
                                str[0] = request.getParameter("damagePlaceText" + i);
                                str[1] = request.getParameter("damageCauseText" + i);
                                str[2] = request.getParameter("reperationText" + i);
                                str[3] = request.getParameter("otherDamageText" + i);
                                Boolean[] bools = new Boolean[5];
                                bools[0] = (request.getParameter("moistCheck" + i).equals("on"));
                                bools[1] = (request.getParameter("rotCheck" + i).equals("on"));
                                bools[2] = (request.getParameter("moldCheck" + i).equals("on"));
                                bools[3] = (request.getParameter("fireCheck" + i).equals("on"));
                                Comment[] comments = new Comment[0];
                                reportpage.add(new ReportPage(info[0], 0, previouslydamaged, new Date(date[0], date[1], date[2]), str[0], str[1], str[2], bools[0], bools[1], bools[2], bools[3], str[3], true, comments));
                            }
                            Comment outerWalls = null;
                            if ((request.getParameter("wallNoCommentCheck").equals("off")))
                            {
                                outerWalls = new Comment(request.getParameter("wallCommentText"), "Wall");
                            }
                            Comment roof = null;
                            if ((request.getParameter("wallNoCommentCheck").equals("off")))
                            {
                                roof = new Comment(request.getParameter("ceilingCommentText"), "Ceiling");
                            }

                            report = new Report(info[1], new Date(date[0], date[1], date[2]), info[2], reportpage, outerWalls, roof);
                            facade.addReportToDB(report);
                            forward(request, response, "/index.html");
                        } catch (Exception ex)
                        {
                            request.setAttribute("fejlmeddelese", ex);
                            forward(request, response, "/fejl.jsp");
                        }
                        break;

                    case "updatePageNr":
                        request.setAttribute("nextReportNr", facade.getNextReportNr());
                        request.setAttribute("numberOfPages", "" + request.getParameter("numberOfReportPages"));
                        forward(request, response, "/reportJSP.jsp");
                        break;
                    default:
                        forward(request, response, "/BuildJSP.jsp");
                        break;
                }
                break;

            case "viewReport":
                //get desired reportid
                int reportid = 1;
                Report report = facade.getReportFromDB(reportid);
                request.setAttribute("BuildingID", report.getBuildingID());
                request.setAttribute("OuterWalls", report.getOuterWalls());
                request.setAttribute("ReportDate", report.getReportDate());
                request.setAttribute("ReportPages", report.getReportPages());
                request.setAttribute("ReportNR", report.getReportnr());
                request.setAttribute("Roof", report.getRoof());
                request.setAttribute("State", report.getState());
                forward(request, response, "/ViewReport.jsp");
                break;

            case "Login":

                forward(request, response, "/LoginJSP.jsp");

                break;

            case "CheckLogin":
                String temp = "";
                switch (request.getParameter("enum"))
                {
                    case "Bruger":
                        temp = "user";
                        break;

                    case "Tekniker":
                        temp = "tech";
                        break;

                    case "Admin":
                        temp = "admin";
                        break;
                }

                if (request.getParameter("username").equals("") || request.getParameter("password").equals("")
                        || request.getParameter("firmID").equals(""))
                {
                    request.setAttribute("doExists", false);
                    forward(request, response, "/LoginJSP.jsp");

                }

                if (facade.userExists(request.getParameter("username"), request.getParameter("password"),
                        request.getParameter("firmID"), temp))
                {

                    session.setAttribute("loginAs", temp);
                    //session.setAttribute("userClass", );
                    switch (temp)
                    {
                        case "user":
                            forward(request, response, "/PostLoginUser.jsp");
                            
                        case "tech":
                            forward(request, response, "/PostLoginTech.jsp");

                        case "admin":
                            forward(request, response, "/PostLoginAdmin.jsp");
                            
                        default:
                            forward(request, response, "/Fejl.jsp");
                    }
                    break;
                }
                
        case "CreateLogin":
                forward(request, response, "/OpretJSP.jsp");
                break;

            case "CreateLogin2":
                String temp2 = "";
                switch (request.getParameter("enum"))
                {
                    case "Bruger":
                        temp2 = "user";
                        break;

                    case "Tekniker":
                        temp2 = "tech";
                        break;

                    case "Admin":
                        temp2 = "admin";
                        break;
                }
                if (facade.userExists(request.getParameter("username"), request.getParameter("password"),
                        request.getParameter("firmID"), temp2) == true)
                {
                    forward(request, response, "/Fejl.jsp");
                } else
                {
                    Login login = new Login(request.getParameter("username"), request.getParameter("password"),
                            request.getParameter("firmID"),
                            temp2);
                    facade.addLoginToDB(login);
                    forward(request, response, "/LoginJSP.jsp");
                }
                break;

            case "goBackToLogin":
                forward(request, response, "/LoginJSP.jsp");

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
