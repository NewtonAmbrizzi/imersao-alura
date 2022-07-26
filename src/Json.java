import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaulObjectMapper = new ObjectMapper();
        defaulObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaulObjectMapper;
    }

    public static JsonNode parse(String source) throws IOException {
        return objectMapper.readTree(source);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz)
            throws JsonProcessingException, IllegalArgumentException {

        return objectMapper.treeToValue(node, clazz);

    }

}