package Controller;

import DataAccess.Facade;
import Domain.Building;
import Domain.Comment;
import Domain.CommentImage;
import Domain.Date;
import Domain.Firm;
import Domain.Login;
import Domain.Report;
import Domain.ReportPage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
            request.setAttribute("fejlMeddelse", "videre sendelse havde ikke en valid string på den næste page");
            forward(request, response, "/Fejl.jsp");
        }
        switch (do_this)
        {

            case "useButton":
                // <editor-fold defaultstate="collapsed" desc="My Fold">
                String button = "";
                button += request.getParameter("button");
                if (button.equals(""))
                {
                    forward(request, response, "/Fejl.jsp");
                }
                useButton(request, response, session, button);
                 // </editor-fold>
                break;

            case "useHidden":
                // <editor-fold defaultstate="collapsed" desc="My Fold">
                String commentPair = "";
                commentPair += request.getParameter("Comment");
                if(commentPair.equals(""))
                {
                    forward(request, response, "/Fejl.jsp");
                }
                    
                String[] commentPaired = commentPair.split(",");
                useHidden(request, response, session, commentPaired[0], Integer.parseInt(commentPaired[1]));
                 // </editor-fold>
                break;

            case "CheckLogin":
                // <editor-fold defaultstate="collapsed" desc="My Fold">

                if (request.getParameter("username").equals("") || request.getParameter("password").equals(""))
                {
                    request.setAttribute("doExists", false);
                    forward(request, response, "/Login.jsp");

                }

                if (facade.userExists(request.getParameter("username"), request.getParameter("password")))
                {
                    Login login = facade.getLoginByUsername(request.getParameter("username"));
                    session.setAttribute("loginAs", login.getAuthorization());
                    session.setAttribute("login", login);
                    request.getParameter("username");
                
                    switch (login.getAuthorization())
                    {
                        case "user":
                            

                        case "tech":
                            
                        case "admin":
                            forward(request, response, "/FrontPage.jsp");
                            break;
                        default:
                            request.setAttribute("fejlMeddelse","dit login har ikke en authority snak med en admin om det");
                            forward(request, response, "/Fejl.jsp");
                            break;
                    }

                } else
                {
                    request.setAttribute("doExists", false);
                    forward(request, response, "/Login.jsp");
                }
                // </editor-fold>
                break;

            case "CreateLogin":
                // <editor-fold defaultstate="collapsed" desc="My Fold">
                String temp2 = "";
                if (request.getParameter("enum") != null)
                {
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
                } else
                {
                    temp2 = "user";
                }
                if (request.getParameter("username").trim().compareTo("") == 0
                        || request.getParameter("password").trim().compareTo("") == 0
                        || request.getParameter("firmID").trim().compareTo("") == 0)
                {
                    request.setAttribute("saveLogin", false);
                    request.setAttribute("listOfFirmID", (facade.viewAllFirms()));
                    forward(request, response, "/AddUser.jsp");
                } else
                {
                    Login newLogin = new Login(request.getParameter("username"), request.getParameter("password"),
                            request.getParameter("firmID"),
                            temp2);
                    request.setAttribute("saveLogin", true);
                    facade.addLoginToDB(newLogin);
                    request.setAttribute("listOfFirmID", (facade.viewAllFirms()));
                    forward(request, response, "/AddUser.jsp");
                }
                // </editor-fold>
                break;

            case "goToViewMyBuildings":
                if (session.getAttribute("login") != null)
                {
                    Login login = (Login) session.getAttribute("login");

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
                        ex.toString();
                    }
                }
                forward(request, response, "/ViewBuildings.jsp");
                break;

            case "createBuild":
                // <editor-fold defaultstate="collapsed" desc="My Fold">
                if (request.getParameter("buildAddress").trim().compareTo("") == 0
                        || request.getParameter("buildZip").trim().compareTo("") == 0
                        || request.getParameter("buildFirmID").trim().compareTo("") == 0
                        || request.getParameter("buildName").trim().compareTo("") == 0
                        || request.getParameter("buildYear").trim().compareTo("") == 0
                        || request.getParameter("buildSize").trim().compareTo("") == 0
                        || request.getParameter("buildUsage").trim().compareTo("") == 0)
                {
                   
                    forward(request, response, "/AddBuilding.jsp");

                } else
                {
                    Building building = new Building(request.getParameter("buildAddress"),
                            request.getParameter("buildName"),
                            request.getParameter("buildUsage"),
                            Integer.parseInt(request.getParameter("buildZip")),
                            Integer.parseInt(request.getParameter("buildFirmID")),
                            Integer.parseInt(request.getParameter("buildYear")),
                            Integer.parseInt(request.getParameter("buildSize")));
                    request.setAttribute("Done", true);

                    
                    try
                    {
                        facade.addBuildingToDB(building);
                        request.setAttribute("saveBuilding", true);
                    request.setAttribute("clearAll", true);
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                    
                    forward(request, response, "/AddBuilding.jsp");
                }// </editor-fold>
                break;

            case "createFirm":
                if (request.getParameter("contactNumber").trim().compareTo("") == 0
                        || request.getParameter("contactMail").trim().compareTo("") == 0)
                {
                    request.setAttribute("saveFirmInfo", false);
                    forward(request, response, "/AddFirm.jsp");
                } else
                {
                    Firm firm = new Firm(request.getParameter("contactNumber"),
                            request.getParameter("contactMail"));
                    request.setAttribute("saveFirmInfo", true);
                    facade.addFirmToDB(firm);
                    request.setAttribute("saveFirmInfo", true);

                    request.setAttribute("clearAll", true);

                    forward(request, response, "/AddFirm.jsp");
                    break;
                }
            case "Report":
                goToReport(request, response);
                break;

            case "changeReport":
                try
                {
                    ArrayList<Integer> reportIDList = facade.getListogReportIDsByBuildingID(Integer.parseInt(request.getParameter("buildingID")));
                    String str = facade.getSingleBuildingByID(Integer.parseInt(request.getParameter("buildingID"))).getAddress();
                        request.setAttribute("Adresse", str);
                    request.setAttribute("reportIDList", reportIDList);
                    
                    viewReport(Integer.parseInt(request.getParameter("Option")), request, response);
                } catch (Exception e)
                {

                }
                break;

            default:
                request.setAttribute("fejlMeddelse","du blev ikke sendt til en valid side"
                        + "" );
                forward(request, response, "/Fejl.jsp");
                break;
        }
    }

    private void useButton(HttpServletRequest request, HttpServletResponse response, HttpSession session, String button)
            throws ServletException, IOException
    {
        switch (button)
        {
            case "Opret nyt login":
                request.setAttribute("listOfFirmID", (facade.viewAllFirms()));
                forward(request, response, "/AddUser.jsp");
                break;

            case "Forside":
                forward(request, response, "/FrontPage.jsp");
                break;
                
            case "Logud":
                session.setAttribute("login", null);
                session.setAttribute("loginAs", null);
                session.setAttribute("building", null);
                forward(request, response, "/Login.jsp");
                break;

            case "Vis bygninger":
                // <editor-fold defaultstate="collapsed" desc="My Fold">
                if (session.getAttribute("login") != null)
                {
                    Login login = (Login) session.getAttribute("login");
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
                    }
                }
                forward(request, response, "/ViewBuildings.jsp");
// </editor-fold>
                break;

            case "Opret bygning":
                
                forward(request, response, "/AddBuilding.jsp");
                break;

            case "Vis alle firmaer":
                request.setAttribute("listOfFirms", facade.viewAllFirms());
                forward(request, response, "/ViewFirms.jsp");
                break;

            case "Opret nyt firma":
                forward(request, response, "/AddFirm.jsp");
                break;

            case "Opret rapport":
                // <editor-fold defaultstate="collapsed" desc="My Fold">
                try
                {
                    
                    Report report;
                    int[] info = new int[3];
                    
                    if (session.getAttribute("building") != null)
                    {
                        Building building = ((Building) session.getAttribute("building"));
                        info[1] = building.getBuildingID();
                    }
                    if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("0")))
                    {
                        info[2] = 0;
                    }
                    else if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("1")))
                    {
                        info[2] = 1;
                    }
                    else if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("2")))
                    {
                        info[2] = 2;
                    }
                    else if ((request.getParameter("stateCheck")) != null && (request.getParameter("stateCheck").equals("3")))
                    {
                        info[2] = 3;
                    }
                    else 
                    {
                        info[2] = 0;
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
                        String[] str =
                        {
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
                                comments.add(new Comment(request.getParameter("wallCommentText"), "Report comment", new CommentImage(ImageIO.read(fileContent), filePart, fileContent)));
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
                                comments.add(new Comment(request.getParameter("ceilingCommentText"), "Report comment", new CommentImage(ImageIO.read(fileContent), filePart, fileContent)));
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
                                comments.add(new Comment(request.getParameter("floorCommentText"), "Report comment", new CommentImage(ImageIO.read(fileContent), filePart, fileContent)));
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
                                comments.add(new Comment(request.getParameter("doorCommentText"), "Report comment", new CommentImage(ImageIO.read(fileContent), filePart, fileContent)));
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
                            outerWalls = new Comment(request.getParameter("outerWallText"), "outerWall", new CommentImage(ImageIO.read(fileContent), filePart, fileContent));

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
                            roof = new Comment(request.getParameter("roofText"), "Ceiling", new CommentImage(ImageIO.read(fileContent), filePart, fileContent));

                        } else
                        {
                            roof = new Comment(request.getParameter("roofText"), "Ceiling");
                        }
                    }

                    report = new Report(info[1], new Date(date[0], date[1], date[2]), info[2], reportpage, outerWalls, roof);
                    facade.addReportToDB(report);
                    request.setAttribute("saveReport", true);
                    goToReport(request, response);
                } catch (ServletException e)
                {
                    request.setAttribute("fejlMeddelse", "der skete en fejl i den generele kode fra den ene side til den anden, vi kender ikke en mulig årsag til denne fejl"
                            + ". hvis venligst en teknikker følgende besked" + "<br>" + e.toString());
                    request.setAttribute("goBackTo", "writeReport");
                    forward(request, response, "/Fejl.jsp");
                } catch (NumberFormatException e)
                {
                    request.setAttribute("fejlMeddelse", "der skete en fejl da vi prøvede at forvanlde informationen i en text box til tal, dette kan ske hvis du skriver et e i tal boxene eller alle datoer ikke er sat"
                            + ". hvis venligst en teknikker følgende besked" + "<br>" + e.toString());
                    request.setAttribute("goBackTo", "writeReport");
                    forward(request, response, "/Fejl.jsp");
                } catch (IOException e)
                {
                    request.setAttribute("fejlMeddelse", "programmet forsøgte at læse en fil der blev ændret mens den læste den vi foreslår du bare går tilbage og prøver igen. hvis dette sker igen "
                            + " hvis venligst en teknikker følgende besked" + "<br>" + e.toString());
                    request.setAttribute("goBackTo", "writeReport");
                    forward(request, response, "/Fejl.jsp");
                }
// </editor-fold>
                break;

            case "Opdater side antal":
                request.setAttribute("nextReportNr", facade.getNextReportNr());
                request.setAttribute("numberOfPages", "" + request.getParameter("numberOfReportPages"));
                forward(request, response, "/AddReport.jsp");
                break;

            case "Kontakt":
                forward(request, response, "/Contact.jsp");
                break;

            default:
                forward(request, response, "/Fejl.jsp");
                break;
        }
    }

    private void useHidden(HttpServletRequest request, HttpServletResponse response, HttpSession session, String comment, int ID)
            throws ServletException, IOException
    {
        switch (comment)
        {
            case "viewReports":
                try
                {
                    ArrayList<Integer> reportIDList = facade.getListogReportIDsByBuildingID(ID);
                    if (reportIDList.size() != 0)
                    {
                        String str = facade.getSingleBuildingByID(ID).getAddress();
                        request.setAttribute("Adresse", str);
                        request.setAttribute("reportIDList", reportIDList);
                        viewReport(reportIDList.get(reportIDList.size() - 1), request, response);
                    } else
                    {
                        request.setAttribute("fejlMeddelse", "Der findes ingen rapport til denne bygning.");
                        request.setAttribute("goBackTo", "viewMyBuildings");
                        forward(request, response, "/Fejl.jsp");
                    }
                } catch (ClassNotFoundException e)
                {
                    request.setAttribute("fejlMeddelse", "programmet kunne ikke finde en klasse, vi kan ikke forklare hvorfor da dette ikke burde ske, "
                            + "men hvis venligst din tekniker følgende besked: \"<br>\""
                            + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                } catch (NumberFormatException e)
                {
                    request.setAttribute("fejlMeddelse", "programmet fik en fejl da den proevede at forvanlde et bogstav saet til et tal saet, "
                            + "dette kan ske hvis du skriver tekst i en tal box eller hvis der ern en fejl i databsen"
                            + "hvis venligst en teknikker foelgende besked" + "<br>" + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                } catch (SQLException e)
                {
                    request.setAttribute("fejlMeddelse", "der var en fejl med at enten hente eller skrive til serveren, "
                            + "hvis det var skrive til kan det vaere fordi du har skrevet tegn der ville afslutte vores kode, som fx "
                            + "; \" eller ` \"<br>\""
                            + "hvis venligst en teknikker foelgende besked" + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                }
                break;

            case "writeReport":
                try
                {
                    session.setAttribute("building", facade.getSingleBuildingByID(ID));
                    
                    goToReport(request, response);
                } catch (ClassNotFoundException e)
                {
                    request.setAttribute("fejlMeddelse", "programmet kunne ikke finde en klasse, vi kan ikke forklare hvorfor da dette ikke burde ske, men hvis venligst din tekniker følgende besked: \"<br>\""
                            + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                } catch (NumberFormatException e)
                {
                    request.setAttribute("fejlMeddelse", "programmet fik en fejl da den proevede at forvanlde et bogstav saet til et tal saet, dette kan ske hvis du skriver tekst i en tal box eller hvis der ern en fejl i databsen"
                            + "hvis venligst en teknikker foelgende besked" + "<br>" + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                } catch (SQLException e)
                {
                    request.setAttribute("fejlMeddelse", "der var en fejl med at enten hente eller skrive til serveren, hvis det var skrive til kan det vaere fordi du har skrevet tegn der ville afslutte vores kode, som fx ; \" eller ` \"<br>\""
                            + "hvis venligst en teknikker foelgende besked" + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                }
                break;

            case "uploadFloorPlan":
                request.setAttribute("BuildingID", ID);
                forward(request, response, "/UploadFloorPlan.jsp");
                break;

            case "Delete":
                try
                {
                    facade.removeBuilding(ID);
                    if (session.getAttribute("login") != null)
                    {
                        Login login = (Login) session.getAttribute("login");
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

                        }
                    }
                    forward(request, response, "/ViewBuildings.jsp");
                } catch (ClassNotFoundException e)
                {
                    request.setAttribute("fejlMeddelse", "programmet kunne ikke finde en klasse, vi kan ikke forklare hvorfor da dette ikke burde ske, men hvis venligst din tekniker følgende besked: \"<br>\""
                            + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                } catch (SQLException e)
                {
                    request.setAttribute("fejlMeddelse", "der skete en fejl da vi ville slette bygningen fra databasen, vi ved dog ikke hvorfor" + "hvis venligst en teknikker foelgende besked" + e.toString());
                    request.setAttribute("goBackTo", "viewBuildings");
                    forward(request, response, "/Fejl.jsp");
                }
                break;
        }
    }

    private void goToReport(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (request.getAttribute("numberOfPages") == null)
        {
            request.setAttribute("numberOfPages", "" + 1);
        }
        request.setAttribute("nextReportNr", facade.getNextReportNr());
        forward(request, response, "/AddReport.jsp");
    }

    private void viewReport(int reportid, HttpServletRequest request, HttpServletResponse response)
    {

        Report report = facade.getReportFromDB(reportid);

        if (report != null)
        {
            request.setAttribute("report", report);
        } else
        {
            try
            {
                request.setAttribute("fejlMeddelse", "programmet kunne ikke finde en klasse, vi kan ikke forklare hvorfor da dette ikke burde ske, men hvis venligst din tekniker følgende besked: \"<br>\"");
                    request.setAttribute("goBackTo", "viewBuildings");
                forward(request, response, "/Fejl.jsp");
            } catch (IOException | ServletException ex)
            {
                ex.printStackTrace();
            }
        }
        try
        {
            forward(request, response, "/ViewReport.jsp");
        } catch (IOException | ServletException ex)
        {
            ex.printStackTrace();
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
