package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Wizard;
import cz.uhk.kppro.repository.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Bez ANOTACE se nejdna o Java Bean
public class WizardServiceImpl implements WizardService {

    private WizardRepository wizardRepository;

    @Autowired
    public WizardServiceImpl(WizardRepository wizardRepository){
        this.wizardRepository = wizardRepository;
    }

    @Override
    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    @Override
    public Wizard getWizardById(long id) {
        return wizardRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteWizardById(long id) {
        Optional<Wizard> wizard = wizardRepository.findById(id);
        if(wizard.isPresent()){
            wizardRepository.delete(wizard.get());
        }
    }

    @Override
    public void saveWizard(Wizard wizard) {
        wizardRepository.save(wizard); // pokud existuje pouze se aktualizuje diky Primary Key
    }
}
