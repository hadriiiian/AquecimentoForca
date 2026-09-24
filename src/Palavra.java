public class Palavra {
	private String palavra;
	private String dica;
	
	//construtor
	public Palavra() {
	}
	
	public Palavra(String palavra, String dica) {
		this.palavra = palavra;
		this.dica = dica;
	}

	//getters
	public String getPalavra() {
		return palavra;
	}
	public String getDica() {
		return dica;
	}

	//setters
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	
}
