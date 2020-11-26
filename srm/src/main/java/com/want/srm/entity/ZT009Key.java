package com.want.srm.entity;

public class ZT009Key {
    private String dzbdh;

    private String dzbms;

    public String getDzbdh() {
        return dzbdh;
    }

    public void setDzbdh(String dzbdh) {
        this.dzbdh = dzbdh == null ? null : dzbdh.trim();
    }

    public String getDzbms() {
        return dzbms;
    }

    public void setDzbms(String dzbms) {
        this.dzbms = dzbms == null ? null : dzbms.trim();
    }
}