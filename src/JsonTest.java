import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonTest {

    private String simpleTestCaseJsonSource = "{\"title\":\"The Shawshank Redemption\"}";

    private String body = "{\"items\":[{\"rank\":\"1\",\"title\":\"The Shawshank Redemption\",\"image\"" +
            ":\"https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg\",\"imDbRating\":\"9.2\"}," +
            "{\"rank\":\"2\",\"title\":\"The Godfather\",\"image\":\"https://imersao-java-apis.s3.amazonaws.com/TopMovies_2.jpg\","
            +
            "\"imDbRating\":\"9.2\"}],\"errorMessage\":\"\"}";

    @Test
    void testParse() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "The Shawshank Redemption");

    }

    @Test
    void fromJson() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        SimpleTestCasePOJO pojo = Json.fromJson(node, SimpleTestCasePOJO.class);

        assertEquals(pojo.getTitle(), "The Shawshank Redemption");

    }

    @Test
    void testeImdbSecnario() throws IOException {
        JsonNode node = Json.parse(body);
        ImdbPOJO imdbPOJO = Json.fromJson(node, ImdbPOJO.class);

        for (FilmesSeriesPOJO filmesSeriesPOJO : imdbPOJO.getItems()) {
            System.out.println(filmesSeriesPOJO.getRank());
            System.out.println(filmesSeriesPOJO.getTitle());
            System.out.println(filmesSeriesPOJO.getImage());
            System.out.println(filmesSeriesPOJO.getImDbRating());
        }

    }

}
