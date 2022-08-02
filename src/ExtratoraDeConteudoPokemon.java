import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import POJOJson.Json;
import POJOJson.PokemonPOJO;
import POJOJson.PokemonSpeciesPOJO;
import POJOJson.PokemonSpritesHomePOJO;
import POJOJson.PokemonSpritesOtherPOJO;
import POJOJson.PokemonSpritesPOJO;

public class ExtratoraDeConteudoPokemon implements ExtratoraDeConteudo {

    public List<Conteudo> extraiConteudos(String json) throws IOException {
        JsonNode node = Json.parse(json);
        PokemonPOJO pokemonPOJO = Json.fromJson(node, PokemonPOJO.class);

        List<Conteudo> conteudos = new ArrayList<>();

        PokemonSpeciesPOJO pokemonSpeciesPOJO = pokemonPOJO.getSpecies();
        PokemonSpritesPOJO pokemonSpritesPOJO = pokemonPOJO.getSprites();
        PokemonSpritesOtherPOJO pokemonSpritesOtherPOJO = pokemonSpritesPOJO.getOther();
        PokemonSpritesHomePOJO pokemonSpritesHomePOJO = pokemonSpritesOtherPOJO.getHome();

        String name = pokemonSpeciesPOJO.getName();
        String urlImagemPokemonShiny = pokemonSpritesHomePOJO.getFront_shiny();

        Conteudo conteudo = new Conteudo(name, urlImagemPokemonShiny, 0.0);
        conteudos.add(conteudo);
        return conteudos;
    }

}
