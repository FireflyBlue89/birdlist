package app.birdlist.object;

import java.sql.Date;

public class InfoOutfit {
    private String out_name;

    private Integer ver_id;

    private String ver_desc;

    private Date ver_date;

    private String ver_code;

    public Integer getVer_id() {
        return ver_id;
    }

    public void setVer_id(Integer ver_id) {
        this.ver_id = ver_id;
    }

    public String getOut_name() {
        return out_name;
    }

    public void setOut_name(String out_name) {
        this.out_name = out_name;
    }

    public String getVer_desc() {
        return ver_desc;
    }

    public void setVer_desc(String ver_desc) {
        this.ver_desc = ver_desc;
    }

    public Date getVer_date() {
        return ver_date;
    }

    public void setVer_date(Date ver_date) {
        this.ver_date = ver_date;
    }

    public String getVer_code() {
        return ver_code;
    }

    public void setVer_code(String ver_code) {
        this.ver_code = ver_code;
    }
}
