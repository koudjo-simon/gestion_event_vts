package tg.esig.event_gestion.component;

import org.springframework.stereotype.Component;
import tg.esig.event_gestion.dao.AttributionRepository;
import tg.esig.event_gestion.model.Attribution;
import tg.esig.event_gestion.model.Evenement;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.List;

@Component
public class AttributionComponent {

    private AttributionRepository attributionRepository;

    public AttributionComponent(AttributionRepository attributionRepository) {
        this.attributionRepository = attributionRepository;
    }

    public List<Attribution> afficheAttribution(){
        List<Attribution> attributions = attributionRepository.findAll();
        return attributions;
    }

    public Attribution ajoutAttribution(Attribution attribution) {
        Attribution attributionSave = attributionRepository.save(attribution);
        return attributionSave;
    }
}