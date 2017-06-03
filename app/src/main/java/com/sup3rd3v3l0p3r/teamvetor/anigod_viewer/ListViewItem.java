package com.sup3rd3v3l0p3r.teamvetor.anigod_viewer;

public class ListViewItem {
    private String titleStr ;
    private String descStr ;
    private String UrlStr;

    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }
    public void setUrl(String url) {
        UrlStr = url;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
    public String getUrl() {
        return this.UrlStr ;
    }
}

