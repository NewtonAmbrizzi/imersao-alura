package POJOJson;

import java.util.List;

public class ImdbPOJO {
    private List<FilmesSeriesImdbPOJO> items;
    private String errorMessage;

    /**
     * @return List<FilmesSeriesPOJO> return the items
     */
    public List<FilmesSeriesImdbPOJO> getItems() {
        return items;
    }

    /**
     * @return String return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setItems(List<FilmesSeriesImdbPOJO> items) {
        this.items = items;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
