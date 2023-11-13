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

@WebServlet(name="CalificarServlet", urlPatterns = {"/CalificarServlet"})
public class CalificarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario= req.getParameter("usuario");
        int nivel= Integer.parseInt(req.getParameter("nivel")) ;
        Usuario user=LoginServlet.gestor_usuario.buscarUsuario(usuario);
        System.out.println(user);
        if(user!=null){
            HttpSession misesion= req.getSession();
            misesion.setAttribute("Notificacion","usuario calificado");
            user.setNivel(nivel);
            resp.sendRedirect("calificar.jsp");
        }else{
            HttpSession misesion= req.getSession();
            misesion.setAttribute("Notificacion","no existe el estudiante con ese usuario");
            resp.sendRedirect("calificar.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}