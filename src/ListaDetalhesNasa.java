import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ListaDetalhesNasa implements ListaDetalhes {
    GeradoraDeFigurinhas geradora;
    List<Conteudo> conteudos;

    public void exibeDetalhes(List<Conteudo> conteudos, GeradoraDeFigurinhas geradora)
            throws Exception {

        this.geradora = geradora;
        this.conteudos = conteudos;

        for (Conteudo conteudo : conteudos) {

            String urlImagem = conteudo.urlImagem();
            String titulo = conteudo.title();
            String copyright = conteudo.copyright();

            String nomeArquivo = titulo.replace(":", "-") + ".png";

            InputStream inputStream = new URL(urlImagem).openStream();
            System.out.println("\nGerando imagem - [" + titulo + "]");
            geradora.cria(inputStream, nomeArquivo, 0);

            System.out.println("Título: \u001b[38;2;174;14;50;1m" + titulo + "\u001b[m");
            System.out.println("Link da Imagem Original: " + urlImagem);
            System.out.println("\u001b[48;2;174;14;50;5mCopyright: " + copyright + "\u001b[m");

        }

    }
}
