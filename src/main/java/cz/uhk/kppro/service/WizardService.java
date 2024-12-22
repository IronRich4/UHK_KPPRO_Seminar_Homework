package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Wizard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WizardService {
    List<Wizard> getAllWizards();
    Wizard getWizardById(long id);
    void deleteWizardById(long id);
    void saveWizard(Wizard wizard);
}
