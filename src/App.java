import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexao HTTP e buscar os top 250 filmes
        Properties prop = getProp();
        String url = prop.getProperty("prop.endereco.url");
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        var body = response.body();

        // extrair os dados que interessam (título, poster, calssificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String, String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            String nomeArquivo = titulo.replace(":", "-") + ".png";

            try {
                InputStream inputStream = new URL(urlImagem).openStream();
                System.out.println("Gerando imagem - [" + titulo + "]");
                geradora.cria(inputStream, nomeArquivo);
            } catch (java.io.FileNotFoundException err) {
                System.out.println("Imagem não encontrada ou link inválido");
            }
            System.out.println("Título: \u001b[38;2;174;14;50;1m" + filme.get("title") + "\u001b[m");
            System.out.println("Poster: " + urlImagem);
            System.out.println("\u001b[48;2;174;14;50;5m🎬 Avaliação imDB: " + filme.get("imDbRating") + "\u001b[m");
            double avaliacaoImdb = Math.floor(Double.parseDouble(filme.get("imDbRating")));
            for (int i = 0; i < avaliacaoImdb; i++)
                System.out.print("\u2B50");
            double avaliacaoUser = Math.round(Math.random() * (10 - 5) + 5);
            System.out.println("\n\u001b[48;2;18;198;40;3m📺 Avaliação do Usuário: " + avaliacaoUser + "\u001b[m");
            for (int i = 0; i < avaliacaoUser; i++)
                System.out.print("\u2B50");
            System.out.println("\n");

        }

    }

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./bin/endereco.properties");
        props.load(file);
        return props;

    }
}
