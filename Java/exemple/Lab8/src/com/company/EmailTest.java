package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class EmailTest
{
    private  final  static  String  PROPS_FILE = "email.properties";
    public static void main(String[] args)
    {
        try {
            //InputStream is = new FileInputStream(PROPS_FILE);
            //if (is != null) {
              //  Reader reader = new InputStreamReader(is, "UTF-8");
              //  Properties props = new Properties();
              //  props.load(reader);
                //Инициализируем переменные
                /*SendEmail.SMTP_SERVER    = props.getProperty ("server" );
                SendEmail.SMTP_Port      = props.getProperty ("port"   );
                SendEmail.EMAIL_FROM     = props.getProperty ("from"   );
                SendEmail.SMTP_AUTH_USER = props.getProperty ("user"   );
                SendEmail.SMTP_AUTH_PWD  = props.getProperty ("pass"   );
                SendEmail.REPLY_TO       = props.getProperty ("replyto");
                SendEmail.FILE_PATH      = PROPS_FILE;
                */
                String data[] = GetProperties.getProperties();
                //собираем данные о самом сообщении
                /*String emailTo = props.getProperty ("to");
                String topic   = props.getProperty ("topic");
                String text    = props.getProperty ("text" );
                //закрываем файл
                is.close();
*/
                SendEmail se = new SendEmail(data[0], data[1]);
                boolean b = se.sendMessage(data[2]);
                if (b==true)
                    System.out.println ("Сообщение отправлено успешно!");
                else
                    System.out.println ("Произошла какая-то ошибка!");
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
