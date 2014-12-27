package com.tassioauad.androiditunesclientlibrary.service.parameter.value;

/**
 * Created by Tássio on 21/05/2014.
 */
public enum EntityValue implements ParameterValueInterface {
    PODCAST_AUTHOR("podcastAuthor"), POSCAST("podcast");

    private String value;

    EntityValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

}
