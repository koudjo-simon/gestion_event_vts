package tg.esig.event_gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tg.esig.event_gestion.model.Evenement;

public interface EvenementRepository  extends JpaRepository<Evenement,Long> {
    Evenement findEvenementByEventname(String nom);

    @Query(value = "SELECT * FROM evenement WHERE eventname=?1", nativeQuery = true)
    Evenement findEventname(String eventname);
}
