package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InterpretaArquivoProperties {

    public Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./bin/properties/endereco.properties");
        props.load(file);
        return props;

    }

}
