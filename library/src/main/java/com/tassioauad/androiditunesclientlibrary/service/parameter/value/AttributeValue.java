package com.tassioauad.androiditunesclientlibrary.service.parameter.value;

/**
 * Created by Tássio on 21/05/2014.
 */
public enum AttributeValue implements ParameterValueInterface {

    TITLE_TERM("titleTerm"), LANGUAGE_TERM("languageTerm"), AUTHOR_TERM("authorTerm"),
    GENRE_INDEX("genreIndex"), ARTIST_TERM("artistTerm"), RATING_INDEX("ratingIndex"),
    KEYWORDS_TERM("keywordsTerm"), DESCRIPTION_TERM("descriptionTerm");

    private String value;

    AttributeValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
