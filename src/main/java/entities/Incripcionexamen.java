package entities;

import jakarta.persistence.*;

@Entity
public class Incripcionexamen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "horario", nullable = false, length = 50)
    private String horario;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "inscripcionId", nullable = false)
    private Inscripcion inscripcionById;

    public Incripcionexamen(String horario) {
        this.horario = horario;
    }

    public Incripcionexamen(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Incripcionexamen that = (Incripcionexamen) o;

        if (id != that.id) return false;
        if (horario != null ? !horario.equals(that.horario) : that.horario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        return result;
    }

    public Inscripcion getInscripcionById() {
        return inscripcionById;
    }

    public void setInscripcionById(Inscripcion inscripcionById) {
        this.inscripcionById = inscripcionById;
    }
}
