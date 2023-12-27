package tg.esig.event_gestion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tg.esig.event_gestion.component.EvenementComponent;
import tg.esig.event_gestion.component.Test;
import tg.esig.event_gestion.component.UtilisateurComponent;
import tg.esig.event_gestion.model.Evenement;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.List;

@Controller
public class EvenementController {
    private EvenementComponent evenementComponent;
    private UtilisateurComponent utilisateurComponent;
    private Test test;

    public EvenementController(EvenementComponent evenementComponent, UtilisateurComponent utilisateurComponent, Test test) {
        this.evenementComponent = evenementComponent;
        this.utilisateurComponent = utilisateurComponent;
        this.test = test;
    }

    @GetMapping("/getEvenement")
    public String getEvenement(Model model){
        List<Evenement> evenements = evenementComponent.afficheEvent();
        model.addAttribute("listEvenements", evenements);
        model.addAttribute("personne", test.getInfo());
        return "evenement";

    }

    @PostMapping("/inserteEvenement")
    public String insertUtilisateur(@RequestParam("eventname") String eventnames, String author, String eventdate, String eventplace, RedirectAttributes redirectAttributes){
        if (eventnames.isEmpty() || author.isEmpty() || eventdate.isEmpty() || eventplace.isEmpty()){
            redirectAttributes.addFlashAttribute("save_error", "Echec saisie");
            return "redirect:/getEvenement";

        }else {
            Evenement evenement = new Evenement();
            evenement.setEventname(eventnames);
            evenement.setAuthor(author);
            evenement.setEventdate(eventdate);
            evenement.setEventplace(eventplace);
            Evenement evenementSave = evenementComponent.ajoutEvenement(evenement);
            redirectAttributes.addFlashAttribute("save_success", "Saisie Validée avec succès");
            return "redirect:/getEvenement";
        }

    }

    @GetMapping("/updateEvenement")
    public String updateEvenement(Long id, String eventname, String author, String eventdate, String eventplace, RedirectAttributes redirectAttributes){
        if (eventname.isEmpty() || author.isEmpty() || eventdate.isEmpty() || eventplace.isEmpty()){
            redirectAttributes.addFlashAttribute("save_error", "Echec saisie");
            return "redirect:/getEvenement";
        }else{
            Evenement evenement = new Evenement();
            evenement.setId(id);
            evenement.setEventname(eventname);
            evenement.setAuthor(author);
            evenement.setEventdate(eventdate);
            evenement.setEventplace(eventplace);
            Evenement evenementUpdate = evenementComponent.updateEvenement(evenement);
            redirectAttributes.addFlashAttribute("save_update", "Mise à jour effectué avec succès");
            return "redirect:/getEvenement";
        }
    }

    @GetMapping("/deleteEvenement")
    public String deleteEvenement(Long id, RedirectAttributes redirectAttributes){
        evenementComponent.deleteEvenement(id);
        redirectAttributes.addFlashAttribute("delete_success", "Suppression Effectué avec succès");
        return "redirect:/getEvenement";
    }
}
