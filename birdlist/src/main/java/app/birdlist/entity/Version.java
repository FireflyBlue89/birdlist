package app.birdlist.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "versions")
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ver_id")
    private int id;

    @Column(name="ver_char")
    private String charName;

    @Column(name="ver_title")
    private String title;

    @Column(name="ver_prev")
    private int prev;

    @Column(name="ver_next")
    private int next;

    @Column(name="ver_date", columnDefinition="DATE")
    private Date date;

    @Lob
    @Column(name="ver_char_img", columnDefinition="MEDIUMBLOB")
    private byte[] character_image;
    
    @Column(name="ver_changelog", columnDefinition="VARCHAR(1000)")
    private String changelog;

    @Column(name="ver_code", columnDefinition="TEXT(15000)")
    private String ver_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getCharacter_image() {
        return character_image;
    }

    public void setCharacter_image(byte[] character_image) {
        this.character_image = character_image;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    public String getVer_code() {
        return ver_code;
    }

    public void setVer_code(String ver_code) {
        this.ver_code = ver_code;
    }
}
