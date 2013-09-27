/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.blWC.servlets;

import ads.blWC.cliente.BuscaLugaresWS;
import ads.blWC.cliente.BuscaLugaresWS_Service;
import ads.blWC.cliente.Lugar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julião
 */
@WebServlet(name = "BuscaLugaresServlet", urlPatterns = {"/BuscaLugaresServlet"})
public class BuscaLugaresServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (request.getParameter("Place_Search") != null) {
            String busqueda = request.getParameter("query");
            String ciudad = request.getParameter("place");
            String tipo = request.getParameter("type");

            HttpSession session = request.getSession(true);
            session.setAttribute("query", busqueda);

            try {
                /* TODO output your page here. You may use following sample code. */

                BuscaLugaresWS_Service service = new BuscaLugaresWS_Service();
                BuscaLugaresWS port = service.getBuscaLugaresWSPort();

                List<Lugar> lugares = new ArrayList<>(port.placeSearch(busqueda, ciudad, tipo));

                if (lugares.size() != 0) {

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>PlaceSearch Results</title>");

                    out.println("<style type=\"text/css\">");
                    out.println("html{");
                    out.println("background-image: url(resources/paradise3.jpg);");
                    out.println("font-family: cursive;");
                    out.println("font-weight: bolder;");
                    out.println("font-style: italic;");
                    out.println("font-size: larger;}");
                    out.println("</style>");

                    out.println("</head>");
                    out.println("<body>");

                    out.println("<script>");
                    out.println("function submitter(btn) {");
                    out.println("var reference = btn.parentElement.id;");
                    out.println("var searchForm = document.forms[\"searchForm\"];");
                    out.println("searchForm.elements[\"Place_Details\"].value = \"Go\";");
                    out.println("searchForm.elements[\"reference\"].value = reference;");
                    out.println("searchForm.submit(); }");
                    out.println("</script>");

                    out.println("<center>");
                    out.println("<h1>Places Search Results for \"" + busqueda + "\"</h1>");
                    out.println("<form id=\"searchForm\" name=\"searchForm\" action=\"BuscaLugaresServlet\" method=\"POST\">");
                    out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"10\" align=\"center\">");
                    out.println("<input type=\"hidden\" name=\"reference\" />");
                    out.println("<input type=\"hidden\" name=\"Place_Details\" />");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>Icon</th>");
                    out.println("<th>Name</th>");
                    out.println("<th>Address</th>");
                    out.println("<th>Rating</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    for (int i = 0; i < lugares.size(); i++) {
                        out.println("<tr>");
                        out.println("<td id=\"" + lugares.get(i).getReferencia() + "\">");
                        out.println("<input type=\"image\" src=\"" + lugares.get(i).getIcono() + "\" onclick=\"submitter(this)\" />");
                        out.println("</td>");
                        out.println("<td>" + lugares.get(i).getNombre() + "</td>");
                        out.println("<td>" + lugares.get(i).getDireccion() + "</td>");
                        out.println("<td>" + lugares.get(i).getClasificacion() + "</td>");
                        out.println("</tr>");
                    }

                    out.println("</tbody>");
                    out.println("</table>");
                    out.println("</form>");
                    out.println("<h6>Click on Place's icon for Details</h6>");
                    out.println("<br/>");
                    out.println("<INPUT Type=\"button\" VALUE=\"Go Back\" onClick=\"history.go(-1);return true;\">");
                    out.println("</center>");
                    out.println("</body>");
                    out.println("</html>");
                } else {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>PlaceSearch Results</title>");
                    out.println("<meta http-equiv=\"refresh\" content=\"3; url=index.jsp\" /> ");
                    out.println("<style type=\"text/css\">");
                    out.println("html{");
                    out.println("background-image: url(resources/paradise3.jpg);");
                    out.println("font-family: cursive;");
                    out.println("font-weight: bolder;");
                    out.println("font-style: italic;");
                    out.println("font-size: larger;}");
                    out.println("</style>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<h1>No Results for \"" + busqueda + "\"</h1>");
                    out.println("<h3>Please make sure that all words are spelled correctly</h3>");
                    out.println("</center>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (Exception e) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>No PlaceSearch Results</title>");
                out.println("<meta http-equiv=\"refresh\" content=\"3; url=index.jsp\" /> ");
                out.println("<style type=\"text/css\">");
                out.println("html{");
                out.println("background-image: url(resources/paradise3.jpg);");
                out.println("font-family: cursive;");
                out.println("font-weight: bolder;");
                out.println("font-style: italic;");
                out.println("font-size: larger;}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<center>");
                out.println("<h1>Invalid Request for \"" + busqueda + "\"</h1>");
                out.println("<h3>Service must be unreachable</h3>");
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }

        if (request.getParameter("Place_Details") != null) {
            String referencia = request.getParameter("reference");

            try {
                /* TODO output your page here. You may use following sample code. */

                BuscaLugaresWS_Service service = new BuscaLugaresWS_Service();
                BuscaLugaresWS port = service.getBuscaLugaresWSPort();

                Lugar lugar = new Lugar();
                lugar = port.placeDetails(referencia);

                HttpSession session = request.getSession();

                session.setAttribute("name", lugar.getNombre());
                session.setAttribute("formatted_Address", lugar.getDireccion());
                session.setAttribute("icon", lugar.getIcono());
                session.setAttribute("formatted_phone_number", lugar.getNumeroTelefonoF());
                session.setAttribute("international_phone_number", lugar.getNumeroTelefonoI());
                session.setAttribute("vecinity", lugar.getVecindario());
                session.setAttribute("url", lugar.getUrl());
                session.setAttribute("rating", lugar.getClasificacion());
                session.setAttribute("webSite", lugar.getWeb());

                response.sendRedirect("result.jsp");
            } finally {
                out.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
