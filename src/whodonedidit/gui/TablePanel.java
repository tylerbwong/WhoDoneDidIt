package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultCaret;
import whodonedidit.version1_0.ActionCard;
import whodonedidit.version1_0.ActionCardType;
import whodonedidit.version1_0.Player;
import whodonedidit.version1_0.Table;

/**
 *
 * @author Brittany Berlanga
 * @author Tyler Wong
 */
public class TablePanel extends JPanel
{

    private String fileNames[];
    private ArrayList<CardButton> actionCards;
    private ArrayList<CardLabel> clueCards;
    private ArrayList<DestinationMarkerLabel> destinationMarkers;
    private ArrayList<OpponentPanel> opponents;
    private CardLabel discardPile;
    private DestinationMarkerLabel handDestinationMarker;
    private MainFrame frame;
    private JLayeredPane layerPane;
    private NotesheetPanel noteSheet;
    private RulesPanel rulesPanel;
    private int cardIndex = 0;
    private ArrestPanel arrestPanel;
    private String userName;
    private Table table;
    private Player player;
    private int computerCount;
    private int turnCount = 1;
    private String currentPlayer;
    private ArrayList<Integer> numCards;
    private String currentDestination;

    public static final Map<String, String> destinationMarkerImages;
    public static final Map<String, String> clueCardImages;
    public static final Map<ActionCardType, String> actionCardImages;
    public static final Map<String, String> privateTipCardImages;

    static
    {
        destinationMarkerImages = new HashMap<>();
        destinationMarkerImages.put("Athena's Forest", "GreeceImages/DM-Athena-Forest.jpg");
        destinationMarkerImages.put("Athens", "GreeceImages/DM-Athens.jpg");
        destinationMarkerImages.put("Atlas' Sky", "GreeceImages/DM-AtlasSky.jpg");
        destinationMarkerImages.put("Dionysus Vineyard", "GreeceImages/DM-Dionysus-Vineyard.jpg");
        destinationMarkerImages.put("Hades Underworld", "GreeceImages/DM-HadesUnderworld.jpg");
        destinationMarkerImages.put("Hephaestus Volcano", "GreeceImages/DM-HephaestusVolcano.jpg");
        destinationMarkerImages.put("Mount Olympus", "GreeceImages/DM-MountOlympus.jpg");
        destinationMarkerImages.put("Phoebe's Moon", "GreeceImages/DM-Phobe-Moon.jpg");
        destinationMarkerImages.put("Poseidon Ocean", "GreeceImages/DM-Poseidon-Ocean.jpg");

        clueCardImages = new LinkedHashMap<>();

        //destinations
        clueCardImages.put("Athena's Forest", "GreeceImages/Location-Athena-Forest.jpg");
        clueCardImages.put("Athens", "GreeceImages/Location-Athens.jpg");
        clueCardImages.put("Atlas' Sky", "GreeceImages/Location-AtlasSky.jpg");
        clueCardImages.put("Dionysus Vineyard", "GreeceImages/Location-Dionysus-Vineyard.jpg");
        clueCardImages.put("Hades Underworld", "GreeceImages/Location-HadesUnderworld.jpg");
        clueCardImages.put("Hephaestus Volcano", "GreeceImages/Location-HephaestusVolcano.jpg");
        clueCardImages.put("Mount Olympus", "GreeceImages/Location-MountOlympus.jpg");
        clueCardImages.put("Phoebe's Moon", "GreeceImages/Location-Phobe-Moon.jpg");
        clueCardImages.put("Poseidon Ocean", "GreeceImages/Location-Poseidon-Ocean.jpg");

        //suspects
        clueCardImages.put("Ares", "GreeceImages/Suspects-Ares.jpg");
        clueCardImages.put("Dionysus", "GreeceImages/Suspects-Dionysus.jpg");
        clueCardImages.put("Hermes", "GreeceImages/Suspects-Hermes.jpg");
        clueCardImages.put("Aphrodite", "GreeceImages/Suspects-Aphrodite.jpg");
        clueCardImages.put("Artemis", "GreeceImages/Suspects-Artemis.jpg");
        clueCardImages.put("Hera", "GreeceImages/Suspects-Hera.jpg");

        //vehicles
        clueCardImages.put("Apollo's Chariot", "GreeceImages/Transportation-ApollosChariot.jpg");
        clueCardImages.put("Athena's Horse", "GreeceImages/Transportation-AthenaHorse.jpg");
        clueCardImages.put("Eros' Wings", "GreeceImages/Transportation-ErosWings.jpg");
        clueCardImages.put("Hades' Dogs", "GreeceImages/Transportation-HadesDogs.jpg");
        clueCardImages.put("Hermes Sandals", "GreeceImages/Transportation-HermesWingSandals.jpg");
        clueCardImages.put("Poseidon's Ship", "GreeceImages/Transportation-PoseidonShip.jpg");

        actionCardImages = new HashMap<>();
        actionCardImages.put(ActionCardType.SuggestFromCurrent, "GreeceImages/Action-SuggestionCurrent.jpg");
        actionCardImages.put(ActionCardType.SuggestFromAny, "GreeceImages/Action-SuggestionAny.jpg");
        actionCardImages.put(ActionCardType.Snoop, "GreeceImages/Action-Snoop.jpg");
        actionCardImages.put(ActionCardType.AllSnoopLeft, "GreeceImages/Action-AllSnoopLeft.jpg");
        actionCardImages.put(ActionCardType.AllSnoopRight, "GreeceImages/Action-AllSnoopRight.jpg");

        privateTipCardImages = new HashMap<>();
        privateTipCardImages.put("Destination", "GreeceImages/Action-PrivateTipAllDestination.jpg");
        privateTipCardImages.put("Suspect", "GreeceImages/Action-PrivateTipAllSuspect.jpg");
        privateTipCardImages.put("Vehicle", "GreeceImages/Action-PrivateTipAllVehicle.jpg");
        privateTipCardImages.put("Female", "GreeceImages/Action-PrivateTipFemale.jpg");
        privateTipCardImages.put("North", "GreeceImages/Action-PrivateTipNorthern.jpg");
        privateTipCardImages.put("Red", "GreeceImages/Action-PrivateTipRed.jpg");
    }

    public TablePanel(MainFrame frame, JLayeredPane layerPane)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        this.clueCards = new ArrayList<CardLabel>();
        this.actionCards = new ArrayList<CardButton>();

        makePanels();
        initComponents();
        initBindings();

        setup();
        validate();
        this.playerTurn.setVisible(false);
        DefaultCaret caret = (DefaultCaret)this.historyArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    private void makePanels()
    {
        this.noteSheet = new NotesheetPanel(this.frame, this.layerPane);
        this.rulesPanel = new RulesPanel(this.frame, this.layerPane);
        this.rulesPanel.setInGame(true);
    }

    public void setTable(Table table)
    {
        this.table = table;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
    
    public NotesheetPanel getNotesheet()
    {
        return this.noteSheet;
    }

    private void initBindings()
    {
        NotesheetAction noteAction = new NotesheetAction(this);
        EndTurnAction endAction = new EndTurnAction();
        RulesAction rulesAction = new RulesAction();
        ArrestAction arrestAction = new ArrestAction(this);

        this.notesheetButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "note");
        this.notesheetButton.getActionMap().put("note", noteAction);
        this.endTurnButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "end");
        this.endTurnButton.getActionMap().put("end", endAction);
        this.rulesButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "rules");
        this.rulesButton.getActionMap().put("rules", rulesAction);
        this.arrestButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "arrest");
        this.arrestButton.getActionMap().put("arrest", arrestAction);
    }

    class NotesheetAction extends AbstractAction
    {
        private TablePanel table;
        public NotesheetAction(TablePanel table)
        {
            this.table = table;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Opened notesheet");
            layerPane.add(noteSheet, JLayeredPane.DRAG_LAYER);
            layerPane.moveToFront(noteSheet);
            layerPane.moveToBack(table);
            layerPane.moveToBack(rulesPanel);
            layerPane.validate();
            noteSheet.getPerson1Check().requestFocus();
        }
    }

    class EndTurnAction extends AbstractAction
    {

        public EndTurnAction()
        {
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Ended turn");
            frame.disableEndTurnButton();
            frame.getController().sendEndTurn();
        }
    }

    class RulesAction extends AbstractAction
    {

        public RulesAction()
        {
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Opened rules");
            layerPane.add(rulesPanel, JLayeredPane.DRAG_LAYER);
            layerPane.moveToFront(rulesPanel);
            layerPane.validate();
            rulesPanel.getBackButton().requestFocus();
        }
    }

    class ArrestAction extends AbstractAction
    {

        private TablePanel panel;

        public ArrestAction(TablePanel panel)
        {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Arrest initiated");
            arrestPanel = new ArrestPanel(frame, layerPane, noteSheet);
            arrestPanel.setCards(actionCards);
            arrestPanel.setTablePanel(panel);
            arrestPanel.setupCards();
            layerPane.add(arrestPanel, JLayeredPane.DRAG_LAYER);
            layerPane.moveToFront(arrestPanel);
            frame.pack();
            layerPane.moveToBack(panel);
            layerPane.moveToBack(noteSheet);
            layerPane.moveToBack(rulesPanel);
            layerPane.validate();
            arrestButton.setEnabled(false);
        }
    }

    public void setUserNames(String[] userNames, ArrayList<Integer> numCards) {
        int j = 0;
        for (int i = 0; i < userNames.length; i++)
        {
            if (!userNames[i].equals(this.userName))
            {
                this.opponents.get(j).setScreenName(userNames[i]);
                this.opponents.get(j).setCardCount(numCards.get(i));
                j++;
            }
        }
    }

    public void setDiscardPile(ActionCardType actionCardType)
    {
        String fileName;
        if (actionCardType == ActionCardType.PrivateTipOne || actionCardType == ActionCardType.PrivateTipAll)
        {
            fileName = "";
        }
        else if (actionCardType == null)
        {
            fileName = "";
        }
        else
        {
            fileName = actionCardImages.get(actionCardType);
        }
        this.discardPile.changeCard(fileName);
    }

    public void setDestinationMarkers(String[] userNames, String[] destMarkers)
    {
        int j = 0;
        for (int i = 0; i < userNames.length; i++)
        {
            if (j < this.opponents.size() && this.opponents.get(j).getScreenName().equals(userNames[i]))
            {
                this.opponents.get(j).setDestinationMarker(destinationMarkerImages.get(destMarkers[i]));
                j++;
            }
            else
            {
                this.currentDestination = destMarkers[i];
                this.handDestinationMarker.changeMarker(destinationMarkerImages.get(destMarkers[i]));
            }
        }
    }

    public void setClueCards(String[] clueCards)
    {
        this.handPanel.removeAll();
        this.clueCards.clear();
        for (int i = 0; i < clueCards.length; i++)
        {
            CardLabel newCard = new CardLabel(clueCardImages.get(clueCards[i]));
            this.clueCards.add(newCard);
            this.handPanel.add(newCard);
        }
    }

    public void setCurrentPlayer(String currentPlayer)
    {
        this.currentPlayer = currentPlayer;
        if (this.userName.equals(this.currentPlayer))
        {
            this.playerTurn.setVisible(true);
        }
        else
        {
            this.playerTurn.setVisible(false);
        }
        for (int i = 0; i < this.opponents.size(); i++)
        {
            if (this.opponents.get(i).getScreenName().equals(this.currentPlayer))
            {
                this.opponents.get(i).enableTurnArrow();
            }
            else
            {
                this.opponents.get(i).disableTurnArrow();
            }
        }
    }

    public void playPrivateTip(List<Player> otherPlayers, List<String> description, ActionCardType actionCardType)
    {
        this.frame.enableEndTurnButton();
        this.frame.disableActionCards();
        this.frame.getViewBuilder().showPrivateTipDialog(otherPlayers, description, actionCardType);
    }

    public void playSnoop(List<Player> otherPlayers)
    {
        this.frame.enableEndTurnButton();
        this.frame.disableActionCards();
        this.frame.getViewBuilder().showSnoopDialog(otherPlayers);
    }

    public void playSuggestion(ActionCardType actionCardType, String currentDestination)
    {
        this.frame.enableEndTurnButton();
        this.frame.disableActionCards();
        this.frame.getViewBuilder().showSuggestionDialog(actionCardType,
                currentDestination);
    }

    public void playAllSnoop(ActionCardType actionCardType)
    {
        this.frame.enableEndTurnButton();
        this.frame.disableActionCards();
        this.frame.getController().sendAllSnoopAction(actionCardType);
    }

    public void setActionCards(ActionCard[] actionCards)
    {
        this.actionCardPanel.removeAll();
        this.actionCards.clear();
        for (int i = 0; i < actionCards.length; i++)
        {
            String fileName;
            ActionCardType cardType = actionCards[i].getType();
            ActionListener actionListener = new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                }
            };
            if (cardType == ActionCardType.PrivateTipAll || cardType == ActionCardType.PrivateTipOne)
            {
                final List<String> description = actionCards[i].getDescription();
                final ActionCardType actionCardType = actionCards[i].getType();
                fileName = privateTipCardImages.get(description.get(description.size() - 1));
                final List<Player> otherPlayers = new ArrayList<>();
                // get other players
                List<Player> allPlayers = this.table.getPlayers();
                for (int j = 0; j < allPlayers.size(); j++)
                {
                    Player currentPlayer = allPlayers.get(j);
                    if (!currentPlayer.getUsername().equals(player.getUsername()))
                    {
                        otherPlayers.add(currentPlayer);
                    }
                }
                actionListener = new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                        playPrivateTip(otherPlayers, description, actionCardType);
                    }
                };
            }
            else
            {
                fileName = actionCardImages.get(actionCards[i].getType());
                if (actionCards[i].getType() == ActionCardType.Snoop)
                {
                    final List<Player> otherPlayers = new ArrayList<>();
                    // get other players
                    List<Player> allPlayers = this.table.getPlayers();
                    for (int j = 0; j < allPlayers.size(); j++)
                    {
                        Player currentPlayer = allPlayers.get(j);
                        if (!currentPlayer.getUsername().equals(player.getUsername()))
                        {
                            otherPlayers.add(currentPlayer);
                        }
                    }
                    actionListener = new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt)
                            {
                                playSnoop(otherPlayers);
                            }
                        };
                }
                else if (actionCards[i].getType() == ActionCardType.SuggestFromAny|| actionCards[i].getType() == ActionCardType.SuggestFromCurrent)
                {
                    final ActionCardType actionCardType = actionCards[i].getType();
                    actionListener = new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt)
                        {
                            playSuggestion(actionCardType, currentDestination);
                        }
                    };
                }
                else
                {
                    final ActionCardType actionCardType = actionCards[i].getType();
                    actionListener = new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt)
                        {
                            playAllSnoop(actionCardType);
                        }
                    };
                }
            }
            CardButton newCard = new CardButton("", fileName, 0);
            newCard.addActionListener(actionListener);
            this.actionCards.add(newCard);
            this.actionCardPanel.add(newCard);
        }
        this.frame.refactor();
    }

    public String getUserName()
    {
        return this.userName;
    }

    public CardLabel getDiscardPile()
    {
        return this.discardPile;
    }

    public void appendToHistoryLog(String entry)
    {
        this.historyArea.append(entry + "\n");
    }

    public JButton getEndTurnButton()
    {
        return this.endTurnButton;
    }

    public JButton getArrestButton()
    {
        return this.arrestButton;
    }

    public void setName(String name)
    {
        this.userName = name;
        this.playerName.setText(this.userName);
    }

    public void setPlayerCount(int count)
    {
        this.computerCount = count;
        addOpponents();
    }

    public void enableActionCards()
    {
        for (int i = 0; i < this.actionCards.size(); i++)
        {
            this.actionCards.get(i).setEnabled(true);
        }
    }

    public void disableActionCards()
    {
        for (int i = 0; i < this.actionCards.size(); i++)
        {
            this.actionCards.get(i).setEnabled(false);
        }
    }

    private void setup()
    {
        getCardFiles();
        this.actionCards = new ArrayList<>();
        this.destinationMarkers = new ArrayList<>();
        this.opponents = new ArrayList<>();
        addDeckandDiscard();
        addDestinationMarkers();
        addCardsToHand();
    }

    private void getCardFiles()
    {
        this.fileNames = new String[]
        {
            "GreeceImages/Location-Athena-Forest.jpg",
            "GreeceImages/Location-Poseidon-Ocean.jpg",
            "GreeceImages/Suspects-Hera.jpg",
            "GreeceImages/Transportation-HadesDogs.jpg",
            "GreeceImages/Suspects-Hera.jpg",
            "GreeceImages/Suspects-Hermes.jpg",
            "GreeceImages/Transportation-ErosWings.jpg",
            "GreeceImages/Location-Phobe-Moon.jpg"
        };
    }

    private void addDeckandDiscard()
    {
        this.discardPile = new CardLabel("TempImages/back.png");
        this.discardPilePanel.add(this.discardPile);
        this.deckPanel.add(new CardLabel("TempImages/back.png"));
    }

    private void addOpponents()
    {
        for (int i = 0; i < this.computerCount; i++)
        {
            OpponentPanel newOpponent = new OpponentPanel("", 0);
            this.opponents.add(newOpponent);
            this.opponentPanel.add(newOpponent);
        }
    }

    private void addDestinationMarkers()
    {
        this.handDestinationMarker = new DestinationMarkerLabel("destinationMarkerObject");
        this.handDestinationMarkerPanel.add(this.handDestinationMarker);
    }

    private void addCardsToHand()
    {
//        for (int i = 0; i < 6; i++)
//        {
//            CardLabel newCard = new CardLabel(this.fileNames[i]);
//            this.clueCards.add(newCard);
//            this.handPanel.add(newCard);
//        }
        for (int i = 0; i < 2; i++)
        {
            CardButton newCard = new CardButton("", "", i);
            this.actionCards.add(newCard);
            newCard.addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    switch (e.getKeyCode())
                    {
                        case KeyEvent.VK_LEFT:
                            actionCards.get(0).requestFocus();
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (actionCards.size() > 1)
                            {
                                actionCards.get(1).requestFocus();
                            }
                            else
                            {
                                actionCards.get(0).requestFocus();
                            }
                            break;
                    }
                }
            });
            newCard.addMouseListener(new CardMouseAdapter(i));
            this.actionCardPanel.add(newCard);
        }
    }

    class CardMouseAdapter extends MouseAdapter
    {

        int cardNum;

        public CardMouseAdapter(int cardNum)
        {
            this.cardNum = cardNum;
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            actionCards.get(this.cardNum).requestFocus();
        }
    }

    public int getCardIndex(CardButton cardButton)
    {
        return this.actionCards.indexOf(cardButton);
    }

    public JButton getFirstCard()
    {
        return this.actionCards.get(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        deckPanel = new javax.swing.JPanel();
        handDestinationMarkerPanel = new javax.swing.JPanel();
        notesheetButton = new javax.swing.JButton();
        arrestButton = new javax.swing.JButton();
        discardPilePanel = new javax.swing.JPanel();
        endTurnButton = new javax.swing.JButton();
        handPanel = new javax.swing.JPanel();
        opponentPanel = new javax.swing.JPanel();
        rulesButton = new javax.swing.JButton();
        actionCardPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyArea = new javax.swing.JTextArea();
        historyLabel = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerTurn = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setFocusTraversalKeysEnabled(false);
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        deckPanel.setBackground(new java.awt.Color(255, 255, 255));
        deckPanel.setFocusTraversalKeysEnabled(false);
        deckPanel.setMaximumSize(new java.awt.Dimension(95, 142));
        deckPanel.setMinimumSize(new java.awt.Dimension(95, 142));
        deckPanel.setPreferredSize(new java.awt.Dimension(95, 142));
        deckPanel.setSize(new java.awt.Dimension(95, 142));
        deckPanel.setLayout(new java.awt.GridBagLayout());

        handDestinationMarkerPanel.setBackground(new java.awt.Color(255, 255, 255));
        handDestinationMarkerPanel.setFocusTraversalKeysEnabled(false);
        handDestinationMarkerPanel.setMaximumSize(new java.awt.Dimension(100, 100));
        handDestinationMarkerPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        handDestinationMarkerPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        handDestinationMarkerPanel.setSize(new java.awt.Dimension(100, 100));
        handDestinationMarkerPanel.setLayout(new javax.swing.BoxLayout(handDestinationMarkerPanel, javax.swing.BoxLayout.LINE_AXIS));

        notesheetButton.setBackground(new java.awt.Color(255, 255, 255));
        notesheetButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        notesheetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/buttons/notesheet.png"))); // NOI18N
        notesheetButton.setMaximumSize(new java.awt.Dimension(52, 70));
        notesheetButton.setMinimumSize(new java.awt.Dimension(52, 70));
        notesheetButton.setPreferredSize(new java.awt.Dimension(52, 70));
        notesheetButton.setRolloverEnabled(true);
        notesheetButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                notesheetButtonActionPerformed(evt);
            }
        });

        arrestButton.setBackground(new java.awt.Color(255, 255, 255));
        arrestButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        arrestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/buttons/arrest.png"))); // NOI18N
        arrestButton.setMaximumSize(new java.awt.Dimension(52, 72));
        arrestButton.setMinimumSize(new java.awt.Dimension(52, 72));
        arrestButton.setPreferredSize(new java.awt.Dimension(52, 72));
        arrestButton.setRolloverEnabled(true);
        arrestButton.setSize(new java.awt.Dimension(52, 72));
        arrestButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                arrestButtonActionPerformed(evt);
            }
        });

        discardPilePanel.setBackground(new java.awt.Color(255, 255, 255));
        discardPilePanel.setFocusTraversalKeysEnabled(false);
        discardPilePanel.setMaximumSize(new java.awt.Dimension(95, 142));
        discardPilePanel.setMinimumSize(new java.awt.Dimension(95, 142));
        discardPilePanel.setPreferredSize(new java.awt.Dimension(95, 142));
        discardPilePanel.setLayout(new java.awt.GridBagLayout());

        endTurnButton.setBackground(new java.awt.Color(255, 255, 255));
        endTurnButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        endTurnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/buttons/end.png"))); // NOI18N
        endTurnButton.setMaximumSize(new java.awt.Dimension(52, 72));
        endTurnButton.setMinimumSize(new java.awt.Dimension(52, 72));
        endTurnButton.setPreferredSize(new java.awt.Dimension(52, 72));
        endTurnButton.setRolloverEnabled(true);
        endTurnButton.setSize(new java.awt.Dimension(52, 72));
        endTurnButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                endTurnButtonActionPerformed(evt);
            }
        });

        handPanel.setBackground(new java.awt.Color(255, 255, 255));
        handPanel.setFocusTraversalKeysEnabled(false);
        handPanel.setLayout(new java.awt.GridBagLayout());

        opponentPanel.setBackground(new java.awt.Color(255, 255, 255));
        opponentPanel.setFocusTraversalKeysEnabled(false);
        opponentPanel.setMinimumSize(new java.awt.Dimension(766, 237));
        opponentPanel.setPreferredSize(new java.awt.Dimension(766, 237));
        opponentPanel.setRequestFocusEnabled(false);
        opponentPanel.setSize(new java.awt.Dimension(766, 237));
        opponentPanel.setLayout(new java.awt.GridBagLayout());

        rulesButton.setBackground(new java.awt.Color(255, 255, 255));
        rulesButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        rulesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/buttons/rules.png"))); // NOI18N
        rulesButton.setMaximumSize(new java.awt.Dimension(52, 72));
        rulesButton.setMinimumSize(new java.awt.Dimension(52, 72));
        rulesButton.setPreferredSize(new java.awt.Dimension(52, 72));
        rulesButton.setRolloverEnabled(true);
        rulesButton.setSize(new java.awt.Dimension(52, 72));
        rulesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rulesButtonActionPerformed(evt);
            }
        });

        actionCardPanel.setBackground(new java.awt.Color(255, 255, 255));
        actionCardPanel.setLocation(new java.awt.Point(224, 148));
        actionCardPanel.setMinimumSize(new java.awt.Dimension(224, 148));
        actionCardPanel.setPreferredSize(new java.awt.Dimension(224, 148));
        actionCardPanel.setSize(new java.awt.Dimension(224, 148));
        actionCardPanel.setVerifyInputWhenFocusTarget(false);
        actionCardPanel.setLayout(new java.awt.GridBagLayout());

        historyArea.setEditable(false);
        historyArea.setColumns(20);
        historyArea.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        historyArea.setRows(5);
        jScrollPane1.setViewportView(historyArea);

        historyLabel.setBackground(new java.awt.Color(255, 255, 255));
        historyLabel.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        historyLabel.setText("History");

        playerName.setBackground(new java.awt.Color(255, 255, 255));
        playerName.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        playerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        playerTurn.setBackground(new java.awt.Color(255, 255, 255));
        playerTurn.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        playerTurn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/TempImages/turnimageinvert.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(notesheetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 8, Short.MAX_VALUE)
                        .add(opponentPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 673, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(rulesButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(endTurnButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(arrestButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, playerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, handDestinationMarkerPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, discardPilePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(actionCardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 159, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(12, 12, 12)
                        .add(handPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 480, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(141, 141, 141)
                                .add(deckPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(58, 58, 58)
                                .add(playerTurn)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(historyLabel)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 501, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(20, 20, 20)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(arrestButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(rulesButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(endTurnButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(notesheetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, opponentPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(historyLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(discardPilePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(deckPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(26, 26, 26)
                        .add(playerTurn))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(handPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(playerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(4, 4, 4)
                        .add(handDestinationMarkerPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(actionCardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void endTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnButtonActionPerformed

        this.frame.disableEndTurnButton();
        this.frame.getController().sendEndTurn();
    }//GEN-LAST:event_endTurnButtonActionPerformed

    private void rulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesButtonActionPerformed
        this.layerPane.add(this.rulesPanel, JLayeredPane.DRAG_LAYER);
        this.layerPane.moveToFront(this.rulesPanel);
        this.layerPane.validate();
        this.rulesPanel.getBackButton().requestFocus();
    }//GEN-LAST:event_rulesButtonActionPerformed

    private void notesheetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesheetButtonActionPerformed
        this.layerPane.add(this.noteSheet, JLayeredPane.DRAG_LAYER);
        this.layerPane.moveToFront(this.noteSheet);
        this.layerPane.moveToBack(this);
        this.layerPane.moveToBack(this.rulesPanel);
        this.layerPane.validate();
        this.noteSheet.getPerson1Check().requestFocus();
    }//GEN-LAST:event_notesheetButtonActionPerformed

    private void arrestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrestButtonActionPerformed
        this.arrestPanel = new ArrestPanel(this.frame, this.layerPane, this.noteSheet);
        this.arrestPanel.setCards(this.actionCards);
        this.arrestPanel.setTablePanel(this);
        this.arrestPanel.setupCards();
        this.layerPane.add(this.arrestPanel, JLayeredPane.DRAG_LAYER);
        this.layerPane.moveToFront(this.arrestPanel);
        this.frame.pack();
        this.layerPane.moveToBack(this);
        this.layerPane.moveToBack(this.noteSheet);
        this.layerPane.moveToBack(this.rulesPanel);
        this.layerPane.validate();
        this.arrestButton.setEnabled(false);
    }//GEN-LAST:event_arrestButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionCardPanel;
    private javax.swing.JButton arrestButton;
    private javax.swing.JPanel deckPanel;
    private javax.swing.JPanel discardPilePanel;
    private javax.swing.JButton endTurnButton;
    private javax.swing.JPanel handDestinationMarkerPanel;
    private javax.swing.JPanel handPanel;
    private javax.swing.JTextArea historyArea;
    private javax.swing.JLabel historyLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton notesheetButton;
    private javax.swing.JPanel opponentPanel;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel playerTurn;
    private javax.swing.JButton rulesButton;
    // End of variables declaration//GEN-END:variables
}
