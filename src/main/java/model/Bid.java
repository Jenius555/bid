package model;

import java.util.Base64;

public class Bid {
    private Long id;
    private Long ts;
    private String ty;
    private String pl;

    public Bid() {
    }

    public Bid(Long id, Long ts, String ty, String pl) {
        this.id = id;
        this.ts = ts;
        this.ty = ty;
        this.pl = pl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getTy() {
        return ty;
    }

    public void setTy(String ty) {
        this.ty = ty;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", ts=" + ts +
                ", ty='" + ty + '\'' +
                ", pl='" + new String(Base64.getDecoder().decode(pl)) + '\'';
    }
}