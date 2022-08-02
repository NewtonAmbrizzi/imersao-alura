import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import POJOJson.FilmesSeriesTmdbPOJO;
import POJOJson.Json;
import POJOJson.TmdbPOJO;

public class ExtratoraDeConteudoTmdb implements ExtratoraDeConteudo {

    public List<Conteudo> extraiConteudos(String json) throws IOException {
        JsonNode node = Json.parse(json);
        TmdbPOJO tmdbPOJO = Json.fromJson(node, TmdbPOJO.class);

        List<Conteudo> conteudos = new ArrayList<>();

        for (FilmesSeriesTmdbPOJO filmesSeriesTmdbPOJO : tmdbPOJO.getResults()) {
            String title;
            if (filmesSeriesTmdbPOJO.getTitle() != null) {
                title = filmesSeriesTmdbPOJO.getTitle();
            } else {
                title = filmesSeriesTmdbPOJO.getName();
            }
            String urlImagem = filmesSeriesTmdbPOJO.getPoster_path();
            double avaliacaoTmdb = filmesSeriesTmdbPOJO.getVote_average();
            Conteudo conteudo = new Conteudo(title, urlImagem, avaliacaoTmdb);

            conteudos.add(conteudo);

        }

        return conteudos;

    }

}
