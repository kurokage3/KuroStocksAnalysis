package Panels.Graphs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TwinGraphPanel extends JPanel {
    private int width = 800;
    private int height = 400;
    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor1;
    private Color lineColor2;
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 10;
    private List<Double> scores1;
    private List<Double> scores2;

    public TwinGraphPanel(List<Double> scores1, List<Double> scores2, Color lineColor1, Color lineColor2) {
        this.scores1 = scores1;
        this.scores2 = scores2;
        this.lineColor1 = lineColor1;
        this.lineColor2 = lineColor2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Determine Scale
        int largestSize = 0;
        if(scores1.size() > scores2.size()){
            largestSize = scores1.size();
        }
        else{
            largestSize = scores2.size();
        }
        double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / (largestSize - 1);
        double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());

        //Draw Graph Points
        List<Point> graphPoints1 = new ArrayList<>();
        for (int i = 0; i < scores1.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding);
            int y1 = (int) ((getMaxScore() - scores1.get(i)) * yScale + padding);
            graphPoints1.add(new Point(x1, y1));
        }
        List<Point> graphPoints2 = new ArrayList<>();
        for (int i = 0; i < scores2.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding);
            int y1 = (int) ((getMaxScore() - scores2.get(i)) * yScale + padding);
            graphPoints2.add(new Point(x1, y1));
        }

        // draw white background
        g2.setColor(Color.WHITE);
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding, getHeight() - 2 * padding - labelPadding);
        g2.setColor(Color.BLACK);

        // create hatch marks and grid lines for y axis.
        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = getHeight() - ((i * (getHeight() - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;
            if (largestSize > 0) {
                g2.setColor(gridColor);
                g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
                g2.setColor(Color.BLACK);
                String yLabel = ((int) ((getMinScore() + (getMaxScore() - getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            g2.drawLine(x0, y0, x1, y1);
        }

        // and for x axis
        for (int i = 0; i < largestSize; i++) {
            if (largestSize > 1) {
                int x0 = i * (getWidth() - padding * 2 - labelPadding) / (largestSize - 1) + padding + labelPadding;
                int x1 = x0;
                int y0 = getHeight() - padding - labelPadding;
                int y1 = y0 - pointWidth;
                if ((i % ((int) ((largestSize / 20.0)) + 1)) == 0) {
                    g2.setColor(gridColor);
                    g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
                    g2.setColor(Color.BLACK);
                    String xLabel = i + "";
                    FontMetrics metrics = g2.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                }
                g2.drawLine(x0, y0, x1, y1);
            }
        }

        // create x and y axes
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() - padding, getHeight() - padding - labelPadding);

        //Draw Lines
        Stroke oldStroke = g2.getStroke();
        //Line 1
        g2.setColor(lineColor1);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints1.size() - 1; i++) {
            int x1 = graphPoints1.get(i).x;
            int y1 = graphPoints1.get(i).y;
            int x2 = graphPoints1.get(i + 1).x;
            int y2 = graphPoints1.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
        //Line 2
        g2.setColor(lineColor2);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints2.size() - 1; i++) {
            int x1 = graphPoints2.get(i).x;
            int y1 = graphPoints2.get(i).y;
            int x2 = graphPoints2.get(i + 1).x;
            int y2 = graphPoints2.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
        g2.setStroke(oldStroke);
        //Points 1
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints1.size(); i++) {
            int x = graphPoints1.get(i).x - pointWidth / 2;
            int y = graphPoints1.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }
        //Points 2
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints2.size(); i++) {
            int x = graphPoints2.get(i).x - pointWidth / 2;
            int y = graphPoints2.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }
    }

    private double getMinScore() {
        double minScore = Double.MAX_VALUE;
        for (Double score : scores1) {
            minScore = Math.min(minScore, score);
        }
        for (Double score : scores2) {
            minScore = Math.min(minScore, score);
        }
        return minScore;
    }

    private double getMaxScore() {
        double maxScore = Double.MIN_VALUE;
        for (Double score : scores1) {
            maxScore = Math.max(maxScore, score);
        }
        for (Double score : scores2) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

//    public void setScores(List<Double> scores) {
//        this.scores = scores;
//        invalidate();
//        this.repaint();
//    }
//
//    public List<Double> getScores() {
//        return scores;
//    }

}