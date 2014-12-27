package com.tassioauad.androiditunesclientlibrary.service.parameter;

import java.util.List;

/**
 * Created by Tássio on 21/05/2014.
 */
public interface ParametersListInterface extends UrlConvertionInterface {

    public void add(ParameterInterface parameter);

    public List<ParameterInterface> getList();
}
