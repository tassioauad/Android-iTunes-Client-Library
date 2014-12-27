package com.tassioauad.androiditunesclientlibrary.service.parameter;

import com.tassioauad.androiditunesclientlibrary.service.parameter.key.ParameterKeyInterface;
import com.tassioauad.androiditunesclientlibrary.service.parameter.value.ParameterValueInterface;

/**
 * Created by Tássio on 21/05/2014.
 */
public interface ParameterInterface extends UrlConvertionInterface {

    public void setKey(String key);

    public void setValue(String value);

    public void setKey(ParameterKeyInterface key);

    public void setValue(ParameterValueInterface value);

    public void setKeyValue(ParameterKeyInterface key, ParameterValueInterface value);

    public String getValue();

    public String getKey();
}
