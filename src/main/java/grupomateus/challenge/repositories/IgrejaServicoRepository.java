package grupomateus.challenge.repositories;

import grupomateus.challenge.models.Igreja;
import grupomateus.challenge.models.IgrejaServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IgrejaServicoRepository extends JpaRepository<IgrejaServico, Long> {

    List<IgrejaServico> findAllByIgreja(Igreja igreja);
    IgrejaServico findByIgrejaIdAndServicoId(Long idIgreja, Long idServico);

}
