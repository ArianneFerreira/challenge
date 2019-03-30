package grupomateus.challenge.repositories;

import grupomateus.challenge.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario>findAllByIgrejaServicoId(Long idIgrejaServico);

}
