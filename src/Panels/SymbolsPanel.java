package Panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SymbolsPanel extends JPanel {
    private JTextField searchBar;
    private JList previouslySearched;

    private ArrayList<String> symbolsHistory;

    public SymbolsPanel() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY),"Stock Market"));
        Box vBox = Box.createVerticalBox();

        searchBar = new JTextField(10);

        loadSymbolsHistory();
        createPreviouslySearchedList();

        vBox.add(searchBar);
        vBox.add(previouslySearched);

        add(vBox);
    }

    public void addSearchedSymbol(String Symbol){
        symbolsHistory.add(Symbol);
    }

    private void createPreviouslySearchedList(){
        String[] list = new String[symbolsHistory.size()];
        list =  symbolsHistory.toArray(list);
        previouslySearched = new JList(list);
        previouslySearched.setFixedCellWidth(100);
        previouslySearched.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.GRAY),"History"));
    }

    private void loadSymbolsHistory(){
        symbolsHistory = new ArrayList<>();
        addSearchedSymbol("TSLA");
        addSearchedSymbol("APPL");
        addSearchedSymbol("MSFT");
        addSearchedSymbol("GOOGL");
        addSearchedSymbol("LUV");
        addSearchedSymbol("FB");
        addSearchedSymbol("UBER");
        //Load from .txt || .dat || DB
    }
}
