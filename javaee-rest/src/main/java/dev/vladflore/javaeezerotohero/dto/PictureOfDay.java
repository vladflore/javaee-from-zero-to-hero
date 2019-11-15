package dev.vladflore.javaeezerotohero.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "copyright",
        "date",
        "explanation",
        "hdurl",
        "media_type",
        "service_version",
        "title",
        "url"
})
public class PictureOfDay {

    @JsonProperty("copyright")
    public String copyright;
    @JsonProperty("date")
    public String date;
    @JsonProperty("explanation")
    public String explanation;
    @JsonProperty("hdurl")
    public String hdurl;
    @JsonProperty("media_type")
    public String mediaType;
    @JsonProperty("service_version")
    public String serviceVersion;
    @JsonProperty("title")
    public String title;
    @JsonProperty("url")
    public String url;

}
