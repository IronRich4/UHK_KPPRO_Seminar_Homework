package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Wizard;
import cz.uhk.kppro.repository.WizardRepository;
import cz.uhk.kppro.service.BroomService;
import cz.uhk.kppro.service.WizardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wizards")
public class WizardController {
    private WizardService wizardService;
    private BroomService broomService;

    @Autowired
    public WizardController(WizardService wizardService, WizardRepository wizardRepository, BroomService broomService) {
        this.wizardService = wizardService;
        this.broomService = broomService;
    }

//    private ArrayList<Wizard> wizards = new ArrayList<>();        // repository pro preskoceni service vrstvy

    @GetMapping("/")
    public String listAllWizards(Model model) {
//        Wizard wizard = new Wizard("modrá",5,"8H02536");
//        wizards.add(wizard);
        model.addAttribute("wizards", wizardService.getAllWizards());
        return "wizard_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
//        Wizard wizard = wizards.get(id);
//        wizard.setId(id);
        Wizard wizard = wizardService.getWizardById(id);
        if(wizard != null){
            model.addAttribute("wizard", wizard);
            return "wizard_detail";
        }
        return "redirect:/wizards/";
//        model.addAttribute("wizard", wizard);
//        return "wizard_detail";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
//        Wizard wizard = wizards.get(id);
//        wizard.setId(id);
        Wizard wizard = wizardService.getWizardById(id);
        if(wizard != null){
            model.addAttribute("wizard", wizard);
            model.addAttribute("brooms", broomService.getAllBrooms());
            model.addAttribute("edit", true);
            return "wizard_edit";
        }
        return "redirect:/wizards/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        wizardService.deleteWizardById(id);
        return "redirect:/wizards/";
    }
    @GetMapping("/create/")
    public String create(Model model){
        model.addAttribute("wizard", new Wizard());
        model.addAttribute("brooms", broomService.getAllBrooms());
        model.addAttribute("edit", false);
        return "wizard_edit";
    }
    @PostMapping("/save/")
    public String save(@Valid Wizard wizard, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
//            model.addAttribute("edit", model.getAttribute("edit")); // prijima co uz tam bylo poslano predtim
            model.addAttribute("edit", wizard.getId() != 0);

            return "wizard_edit";
        }
        wizardService.saveWizard(wizard);
        return "redirect:/wizards/";
    }


}