package grupomateus.challenge.repositories;

import grupomateus.challenge.models.Igreja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgrejaRepository extends JpaRepository<Igreja, Long> {

}
