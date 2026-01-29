package campoMinado;

import java.util.Map;

public interface IFile {
    Map<String, Integer> readFile(String path);
    void writeFile(Map<String, Integer> score, String path);
}
