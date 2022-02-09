package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import fu.ex.dtos.RoomDTO;
import java.util.ArrayList;

public final class computerform_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Create a new computer</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <h1>ADD NEW COMPUTER INFORMATION</h1>\n");
      out.write("      <form action=\"\" method=\"POST\">\n");
      out.write("         <table width=\"600px\" border=\"0px solid\">\n");
      out.write("            <tr>\n");
      out.write("               <td>ID</td>\n");
      out.write("               <td>:<input type=\"text\" name=\"txtID\" value=\"\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               <td>CPU</td>\n");
      out.write("               <td>:<input type=\"text\" name=\"txtCPU\" value=\"\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               <td>Hard Disk</td>\n");
      out.write("               <td>:<input type=\"text\" name=\"txtHardDisk\" value=\"\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               <td>RAM</td>\n");
      out.write("               <td>:<input type=\"text\" name=\"txtRAM\" value=\"\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               <td>VGA</td>\n");
      out.write("               <td>:<input type=\"text\" name=\"txtVGA\" value=\"\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               <td>Monitor</td>\n");
      out.write("               <td>:<input type=\"text\" name=\"txtMonitor\" value=\"\" /></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               <td>Room</td>\n");
      out.write("               <td>:<select name=\"cboRoom\">\n");
      out.write("\n");
      out.write("                  </select>\n");
      out.write("               </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("               <td colspan=\"2\"><input type=\"submit\" value=\"Create\"></td>\n");
      out.write("            </tr>\n");
      out.write("         </table>\n");
      out.write("      </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
