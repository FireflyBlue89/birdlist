package app.birdlist.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class Characters {
    @Id
    @Column(name="char_name")
    private String name;

    @Column(name="char_profile")
    private Byte[] profile_image;
    
    @Column(name="char_desc")
    private String description;

    @OneToMany
    private List<Outfits> outfits;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Byte[] getProfile_image() {
        return profile_image;
    }
    public void setProfile_image(Byte[] profile_image) {
        this.profile_image = profile_image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Outfits> getOutfits() {
        return outfits;
    }
    public void setOutfits(List<Outfits> outfits) {
        this.outfits = outfits;
    }
}