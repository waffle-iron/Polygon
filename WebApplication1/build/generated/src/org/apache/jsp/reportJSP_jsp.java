package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reportJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <h1>Opret rapport</h1> \r\n");
      out.write("\r\n");
      out.write("        <form id=\"myForm\" action=\"ControllerServlet\" method=\"GET\">\r\n");
      out.write("            <h2> Rapport forside </h2>\r\n");
      out.write("            <p>Rapport nummer: <input type=\"number\" name=\"reportNRtext\" \r\n");
      out.write("                                      value =\"");
      out.print( (request.getParameter("reportNRtext") == null ? "" : request.getParameter("reportNRtext")));
      out.write("\" ></p>\r\n");
      out.write("            <p>Navn på bygning: <input type=\"text\" name=\"buildingNameText\"\r\n");
      out.write("                                       value =\"");
      out.print( (request.getParameter("buildingNameText") == null ? "" : request.getParameter("buildingNameText")));
      out.write("\"></p>\r\n");
      out.write("            <p>Dato: <input type=\"date\" name=\"dateDate\"\r\n");
      out.write("                            value =\"");
      out.print( (request.getParameter("dateDate") == null ? "" : request.getParameter("dateDate")));
      out.write("\"></p>\r\n");
      out.write("            <p>Adresse: <input type=\"text\" name=\"adressText\"\r\n");
      out.write("                               value =\"");
      out.print( (request.getParameter("adressText") == null ? "" : request.getParameter("adressText")));
      out.write("\"></p>\r\n");
      out.write("            <p>Postnr./by: <input type=\"text\" name=\"zipText\"\r\n");
      out.write("                                  value =\"");
      out.print( (request.getParameter("zipText") == null ? "" : request.getParameter("zipText")));
      out.write("\"></p>\r\n");
      out.write("\r\n");
      out.write("            <p><b>Generel information om bygningen</b></p>\r\n");
      out.write("            <p>Byggeår <input type=\"number\" name=\"buildYearNum\" value =\"");
      out.print( (request.getParameter("buildYearNum") == null ? "" : request.getParameter("buildYearNum")));
      out.write("\"></p>\r\n");
      out.write("            <p>Bygningsareal i m<sup>2</sup> <br>\r\n");
      out.write("                (hver etage tælles seperat) <input type=\"number\" name=\"buildingAreaNum\" value =\"");
      out.print( (request.getParameter("buildingAreaNum") == null ? "0" : request.getParameter("buildingAreaNum")));
      out.write("\"></p>\r\n");
      out.write("            <p>Hvad bruges bygningen til/<br>\r\n");
      out.write("                hvad har bygningen været brugt til? <input type=\"text\" name=\"usageText\" value =\"");
      out.print( (request.getParameter("usageText") == null ? "" : request.getParameter("usageText")));
      out.write("\"\r\n");
      out.write("                                                           ></p>\r\n");
      out.write("            <p><b>Gennemgang af bygningen udvendig</b></p>\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th></th>\r\n");
      out.write("                        <th>Bemærkninger</th>\r\n");
      out.write("                        <th>Ingen bemærkninger</th>\r\n");
      out.write("                        <th>Billede</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Tag</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"roofCommentCheck\"></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"roofNoCommentCheck\"></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"roofPictureCheck\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"4\"><input type=\"text\" name=\"roofText\" size=\"90\" value =\"");
      out.print( (request.getParameter("roofText") == null ? "" : request.getParameter("roofText")));
      out.write("\"\r\n");
      out.write("                                               ></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("            <br>\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th></th>\r\n");
      out.write("                        <th>Bemærkninger</th>\r\n");
      out.write("                        <th>Ingen bemærkninger</th>\r\n");
      out.write("                        <th>Billede</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Ydervægge</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"outerWallCommentCheck\"></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"outerWallNoCommentCheck\"></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"outerWallPictureCheck\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"4\"><input type=\"text\" name=\"outerWallText\" size=\"90\" value =\"");
      out.print( (request.getParameter("outerWallText") == null ? "" : request.getParameter("outerWallText")));
      out.write("\"\r\n");
      out.write("                                               ></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <h2> Rapport side <input type=\"number\" name=\"numberOfReportPages\" value =\"");
      out.print( (request.getParameter("numberOfReportPages") == null ? "1" : request.getParameter("numberOfReportPages")));
      out.write("\"\r\n");
      out.write("                                     ></h2><input type=\"submit\"  value=\"Opdater sideantal\" name=\"button\" />\r\n");
      out.write("            <input type=\"hidden\" name =\"do_this\" value=\"useButton\">\r\n");
      out.write("\r\n");
      out.write("            <p>Rapport nummer: <input type=\"number\" name=\"reportNRNum\" value=\"");
      out.print( request.getAttribute("reportNRNum"));
      out.write("\" ></p>\r\n");
      out.write("                ");
 int pages = 0;
                    pages += Integer.parseInt((String) request.getAttribute("numberOfPages"));
                    for (int i = 1; i < pages + 1; i++)
                    {
                
      out.write("\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Har der været<br>\r\n");
      out.write("                            skade i lokalet?</td>\r\n");
      out.write("                        <td colspan=\"3\"><p> Ja <input type=\"checkbox\" name=\"damageCheckYes\" /></p>\r\n");
      out.write("                            <p> Nej <input type=\"checkbox\" name=\"damageCheckNo\"/></p></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Hvornår?</td>\r\n");
      out.write("                        <td><input type=\"date\" name=\"damageDate\"></td>\r\n");
      out.write("                        <td>Hvor?</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"damagePlaceText\" value =\"");
      out.print( (request.getParameter("damagePlaceText") == null ? "" : request.getParameter("damagePlaceText")));
      out.write("\"\r\n");
      out.write("                                   ></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Hvad er der sket?</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"damageCauseText\" value =\"");
      out.print( (request.getParameter("damageCauseText") == null ? "" : request.getParameter("damageCauseText")));
      out.write("\"\r\n");
      out.write("                                   ></td>\r\n");
      out.write("                        <td>Hvad er repereret?</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"reperationText\"value =\"");
      out.print( (request.getParameter("reperationText") == null ? "" : request.getParameter("reperationText")));
      out.write("\"\r\n");
      out.write("                                   ></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Skade</td>\r\n");
      out.write("                        <td colspan=\"3\"><p><input type=\"checkbox\" name=\"moistCheck\" />Fugt</p>\r\n");
      out.write("                            <p><input type=\"checkbox\" name=\"rotCheck\" />Råd og Svamp</p>\r\n");
      out.write("                            <p><input type=\"checkbox\" name=\"moldCheck\" />Skimmel</p>\r\n");
      out.write("                            <p><input type=\"checkbox\" name=\"fireCheck\" />Brand</p>\r\n");
      out.write("                            <p><input type=\"checkbox\" name=\"otherDamageCheck\" />Anden skade:</p>  <input type=\"text\" name=\"otherDamageText\" size=\"100\" value =\"");
      out.print( (request.getParameter("otherDamageText") == null ? "" : request.getParameter("otherDamageText")));
      out.write("\"\r\n");
      out.write("                                                                                                         > </td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("            <p><b>Skade:</b> </p>\r\n");
      out.write("            <p><input type=\"checkbox\" name=\"moistCheck\" />Fugt</p>\r\n");
      out.write("            <p><input type=\"checkbox\" name=\"rotCheck\" />Råd og Svamp</p>\r\n");
      out.write("            <p><input type=\"checkbox\" name=\"moldCheck\" />Skimmel</p>\r\n");
      out.write("            <p><input type=\"checkbox\" name=\"fireCheck\" />Brand</p>\r\n");
      out.write("            <p><input type=\"checkbox\" name=\"otherDamageCheck\" />Anden skade:</p>  <input type=\"text\" name=\"otherDamageText\" size=\"100\" value =\"");
      out.print( (request.getParameter("otherDamageText") == null ? "" : request.getParameter("otherDamageText")));
      out.write("\"\r\n");
      out.write("                                                                                         >\r\n");
      out.write("            <p><b>Gennemgang af...</b></p>\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th></th>\r\n");
      out.write("                        <th>Bemærkninger</th>\r\n");
      out.write("                        <th>Ingen bemærkninger</th>\r\n");
      out.write("                        <th>Billede</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Vægge</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"wallCommentCheck\"/></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"wallNoCommentCheck\"/></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"4\"><input type=\"text\" name=\"wallCommentText\" size=\"80\"> </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Loft</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"ceilingCommentCheck\"/></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"ceilingNoCommentCheck\"/></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"4\"><input type=\"text\" name=\"ceilingCommentText\" size=\"80\"> </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Gulv</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"floorCommentCheck\"/></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"floorNoCommentCheck\"/></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"4\"><input type=\"text\" name=\"floorCommentText\" size=\"80\"> </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Vinduer/døre</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"doorCommentCheck\"/></td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"doorNoCommentCheck\"/></td>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"4\"><input type=\"text\" name=\"doorCommentText\" size=\"80\"> </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <p><b>Fugtscanning</b></p>\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Er der foretaget fugtscanning?</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"scanYesCheck\"/></td>\r\n");
      out.write("                        <td colspan=\"2\"><input type=\"checkbox\" name=\"scanNoCheck\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Fugtscanning:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"moistText\"/></td>\r\n");
      out.write("                        <td>Målepunkt:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"measureText\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"4\"><input type=\"text\" name=\"moistScanText\" size=\"90\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("            <p><b>Konklusion</b></p>\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th><b>Lokale</b></th>\r\n");
      out.write("                        <th><b>Anbefalinger</b></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><input type=\"text\" name=\"conlusionRoomText1\"/></td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"conlusionRecomText1\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><input type=\"text\" name=\"conlusionRoomText2\"/></td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"conlusionRecomText2\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><input type=\"text\" name=\"conlusionRoomText3\"/></td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"conlusionRecomText3\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("            <p>Bygningsgennemgangen er foretaget af<input type=\"text\" name=\"technicianText\"/>, <br>Polygon\r\n");
      out.write("                i samarbejde med <input type=\"text\" name=\"responsibleText\"/>(bygningsansvarlig).\r\n");
      out.write("            </p>\r\n");
      out.write("            <p><b>Bygningen er kategoriseret som</b></p>\r\n");
      out.write("            <table border=\"1\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Tilstand</th>\r\n");
      out.write("                        <th>Beskrivelse af bygningen</th>\r\n");
      out.write("                        <th>Funktion af bygningen</th>\r\n");
      out.write("                        <th>Tilstandsgrad</th>\r\n");
      out.write("\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Tilstandsgrad 0</b></td>\r\n");
      out.write("                        <td>Bygningsdelen er ny og som bygget</td>\r\n");
      out.write("                        <td>Funktionen er som beskrevet</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"state0Check\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Tilstandsgrad 1</b></td>\r\n");
      out.write("                        <td>Bygningsdelen er intakt, men med<br>\r\n");
      out.write("                            begyndende slid og synlige skader<br>\r\n");
      out.write("                            (kun kosmetiske skader)</td>\r\n");
      out.write("                        <td>Funktionen er som beskrevet</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"state1Check\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Tilstandsgrad 2</b></td>\r\n");
      out.write("                        <td>Bygningsdelen er begyndt at forfalde<br>\r\n");
      out.write("                            med enkelte defekte komponenter</td>\r\n");
      out.write("                        <td>Funktionen er nedsat-<br>\r\n");
      out.write("                            fare for følgeskader</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"state2Check\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><b>Tilstandsgrad 3</b></td>\r\n");
      out.write("                        <td>Bygningsdelen er nedbrugt og skal<br>\r\n");
      out.write("                            udskiftes</td>\r\n");
      out.write("                        <td>Funktionen er ophørt-<br>\r\n");
      out.write("                            fare for følgeskader</td>\r\n");
      out.write("                        <td><input type=\"checkbox\" name=\"state3Check\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <input type=\"button\" value=\"createReport\" name=\"button\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
