import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class ExtratorPalavrasCSV {
	public static ArrayList<Palavra> extrairPalavras(String nomeArquivoCSV){
		ArrayList<Palavra> palavras = new ArrayList<>();
		File arquivo = new File(nomeArquivoCSV);
		
		if(!arquivo.exists()) {
			return null;
		}
		
		try (Scanner ler = new Scanner(arquivo, StandardCharsets.UTF_8.name())) {
			while (ler.hasNextLine()) {
				String linha = ler.nextLine().trim();
				
				if (linha.isEmpty()) {continue;}		
			
			String[] partes = linha.split(",");
			
			if (partes.length < 3) {
				return null;
			}
			
			String termo = partes[0].trim();
			int dificuldade = Integer.parseInt(partes[1].trim());
			Dificuldade dificuldadeEnum = Dificuldade.values()[dificuldade];
			String dica = partes[2].trim();
			
			Palavra p = new Palavra(termo, dica, dificuldadeEnum);
			palavras.add(p);
		}
	} catch(Exception e) {
		return null;
	}
	
	return palavras;
}
}
