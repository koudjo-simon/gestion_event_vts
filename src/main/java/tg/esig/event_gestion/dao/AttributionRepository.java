package tg.esig.event_gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tg.esig.event_gestion.model.Attribution;

public interface AttributionRepository extends JpaRepository<Attribution, Long> {
    Attribution findAttributionById(Long id);
    @Query(value = "SELECT * FROM attribution WHERE id=?1", nativeQuery = true)
    Attribution findId(Long id);

}
