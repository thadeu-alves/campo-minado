package campoMinado;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class File implements IFile  {
    @Override
    public Map<String, Integer> readFile(String path) {
        Map<String, Integer> scores = new HashMap<>();
        try(BufferedReader ler = new BufferedReader(new FileReader(path))){
        	String linha;
            String[]partes;
            while((linha = ler.readLine()) != null){
            	partes = linha.split(":");
            	String nome = partes[0];
            	int pontuacao = Integer.parseInt(partes[1]);
            	scores.put(nome,pontuacao);
            }
        }
        catch(IOException e) {
        	System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return scores;
    }

    @Override
    public void writeFile(Map<String, Integer> score, String path) {
    	try(BufferedWriter escLinha = new BufferedWriter(new FileWriter(path))) {
    		for(Map.Entry<String,Integer> linha: score.entrySet()) {
    			String nome = linha.getKey();
    			int pontuacao = linha.getValue();
    			
    			escLinha.write(nome + ":" + pontuacao);
    			escLinha.newLine();
    			
    		}
    	}
    	catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
