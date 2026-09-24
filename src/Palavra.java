import java.time.LocalDate;
public class Palavra {
	private String palavra;
	private String dica;
	private Dificuldade nivelDeDificuldade;
	private LocalDate dataCadastro;


	public Palavra(String palavra, String dica, Dificuldade nivelDeDificuldade) {
		this.palavra = palavra;
		this.dica = dica;
		this.nivelDeDificuldade = nivelDeDificuldade;
	}

	//getters
	public String getPalavra() {
		return palavra;
	}
	public String getDica() {
		return dica;
	}
	public Dificuldade getNivelDeDificuldade() {
		return nivelDeDificuldade;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	//setters
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	public void setNivelDeDificuldade(Dificuldade nivelDeDificuldade) {
		this.nivelDeDificuldade = nivelDeDificuldade;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public boolean equals(Object obj) {
		Palavra outra = (Palavra) obj;
		return this.palavra.equals(outra.palavra);
	}
	
	public String toString() {
		return "Palavra: " + palavra + "|" + "Dica: " + dica;
	}

	
}
