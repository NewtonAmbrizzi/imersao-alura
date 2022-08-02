import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;

public class GeradoraDeFigurinhasPokemon implements GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo, double avaliacaoTmdb) throws Exception {

        BufferedImage spriteShiny = ImageIO.read(inputStream);
        BufferedImage logoPokemon = ImageIO.read(new File("entrada/pokemon-logo.png"));

        int largura = spriteShiny.getWidth();
        int altura = spriteShiny.getHeight();
        int alturaLogo = logoPokemon.getHeight();
        int larguraLogo = logoPokemon.getWidth();
        int novaAltura = altura + 150;
        int novaLargura = largura + 100;
        BufferedImage novaImagem = new BufferedImage(novaLargura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para novo imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(logoPokemon, novaLargura / 2 - larguraLogo / 2, novaAltura / 2 - alturaLogo / 2, null);
        graphics.drawImage(spriteShiny, novaLargura / 2 - largura / 2, 0, null);

        // escrever uma frase na nova imagem
        Font fonte = new Font("Impact", Font.ITALIC, 55);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);
        String pokemon = nomeArquivo.replace(".png", "").toUpperCase();
        int larguraTexto = graphics.getFontMetrics().stringWidth(pokemon);

        graphics.drawString(pokemon, novaLargura / 2 - larguraTexto / 2, novaAltura - 70);

        // escrever a nova imagem em um arquivo

        createDir();
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

    private static void createDir() {
        File diretorio = new File("C:\\Users\\Crislei\\Desktop\\Newton\\imersao-java-alura\\alura-stickers\\saida");
        if (!diretorio.exists())
            diretorio.mkdirs();
    }

}
