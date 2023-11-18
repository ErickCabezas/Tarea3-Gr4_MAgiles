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
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        String opcion=solicitud.getParameter("opc");
        if(opcion.equalsIgnoreCase("cerrar")){
            respuesta.sendRedirect("index.jsp");
        }else{
            respuesta.sendRedirect("calificar.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        HttpSession miSesion= solicitud.getSession();
        miSesion.setAttribute("userMatricula",LoginServlet.usuario );
        respuesta.sendRedirect("matricula.jsp");
    }
}
