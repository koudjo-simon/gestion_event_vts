package tg.esig.event_gestion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tg.esig.event_gestion.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findUtilisateurByNom(String Nom);

    @Query(value = "SELECT * FROM utilisateur WHERE nom=?1", nativeQuery = true)
    Utilisateur findNom(String nom);
}
