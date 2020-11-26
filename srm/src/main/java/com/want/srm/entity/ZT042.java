package com.want.srm.entity;

public class ZT042 {
    private String zguid;

    private String zaccount;

    private String ztype;

    private String ztime;

    private String zvoucherno;

    private String zresult;

    public String getZguid() {
        return zguid;
    }

    public void setZguid(String zguid) {
        this.zguid = zguid == null ? null : zguid.trim();
    }

    public String getZaccount() {
        return zaccount;
    }

    public void setZaccount(String zaccount) {
        this.zaccount = zaccount == null ? null : zaccount.trim();
    }

    public String getZtype() {
        return ztype;
    }

    public void setZtype(String ztype) {
        this.ztype = ztype == null ? null : ztype.trim();
    }

    public String getZtime() {
        return ztime;
    }

    public void setZtime(String ztime) {
        this.ztime = ztime == null ? null : ztime.trim();
    }

    public String getZvoucherno() {
        return zvoucherno;
    }

    public void setZvoucherno(String zvoucherno) {
        this.zvoucherno = zvoucherno == null ? null : zvoucherno.trim();
    }

    public String getZresult() {
        return zresult;
    }

    public void setZresult(String zresult) {
        this.zresult = zresult == null ? null : zresult.trim();
    }
}