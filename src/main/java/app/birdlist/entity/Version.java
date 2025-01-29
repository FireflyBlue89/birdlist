package app.birdlist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "versions")
public class Version {
    @Id
    @Column(name="ver_id")
    private int id;

    @Column(name="ver_title")
    private String title;

    @Column(name="ver_date", columnDefinition="DATE")
    private String date;

    @Lob
    @Column(name="ver_char_img", columnDefinition="MEDIUMBLOB")
    private byte[] profile_image;
    
    @Column(name="ver_changelog", columnDefinition="VARCHAR(1000)")
    private String changelog;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte[] getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(byte[] profile_image) {
        this.profile_image = profile_image;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }
}
