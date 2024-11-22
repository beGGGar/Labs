package controller;

import model.CollectionCreator;

import java.util.ArrayList;
import javafx.application.Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 

public class App1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		int HEIGHT = 720;
		int WIDTH = 1080;

		primaryStage.setTitle("Dependency of time");

		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Amount");
		yAxis.setLabel("Time");

		final LineChart<Number, Number> lineChart = new LineChart<Number,Number>(xAxis, yAxis);

		lineChart.setTitle("Dependency of median time fo ArrayList");

		XYChart.Series series = new XYChart.Series();
		series.setName("Add");
		for(int i = 10;i<=1000;i=i*10)
		{
		series.getData().add(new XYChart.Data(i,CollectionCreator.RunTimeList(i).get(1)));
		}  
		
		 XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Remove");
	        for(int i = 10;i<=1000;i=i*10)
			{
			series2.getData().add(new XYChart.Data(i,CollectionCreator.RunTimeList(i).get(3)));
			}  
		
		
	        Scene scene  = new Scene(lineChart,WIDTH,HEIGHT);
	      lineChart.getData().addAll(series,series2);
	       
	        primaryStage.setScene(scene);
	        primaryStage.show();

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
