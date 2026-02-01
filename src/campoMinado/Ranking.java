package campoMinado;

import java.util.HashMap;
import java.util.Map;

public class Ranking implements IRanking {
    private final String FILE_PATH = new java.io.File("..").getAbsolutePath() + "/data/ranking.txt";
    private File file;
    private Map<String, Integer> people;

    public Ranking(){
        this.file = new File();
        this.people = new HashMap<>();
    }

    @Override
    public void printRanking() {
        getScores();
        people.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(person -> {
                    System.out.println(
                            person.getKey() +
                                    " ganhou em " + person.getValue() + " rodadas"
                    );
                });
    }

    @Override
    public void addScore(String name, int score) {
        people.put(name, score);
        file.writeFile(people, FILE_PATH);
    }

    @Override
    public Map<String, Integer> getScores() {
        people = file.readFile(FILE_PATH);
        return people;
    }
}
