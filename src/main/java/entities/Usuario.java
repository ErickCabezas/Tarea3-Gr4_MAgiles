package entities;

import entities.Inscripcion;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@NamedQuery(name = "Usuario.usuarios", query = "SELECT u FROM Usuario u")
@Table(name = "usuario", schema = "proyectoma")
public class Usuario {
    @Id
    @Column(name = "usuarioId", nullable = false)
    private int usuarioId;
    @Basic
    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;
    @Basic
    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic
    @Column(name = "ci", nullable = false, length = 10)
    private String ci;
    @Basic
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;
    @Basic
    @Column(name = "telefono", nullable = false)
    private int telefono;
    @Basic
    @Column(name = "modoUsuario", nullable = false, length = 10)
    private String modoUsuario;
    @Basic
    @Column(name = "inscripcion", nullable = true)
    private Integer inscripcion;
    @OneToMany(mappedBy = "usuarioByUsuario")
    private Collection<Inscripcion> inscripcionsByUsuarioId;
    @ManyToOne
    @JoinColumn(name = "inscripcion", referencedColumnName = "inscripcionId", insertable = false, updatable = false)
    private Inscripcion inscripcionByInscripcion;

    public Usuario(String usuario, String contrasena, String nombre, String apellido, String ci, String correo, int telefono, String modoUsuario, Inscripcion inscripcionByInscripcion) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.correo = correo;
        this.telefono = telefono;
        this.modoUsuario = modoUsuario;
        this.inscripcionByInscripcion = inscripcionByInscripcion;
    }

    public Usuario(){

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ci='" + ci + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                ", modoUsuario='" + modoUsuario + '\'' +
                ", inscripcion=" + inscripcion +
                ", inscripcionsByUsuarioId=" + inscripcionsByUsuarioId +
                ", inscripcionByInscripcion=" + inscripcionByInscripcion +
                '}';
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getModoUsuario() {
        return modoUsuario;
    }

    public void setModoUsuario(String modoUsuario) {
        this.modoUsuario = modoUsuario;
    }

    public Integer getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Integer inscripcion) {
        this.inscripcion = inscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario1 = (Usuario) o;

        if (usuarioId != usuario1.usuarioId) return false;
        if (telefono != usuario1.telefono) return false;
        if (usuario != null ? !usuario.equals(usuario1.usuario) : usuario1.usuario != null) return false;
        if (contrasena != null ? !contrasena.equals(usuario1.contrasena) : usuario1.contrasena != null) return false;
        if (nombre != null ? !nombre.equals(usuario1.nombre) : usuario1.nombre != null) return false;
        if (apellido != null ? !apellido.equals(usuario1.apellido) : usuario1.apellido != null) return false;
        if (ci != null ? !ci.equals(usuario1.ci) : usuario1.ci != null) return false;
        if (correo != null ? !correo.equals(usuario1.correo) : usuario1.correo != null) return false;
        if (modoUsuario != null ? !modoUsuario.equals(usuario1.modoUsuario) : usuario1.modoUsuario != null)
            return false;
        if (inscripcion != null ? !inscripcion.equals(usuario1.inscripcion) : usuario1.inscripcion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usuarioId;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (ci != null ? ci.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + telefono;
        result = 31 * result + (modoUsuario != null ? modoUsuario.hashCode() : 0);
        result = 31 * result + (inscripcion != null ? inscripcion.hashCode() : 0);
        return result;
    }

    public Collection<Inscripcion> getInscripcionsByUsuarioId() {
        return inscripcionsByUsuarioId;
    }

    public void setInscripcionsByUsuarioId(Collection<Inscripcion> inscripcionsByUsuarioId) {
        this.inscripcionsByUsuarioId = inscripcionsByUsuarioId;
    }

    public Inscripcion getInscripcionByInscripcion() {
        return inscripcionByInscripcion;
    }

    public void setInscripcionByInscripcion(Inscripcion inscripcionByInscripcion) {
        this.inscripcionByInscripcion = inscripcionByInscripcion;
    }
}