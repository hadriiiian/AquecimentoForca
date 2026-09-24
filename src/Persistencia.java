import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Persistencia {
	
	private XStream xstream;
	
	public Persistencia() {
		this.xstream = new XStream (new DomDriver());
		 this.xstream.allowTypes(new Class[] {
				 CentralDeInformacoes.class,
				 Jogador.class,
				 Sexo.class,
				 ArrayList.class
		 });
	}
	
	public void salvarCentral(CentralDeInformacoes informacao, String nomeArquivo) {
		
		String xml = xstream.toXML(informacao);
		
		try {
			File arquivo = new File (nomeArquivo);
			PrintWriter writer = new PrintWriter(arquivo);
			writer.println(xml);
			writer.close();	
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
