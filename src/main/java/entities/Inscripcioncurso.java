package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Inscripcioncurso {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "profesor", nullable = true)
    private Integer profesor;
    @Basic
    @Column(name = "aula", nullable = false)
    private int aula;
    @Basic
    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;
    @Basic
    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;
    @Basic
    @Column(name = "nivel", nullable = false, length = 10)
    private String nivel;
    @Basic
    @Column(name = "costo", nullable = true, precision = 0)
    private Double costo;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "inscripcionId", nullable = false)
    private Inscripcion inscripcionById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProfesor() {
        return profesor;
    }

    public void setProfesor(Integer profesor) {
        this.profesor = profesor;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscripcioncurso that = (Inscripcioncurso) o;

        if (id != that.id) return false;
        if (aula != that.aula) return false;
        if (profesor != null ? !profesor.equals(that.profesor) : that.profesor != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (nivel != null ? !nivel.equals(that.nivel) : that.nivel != null) return false;
        if (costo != null ? !costo.equals(that.costo) : that.costo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (profesor != null ? profesor.hashCode() : 0);
        result = 31 * result + aula;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        result = 31 * result + (costo != null ? costo.hashCode() : 0);
        return result;
    }

    public Inscripcion getInscripcionById() {
        return inscripcionById;
    }

    public void setInscripcionById(Inscripcion inscripcionById) {
        this.inscripcionById = inscripcionById;
    }
}
