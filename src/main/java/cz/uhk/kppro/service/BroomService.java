package cz.uhk.kppro.service;

import cz.uhk.kppro.model.Broom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BroomService {
    List<Broom> getAllBrooms();
    Broom getBroomById(long id);
    void deleteBroomById(long id);
    void saveBroom(Broom broom);
}
