package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name= "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // stara se o autoinkrement
    private long id; // primarni klic musi byt v long

    @NotBlank(message = "Name must not be Empty")
    @Size(min = 3, max = 20, message = "Maximum is 40 Characters")
    private String name;

    @NotBlank(message = "The House Needs its Ghostly Patron")
    @Size(min = 3, max = 20, message = "Maximum is 40 Characters")
    private String patron;

    @Min(value=10)
    @Max(value=2000)
    @Comment("The House must be able to Accomodate Students")
    private int capacity;


    //vlastnena strana
    @OneToMany(mappedBy = "house")
    private List<Wizard> wizards;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
