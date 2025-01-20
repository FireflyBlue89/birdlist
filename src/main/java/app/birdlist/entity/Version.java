package app.birdlist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Version {
    @Id
    @Column(name="ver_id")
    private int id;

    @Column(name="ver_title")
    private String title;

    @Column(name="ver_char_img")
    private Byte[] profile_image;
    
    @Column(name="ver_changelog")
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

    public Byte[] getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Byte[] profile_image) {
        this.profile_image = profile_image;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }
}
