package tg.esig.event_gestion.component;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import tg.esig.event_gestion.dao.AttributionRepository;
import tg.esig.event_gestion.dao.EvenementRepository;
import tg.esig.event_gestion.dao.UtilisateurRepository;
import tg.esig.event_gestion.model.Attribution;
import tg.esig.event_gestion.model.Evenement;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.List;
import java.util.Optional;

@Component
public class Test {
    private final UtilisateurRepository utilisateurRepository;
    private final EvenementRepository evenementRepository;
    private AttributionRepository attributionRepository;

    public Test(UtilisateurRepository utilisateurRepository, EvenementRepository evenementRepository, AttributionRepository attributionRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.evenementRepository = evenementRepository;
        this.attributionRepository = attributionRepository;
    }
    @PostConstruct
    public void afficheAttribution() {
        Attribution attribution = attributionRepository.findId(1L);
            //attribution.setEvenement();

        System.out.println("attribution afficher: "+attribution);
    }

  //  @PostConstruct
   // public void InsetsUtilisateur(){
     //   Utilisateur utilisateur= new Utilisateur();
     //   utilisateur.setNom("SALOU");
     //   utilisateur.setPrenom("Kadji");
    //    utilisateur.setAge(25);
     //   utilisateur.setLocation("Be-Kpota");
     //   Utilisateur utilisateurSave = utilisateurRepository.save(utilisateur);
      //  System.out.println("Utilisateur inserer" + utilisateurSave);
       // Utilisateur utilisateur = utilisateurRepository.findNom("SALOU");
     //   utilisateur.setAge(20);

        //Utilisateur utilisateur1 = utilisateurRepository.save((utilisateur));

       // System.out.println("utilisateur afficher: "+utilisateur);


  //  }
    //@PostConstruct
    public void InsertEvenement(){

        Evenement evenement = new Evenement();
        evenement.setEventname("Happy run");
        evenement.setAuthor("Brad Pitt");
        evenement.setEventdate("12/07/2023");
        evenement.setEventplace("baguida");
        Evenement evenementSave = evenementRepository.save(evenement);
        System.out.println("Evenement inserer:"+evenementSave );
    }
    public String afficheInfo(){
        List<Utilisateur> utilisateurs= utilisateurRepository.findAll();
        return utilisateurs.toString();
    }


    public List<Utilisateur> getInfo(){
        List<Utilisateur> utilisateurs= utilisateurRepository.findAll();
        return utilisateurs;
    }

}