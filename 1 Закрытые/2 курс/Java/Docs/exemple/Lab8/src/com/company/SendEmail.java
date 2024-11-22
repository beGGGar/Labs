package com.company;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import static javax.mail.Transport.send;

public class SendEmail
{
    private            Message  message        = null;
    protected  static  String   SMTP_AUTH_USER = null;
    protected  static  String   SMTP_AUTH_PWD  = null;
    protected  static  String   EMAIL_FROM     = null;
    protected  static  String   SMTP_SERVER    = null;
    protected  static  String   SMTP_Port      = null;
    protected  static  String   REPLY_TO       = null;
    protected  static  String   FILE_PATH      = null;

    /**
     * Конструктор с параметрами
     * @param emailTo адресс электронной почты получателя
     * @param topic тема письма
     */
    public SendEmail(final String emailTo, final String topic)
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.host"               , SMTP_SERVER                     );
        properties.put("mail.smtp.port"               , SMTP_Port                       );
        properties.put("mail.smtp.user"               , SMTP_AUTH_USER                  );
        properties.put("mail.smtp.auth"               , "true"                          );
        properties.put("mail.smtp.socketFactory.fallback", "false"                      );
        properties.put("mail.smtp.ssl.enable"         , "true"                          );
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        try {
            Authenticator auth = new EmailAuthenticator(SMTP_AUTH_USER, SMTP_AUTH_PWD);
            Session session = Session.getDefaultInstance(properties, auth);
            session.setDebug(false);

            InternetAddress email_from = new InternetAddress(EMAIL_FROM);
            InternetAddress email_to   = new InternetAddress(emailTo   );
            InternetAddress reply_to   = (REPLY_TO != null) ?
                    new InternetAddress(REPLY_TO) : null;
            message = new MimeMessage(session);

            message.setFrom(email_from);
            message.setRecipient(Message.RecipientType.TO, email_to);
            message.setSubject(topic);
            if (reply_to != null)
                message.setReplyTo (new Address[] {reply_to});
        } catch (AddressException e) {
            System.err.println(e.getMessage());
        } catch (MessagingException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Функция отправления сообщения на электронную почту
     * @param text -текст сообщения
     * @return true,если все выполниться успешно и false-в случае ошибки
     */
    public boolean sendMessage (final String text)
    {
        boolean result = false;
        try {
            // Содержимое сообщения
            Multipart mmp = new MimeMultipart();
            // Текст сообщения
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(text, "text/plain; charset=utf-8");
            mmp.addBodyPart(bodyPart);
            // Вложение файла в сообщение
            if (FILE_PATH != null) {
                MimeBodyPart mbr = createFileAttachment(FILE_PATH);
                mmp.addBodyPart(mbr);
            }
            // Определение контента сообщения
            message.setContent(mmp);
            // Отправка сообщения
            send(message);
            result = true;
        } catch (MessagingException e){
            // Ошибка отправки сообщения
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Функция создания файлового вложения
     * @param filepath путь к файлу
     * @return MimeBodyPart
     * @throws MessagingException
     */
    private MimeBodyPart createFileAttachment(String filepath) throws MessagingException
    {
        // Создание MimeBodyPart
        MimeBodyPart mbp = new MimeBodyPart();

        // Определение файла в качестве контента
        FileDataSource fds = new FileDataSource(filepath);
        mbp.setDataHandler(new DataHandler(fds));
        mbp.setFileName(fds.getName());
        return mbp;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
