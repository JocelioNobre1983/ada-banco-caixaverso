import com.ada.caixaverso.model.Transacoes;
import com.ada.caixaverso.reader.CsvReader;

import java.io.IOException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException {

        CsvReader reader = new CsvReader();
        List<Transacoes> transacoes = reader.ler("src/main/resources/operacoes_100.csv");
        transacoes.forEach(System.out::println);

    }
}
