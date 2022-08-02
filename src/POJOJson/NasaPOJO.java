package POJOJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaPOJO {
    private String title;
    private String url;
    private String copyright;

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getCopyright() {
        return this.copyright;
    }

}
