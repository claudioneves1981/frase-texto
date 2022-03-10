import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Texto {

    private String texto;
    private Long quantidadePalavras;
    private String fraseAleatoria;

    Integer tempoEstimadoLeitura;
    List<String> palavras = new ArrayList<>();
    List<String> frases = new ArrayList<>();

    @Override
    public String toString() {
        return texto;

    }

    public Texto(){

    }

    public Texto(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getQuantidadePalavras() {

        palavras = List.of(texto.split(" "));
        quantidadePalavras = (long)palavras.size();
        return quantidadePalavras;
    }

    public void setQuantidadePalavras(Long quantidadePalavras) {
        this.quantidadePalavras = quantidadePalavras;
    }

    public Integer getTempoEstimadoLeitura() {
        tempoEstimadoLeitura = Math.toIntExact(getQuantidadePalavras() / 60);
        return tempoEstimadoLeitura;
    }

    public void setTempoEstimadoLeitura(Integer tempoEstimadoLeitura) {
        this.tempoEstimadoLeitura = tempoEstimadoLeitura;
    }

    public List<String> getFrasesCom(String texto) {
            frases = getFrases();
            List<String> frasesCom  = new ArrayList<>();
            for (int i = 0; i < frases.size(); i++) {
                if (frases.get(i).contains(texto)) {
                    frasesCom.add(frases.get(i));
                }
            }

            return frasesCom;



    }

    public String getFraseAleatoria() {
        List<String> frases = getFrases();
        Random random = new Random();
        fraseAleatoria = frases.get(random.nextInt(frases.size()));
        return fraseAleatoria;
    }

    public void setFraseAleatoria(String fraseAleatoria) {
        this.fraseAleatoria = fraseAleatoria;
    }

    public Texto substitui(String palavraAntiga, String palavraNova){
        return new Texto(this.texto.replace(palavraAntiga, palavraNova));
    }

    public Texto adicionaFrase(Frase frase){
       return new Texto(this.texto.concat(frase.getFrase()));
    }

    public Texto adicionaFrase(String s){
        return new Texto(this.texto.concat(s));
    }

    public List<String> getFrases() {
        return List.of(this.texto.split("\\."));
    }
}
