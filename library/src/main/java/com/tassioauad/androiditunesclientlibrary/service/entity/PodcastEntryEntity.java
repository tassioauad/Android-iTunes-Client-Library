package com.tassioauad.androiditunesclientlibrary.service.entity;

import java.util.List;

/**
 * Created by Tássio on 09/06/2014.
 */
public class PodcastEntryEntity {

    public List<MediaGroup> mediaGroups;

    public String title;

    public String link;

    public String author;

    public String publishedDate;

    public String contentSnippet;

    public String content;

    public List<String> categories;

    public List<MediaGroup> getMediaGroups() {
        return mediaGroups;
    }

    public void setMediaGroups(List<MediaGroup> mediaGroups) {
        this.mediaGroups = mediaGroups;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getContentSnippet() {
        return contentSnippet;
    }

    public void setContentSnippet(String contentSnippet) {
        this.contentSnippet = contentSnippet;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
