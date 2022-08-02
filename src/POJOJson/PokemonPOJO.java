package POJOJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonPOJO {

    private PokemonSpeciesPOJO species;
    private PokemonSpritesPOJO sprites;

    public PokemonSpritesPOJO getSprites() {
        return sprites;
    }

    public PokemonSpeciesPOJO getSpecies() {
        return species;
    }

}
