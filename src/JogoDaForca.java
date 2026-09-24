public class JogoDaForca {
	private Palavra[] dicionario;
	private int posSorteada;
	private String gabarito;
	private int acertos;
	
	//construtor
	public JogoDaForca(Palavra[] dicionario) {
		this.dicionario = dicionario;
		this.posSorteada = -1;
	}
	
	//getters
	public Palavra[] getDicionario() {
		return dicionario;
	}
	public int getPosSorteada() {
		return posSorteada;
	}
	public String getGabarito() {
		return gabarito;
	}
	
	//setters
	public void setDicionario(Palavra[] dicionario) {
		this.dicionario = dicionario;
        this.acertos = 0;
        for (Palavra p : dicionario) {
            if (p == null) acertos++;
        }
	}
	
	public String getDicaPalavra() {
		return dicionario[posSorteada].getDica();
	}
	
	public void sortear() {
		if (acertos == dicionario.length) 
			return;

        int num;
        
        do {
            num = (int) (Math.random() * dicionario.length);
        } while (dicionario[num] == null);
		
		this.posSorteada = num;
		this.gabarito = "?".repeat(dicionario[num].getPalavra().length());
	}
	
	public boolean testarLetra(char c) {
		StringBuilder gabarito = new StringBuilder(this.gabarito);
		String palavra = dicionario[posSorteada].getPalavra();
		boolean find = false;
		
		for (int i = 0; i < palavra.length(); i++) {
			if (palavra.charAt(i) == c) {
				gabarito.setCharAt(i, palavra.charAt(i));	
				find = true;
			}
		}
		
		this.gabarito = gabarito.toString();
		return find;
	}
	
	public boolean acabou() {
		if (gabarito == null || gabarito.contains("?"))
			return false;
		
		if (posSorteada != -1) {
			dicionario[posSorteada] = null;
			posSorteada = -1;
			acertos++;
		}
		return true;
	}
	
	
}