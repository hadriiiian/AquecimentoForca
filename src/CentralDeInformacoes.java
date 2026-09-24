import java.util.ArrayList;
public class CentralDeInformacoes {
	private ArrayList<Jogador> todosJogadores = new ArrayList<Jogador>();
	private ArrayList<Palavra> palavras = new ArrayList<Palavra>();

	//getters
	public ArrayList<Jogador> getTodosJogadores() {
		return todosJogadores;
	}
	public ArrayList<Palavra> getPalavras() {
		return palavras;
	}

	//setters
	public void setTodosJogadores(ArrayList<Jogador> todosJogadores) {
		this.todosJogadores = todosJogadores;
	}
	
	//em relação à todosJogadores
	public boolean addJogador(Jogador j) {
		for (int i = 0; i < todosJogadores.size(); i++) {
			if (todosJogadores.get(i).equals(j))
				return false;
		}
		todosJogadores.add(j);
		return true;
	}
	
	public Jogador readCPF(String cpf) {
		for (int i = 0; i < todosJogadores.size(); i++) {
			if (todosJogadores.get(i).getCPF().equals(cpf))
				return todosJogadores.get(i);
		}
		return null;
	}
	
	public Jogador readEmail(String email) {
		for (int i = 0; i < todosJogadores.size(); i++) {
			if (todosJogadores.get(i).getEmail().equals(email))
				return todosJogadores.get(i);
		}
		return null;
	}
	
	//em relação à palavras
	public boolean addPalavra(Palavra p) {
		for (int i = 0; i < palavras.size(); i++) {
			if (palavras.get(i).equals(p))
				return false;
		}
		palavras.add(p);
		return true;
	}
	
	public Palavra readPalavra(String palavra) {
		for (int i = 0; i < palavras.size(); i++) {
			if (palavras.get(i).getPalavra().equals(palavra))
				return palavras.get(i);
		}
		return null;
	}
}
