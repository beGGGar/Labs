package com.company;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
public class GetProperties {
    private  final  static  String  PROPS_FILE = "email.properties";

    /**
     * Функция для получения данных из файла
     * @return массив строк с данными для отправки сообщения
     */
    static String[] getProperties() {
        String arrayMessange[] = new    String[3] ;
        try {
            InputStream is = new FileInputStream(PROPS_FILE);
            if (is != null) {
                Reader reader = new InputStreamReader(is, "UTF-8");
                Properties props = new Properties();
                props.load(reader);
                //Инициализируем переменные
                SendEmail.SMTP_SERVER = props.getProperty("server");
                SendEmail.SMTP_Port = props.getProperty("port");
                SendEmail.EMAIL_FROM = props.getProperty("from");
                SendEmail.SMTP_AUTH_USER = props.getProperty("user");
                SendEmail.SMTP_AUTH_PWD = props.getProperty("pass");
                SendEmail.REPLY_TO = props.getProperty("replyto");
                SendEmail.FILE_PATH = PROPS_FILE;
                //String arrayMessange[] = new    String[2] ;
                arrayMessange[0] = props.getProperty ("to");
                arrayMessange[1]   = props.getProperty ("topic");
                arrayMessange[2]  = props.getProperty ("text" );
                //закрываем файл
                is.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayMessange;
    }
}
