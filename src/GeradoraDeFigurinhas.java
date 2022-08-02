import java.io.InputStream;

public interface GeradoraDeFigurinhas {

    void cria(InputStream inputStream, String nomeArquivo, double avaliacaoTmdb) throws Exception;

}
