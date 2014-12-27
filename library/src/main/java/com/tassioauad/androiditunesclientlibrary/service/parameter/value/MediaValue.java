package com.tassioauad.androiditunesclientlibrary.service.parameter.value;

/**
 * Created by Tássio on 20/05/2014.
 */
public enum MediaValue implements ParameterValueInterface {

    PODCAST("podcast");

    private String value;

    MediaValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }


}

