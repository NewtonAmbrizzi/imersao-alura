import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.databind.JsonNode;

public class App {
    public static void main(String[] args) throws Exception {

        // chama o menu e faz uma conexao HTTP com a API selecionada

        String url = Menu.selecionaOpcao();
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body = response.body();

        // extrair os dados que interessam (título, poster, calssificação)
        JsonNode node = Json.parse(body);
        ImdbPOJO imdbPOJO = Json.fromJson(node, ImdbPOJO.class);

        // exibir e manipular os dados

        var geradora = new GeradoraDeFigurinhas();
        for (FilmesSeriesPOJO filmesSeriesPOJO : imdbPOJO.getItems()) {

            String urlImagem = filmesSeriesPOJO.getImage().replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String titulo = filmesSeriesPOJO.getTitle();
            int rank = filmesSeriesPOJO.getRank();
            double avaliacaoImdb = filmesSeriesPOJO.getImDbRating();

            String nomeArquivo = titulo.replace(":", "-") + ".png";

            InputStream inputStream = new URL(urlImagem).openStream();
            System.out.println("\nGerando imagem - [" + titulo + "]");
            geradora.cria(inputStream, nomeArquivo);

            System.out.println("Título: \u001b[38;2;174;14;50;1m" + titulo + "\u001b[m");
            System.out.println("Ranking ImDb: " + rank);
            System.out.println("Poster: " + urlImagem);
            System.out.println("\u001b[48;2;174;14;50;5m🎬 Avaliação imDB: " + avaliacaoImdb + "\u001b[m");
            avaliacaoImdb = Math.floor(avaliacaoImdb);
            for (int i = 0; i < avaliacaoImdb; i++)
                System.out.print("\u2B50");
            double avaliacaoUser = Math.round(Math.random() * (10 - 5) + 5);
            System.out.println("\n\u001b[48;2;18;198;40;3m📺 Avaliação do Usuário: " + avaliacaoUser + "\u001b[m");
            for (int i = 0; i < avaliacaoUser; i++)
                System.out.print("\u2B50");
            System.out.println("\n");

        }

    }

}
