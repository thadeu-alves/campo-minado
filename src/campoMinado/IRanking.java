package campoMinado;

import java.util.ArrayList;
import java.util.Map;

public interface IRanking {
    void printRanking();
    void addScore(String name, int score);
    Map<String, Integer> getScores();
}
