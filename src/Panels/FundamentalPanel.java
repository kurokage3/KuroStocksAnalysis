package Panels;

import Panels.Graphs.TwinGraphPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

//Display Bar Graphs of Fundamental Analysis Indicators
public class FundamentalPanel extends JPanel {

    private TwinGraphPanel first_graph;
    private TwinGraphPanel second_graph;
    private TwinGraphPanel third_graph;
    private TwinGraphPanel forth_graph;

    private Box firstSection;
    private Box secondSection;
    private Box thirdSection;
    private Box forthSection;

    public FundamentalPanel() {
        setLayout(new GridLayout(4, 1));
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY),"Fundamental Analysis"));

        //getData();

        createSections();

        add(firstSection);
        add(secondSection);
        add(thirdSection);
        add(forthSection);
    }

    private void createSections(){
        //Create Colors
        Color color_EPS = new Color(0, 150, 0, 255);
        Color color_PE = new Color(0, 230, 200, 180);

        Color color_PS = new Color(255, 0, 0, 180);
        Color color_PEG = new Color(255, 116, 0, 180);

        Color color_ROE = new Color(0, 0, 255, 180);
        Color color_PB = new Color(0, 230, 204, 180);

        Color color_DY = new Color(0, 150, 0, 255);
        Color color_DPR = new Color(0, 230, 200, 180);

        //Create Graphs
        first_graph = new TwinGraphPanel(getRandomData(), getRandomData(), color_EPS, color_PE);
        second_graph = new TwinGraphPanel(getRandomData(), getRandomData(), color_PS, color_PEG);
        third_graph = new TwinGraphPanel(getRandomData(), getRandomData(), color_ROE, color_PB);
        forth_graph = new TwinGraphPanel(getRandomData(), getRandomData(), color_DY, color_DPR);

        first_graph.setPreferredSize(new Dimension(600, 300));
        second_graph.setPreferredSize(new Dimension(600, 300));
        third_graph.setPreferredSize(new Dimension(600, 300));
        forth_graph.setPreferredSize(new Dimension(600, 300));

        //Create Labels
        Box vBox1 = Box.createHorizontalBox();
        JLabel first_a = new JLabel("Earnings Per Share (EPS)");
        first_a.setForeground(color_EPS);
        JLabel first_b = new JLabel("Price to Earnings Ratio (P/E)");
        first_b.setForeground(color_PE);
        vBox1.add(first_a);
        vBox1.add(Box.createRigidArea(new Dimension(10, 0)));
        vBox1.add(first_b);

        Box vBox2 = Box.createHorizontalBox();
        JLabel second_a = new JLabel("Price to Sales Ratio (P/S)");
        second_a.setForeground(color_PS);
        JLabel second_b = new JLabel("Projected Earnings Growth (PEG)");
        second_b.setForeground(color_PEG);
        vBox2.add(second_a);
        vBox2.add(Box.createRigidArea(new Dimension(10, 0)));
        vBox2.add(second_b);

        Box vBox3 = Box.createHorizontalBox();
        JLabel third_a = new JLabel("Return On Equity (ROE)");
        third_a.setForeground(color_ROE);
        JLabel third_b = new JLabel("Price to Book Ratio (P/B)");
        third_b.setForeground(color_PB);
        vBox3.add(third_a);
        vBox3.add(Box.createRigidArea(new Dimension(10, 0)));
        vBox3.add(third_b);

        Box vBox4 = Box.createHorizontalBox();
        JLabel forth_a = new JLabel("Dividend Payout Ratio (DividendValue/NetIncome)");
        forth_a.setForeground(color_DPR);
        JLabel forth_b = new JLabel("Dividend Yield (YearlyDividend/StockPrice)");
        forth_b.setForeground(color_DY);
        vBox4.add(forth_a);
        vBox4.add(Box.createRigidArea(new Dimension(10, 0)));
        vBox4.add(forth_b);

        //Add Graphs & Labels to each Section Panels
        firstSection = Box.createVerticalBox();
        firstSection.add(vBox1);
        firstSection.add(first_graph);
        secondSection = Box.createVerticalBox();
        secondSection.add(vBox2);
        secondSection.add(second_graph);
        thirdSection = Box.createVerticalBox();
        thirdSection.add(vBox3);
        thirdSection.add(third_graph);
        forthSection = Box.createVerticalBox();
        forthSection.add(vBox4);
        forthSection.add(forth_graph);
    }

    private ArrayList<Double> getRandomData(){
        ArrayList<Double> scores = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 40;
        int maxScore = 10;
        for (int i = 0; i < maxDataPoints; i++) {
            scores.add((double) random.nextDouble() * maxScore);
        }
        return scores;
    }
}
