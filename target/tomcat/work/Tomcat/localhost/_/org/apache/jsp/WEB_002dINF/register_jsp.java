/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-05-27 12:54:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;chareset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("    \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\"></script>\n");
      out.write("  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\n");
      out.write("  <style>\n");
      out.write("    body {\n");
      out.write("      color: #fff;\n");
      out.write("      background: #3598dc;\n");
      out.write("      font-family: 'Roboto', sans-serif;\n");
      out.write("    }\n");
      out.write("    .form-control {\n");
      out.write("      height: 41px;\n");
      out.write("      background: #f2f2f2;\n");
      out.write("      box-shadow: none !important;\n");
      out.write("      border: none;\n");
      out.write("    }\n");
      out.write("    .form-control:focus {\n");
      out.write("      background: #e2e2e2;\n");
      out.write("    }\n");
      out.write("    .form-control, .btn {\n");
      out.write("      border-radius: 3px;\n");
      out.write("    }\n");
      out.write("    .signup-form {\n");
      out.write("      width: 400px;\n");
      out.write("      margin: 30px auto;\n");
      out.write("    }\n");
      out.write("    .signup-form form {\n");
      out.write("      color: #999;\n");
      out.write("      border-radius: 3px;\n");
      out.write("      margin-bottom: 15px;\n");
      out.write("      background: #fff;\n");
      out.write("      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\n");
      out.write("      padding: 30px;\n");
      out.write("    }\n");
      out.write("    .signup-form h2  {\n");
      out.write("      color: #333;\n");
      out.write("      font-weight: bold;\n");
      out.write("      margin-top: 0;\n");
      out.write("    }\n");
      out.write("    .signup-form hr  {\n");
      out.write("      margin: 0 -30px 20px;\n");
      out.write("    }\n");
      out.write("    .signup-form .form-group {\n");
      out.write("      margin-bottom: 20px;\n");
      out.write("    }\n");
      out.write("    .signup-form input[type=\"checkbox\"] {\n");
      out.write("      margin-top: 3px;\n");
      out.write("    }\n");
      out.write("    .signup-form .row div:first-child {\n");
      out.write("      padding-right: 10px;\n");
      out.write("    }\n");
      out.write("    .signup-form .row div:last-child {\n");
      out.write("      padding-left: 10px;\n");
      out.write("    }\n");
      out.write("    .signup-form .btn {\n");
      out.write("      font-size: 16px;\n");
      out.write("      font-weight: bold;\n");
      out.write("      background: #3598dc;\n");
      out.write("      border: none;\n");
      out.write("      min-width: 140px;\n");
      out.write("    }\n");
      out.write("    .signup-form .btn:hover, .signup-form .btn:focus {\n");
      out.write("      background: #2389cd !important;\n");
      out.write("      outline: none;\n");
      out.write("    }\n");
      out.write("    .signup-form a {\n");
      out.write("      color: #fff;\n");
      out.write("      text-decoration: underline;\n");
      out.write("    }\n");
      out.write("    .signup-form a:hover {\n");
      out.write("      text-decoration: none;\n");
      out.write("    }\n");
      out.write("    .signup-form form a {\n");
      out.write("      color: #3598dc;\n");
      out.write("      text-decoration: none;\n");
      out.write("    }\n");
      out.write("    .signup-form form a:hover {\n");
      out.write("      text-decoration: underline;\n");
      out.write("    }\n");
      out.write("    .signup-form .hint-text  {\n");
      out.write("      padding-bottom: 15px;\n");
      out.write("      text-align: center;\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"signup-form\">\n");
      out.write("  <form action=\"register\" method=\"post\">\n");
      out.write("    <h2>Inscription chez MyOffers</h2>\n");
      out.write("    <hr>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col\"><input type=\"text\" class=\"form-control\" name=\"prenom\" placeholder=\"Prenom\" required=\"required\"></div>\n");
      out.write("        <div class=\"col\"><input type=\"text\" class=\"form-control\" name=\"nom\" placeholder=\"Nom\" required=\"required\"></div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <input type=\"email\" class=\"form-control\" name=\"login\" placeholder=\"Email\" required=\"required\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <input type=\"email\" class=\"form-control\" name=\"tel\" placeholder=\"tÃ©lÃ©phone\" required=\"required\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"mot de passe\" required=\"required\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <input type=\"password\" class=\"form-control\" name=\"confirm_password\" placeholder=\"Confirmer le mot de passe\" required=\"required\">\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <label class=\"form-check-label\"><input type=\"checkbox\" required=\"required\"> j'accepte les  <a href=\"#\">les termes d'utilisation</a> &amp; <a href=\"#\">politique de confidentialitÃ©</a></label>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("      <button type=\"submit\" class=\"btn btn-primary btn-lg\">Inscrire</button>\n");
      out.write("    </div>\n");
      out.write("  </form>\n");
      out.write("  <div class=\"hint-text\">DÃ©ja inscrit? <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login\">Connectez-vous ici</a></div>\n");
      out.write("</div>\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
