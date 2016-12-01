package br.com.cwi.crescer.exfilmesaula5;

import br.com.cwi.crescer.exfilmesaula5.entity.Filme;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author regis
 */
@WebServlet(name = "filme", urlPatterns = {"/filme"})
public class FilmeServlet extends HttpServlet {

    @EJB
    private FilmeBean filmeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.append("<table class=\"table table-hover\"><thead><tr><th>Nome</th></tr></thead><tbody>");
            
            filmeBean.findAll().forEach(f-> {
                out.append("<tr><td>").append(f.getTitulo()).append("</td></tr>");
            });
            
            out.append("</tbody></table>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String titulo = req.getParameter("titulo");
        if (titulo != null) {
            final Filme filme = new Filme();
            filme.setTitulo(titulo);
            filmeBean.insert(filme);
        }
        resp.sendRedirect("/exFilmesAula5");
    }

    
    
}
