package cz.uhk.kppro.repository; // komunikace mezi vrstvami DATASOURCE a SERVICE

import cz.uhk.kppro.model.Broom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BroomRepository extends JpaRepository<Broom, Long> {
    Long Id(long id);   // ma připravené metody

    // příklady případů užití :)

//    List<Broom> getAllByColorContainsIgnoreCase(String color);
//    Broom getBroomByColor(String color);
//    List<Broom> getBroomsByNumberOfSeatsBetweenAndColorContainsIgnoreCase(String from, String to, String color);

}
