package com.tassioauad.androiditunesclientlibrary.service.utils;

import com.tassioauad.androiditunesclientlibrary.service.parameter.ParametersListInterface;

/**
 * Created by Tássio on 21/05/2014.
 */
public abstract class ItunesSearchApiUrlBuilder {

    private static final String BASE_URL = "https://itunes.apple.com/search";

    public static String build(ParametersListInterface parametersList) {
        return BASE_URL + "?" + parametersList.toUrlFormat();
    }

}
