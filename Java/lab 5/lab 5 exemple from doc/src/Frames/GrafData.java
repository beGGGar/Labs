package Frames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

import d2graf.SeparateTemplate;

public class GrafData {
/**
 * Класс содержит данные для построения графика
 */
	
	private String temp = "";
	private boolean Correct = false;
	private GrafDataTitle Title;
	/**
	 * Описание графика
	 */
	private Map <String, ArrayList> DataValues;
	/**
	 * Данные графика
	 */	
	
	public GrafData() {
		this.Title = null;
		this.DataValues = null;
		this.Correct = false;
	}

	/**
	 * Создаем объект данных графика из описания и двух массивов
	 * @param Title
	 * @param X
	 * @param Y
	 */
	public GrafData(GrafDataTitle Title, ArrayList <Float> X, ArrayList <Float> Y) {
		
		if( checkTitle(Title) && !X.isEmpty() && !Y.isEmpty() && X.size() == Y.size() ) {
			this.Title = Title;
			this.DataValues = new HashMap <String, ArrayList>();
			DataValues.put("X", X);
			DataValues.put("Y", Y);
			makeTitleFromDataArray();
			this.Correct = true;
		}
	}
	
	
	public GrafData(String FilePath, SeparateTemplate Separator) {

	}
	
	
	//------------------ set ------------------

	/**
	 * Проверяем переданное описание графика
	 * @param Title
	 * @return
	 */
	private boolean checkTitle(GrafDataTitle Title) {
		boolean Result = true;
			if(Title.getName().equals("") || Title.getName()==null) {
				Result = false;
			}
		return Result;
	}
	
	
	//------------------ get ------------------
	
	/**
	 * Возвращаем описание данных графика
	 * @return
	 */
	public GrafDataTitle getTitle() {
		return this.Title;
	}
	
	public ArrayList <Float> getGrafDataX() {
		return this.DataValues.get("X");
	}
	
	public ArrayList <Float> getGrafDataY() {
		return this.DataValues.get("Y");
	}
	
	public Map <String, ArrayList> getValues() {
		return this.DataValues;
	}
	
	
	
	//------------------ status ------------------
	
	boolean isCorrect() {
		return this.Correct;
	}
	
	
	
	//------------------ private ------------------
	
	/**
	 * Метод устанавливает максимальные и минимальные значения в title 
	 */
	private void makeTitleFromDataArray() {
		ArrayList <Float> X = this.DataValues.get("X");
		ArrayList <Float> Y = this.DataValues.get("Y");
		
		float min = X.get(0);
		float max = X.get(X.size()-1);
		
		for(float temp : X) {
			if( temp < min ) min = temp;
			if( temp > max ) max = temp;
		}
		
		this.Title.setMaxX(max);
		this.Title.setMinX(min);

		min = Y.get(0);
		max = Y.get(Y.size()-1);
		
		for(float temp : Y) {
			if( temp < min ) min = temp;
			if( temp > max ) max = temp;
		}		

		this.Title.setMaxY(max);
		this.Title.setMinY(min);
		
	}
	
	
	
	public void importDataFromFile(String FilePath, SeparateTemplate Separator) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(FilePath));
			ArrayList <Float> ar = new ArrayList();
			String arname = "";
			
			while((temp = br.readLine()) != "" & temp != null) {
				//Если строка совпадает с шаблоном, извлекаем данные и записываем в массив
				
				//Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");  
				Pattern p = Pattern.compile(Separator.get());
		        Matcher m = p.matcher(temp);
		        if( m.matches() ) {
		        	ar.add(Float.parseFloat(m.group(2)));
		        	if( arname.equals("") )
		        	{ arname = m.group(2); }
		        	/*
			        for(int i=1; i<= m.groupCount(); i++ )
			        {
			        	ar.add(Float.parseFloat(m.group(i)));
			        }
			        */
		        }
				
		        /*
				if( temp.indexOf("book::") >= 0  ) {
					//Устанавливаем признак начала разбора строк
					start = true;
				}
				else if( temp.length() == 0 ) { 
					start = false; 
				}
				
				if( start ) {	
					
					key = temp.substring(0, temp.indexOf(':'));
					value = temp.substring(temp.indexOf(':')+2, temp.length()-1);
					
					if( !key.isEmpty() && !value.isEmpty()) {
						switch (key) {
						case "Name":
							this.setName(value);
							break;
						case "Annot":
							this.setAnnot(value);
							break;
						case "Author":
							this.setAuthor(value);
							break;
						case "Publisher":
							this.setPublisher(Integer.parseInt(value));
							break;
						case "Lang":
							this.setLang(value);
							break;
						case "Size":
							this.setSize(Integer.parseInt(value));
							break;
						case "DateOutput":
							this.setDateOutput(LocalDate.parse(value));
							break;
						}
					}
				}
		    */
			}
			br.close();
			DataValues.put(arname, ar);
		}
		catch( IOException exc ) {
			System.out.println(exc.getMessage());
		}
	}

}
