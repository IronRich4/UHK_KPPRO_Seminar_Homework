package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name= "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // stara se o autoinkrement
    private long id; // primarni klic musi byt v long

    @NotBlank(message = "House Name Must Be Entered")
    @Size(min = 3, max = 40, message = "Has to be at Least 3 Letters")
    private String name;

    @NotBlank(message = "The House Needs a Patron")
    private String patron;

    @Min(value = 1)
    @Max(value = 250)
    private int capacity;

    //vlastnena strana
    @OneToMany(mappedBy = "house")
    private List<Wizard> wizards;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}

