package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name= "brooms")
public class Broom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // stara se o autoinkrement
    private long id; // primarni klic musi byt v long

    @NotBlank(message = "SPZ NESMI byt Prazdne")
    @Size(min = 7, max = 7, message = "MAX 7 Znaku pro SPZ")
    private String licensePlate;
    private String color;

    @Min(value=2)
    @Max(value=7)
    private int numberOfSeats;

//    @OneToOne(mappedBy = "broom")
//    private Wizard wizard;

    //vlastnena strana
    @OneToMany(mappedBy = "broom")
    private List<Wizard> wizards;

//    public Broom(String color, int i, String s) {
//        this.color = color;
//        this.numberOfSeats = i;
//        this.licensePlate = s;
//    }
//    public Broom(){
//    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
