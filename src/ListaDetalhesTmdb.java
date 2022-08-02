import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ListaDetalhesTmdb implements ListaDetalhes {

    GeradoraDeFigurinhas geradora;
    List<Conteudo> conteudos;

    public void exibeDetalhes(List<Conteudo> conteudos, GeradoraDeFigurinhas geradora)
            throws Exception {

        this.geradora = geradora;
        this.conteudos = conteudos;

        for (Conteudo conteudo : conteudos) {

            String urlImagem = conteudo.urlImagem();
            String titulo = conteudo.title();
            double avaliacaoTmdb = conteudo.avaliacao();

            String nomeArquivo = titulo.replace(":", "-") + ".png";

            InputStream inputStream = new URL(urlImagem).openStream();
            System.out.println("\nGerando imagem - [" + titulo + "]");
            geradora.cria(inputStream, nomeArquivo, avaliacaoTmdb);

            System.out.println("Título: \u001b[38;2;174;14;50;1m" + titulo + "\u001b[m");
            System.out.println("Poster: " + urlImagem);
            System.out.println("\u001b[48;2;174;14;50;5m🎬 Avaliação TMDB: " + avaliacaoTmdb + "\u001b[m");
            avaliacaoTmdb = Math.floor(avaliacaoTmdb);
            for (int i = 0; i < avaliacaoTmdb; i++)
                System.out.print("\u2B50");
            double avaliacaoUser = Math.round(Math.random() * (10 - 5) + 5);
            System.out.println("\n\u001b[48;2;18;198;40;3m📺 Avaliação do Usuário: " + avaliacaoUser + "\u001b[m");
            for (int i = 0; i < avaliacaoUser; i++)
                System.out.print("\u2B50");
            System.out.println("\n");

        }

    }

}
