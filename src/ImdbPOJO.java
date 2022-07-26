import java.util.List;

public class ImdbPOJO {
    private List<FilmesSeriesPOJO> items;
    private String errorMessage;

    /**
     * @return List<FilmesSeriesPOJO> return the items
     */
    public List<FilmesSeriesPOJO> getItems() {
        return items;
    }

    /**
     * @return String return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setItems(List<FilmesSeriesPOJO> items) {
        this.items = items;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
