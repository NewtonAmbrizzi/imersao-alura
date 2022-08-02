package POJOJson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TmdbPOJO {

    private List<FilmesSeriesTmdbPOJO> results;

    /**
     * @return List <FilmesSeriesTmdbPOJO> return the results
     */
    public List<FilmesSeriesTmdbPOJO> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(List<FilmesSeriesTmdbPOJO> results) {
        this.results = results;
    }

}
