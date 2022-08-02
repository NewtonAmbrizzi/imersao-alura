import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import properties.InterpretaArquivoProperties;

public class Menu {

    private ExtratoraDeConteudo extratora;
    private GeradoraDeFigurinhas geradoraDeFigurinhas;
    private ListaDetalhes detalhes;
    private String endereco;
    private int numeroPokemon;

    private static void geraMenu() {

        System.out.print("+-----------------------------------------------+\n");
        System.out.print("|            Menu Gerador de Figurinhas         |\n");
        System.out.print("+-----------------------------------------------+\n");
        System.out.print("| Opção 1 - API Tmdb - Top Filmes               |\n");
        System.out.print("| Opção 2 - API Tmdb - Filmes mais populares    |\n");
        System.out.print("| Opção 3 - API Tmdb - Top Series               |\n");
        System.out.print("| Opção 4 - API Tmdb - Series mais populares    |\n");
        System.out.print("| Opção 5 - API Nasa - Gera imagens da Nasa     |\n");
        System.out.print("| Opção 6 - API Poke - Pokemon shiny aleatório  |\n");
        System.out.print("| Opção 0 - Sair                                |\n");
        System.out.print("+-----------------------------------------------+\n");
        System.out.println("Digite um número para selecionar a opção: ");

    }

    public final void selecionaOpcaoDoMenu() throws IOException {
        int opcao;
        InterpretaArquivoProperties interpretaProperties = new InterpretaArquivoProperties();
        Properties prop = interpretaProperties.getProp();
        Scanner menu = new Scanner(System.in);

        while (endereco == null) {

            geraMenu();
            try {
                opcao = menu.nextInt();
            } catch (InputMismatchException err) {
                System.out.println("Caracter inválido, inicie novamente");
                opcao = 99;
                System.exit(0);
            }

            switch (opcao) {
                case 0:
                    System.out.print("\nAté logo!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.urlTopMovies");
                    extratora = new ExtratoraDeConteudoTmdb();
                    geradoraDeFigurinhas = new GeradoraDeFigurinhasTmdb();
                    detalhes = new ListaDetalhesTmdb();
                    break;
                case 2:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.urlMostPopularMovies");
                    extratora = new ExtratoraDeConteudoTmdb();
                    geradoraDeFigurinhas = new GeradoraDeFigurinhasTmdb();
                    detalhes = new ListaDetalhesTmdb();
                    break;
                case 3:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.urlTopTVs");
                    extratora = new ExtratoraDeConteudoTmdb();
                    geradoraDeFigurinhas = new GeradoraDeFigurinhasTmdb();
                    detalhes = new ListaDetalhesTmdb();
                    break;
                case 4:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.urlMostPopularTVs");
                    extratora = new ExtratoraDeConteudoTmdb();
                    geradoraDeFigurinhas = new GeradoraDeFigurinhasTmdb();
                    detalhes = new ListaDetalhesTmdb();
                    break;
                case 5:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.nasa");
                    extratora = new ExtratoraDeConteudoNasa();
                    geradoraDeFigurinhas = new GeradoraDeFigurinhasNasa();
                    detalhes = new ListaDetalhesNasa();
                    break;
                case 6:
                    System.out.print("\nOpcão " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.pokemon");
                    double aleatorio = Math.random() * 904;
                    numeroPokemon = (int) aleatorio + 1;
                    endereco = endereco + numeroPokemon;
                    extratora = new ExtratoraDeConteudoPokemon();
                    geradoraDeFigurinhas = new GeradoraDeFigurinhasPokemon();
                    detalhes = new ListaDetalhesPokemon();
                    break;
                default:
                    System.out.print("\nOpção Inválida!\n\n");
                    break;
            }

        }

        menu.close();
    }

    /**
     * @return ExtratoraDeConteudo return the extratora
     */
    public ExtratoraDeConteudo getExtratora() {
        return extratora;
    }

    public String getEndereco() {
        return endereco;
    }

    public GeradoraDeFigurinhas getGeradoraDeFigurinhas() {
        return geradoraDeFigurinhas;
    }

    public ListaDetalhes getDetalhes() {
        return detalhes;
    }

}
