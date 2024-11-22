package com.company;

import javax.mail.PasswordAuthentication;

public class EmailAuthenticator extends javax.mail.Authenticator
{
	private String login   ;
	private String password;

	/**
	 * Конструктор с параметрами
	 * @param login логин
	 * @param password пароль
	 */
	public EmailAuthenticator (final String login, final String password)
	{
		this.login    = login;
		this.password = password;
	}

	/**
	 * Гет-метод для получения пароля и логина
	 * @return пароль и логин
	 */
	public PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(login, password);
	}
}
