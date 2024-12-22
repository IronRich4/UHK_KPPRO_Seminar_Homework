package cz.uhk.kppro.repository; // komunikace mezi vrstvami DATASOURCE a SERVICE

import cz.uhk.kppro.model.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WizardRepository extends JpaRepository<Wizard, Long> {

    // příklady případů užití :)

//    List<Car> getAllByColorContainsIgnoreCase(String color);
//    Car getCarByColor(String color);
//    List<Car> getCarsByNumberOfSeatsBetweenAndColorContainsIgnoreCase(String from, String to, String color);

}
