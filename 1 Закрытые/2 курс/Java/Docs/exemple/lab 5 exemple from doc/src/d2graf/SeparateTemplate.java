package d2graf;

public class SeparateTemplate {
/**
 * Шаблон разбора строки лога
 */
	
	private String Template = "";
	
	SeparateTemplate(String Template) {
		this.set(Template);
	}

	/**
	 * Установка значения шаблона
	 * @param Template
	 * @return
	 */
	public boolean set(String Template)  {
		boolean Result = true;
		this.Template = Template;
		return Result;
	}
	
	/**
	 * Возврат значения шаблона
	 * @return
	 */
	public String get() {
		return this.Template;
	}
	
}
