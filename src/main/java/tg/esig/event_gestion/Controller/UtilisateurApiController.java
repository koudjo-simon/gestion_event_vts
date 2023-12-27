package tg.esig.event_gestion.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tg.esig.event_gestion.component.Test;
import tg.esig.event_gestion.component.UtilisateurComponent;
import tg.esig.event_gestion.dao.UtilisateurRepository;
import tg.esig.event_gestion.model.Utilisateur;

@RestController
public class UtilisateurApiController {
    private  Test test;
    private UtilisateurComponent utilisateurComponent;

    public UtilisateurApiController(Test test, UtilisateurComponent utilisateurComponent) {
        this.test = test;
        this.utilisateurComponent = utilisateurComponent;
    }

    @GetMapping("/afficheUtilisateur")
    public String afficheUtilisateur(){
        String info = test.afficheInfo();
        return info;
    }

    @PostMapping("/ajoutUtilisateur")
    public Utilisateur ajoutUtilisateur(@RequestBody Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }else {
            Utilisateur utilisateurSave = utilisateurComponent.ajoutUtilisateur(utilisateur);
            return utilisateurSave;
        }

    }

    @PostMapping("/updateUtilisateur")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }else{
            Utilisateur utilisateur1 = utilisateurComponent.updateUtilisateur(utilisateur);
            return utilisateur1;
        }
    }
}
