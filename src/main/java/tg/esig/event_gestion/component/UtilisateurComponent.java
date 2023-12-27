package tg.esig.event_gestion.component;

import org.springframework.stereotype.Component;
import tg.esig.event_gestion.dao.UtilisateurRepository;
import tg.esig.event_gestion.model.Utilisateur;

import java.util.Optional;

@Component
public class UtilisateurComponent {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurComponent(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    public Utilisateur ajoutUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateurSave = utilisateurRepository.save(utilisateur);
        return utilisateurSave;
    }
    public Utilisateur updateUtilisateur(Utilisateur utilisateur){
        Utilisateur utilisateurSave = null;
        Optional<Utilisateur> utilisateurOld = utilisateurRepository.findById(utilisateur.getId());
        if (utilisateurOld.isPresent()){
            utilisateurOld.get().setNom(utilisateur.getNom());
            utilisateurOld.get().setPrenom(utilisateur.getPrenom());
            utilisateurOld.get().setAge(utilisateur.getAge());
            utilisateurOld.get().setLocation(utilisateur.getLocation());
            utilisateurSave = utilisateurRepository.save(utilisateurOld.get());

        }else {
            Utilisateur utilisateurNew = new Utilisateur();
            utilisateurNew.setNom(utilisateur.getNom());
            utilisateurNew.setPrenom(utilisateur.getPrenom());
            utilisateurNew.setAge(utilisateur.getAge());
            utilisateurNew.setLocation(utilisateur.getLocation());
            utilisateurSave = utilisateurRepository.save(utilisateurNew);

        }
        return utilisateurSave;
    }
    public void deleteUtilisateur(Long id){
        utilisateurRepository.deleteById(id);
    }


    public Utilisateur getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.orElse(null);
    }
}
