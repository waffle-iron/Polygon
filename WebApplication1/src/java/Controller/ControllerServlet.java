package Controller;

import static Controller.Logic.*;
import helperClasses.Building;
import helperClasses.Comment;
import helperClasses.Date;
import helperClasses.Firm;
import helperClasses.Login;
import helperClasses.Report;
import helperClasses.ReportPage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class ControllerServlet extends HttpServlet
{

    Facade facade = new Facade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

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
            case "useComment":
                String commentPair = "";
                commentPair += request.getParameter("Comment");
                String[] commentPaired = commentPair.split(",");
                useComment(request, response, session, commentPaired[0], Integer.parseInt(commentPaired[1]));
                break;
            case "useButton":
                String button = "";
                button += request.getParameter("button");
                if (button.equals("null"))
                {
                    forward(request, response, "/index.html");
                }
                useButton(request, response, session, button);
                break;

            case "goToAddBuilding":
                request.setAttribute("ValidFirmID", getFirmIDsFromUserID((Login) session.getAttribute("login")));
                forward(request, response, "/AddBuildingJSP.jsp");
                break;

            case "Image":
                forward(request, response, "/ImageJSPTemp.jsp");
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
                    request.setAttribute("ValidFirmID", getFirmIDsFromUserID((Login) session.getAttribute("login")));
                    forward(request, response, "/AddBuildingJSP.jsp");

                } else
                {
                    Building building = new Building(request.getParameter("buildAddress"),
                            request.getParameter("buildZip"),
                            request.getParameter("buildFirmID"),
                            request.getParameter("buildName"),
                            request.getParameter("buildYear"),
                            request.getParameter("buildSize"),
                            request.getParameter("buildUsage"));
                    request.setAttribute("Done", true);
                    request.setAttribute("saveBuildingInfo", building);
                    facade.addBuildingToDB(building);
                    request.setAttribute("clearAll", true);

                    forward(request, response, "/AddBuildingJSP.jsp");
                }
                break;

            case "goToViewMyBuildings":
                if (session.getAttribute("login") != null)
                {
                    Login login = (Login) session.getAttribute("login");

                    System.out.println(session.getAttribute("login").toString());
                    System.out.println(login.getFirmID());

                    try
                    {
                        if (login.getAuthorization().equals("user"))
                        {
                            request.setAttribute("listOfBuildings", facade.viewMyBuildings(Integer.parseInt(login.getFirmID())));
                        } else
                        {
                            request.setAttribute("listOfBuildings", facade.getBuildingsFromDatabase());
                        }
                    } catch (Exception ex)
                    {
                        System.out.println("test1");
                    }
                }
                forward(request, response, "/viewMyBuildingsJSP.jsp");

                break;

            case "goBackBuilding":

                forward(request, response, "/index.html");

                break;

            case "goToFirm":
                forward(request, response, "/FirmJSP.jsp");
                break;

            case "createFirm":
                if (request.getParameter("contactNumber").trim().compareTo("") == 0
                        || request.getParameter("contactMail").trim().compareTo("") == 0)
                {
                    request.setAttribute("saveFirmInfo", false);
                    forward(request, response, "/FirmJSP.jsp");
                } else
                {
                    Firm firm = new Firm(request.getParameter("contactNumber"),
                            request.getParameter("contactMail"));
                    request.setAttribute("saveFirmInfo", true);
                    facade.addFirmToDB(firm);
                    request.setAttribute("clearAll", true);

                    forward(request, response, "/FirmJSP.jsp");
                    break;
                }

            case "Report":
                goToReport(request,response);
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

            case "goToFrontPage":
                forward(request, response, "/FrontPageJSP.jsp");
                break;

            case "CheckLogin":
                String temp = "";

                if (request.getParameter("username").equals("") || request.getParameter("password").equals(""))
                {
                    request.setAttribute("doExists", false);
                    forward(request, response, "/LoginJSP.jsp");

                }

                if (facade.userExists(request.getParameter("username"), request.getParameter("password")))
                {
                    Login login = facade.getLoginByUsername(request.getParameter("username"));
                    session.setAttribute("loginAs", login.getAuthorization());
                    session.setAttribute("login", login);
                    switch (login.getAuthorization())
                    {
                        case "user":
                            forward(request, response, "/FrontPageJSP.jsp");
                            break;

                        case "tech":
                            forward(request, response, "/FrontPageJSP.jsp");
                            break;
                        case "admin":
                            forward(request, response, "/FrontPageJSP.jsp");
                            break;
                        default:
                            forward(request, response, "/Fejl.jsp");
                            break;
                    }

                } else
                {
                    request.setAttribute("doExists", false);
                    forward(request, response, "/LoginJSP.jsp");
                }
                break;

            case "goToCreateLogin":
                forward(request, response, "/OpretJSP.jsp");
                break;

            case "CreateLogin":
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
                if (request.getParameter("username").trim().compareTo("") == 0
                        || request.getParameter("password").trim().compareTo("") == 0
                        || request.getParameter("firmID").trim().compareTo("") == 0)
                {
                    request.setAttribute("saveLogin", false);
                    forward(request, response, "/OpretJSP.jsp");

                } else
                {
                    Login newLogin = new Login(request.getParameter("username"), request.getParameter("password"),
                            request.getParameter("firmID"),
                            temp2);
                    request.setAttribute("saveLogin", true);
                    facade.addLoginToDB(newLogin);
                    forward(request, response, "/OpretJSP.jsp");
                }
                break;

            case "goBackToLogin":
                forward(request, response, "/LoginJSP.jsp");

                break;
            default:
                System.out.println("Not valid command" + do_this);
                forward(request, response, "/Fejl.jsp");
                break;

        }
    }
    private void goToReport(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setAttribute("numberOfPages", "" + 1);
            request.setAttribute("nextReportNr", facade.getNextReportNr());
                forward(request, response, "/reportJSP.jsp");
    }
    
    private void useButton(HttpServletRequest request, HttpServletResponse response, HttpSession session, String button)
             throws ServletException, IOException
    {
        switch (button)
        {
            case "Delete":
                break;

            case "createReport":
                try 
                {
                    Report report;
                    int[] info = new int[3];
                    info[1] = Logic.BuildingNameToBuildingID((String) request.getAttribute("buildingNameText"));

                    if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("0")))
                    {
                        info[2] = 0;
                    }
                    if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("1")))
                    {
                        info[2] = 1;
                    }
                    if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("2")))
                    {
                        info[2] = 2;
                    }
                    if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("3")))
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
                    for (int i = 1; i < Integer.parseInt(request.getParameter("numberOfReportPages")) + 1; i++)
                    {
                        int[] raportdate = new int[3];
                        tempdate = (request.getParameter("dateDate")).split("-");
                        for (int j = 0; j < 3; j++)
                        {
                            date[j] = Integer.parseInt(tempdate[j]);
                        }
                        boolean previouslydamaged = false;
                        if (request.getParameter("damageCheckYes" + i) != null && (request.getParameter("damageCheckYes" + i)).equals("on"))
                        {
                            previouslydamaged = true;
                        }
                        String[] str = {
                                    "", "", "", ""
                                };
                        if (request.getParameter("damagePlaceText" + i) != null)
                        {

                            str[0] = request.getParameter("damagePlaceText" + i);
                        }
                        if (request.getParameter("damageCauseText" + i) != null)
                        {
                            str[1] = request.getParameter("damageCauseText" + i);
                        }
                        if (request.getParameter("reperationText" + i) != null)
                        {
                            str[2] = request.getParameter("reperationText" + i);
                        }
                        if (request.getParameter("otherDamageText" + i) != null)
                        {
                            str[3] = request.getParameter("otherDamageText" + i);
                        }
                        Boolean[] bools
                                =
                                {
                                    false, false, false, false, false
                                };
                        if (request.getParameter("moistCheck" + i) != null)
                        {
                            bools[0] = (request.getParameter("moistCheck" + i).equals("on"));
                        }
                        if (request.getParameter("rotCheck" + i) != null)
                        {
                            bools[1] = (request.getParameter("rotCheck" + i).equals("on"));
                        }
                        if (request.getParameter("moldCheck" + i) != null)
                        {
                            bools[2] = (request.getParameter("moldCheck" + i).equals("on"));
                        }
                        if (request.getParameter("fireCheck" + i) != null)
                        {
                            bools[3] = (request.getParameter("fireCheck" + i).equals("on"));
                        }
                        ArrayList<Comment> comments = new ArrayList<>();
                        if ((request.getParameter("wallCommentCheck" + i).equals("on")))
                        {
                            Part filePart = request.getPart("wallImage"); // Retrieves <input type="file" name="file">

                            if (filePart != null)
                            {
                                //filename got but not used
                                String fileName = filePart.getSubmittedFileName();
                                InputStream fileContent = filePart.getInputStream();
                                comments.add(new Comment(request.getParameter("wallCommentText"), "Report comment", ImageIO.read(fileContent)));
                            } else
                            {
                                comments.add(new Comment(request.getParameter("wallCommentText"), "Report comment"));
                            }
                        }
                        if ((request.getParameter("ceilingCommentCheck" + i).equals("on")))
                        {

                            Part filePart = request.getPart("Ceilingimage"); // Retrieves <input type="file" name="file">
                            if (filePart != null)
                            {
                                //filename got but not used
                                String fileName = filePart.getSubmittedFileName();
                                InputStream fileContent = filePart.getInputStream();
                                comments.add(new Comment(request.getParameter("ceilingCommentText"), "Report comment", ImageIO.read(fileContent)));
                            } else
                            {
                                comments.add(new Comment(request.getParameter("ceilingCommentText"), "Report comment"));
                            }
                        }
                        if ((request.getParameter("floorCommentCheck" + i).equals("on")))
                        {

                            Part filePart = request.getPart("floorimage"); // Retrieves <input type="file" name="file">
                            if (filePart != null)
                            {
                                //filename got but not used
                                String fileName = filePart.getSubmittedFileName();
                                InputStream fileContent = filePart.getInputStream();
                                comments.add(new Comment(request.getParameter("floorCommentText"), "Report comment", ImageIO.read(fileContent)));
                            } else
                            {
                                comments.add(new Comment(request.getParameter("floorCommentText"), "Report comment"));
                            }
                        }
                        if ((request.getParameter("doorCommentCheck" + i).equals("on")))
                        {

                            Part filePart = request.getPart("doorimage"); // Retrieves <input type="file" name="file">
                            if (filePart != null)
                            {
                                //filename got but not used
                                String fileName = filePart.getSubmittedFileName();
                                InputStream fileContent = filePart.getInputStream();
                                comments.add(new Comment(request.getParameter("doorCommentText"), "Report comment", ImageIO.read(fileContent)));
                            } else
                            {
                                comments.add(new Comment(request.getParameter("doorCommentText"), "Report comment"));
                            }
                        }
                        reportpage.add(new ReportPage(info[0], 0, previouslydamaged, new Date(date[0], date[1], date[2]), str[0], str[1], str[2], bools[0], bools[1], bools[2], bools[3], str[3], true, comments));
                    }
                    Comment outerWalls = null;
                    if ((request.getParameter("outerWallCommentCheck").equals("on")))
                    {
                        Part filePart = request.getPart("wallImage"); // Retrieves <input type="file" name="file">
                        if (filePart != null)
                        {
                            //filename got but not used
                            String fileName = filePart.getSubmittedFileName();
                            InputStream fileContent = filePart.getInputStream();
                            outerWalls = new Comment(request.getParameter("outerWallText"), "outerWall", ImageIO.read(fileContent));

                        } else
                        {
                            outerWalls = new Comment(request.getParameter("outerWallText"), "outerWall");
                        }
                    }
                    Comment roof = null;
                    if ((request.getParameter("roofCommentCheck").equals("on")))
                    {
                        Part filePart = request.getPart("roofImage"); // Retrieves <input type="file" name="file">
                        if (filePart != null)
                        {
                            //filename got but not used
                            String fileName = filePart.getSubmittedFileName();
                            InputStream fileContent = filePart.getInputStream();
                            roof = new Comment(request.getParameter("roofText"), "Ceiling", ImageIO.read(fileContent));

                        } else
                        {
                            roof = new Comment(request.getParameter("roofText"), "Ceiling");
                        }
                    }

                    report = new Report(info[1], new Date(date[0], date[1], date[2]), info[2], reportpage, outerWalls, roof);
                    facade.addReportToDB(report);
                    forward(request, response, "/index.html");
                } catch (Exception ex)
                {
                    ex.printStackTrace();
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
    }

    private void useComment(HttpServletRequest request, HttpServletResponse response, HttpSession session, String comment, int ID)
        throws ServletException, IOException
    {
        switch(comment)
        {
            case "Delete":
                
                break;
            case "viewReports":
                
                break;
            case "writeReport":
                request.setAttribute("BuildingID", ID);
                goToReport(request,response);
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
