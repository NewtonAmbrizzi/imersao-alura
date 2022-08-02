package POJOJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmesSeriesTmdbPOJO {

    private String title;
    private String name;
    private String poster_path;
    private double vote_average;

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the poster_path
     */
    public String getPoster_path() {
        return "https://image.tmdb.org/t/p/w500" + poster_path;
    }

    /**
     * @param poster_path the poster_path to set
     */
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    /**
     * @return double return the vote_average
     */
    public double getVote_average() {
        return vote_average;
    }

    /**
     * @param vote_average the vote_average to set
     */
    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
