package MyToolkit;
// размещение элементов в сетке

import java.awt.GridBagConstraints;

public class GBC extends GridBagConstraints {

	public GBC(
			int gridx, 
			int gridy, 
			int gridwidth, 
			int gridheight,
			double weightx,
			double weighty,
			int anhor
			) {
		
		super();
		make(gridx, 
			gridy, 
			gridwidth, 
			gridheight,
			weightx, 
			weighty, 
			anhor, 
			0);
	}
	
	public GBC(
			int gridx, 
			int gridy, 
			int gridwidth, 
			int gridheight,
			double weightx,
			double weighty,
			int anhor,
			int fill
			) {
		
		super();
		make(gridx, 
			gridy, 
			gridwidth, 
			gridheight,
			weightx, 
			weighty, 
			anhor, 
			fill);
	}	
	
	private void make(int gridx, 
			int gridy, 
			int gridwidth, 
			int gridheight,
			double weightx,
			double weighty,
			int anhor, 
			int fill
			) {
		this.gridx = gridx; //номер начального столбца
		this.gridy = gridy; //номер начальной строки
		this.gridwidth = gridwidth; //количество ячеек занимаемых по горизонтали
		this.gridheight = gridheight; //количество ячеек, занимаемых по вертикали
		this.weightx = weightx; //вес при увеличении ячейки в размерах
		this.weighty = weighty; //вес при увеличении ячейки в размерах
		this.anchor = anhor; //выравнивание в ячейке
		this.fill = fill; //заполнение ячейки полностью
	}
	
	
}
