package grupomateus.challenge.models;

import javax.persistence.*;

@Entity
@Table(name="igreja")
public class Igreja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String paroco;

    @Column
    private String telefone;

    @Column
    private String descricao;

    //---------------------------------------------------------------------------
    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getParoco() {
        return paroco;
    }

    public void setParoco(String paroco) {
        this.paroco = paroco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}
