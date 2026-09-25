import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class GeradorDeRelatorios {
	public static void gerarRelatorio(CentralDeInformacoes central) {
		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
		try {
		PdfWriter.getInstance(doc, new FileOutputStream("relatorio.pdf"));
		doc.open();
		
		doc.add(new Paragraph("Central de Informações\n\n"));
		
		doc.add(new Paragraph("-Lista de Jogadores-"));
		if(central.getTodosJogadores() != null && !central.getTodosJogadores().isEmpty()) {
			for (Jogador j : central.getTodosJogadores()) {
				doc.add(new Paragraph(j.toString()));
			}
		} else {
			doc.add(new Paragraph("Nenhum jogador cadastrado!"));
		}
		
		doc.add(new Paragraph("\n"));
		
		doc.add(new Paragraph ("- Lista de Palavras -"));
		if(central.getPalavras() != null && !central.getPalavras().isEmpty()) {
			for (Palavra p : central.getPalavras()) {
				doc.add(new Paragraph(p.toString()));
			}
		} else {
			doc.add(new Paragraph("Nenhuma palavra cadastrado!"));
		}
		
		System.out.println("PDF gerado com sucesso!");
		
		} catch(Exception e) {
			System.err.println("Erro ao gerar pdf: " + e.getMessage());
		} finally {
			if(doc != null && doc.isOpen()) {
			doc.close();
			}
		}
	}
}
