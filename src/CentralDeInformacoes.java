import java.util.ArrayList;
public class CentralDeInformacoes {
	private ArrayList<Jogador> todosJogadores = new ArrayList<Jogador>();

	//getters
	public ArrayList<Jogador> getTodosJogadores() {
		return todosJogadores;
	}
	
	//setters
	public void setTodosJogadores(ArrayList<Jogador> todosJogadores) {
		this.todosJogadores = todosJogadores;
	}
	
	public boolean add(Jogador j) {
		if(j == null)
			return false;
		todosJogadores.add(j);
		return true;
	}
	
	public Jogador readCPF(String cpf) {
	}
}
