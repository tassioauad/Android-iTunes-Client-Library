package com.tassioauad.androiditunesclientlibrary.service.parameter.key;

/**
 * Created by Tássio on 24/05/2014.
 */
public enum Key {

    ATTRIBUTE("attribute"), ENTITY("entity"), MEDIA("media"), TERM("term"), LIMIT("limit");

    private String value;

    Key(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
