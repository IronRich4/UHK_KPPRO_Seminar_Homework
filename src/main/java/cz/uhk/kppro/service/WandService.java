package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Wand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WandService {
    List<Wand> getAllWands();
    Wand getWandById(long id);
    void deleteWandById(long id);
    void saveWand(Wand wand);
}
