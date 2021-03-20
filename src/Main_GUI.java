import Panels.*;

import javax.swing.*;
import java.awt.*;

public class Main_GUI extends JFrame {
    //Constant Variables
    private final int WINDOW_WIDTH = 1920;
    private final int WINDOW_HEIGHT = 1040;

    //Main Method
    public static void main(String[] args) {
        new Main_GUI();
    }

    //Panels
    private MenuPanel menuPanel;
    private SymbolsPanel symbolsPanel;
    private TechnicalPanel technicalPanel;
    private FundamentalPanel fundamentalPanel;
    private ActionPanel actionPanel;

    //Constructor
    public Main_GUI() {
        // JFrame Default Values
        setTitle("Kuro Stocks Analysis");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        //pack();

        // Create Custom Panel.
//        menuPanel = new MenuPanel();
        symbolsPanel = new SymbolsPanel();
        technicalPanel = new TechnicalPanel();
        fundamentalPanel = new FundamentalPanel();
//        actionPanel = new ActionPanel();

        // Add the components to the content pane.
//        add(menuPanel, BorderLayout.NORTH);
        add(symbolsPanel, BorderLayout.WEST);
        add(technicalPanel, BorderLayout.CENTER);
        add(fundamentalPanel, BorderLayout.EAST);
//        add(actionPanel, BorderLayout.SOUTH);
    }
}
