import java.util.ArrayList;
import java.util.List;

public class Frase {

    private String frase;
    List<Frase> frases = new ArrayList<>();
    List<String> frasesString = new ArrayList<>();

    @Override
    public String toString() {
        return frase;
    }

    public Frase(){

    }

    public Frase(String frase){
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public void setFrases(List<Frase> frases) {
        this.frases = frases;
    }

}
