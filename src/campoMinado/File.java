package campoMinado;

import java.util.HashMap;
import java.util.Map;

public class File implements IFile  {
    @Override
    public Map<String, Integer> readFile(String path) {
        Map<String, Integer> scores = new HashMap<>();
        //TODO Use a classe BufferedReader e FileReader para ler um arquivo txt
        return Map.of();
    }

    @Override
    public void writeFile(Map<String, Integer> score, String path) {
        //TODO Use a classe BufferedReader para escrever em arquivos txt
    }
}
