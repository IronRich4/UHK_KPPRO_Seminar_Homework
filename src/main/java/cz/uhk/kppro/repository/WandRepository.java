package cz.uhk.kppro.repository; // komunikace mezi vrstvami DATASOURCE a SERVICE

import cz.uhk.kppro.model.Wand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WandRepository extends JpaRepository<Wand, Long> {
    Long Id(long id);   // ma připravené metody

    // příklady případů užití :)

//    List<Wand> getAllByColorContainsIgnoreCase(String color);
//    Wand getWandByColor(String color);
//    List<Wand> getWandsByNumberOfSeatsBetweenAndColorContainsIgnoreCase(String from, String to, String color);

}
