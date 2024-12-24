package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Wand;
import cz.uhk.kppro.repository.WandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Bez ANOTACE se nejdna o Java Bean
public class WandServiceImpl implements WandService{

    private WandRepository wandRepository;

    @Autowired
    public WandServiceImpl(WandRepository wandRepository){
        this.wandRepository = wandRepository;
    }

    @Override
    public List<Wand> getAllWands() {
        return wandRepository.findAll();
    }

    @Override
    public Wand getWandById(long id) {
        return wandRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteWandById(long id) {
        Optional<Wand> wand = wandRepository.findById(id);
        if(wand.isPresent()){
            wandRepository.delete(wand.get());
        }
    }

    @Override
    public void saveWand(Wand wand) {
        wandRepository.save(wand); // pokud existuje pouze se aktualizuje diky Primary Key
    }
}
