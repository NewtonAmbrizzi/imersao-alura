import java.io.IOException;
import java.util.List;

public interface ExtratoraDeConteudo {

    List<Conteudo> extraiConteudos(String json) throws IOException;

}
