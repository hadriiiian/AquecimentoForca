
public class Jogador {
	private String nome;
	private String email;
	private Sexo sexo;
	private String cpf;

	//getters
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public String getCPF() {
		return cpf;
	}
	
	//setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	//construtor
	public Jogador(String nome, String email, Sexo sexo, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.cpf = cpf;
	}
	
	public String toString() {
		return String.format("%s(%s): %s, %s", nome, sexo, email, cpf);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		Jogador j = (Jogador) obj;
		
		return (cpf.equals(j.getCPF()) && email.equals(j.getEmail()));
	}
}