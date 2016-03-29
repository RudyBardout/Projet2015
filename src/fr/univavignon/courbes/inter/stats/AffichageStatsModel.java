/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * --------------------
 * BarChart3DDemo1.java
 * --------------------
 * (C) Copyright 2002-2004, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: BarChart3DDemo1.java,v 1.17 2004/04/26 19:11:53 taqua Exp $
 *
 * Changes
 * -------
 * 29-May-2002 : Version 1 (DG);
 * 11-Oct-2002 : Renamed VerticalBar3DDemo --> VerticalBarChart3DDemo (DG);
 * 13-May-2003 : Renamed VerticalBarChart3DDemo --> BarChart3DDemo1 (DG);
 * 24-Nov-2003 : Copied dataset creation code into this demo (DG);
 *
 */

package fr.univavignon.courbes.inter.stats;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.ApplicationFrame;

import fr.univavignon.courbes.stats.StockageStats;

/**
 * A simple demonstration application showing how to create a vertical 3D bar chart using data
 * from a {@link CategoryDataset}.
 *
 */
public class AffichageStatsModel extends ApplicationFrame {
	
	final double[][] data = new double[5][5];
	int current_player = 0;

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public AffichageStatsModel(final String title) {

        super(title);
        
        for (int i=0;i<2;i++) {
        	if (i==0) fillMatrix("Leroy");
        	if (i==1) fillMatrix("Kvothe");
        }
        
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
   private CategoryDataset createDataset() {
	   
	   try {}
	   catch (Exception e) {
		   System.out.println(e.toString());
	   }
       
       return DatasetUtilities.createCategoryDataset("Joueur ", "Stat ", data);

   }

	private void fillMatrix(String name) {
		try {
		   
			InputStream ips = new FileInputStream(name+".txt");
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			
			int i = 0;
			ligne = br.readLine();
			ligne = br.readLine();
			while ((ligne = br.readLine()) != null) {
				if (i==4) {
					data[current_player][i] = Integer.parseInt(ligne.substring(0));
					data[current_player][i] /= 35;
				}
				else if (i==2 || i==3) {
					data[current_player][i] = Integer.parseInt(ligne.substring(0));
					data[current_player][i] /= 7;
				}
				else 
					data[current_player][i] = Integer.parseInt(ligne.substring(0));
				i++;
			}
			br.close();
			current_player++;
			if (current_player == 6) current_player = 0;
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	   
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        final JFreeChart chart = ChartFactory.createBarChart3D(
            "Statistiques des joueurs",      // chart title
            "Statistiques",               // domain axis label
            "Valeur",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        return chart;

    }
    
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************

}
