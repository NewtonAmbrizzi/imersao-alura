package POJOJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonSpritesPOJO {

    private PokemonSpritesOtherPOJO other;
    private String front_default;

    public String getFront_default() {
        return front_default;
    }

    public PokemonSpritesOtherPOJO getOther() {
        return other;
    }

}
