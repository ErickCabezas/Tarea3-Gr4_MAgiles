package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Inscripcion {
    @Basic
    @Column(name = "fechaInscripcion", nullable = false)
    private Date fechaInscripcion;
    @Basic
    @Column(name = "horario", nullable = false, length = 10)
    private String horario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inscripcionId", nullable = false)
    private int inscripcionId;
    @Basic
    @Column(name = "usuario", nullable = true)
    private Integer usuario;
    @Basic
    @Column(name = "nivel", nullable = false)
    private int nivel;
    @OneToOne(mappedBy = "inscripcionById")
    private Incripcionexamen incripcionexamenByInscripcionId;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "usuarioId", insertable=false, updatable=false)
    private Usuario usuarioByUsuario;
    @OneToOne(mappedBy = "inscripcionById")
    private Inscripcioncurso inscripcioncursoByInscripcionId;
    @OneToMany(mappedBy = "inscripcionByInscripcion")
    private Collection<Usuario> usuariosByInscripcionId;


    public Inscripcion(Date fechaInscripcion, String horario, Usuario usuarioByUsuario, int nivel, Incripcionexamen incripcionexamenByInscripcionId) {
        this.fechaInscripcion = fechaInscripcion;
        this.horario = horario;
        this.usuarioByUsuario = usuarioByUsuario;
        this.nivel = nivel;
        this.incripcionexamenByInscripcionId = incripcionexamenByInscripcionId;
    }

    public Inscripcion(){

    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(int inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscripcion that = (Inscripcion) o;

        if (inscripcionId != that.inscripcionId) return false;
        if (nivel != that.nivel) return false;
        if (fechaInscripcion != null ? !fechaInscripcion.equals(that.fechaInscripcion) : that.fechaInscripcion != null)
            return false;
        if (horario != null ? !horario.equals(that.horario) : that.horario != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fechaInscripcion != null ? fechaInscripcion.hashCode() : 0;
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        result = 31 * result + inscripcionId;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + nivel;
        return result;
    }

    public Incripcionexamen getIncripcionexamenByInscripcionId() {
        return incripcionexamenByInscripcionId;
    }

    public void setIncripcionexamenByInscripcionId(Incripcionexamen incripcionexamenByInscripcionId) {
        this.incripcionexamenByInscripcionId = incripcionexamenByInscripcionId;
    }

    public Usuario getUsuarioByUsuario() {
        return usuarioByUsuario;
    }

    public void setUsuarioByUsuario(Usuario usuarioByUsuario) {
        this.usuarioByUsuario = usuarioByUsuario;
    }

    public Inscripcioncurso getInscripcioncursoByInscripcionId() {
        return inscripcioncursoByInscripcionId;
    }

    public void setInscripcioncursoByInscripcionId(Inscripcioncurso inscripcioncursoByInscripcionId) {
        this.inscripcioncursoByInscripcionId = inscripcioncursoByInscripcionId;
    }

    public Collection<Usuario> getUsuariosByInscripcionId() {
        return usuariosByInscripcionId;
    }

    public void setUsuariosByInscripcionId(Collection<Usuario> usuariosByInscripcionId) {
        this.usuariosByInscripcionId = usuariosByInscripcionId;
    }
}
