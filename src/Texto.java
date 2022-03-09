import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Texto {

    private String texto;
    private Long quantidadePalavras;
    private Integer tempoEstimadoLeitura;
    private String fraseAleatoria;

    List<String> palavras = new ArrayList<>();
    List<Texto> textos = new ArrayList<>();
    Frase frase = new Frase();

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
        Integer tempoEstimadoLeitura = Math.toIntExact(getQuantidadePalavras() / 60);
        return tempoEstimadoLeitura;
    }

    public void setTempoEstimadoLeitura(Integer tempoEstimadoLeitura) {
        this.tempoEstimadoLeitura = tempoEstimadoLeitura;
    }

    public List<String> getFrasesCom(String texto) {

            List<String> frasesCom = new ArrayList<>();
            List<String> frases = getFrases();
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

    public void substitui(String palavraAntiga, String palavraNova){
         texto.replace(palavraAntiga, palavraNova);
    }

    public Texto adicionaFrase(Frase frase){
        Texto texto = new Texto(frase.getFrase());
        textos.add(texto);
        return texto;
    }

    public Texto adicionaFrase(String s){
        Texto texto = new Texto(s);
        textos.add(texto);
        return texto;
    }

    public List<String> getFrases() {
        List<String> frasesString = List.of(getTexto().split("\\."));
        return frasesString;
    }
}
