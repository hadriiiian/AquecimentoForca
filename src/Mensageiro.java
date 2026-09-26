import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

public class Mensageiro {
	
	private static final String EMAIL_REMETENTE = "forcaaquecimento@gmail.com";
	private static final String SENHA_REMETENTE = "qvvepscjwqzqiyqq";
	
	public static void enviarMensagem(String emailDestinatario, String assunto, String mensagem) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(props, 
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() 
					{
						return new PasswordAuthentication(EMAIL_REMETENTE, SENHA_REMETENTE);
					}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(EMAIL_REMETENTE));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));
			message.setText(mensagem);
			message.setSubject(assunto);
			Transport.send(message);
		}
		catch (MessagingException e) {
			System.out.println("Erro ao enviar e-mail para " + emailDestinatario + ": " + e.getMessage());
		}
	}
}
