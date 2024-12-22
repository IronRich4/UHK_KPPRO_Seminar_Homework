package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Broom;
import cz.uhk.kppro.repository.BroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Bez ANOTACE se nejdna o Java Bean
public class BroomServiceImpl implements BroomService{

    private BroomRepository broomRepository;

    @Autowired
    public BroomServiceImpl(BroomRepository broomRepository){
        this.broomRepository = broomRepository;
    }

    @Override
    public List<Broom> getAllBrooms() {
        return broomRepository.findAll();
    }

    @Override
    public Broom getBroomById(long id) {
        return broomRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBroomById(long id) {
        Optional<Broom> broom = broomRepository.findById(id);
        if(broom.isPresent()){
            broomRepository.delete(broom.get());
        }
    }

    @Override
    public void saveBroom(Broom broom) {
        broomRepository.save(broom); // pokud existuje pouze se aktualizuje diky Primary Key
    }
}
