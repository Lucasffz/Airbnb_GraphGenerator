 package desafio.poo.controler;

import desafio.poo.model.*;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;



public class Gerador_Grafico {
	private String arqG;
	
	
	
	private CategoryDataset criarDataSet(ArrayList<Bairro> bairros) {
		
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		for (int i = 0; i < bairros.size(); i++) {
			dataSet.addValue(bairros.get(i).getQuantidade(), bairros.get(i).getNome(), "");
		}
		
		
		return dataSet;
	}
	
	private JFreeChart createBarChart(CategoryDataset dataSet) {
		JFreeChart graficobarras = ChartFactory.createBarChart(" Quantidade locais disponíveis para locação por bairro", "", "Quantidade", 
				dataSet,
				PlotOrientation.HORIZONTAL,
				true,
				false,
				false);
		return graficobarras;
		
	}
	
	
	private JFreeChart createPieChart(ArrayList<Bairro> bairros) {
		DefaultPieDataset dataSet = new DefaultPieDataset();
		
		for (int i = 0; i < bairros.size(); i++) {
			dataSet.setValue(bairros.get(i).getNome(), bairros.get(i).getQuantidade());
		}
		
		
		JFreeChart graficopizza = ChartFactory.createPieChart(
				"Quantidade de locais disponiveis para locação por bairro na cidade de Vancouver", dataSet, true, false,
				false);
		return graficopizza;
		
	}
	
	private JFreeChart create3DChart(CategoryDataset dataSet) {
		JFreeChart tresDChart = ChartFactory.createBarChart3D("Quantidade de locais disponiveis para locação por bairro",
				"Bairros", "Quantidade de locais por bairro", dataSet);
		return tresDChart;
		
		
	}
	
	
	
	
	
	
	
	
	
	public void criarGraficoBarra(ArrayList<Bairro> bairros) {
		CategoryDataset dataSet = this.criarDataSet(bairros);
		JFreeChart grafico = this.createBarChart(dataSet);
		
		
		arqG = "grafico.jpeg";
		File barChartt = new File(arqG);
		
		try {
			ChartUtilities.saveChartAsJPEG(barChartt, grafico, 1200, 800);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void criarGraficoPizza(ArrayList<Bairro> bairros) {
		JFreeChart grafico = this.createPieChart(bairros);
		
		
		arqG = "grafico2.jpeg";
		File pizzaChartt = new File(arqG);
		
		try {
			ChartUtilities.saveChartAsJPEG(pizzaChartt, grafico, 1200, 800);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void criarGrafico3D(ArrayList<Bairro> bairros) {
		CategoryDataset dataSet = this.criarDataSet(bairros);
		JFreeChart grafico = create3DChart(dataSet);
		
		
		arqG = "grafico3.jpeg";
		File bar3dChartt = new File(arqG );
		
		try {
			ChartUtilities.saveChartAsJPEG(bar3dChartt, grafico, 1200, 800);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getarqg() {
		return arqG;
	}
	
	
	
	
	
	
	
	
	

}
