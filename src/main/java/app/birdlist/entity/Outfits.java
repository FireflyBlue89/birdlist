package app.birdlist.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Outfits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="outfit_id")
    private int id;

    @Column(name="outfit_name")
    private String name;

    @OneToMany
    private List<Version> versions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
