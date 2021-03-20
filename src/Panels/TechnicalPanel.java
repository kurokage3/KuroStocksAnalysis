package Panels;

import Panels.Graphs.GraphPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TechnicalPanel extends JPanel {
    private GraphPanel mainStockGraph;
    private GraphPanel volumeGraph;

    private JLabel stockPriceLabel;
    private JLabel stockVolumeLabel;

    private Box timeSpanOptions;
    private JButton dailyButton;
    private JButton weeklyButton;
    private JButton monthlyButton;
    private JButton quarterlyButton;
    private JButton yearlyButton;

    public TechnicalPanel() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY),"Technical Analysis"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buildTimeOptionsPanel();
        buildMainStockGraphs();

        add(timeSpanOptions);
        add(stockPriceLabel);
        add(mainStockGraph);
        add(stockVolumeLabel);
        add(volumeGraph);
    }

    private void buildMainStockGraphs(){
        Color priceColor = new Color(0, 150, 0, 255);
        stockPriceLabel = new JLabel("Stock Price:", JLabel.LEFT);
        stockPriceLabel.setForeground(priceColor);
        mainStockGraph = new GraphPanel(getRandomData(), priceColor);
        mainStockGraph.setPreferredSize(new Dimension(1000, 780));

        Color volumeColor = new Color(255, 0, 207, 255);
        stockVolumeLabel = new JLabel("Stock Volume:", JLabel.LEFT);
        stockVolumeLabel.setForeground(volumeColor);
        volumeGraph = new GraphPanel(getRandomData(), volumeColor);
        volumeGraph.setPreferredSize(new Dimension(1000, 180));
    }

    private void buildTimeOptionsPanel(){
        timeSpanOptions = Box.createHorizontalBox();
        timeSpanOptions.setAlignmentX(LEFT_ALIGNMENT);

        dailyButton = new JButton("Daily");
        weeklyButton = new JButton("Weekly");
        monthlyButton = new JButton("Monthly");
        quarterlyButton = new JButton("Quarterly");
        yearlyButton = new JButton("Yearly");

        timeSpanOptions.add(weeklyButton);
        timeSpanOptions.add(dailyButton);
        timeSpanOptions.add(monthlyButton);
        timeSpanOptions.add(quarterlyButton);
        timeSpanOptions.add(yearlyButton);
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
