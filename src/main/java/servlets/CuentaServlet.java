package servlets;

import com.example.web.Gestor_Usuario;
import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="CuentaServlet", urlPatterns = {"/CuentaServlet"})
public class CuentaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opc=req.getParameter("opc");
        if(opc.equalsIgnoreCase("cerrar")){
            resp.sendRedirect("index.jsp");
        }else{
            resp.sendRedirect("calificar.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession misesion= req.getSession();
        misesion.setAttribute("userMatricula",LoginServlet.usuario );
        resp.sendRedirect("matricula.jsp");
    }
}
