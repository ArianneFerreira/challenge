package grupomateus.challenge.models;

import javax.persistence.*;

@Entity
@Table(name ="igreja_servico")
public class IgrejaServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_igreja")
    private Igreja igreja;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    //---------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
