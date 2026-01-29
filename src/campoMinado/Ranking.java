package campoMinado;

import java.util.HashMap;
import java.util.Map;

public class Ranking implements IRanking {
    private final String FILE_PATH = "./ranking.txt";
    private File file;
    private Map<String, Integer> people;

    public Ranking(){
        this.file = new File();
        this.people = new HashMap<>();
    }

    @Override
    public void printRanking() {
        getScores();
        for(Map.Entry<String, Integer> person : people.entrySet()){
            String name = person.getKey();
            int score = person.getValue();

            System.out.println("Nome: " + name + " | " + score + " pontos");
        }
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
