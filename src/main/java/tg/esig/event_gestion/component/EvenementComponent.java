package tg.esig.event_gestion.component;

import org.springframework.stereotype.Component;
import tg.esig.event_gestion.dao.EvenementRepository;
import tg.esig.event_gestion.model.Evenement;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.List;
import java.util.Optional;

@Component
public class EvenementComponent {

    private EvenementRepository evenementRepository;


    public EvenementComponent(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public List<Evenement> afficheEvent(){
        List<Evenement> evenements = evenementRepository.findAll();
        return evenements;
    }

    public Evenement ajoutEvenement(Evenement evenement){
        Evenement evenementSave = evenementRepository.save(evenement);
        return evenementSave;
    }

    public Evenement updateEvenement(Evenement evenement){
        Evenement evenementSave = null;
        Optional<Evenement> evenementOld = evenementRepository.findById(evenement.getId());
        if (evenementOld.isPresent()){
            evenementOld.get().setEventname(evenement.getEventname());
            evenementOld.get().setAuthor(evenement.getAuthor());
            evenementOld.get().setEventdate(evenement.getEventdate());
            evenementOld.get().setEventplace(evenement.getEventplace());
            evenementSave = evenementRepository.save(evenementOld.get());

        }else {
            Evenement evenementNew = new Evenement();
            evenementNew.setEventname(evenement.getEventname());
            evenementNew.setAuthor(evenement.getAuthor());
            evenementNew.setEventdate(evenement.getEventdate());
            evenementNew.setEventplace(evenement.getEventplace());
            evenementSave = evenementRepository.save(evenementNew);

        }
        return evenementSave;
    }
    public void deleteEvenement(Long id){
        evenementRepository.deleteById(id);
    }


    public Evenement getEvenementById(Long id) {
        Optional<Evenement> evenementOptional = evenementRepository.findById(id);
        return evenementOptional.orElse(null);
    }
}
