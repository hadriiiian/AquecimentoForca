import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Persistencia {
	
	private XStream xstream;
	private static final String NOME_ARQUIVO = "central.xml";
	
	public Persistencia() {
		this.xstream = new XStream (new DomDriver());
		 this.xstream.allowTypes(new Class[] {
				 CentralDeInformacoes.class,
				 Jogador.class,
				 Sexo.class,
				 ArrayList.class
		 });
	}
	
	public void salvarCentral(CentralDeInformacoes informacao) {
		
		String xml = xstream.toXML(informacao);
		
		try (PrintWriter writer = new PrintWriter(NOME_ARQUIVO, "UTF-8")) {
			writer.println(xml);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	public CentralDeInformacoes recuperarCentral(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);
		
		if(!arquivo.exists()){
			return new CentralDeInformacoes();
		}
		
		try {
			return(CentralDeInformacoes) xstream.fromXML(arquivo);
		} catch(Exception e) {
			return new CentralDeInformacoes();
		}	
	}
	
}
