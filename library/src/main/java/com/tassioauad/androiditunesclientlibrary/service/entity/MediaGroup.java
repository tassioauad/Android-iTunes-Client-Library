package com.tassioauad.androiditunesclientlibrary.service.entity;

import java.util.List;

/**
 * Created by Tássio on 09/06/2014.
 */
public class MediaGroup
{
    public List<Content> contents;

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
