import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {

    private static void geraMenu() {

        System.out.print("+----------------------------------+\n");
        System.out.print("|    Menu Gerador de Figurinhas    |\n");
        System.out.print("+----------------------------------+\n");
        System.out.print("| Opção 1 - Top 250 Filmes         |\n");
        System.out.print("| Opção 2 - Filmes mais populares  |\n");
        System.out.print("| Opção 3 - Top 250 Series         |\n");
        System.out.print("| Opção 4 - Series mais populares  |\n");
        System.out.print("| Opção 0 - Sair                   |\n");
        System.out.print("+----------------------------------+\n");
        System.out.println("Digite um número para selecionar a opção: ");

    }

    public static final String selecionaOpcao() throws IOException {
        int opcao;
        InterpretaArquivoProperties interpretaProperties = new InterpretaArquivoProperties();
        Properties prop = interpretaProperties.getProp();
        String endereco = "";
        Scanner menu = new Scanner(System.in);

        while (endereco == "") {

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
                    endereco = prop.getProperty("prop.endereco.urlTop250Movies");
                    break;
                case 2:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.urlMostPopularMovies");
                    break;
                case 3:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.urlTop250TVs");
                    break;
                case 4:
                    System.out.print("\nOpção " + opcao + " selecionada, gerando as Stickers!\n");
                    endereco = prop.getProperty("prop.endereco.urlMostPopularTVs");
                    break;
                default:
                    System.out.print("\nOpção Inválida!\n\n");
                    break;
            }

        }

        menu.close();
        return endereco;
    }

}
