package app.birdlist.object;

import java.sql.Date;

public class InfoVersion {
    private Integer id;
    private String char_name;
    private String title;
    private Date date;
    private String changelog;
    private String code;
    private Integer prev;
    private Integer next;

    public InfoVersion() {
    }

    public InfoVersion(Integer id, String char_name, String title, Date date, String changelog, String code, Integer prev,
            Integer next) {
        this.id = id;
        this.char_name = char_name;
        this.title = title;
        this.date = date;
        this.changelog = changelog;
        this.code = code;
        this.prev = prev;
        this.next = next;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChar_name() {
        return char_name;
    }

    public void setChar_name(String char_name) {
        this.char_name = char_name;
    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrev() {
        return prev;
    }

    public void setPrev(Integer prev) {
        this.prev = prev;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }
}
