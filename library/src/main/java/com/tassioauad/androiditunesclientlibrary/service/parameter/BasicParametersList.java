package com.tassioauad.androiditunesclientlibrary.service.parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tássio on 21/05/2014.
 */
public class BasicParametersList implements ParametersListInterface {

    private List<ParameterInterface> parameterList;

    public BasicParametersList() {
        parameterList = new ArrayList<ParameterInterface>();
    }

    @Override
    public void add(ParameterInterface parameter) {
        parameterList.add(parameter);
    }

    @Override
    public List<ParameterInterface> getList() {
        return parameterList;
    }

    @Override
    public String toUrlFormat() {

        String url = "";
        for (ParameterInterface parameter : parameterList) {
            url += parameter.toUrlFormat() + "&";
        }

        if (url.length() > 0) {
            url = url.substring(0, url.length() - 1);
            return url;
        } else {
            return null;
        }

    }
}
