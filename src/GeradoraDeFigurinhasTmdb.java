import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhasTmdb implements GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo, double avaliacaoTmdb) throws Exception {
        // leitura da imagem
        String arquivoMeme = "FAIL";

        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        if (avaliacaoTmdb > 7.5)
            arquivoMeme = "TOP";

        BufferedImage imagemMeme = ImageIO.read(new File("entrada/" + arquivoMeme + ".png"));

        // cria nova imagem em memória com trasparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 150;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para novo imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        graphics.drawImage(imagemMeme, 0, novaAltura - 180, null);

        // configurar a fonte
        fonteMeme(avaliacaoTmdb, graphics);

        // escrever uma frase na nova imagem

        graphics.drawString(arquivoMeme + " !!!", largura - 250, novaAltura - 80);

        Font fonte = new Font("Impact", Font.PLAIN, 40);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        graphics.drawString("Rating: " + avaliacaoTmdb, largura - 180, novaAltura - 10);

        // escrever a nova imagem em um arquivo

        createDir();
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
    }

    private static void createDir() {
        File diretorio = new File("C:\\Users\\Crislei\\Desktop\\Newton\\imersao-java-alura\\alura-stickers\\saida");
        if (!diretorio.exists())
            diretorio.mkdirs();
    }

    private static void fonteMeme(double avaliacaoTmdb, Graphics2D graphics) {
        Font fonte = new Font("Impact", Font.PLAIN, 60);
        graphics.setColor(Color.RED);
        if (avaliacaoTmdb > 7.5)
            graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

    }

}
