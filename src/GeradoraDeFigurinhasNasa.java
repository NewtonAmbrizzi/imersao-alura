import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhasNasa implements GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo, double avaliacaoTmdb) throws Exception {
        // leitura da imagem

        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        BufferedImage imagemLogo = ImageIO.read(new File("entrada/nasa.png"));

        // cria nova imagem em memória com trasparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 150;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para novo imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        graphics.drawImage(imagemLogo, 0, novaAltura - 220, null);

        // escrever uma frase na nova imagem
        Font fonte = new Font("Impact", Font.PLAIN, 36);
        graphics.setColor(Color.BLUE);
        graphics.setFont(fonte);

        graphics.drawString("Picture: " + nomeArquivo.replace(".png", "."), 290, novaAltura - 55);

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
