package grupomateus.challenge.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Temporal(TemporalType.TIME)
    @Column
    private Date horaInicial;

    @Temporal(TemporalType.TIME)
    @Column
    private Date horaFinal;

    @ManyToOne
    @JoinColumn(name = "id_igreja_servico")
    private IgrejaServico igrejaServico;

    @ManyToOne
    @JoinColumn(name = "id_dia_semana")
    private DiaSemana diaSemana;

    //---------------------------------------------------------------


    public Long getId() {
        return id;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public IgrejaServico getIgrejaServico() {
        return igrejaServico;
    }

    public void setIgrejaServico(IgrejaServico igrejaServico) {
        this.igrejaServico = igrejaServico;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }
}
