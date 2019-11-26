package dev.vladflore.javaeezerotohero.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

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
@Data
public class PictureOfDay {

    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("date")
    private String date;
    @JsonProperty("explanation")
    private String explanation;
    @JsonProperty("hdurl")
    private String hdurl;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("service_version")
    private String serviceVersion;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
}
