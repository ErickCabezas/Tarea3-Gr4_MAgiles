package servlets;

import com.example.web.InscripcionCurso;
import com.example.web.InscripcionExamen;
import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="ExamenServlet", urlPatterns = {"/ExamenServlet"})
public class ExamenServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario user=LoginServlet.usuario;
        String horario = req.getParameter("horario");
        String notifica="";
        if(user.getInscripcion().nivel!=0) {
            if (horario.equalsIgnoreCase("0")){
                notifica="seleccione horario";
                HttpSession misesion= req.getSession();
                misesion.setAttribute("noti", notifica);
                resp.sendRedirect("examen.jsp");
            }else {
                user.setInscripcion(new InscripcionExamen(horario));
                notifica=user.getInscripcion().inscribir();
                HttpSession misesion= req.getSession();
                misesion.setAttribute("noti", notifica);
                resp.sendRedirect("examen.jsp");
            }
        }else{
            HttpSession misesion= req.getSession();
            misesion.setAttribute("noti", "si ya dio el examen espere la calificacion");
            resp.sendRedirect("examen.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
