import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import POJOJson.Json;
import POJOJson.NasaPOJO;

public class ExtratoraDeConteudoNasa implements ExtratoraDeConteudo {

    public List<Conteudo> extraiConteudos(String json) throws IOException {

        JsonNode node = Json.parse(json);
        NasaPOJO[] nasaPOJO = Json.fromJson(node, NasaPOJO[].class);

        List<Conteudo> conteudos = new ArrayList<>();

        for (int i = 0; i < nasaPOJO.length; i++) {

            String title = nasaPOJO[i].getTitle();
            String urlImagem = nasaPOJO[i].getUrl();
            String copyright = nasaPOJO[i].getCopyright();
            Conteudo conteudo = new Conteudo(title, urlImagem, copyright);

            conteudos.add(conteudo);

        }

        return conteudos;

    }

}
