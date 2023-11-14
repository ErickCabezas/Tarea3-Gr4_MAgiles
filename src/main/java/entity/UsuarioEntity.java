package entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Usuario.usuarios", query = "SELECT u FROM UsuarioEntity u")
@Table(name = "usuario", schema = "proyectoma", catalog = "")
public class UsuarioEntity {
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @Basic
    @Column(name = "ci")
    private String ci;
    @Basic
    @Column(name = "correo")
    private String correo;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "modoUsuario")
    private String modoUsuario;
    @Basic
    @Column(name = "nivel")
    private int nivel;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuarioId")
    private int usuarioId;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getModoUsuario() {
        return modoUsuario;
    }

    public void setModoUsuario(String modoUsuario) {
        this.modoUsuario = modoUsuario;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity usuario = (UsuarioEntity) o;

        if (nivel != usuario.nivel) return false;
        if (usuarioId != usuario.usuarioId) return false;
        if (nombre != null ? !nombre.equals(usuario.nombre) : usuario.nombre != null) return false;
        if (apellido != null ? !apellido.equals(usuario.apellido) : usuario.apellido != null) return false;
        if (ci != null ? !ci.equals(usuario.ci) : usuario.ci != null) return false;
        if (correo != null ? !correo.equals(usuario.correo) : usuario.correo != null) return false;
        if (telefono != null ? !telefono.equals(usuario.telefono) : usuario.telefono != null) return false;
        if (modoUsuario != null ? !modoUsuario.equals(usuario.modoUsuario) : usuario.modoUsuario != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", ci='" + ci + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", modoUsuario='" + modoUsuario + '\'' +
                ", nivel=" + nivel +
                ", usuarioId=" + usuarioId +
                '}';
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (ci != null ? ci.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (modoUsuario != null ? modoUsuario.hashCode() : 0);
        result = 31 * result + nivel;
        result = 31 * result + usuarioId;
        return result;
    }
}
