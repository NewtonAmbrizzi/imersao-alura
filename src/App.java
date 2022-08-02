import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // chama o menu, faz uma conexao HTTP com a API selecionada

        var menu = new Menu();
        menu.selecionaOpcaoDoMenu();

        String url = menu.getEndereco();
        var http = new ClientHttp();
        String json = http.retornaBody(url);

        // extrai conteúdo
        ExtratoraDeConteudo extratora = menu.getExtratora();
        List<Conteudo> conteudos = extratora.extraiConteudos(json);

        // exibe e manipula os dados

        GeradoraDeFigurinhas geradora = menu.getGeradoraDeFigurinhas();
        ListaDetalhes detalhes = menu.getDetalhes();

        detalhes.exibeDetalhes(conteudos, geradora);

    }

}
