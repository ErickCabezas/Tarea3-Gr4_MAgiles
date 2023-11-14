package servlets;

import com.example.web.InscripcionCurso;
import com.example.web.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="MatriculaServlet", urlPatterns = {"/MatriculaServlet"})
public class MatriculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("cuentaUser.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Usuario user=LoginServlet.usuario;
        int nivel=user.getInscripcion().nivel;
        String horario = req.getParameter("horario");
        String fechaIni= String.valueOf(LocalDate.now().plusMonths(1));
        String fechaFin= String.valueOf(LocalDate.now().plusMonths(4));
        String notifica="";
        if(user.getInscripcion().nivel!=0) {
            if (horario.equalsIgnoreCase("0")){
                notifica="seleccione horario";
                HttpSession misesion= req.getSession();
                misesion.setAttribute("noti", notifica);
                resp.sendRedirect("matricula.jsp");
            }else {
                if (horario.equalsIgnoreCase("7-9")) {
                    user.setInscripcion(new InscripcionCurso(101, fechaIni, fechaFin, horario, 300, nivel));
                }
                if (horario.equalsIgnoreCase("9-11")) {
                    user.setInscripcion(new InscripcionCurso(102, fechaIni, fechaFin, horario, 300, nivel));
                }
                if (horario.equalsIgnoreCase("11-13")) {
                    user.setInscripcion(new InscripcionCurso(103, fechaIni, fechaFin, horario, 300, nivel));
                }
                if (horario.equalsIgnoreCase("14-16")) {
                    user.setInscripcion(new InscripcionCurso(104, fechaIni, fechaFin, horario, 300, nivel));
                }
                if (horario.equalsIgnoreCase("16-18")) {
                    user.setInscripcion(new InscripcionCurso(105, fechaIni, fechaFin, horario, 300, nivel));
                }
                if (horario.equalsIgnoreCase("18-20")) {
                    user.setInscripcion(new InscripcionCurso(106, fechaIni, fechaFin, horario, 300, nivel));
                }
                notifica=user.getInscripcion().inscribir();
                HttpSession misesion= req.getSession();
                misesion.setAttribute("noti", notifica);
                resp.sendRedirect("matricula.jsp");
            }
        }else{
            HttpSession misesion= req.getSession();
            misesion.setAttribute("userMatricula", user);
            resp.sendRedirect("examen.jsp");
        }

    }
}
