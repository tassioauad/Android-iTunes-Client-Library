package com.tassioauad.androiditunesclientlibrary.service.parameter;

import com.tassioauad.androiditunesclientlibrary.service.parameter.key.Key;
import com.tassioauad.androiditunesclientlibrary.service.parameter.key.ParameterKeyInterface;
import com.tassioauad.androiditunesclientlibrary.service.parameter.value.AttributeValue;
import com.tassioauad.androiditunesclientlibrary.service.parameter.value.EntityValue;
import com.tassioauad.androiditunesclientlibrary.service.parameter.value.MediaValue;
import com.tassioauad.androiditunesclientlibrary.service.parameter.value.ParameterValueInterface;

/**
 * Created by Tássio on 21/05/2014.
 */
public class BasicParameter implements ParameterInterface {

    private String key;
    private String value;

    public BasicParameter() {
    }

    public BasicParameter(AttributeValue attributeValue) {
        key = Key.ATTRIBUTE.getValue();
        value = attributeValue.getValue();
    }

    public BasicParameter(EntityValue entityValue) {
        key = Key.ENTITY.getValue();
        value = entityValue.getValue();
    }

    public BasicParameter(MediaValue mediaValue) {
        key = Key.MEDIA.getValue();
        value = mediaValue.getValue();
    }

    public BasicParameter(String key, ParameterValueInterface value) {
        this.key = key;
        this.value = value.getValue();
    }

    public BasicParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public BasicParameter(Key key, String value) {
        this.key = key.getValue();
        this.value = value;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setKey(ParameterKeyInterface key) {
        this.key = key.getValue();
    }

    @Override
    public void setValue(ParameterValueInterface value) {
        this.value = value.getValue();
    }

    @Override
    public void setKeyValue(ParameterKeyInterface key, ParameterValueInterface value){
        this.key = key.getValue();
        this.value = value.getValue();
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toUrlFormat() {
        return key + "=" + value;
    }
}
