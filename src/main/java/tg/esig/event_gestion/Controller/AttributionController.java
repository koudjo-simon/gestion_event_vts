package tg.esig.event_gestion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tg.esig.event_gestion.component.AttributionComponent;
import tg.esig.event_gestion.component.EvenementComponent;
import tg.esig.event_gestion.component.Test;
import tg.esig.event_gestion.component.UtilisateurComponent;
import tg.esig.event_gestion.model.Attribution;
import tg.esig.event_gestion.model.Evenement;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.List;

@Controller
public class AttributionController {
    private AttributionComponent attributionComponent;
    private UtilisateurComponent utilisateurComponent;
    private EvenementComponent evenementComponent;
    private Test test;

    public AttributionController(AttributionComponent attributionComponent, UtilisateurComponent utilisateurComponent, EvenementComponent evenementComponent, Test test) {
        this.attributionComponent = attributionComponent;
        this.utilisateurComponent = utilisateurComponent;
        this.evenementComponent = evenementComponent;
        this.test = test;
    }

    @GetMapping("/getAttribution")
    public String getAttribution(Model model){
        List<Attribution> attributions = attributionComponent.afficheAttribution();
        model.addAttribute("listAttributions", attributions);
        model.addAttribute("event", evenementComponent.afficheEvent());
        model.addAttribute("personne", test.getInfo());
        return "attribution";

    }

    @GetMapping("/insertAttribution")
    public String insertAttribution(Long utilisateur_id, Long evenement_id, String statut, RedirectAttributes redirectAttributes){
        if (utilisateur_id == null || evenement_id == null) {
            redirectAttributes.addFlashAttribute("save_error", "Echec saisie");
            return "redirect:/getAttribution";
        } else {
            Utilisateur utilisateur = utilisateurComponent.getUtilisateurById(utilisateur_id);
            Evenement evenement = evenementComponent.getEvenementById(evenement_id);

            Attribution attribution = new Attribution();
            attribution.setUtilisateur(utilisateur);
            attribution.setEvenement(evenement);
            attribution.setStatut(statut);

            attributionComponent.ajoutAttribution(attribution);

            redirectAttributes.addFlashAttribute("save_success", "Saisie validée avec succès");
            return "redirect:/getAttribution";
        }
    }



}
