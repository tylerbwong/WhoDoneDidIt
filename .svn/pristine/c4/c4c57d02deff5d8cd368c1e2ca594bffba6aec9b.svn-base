package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Tyler Wong
 */
public class RulesPanel extends javax.swing.JPanel
{

    private MainFrame frame;
    JLayeredPane layerPane;
    private boolean inGame;
    private String language;

    /**
     * Creates new form Rules
     */
    public RulesPanel(MainFrame frame, JLayeredPane layerPane)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        BackAction backAction = new BackAction(this);
        initComponents();
        this.backButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "pressed");
        this.backButton.getActionMap().put("pressed", backAction);
    }

    class BackAction extends AbstractAction
    {

        RulesPanel panel;

        public BackAction(RulesPanel panel)
        {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Closed rules");
            layerPane.remove(layerPane.getIndexOf(panel));
            layerPane.repaint();
            layerPane.validate();
        }
    }
    
    public void setLanguage(String lang)
    {
        this.language = lang;
        
        if (this.language.equals("Español"))
        {
            this.titleLabel.setText("Reglas");
            this.rulesArea.setText("JUGAR\n" +
"\n" +
"El distribuidor juega primero. Juego pasa a la izquierda. En su turno, usted:\n" +
"1. Tome la tarjeta de acción de arriba del mazo y agregarlo a tu mano.\n" +
"2. Juega uno de sus dos cartas de acción (ver \"Naipes Acción\" a continuación).\n" +
"3. Concluir su turno marcando fuera de la identidad de cualquier tarjeta de Pista que se mostraron durante tu turno. Siéntase libre de tomar notas en su notesheet, como lo que se ve sucediendo durante los turnos de otros jugadores.\n" +
"4. A menos que usted está listo para hacer una acusación (ver \"Cómo hacer una acusación\"), su turno termina. Coloque la carta de Acción que acabas de jugar en la pila de descartes. El jugador a la izquierda ahora toma su turno.\n" +
"\n" +
"Naipes Acción\n" +
"Hay cinco tipos diferentes de cartas de Acción. Para jugar una carta de Acción (excepto un Consejo Privado), sólo tiene que tomar la carta de tu mano y colóquelo boca arriba sobre la mesa frente a usted.\n" +
"\n" +
"* HACER UNA SUGERENCIA desde cualquier destino\n" +
"Decidir qué destino está a parte de su sugerencia. Si el destino es diferente a la que se encuentra, cambiar su marcador Destino actual para el destino deseado. Si otro jugador tiene esta Marker Destinos, dará que la suya jugador a cambio. Si el marcador deseado es por la bandeja, intercambiar con su marcador. una vez que el marcador de destino deseado está delante de ti, hacer su sugerencia (ver \"Hacer una Sugerencia\").\n" +
"\n" +
"* HACER UNA SUGERENCIA del destino actual (o mover)\n" +
"Sólo se puede hacer una sugerencia del destino cuyo marcador de destino es actualmente ante usted o usted puede intercambiar el marcador de destino para otro - pero si lo hace, usted termina su turno sin hacer una sugerencia (ver \"Hacer una Sugerencia\").\n" +
"\n" +
"* FISGONEAR\n" +
"Seleccionar un oponente a poner toda su mano, boca abajo, sobre la mesa. Elija cualquier tarjeta y mirarlo, teniendo cuidado de que ningún otro jugador ve su identidad. Devuelva la tarjeta al oponente que luego recoge toda la mano.\n" +
"\n" +
"* ALL SNOOP significa que cada jugador colocará toda la cara la mano hacia abajo, hacia el jugador indicado en la tarjeta. Cada jugador curiosea en la mano que se le ofrece.\n" +
"\n" +
"* Sleuth ESTUPENDO (no disponible en la versión 1.0)\n" +
"Lea en voz alta la tarjeta y mostrar a tus oponentes. Cada uno, a su vez, debe ahora mostrar una tarjeta Clue con la característica especificada. (Por ejemplo, \"Muéstrame un destino en el sur.\") Si un jugador no tiene una tarjeta del tipo especificado, se muestra nada.\n" +
"\n" +
"* CONSEJO PRIVADO\n" +
"Pase esta carta boca abajo a un rival que lo recoge y lo lee a sí mismo. Luego regresa esta carta, junto con una carta Clue del tipo solicitado (o todas las cartas que tiene de este tipo, si así se lo indique la tarjeta Consejo Privado). Si el oponente no tiene cartas del tipo solicitado, se devuelve sólo la tarjeta Consejo Privado. Volver tarjeta de Pista (s) al oponente después de estudiarlos. IMPORTANTE: Después de jugar una tarjeta de lugar \"privado Tip\", en los términos de la pila de descartes, boca abajo\n" +
"\n" +
"\n" +
"La terminación de su Turno\n" +
"Después de haber jugado una carta de Acción, colóquelo boca arriba en la pila de descartes, a menos que usted jugó un Consejo Privado. La identidad de estas tarjetas debe mantenerse en secreto de sus oponentes, por lo que los coloca abajo.\n" +
"\n" +
"Haciendo una sugerencia\n" +
"\n" +
"Para hacer una sugerencia, nombrar a un sospechoso, de vehículos y el destino cuyo marcador está delante de ti.\n" +
"\n" +
"Ejemplo: \"Sugiero que el profesor Ciruela es viajar en el globo de aire caliente, al Gran Cañón\".\n" +
"\n" +
"Hacer sugerencias a través del juego le ayudará a determinar - por proceso de eliminación - que tres cartas comprenden la solución.\n" +
"\n" +
"Demostrando una sugerencia Verdadero o Falso\n" +
"Tan pronto como usted hace una sugerencia, sus oponentes, a su vez, tratan de demostrarlo falsa. El primero en probar es el jugador a su izquierda. Ese jugador mira sus cartas para ver si una de las tres cartas que acaba de ser nombrado está ahí. Si es así, debe mostrar a usted y nadie más. Si el jugador tiene más de una de las cartas llamadas, se selecciona una sola para mostrarle. Si ese oponente no tiene ninguna de las cartas que usted nombró, entonces la oportunidad de demostrar su sugerencia falsos pases, a su vez, al siguiente jugador a la izquierda.\n" +
"\n" +
"Tan pronto como cualquier oponente que muestra una de las tarjetas que usted nombró, es una prueba de que esta carta no puede ser parte de la solución. Para terminar el turno marcando fuera de esta tarjeta en su notesheet. (Algunos jugadores también les resulta útil para marcar las iniciales del jugador que mostró la tarjeta.) Si no hay nadie capaz de demostrar su sugerencia falsa, es posible que ya sea terminar tu turno o hacer una Acusación.\n" +
"\n" +
"Nota especial sobre Sugerencias\n" +
"Cuando usted hace una sugerencia, puede, si lo desea, el nombre de una o más de las cartas que tienes en tu mano. Esto puede ayudar a identificar información o para engañar a tus oponentes.\n" +
"\n" +
"\n" +
"Cómo hacer una Acusación\n" +
"\n" +
"Cuando usted piensa que ha descubierto que tres cartas comprenden la solución, usted debe hacer una acusación en su turno. Usted puede hacerlo después de jugar una carta de Acción, o si usted está convencido de que sabe la solución, es posible hacer una acusación sin jugar una carta de Acción. Hacerlo al nombrar los tres elementos que cree que va a estar en que se encuentra en la Solución. Comienza diciendo: \"Yo acuso (sospechoso) de cometer el crimen. Él / ella en viajar a (Destino) en el (vehículo).\" Entonces, teniendo cuidado de que nadie más ve, mira las tres tarjetas de Pista de la Solución.\n" +
"\n" +
"Nota: En una sugerencia, el destino que nombre debe ser el mismo que el marcador de destino antes. En una acusación, es posible que el nombre de cualquier destino. También recuerde que usted puede hacer sólo una acusación por juego.\n" +
"\n" +
"Victorioso\n" +
"\n" +
"Si su acusación es correcta (es decir, los tres elementos que usted nombró están en la solución), mostrar a los otros jugadores las tarjetas y reclamar su victoria. Gran trabajo de detective! ¡Tú ganas!\n" +
"\n" +
"Si su acusación es incorrecta ...\n" +
"Secretamente devolver las tres tarjetas de la Solución boca abajo.\n" +
"Tenga cuidado de no dejar escapar ninguna parte de la solución.\n" +
"Usted permanece en el juego, pero hace sin más obras, por lo que no se puede ganar.\n" +
"Usted continúa para tratar de probar Sugerencias de tus oponentes falsa.\n" +
"Los opositores aún pueden intercambiar marcadores Destino con ustedes como siempre.");
            this.rulesArea.setCaretPosition(0);
            this.backButton.setText("Regresa");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
        else if(this.language.equals("中文"))
        {
            this.titleLabel.setText("規則");
            this.rulesArea.setText("玩\n" +
"\n" +
"經銷商扮演第一。發揮傳遞到左邊。在你的回合，你：\n" +
"1.採取從牌堆頂的行動卡，並把它添加到你的手。\n" +
"2。發揮你的兩個行動卡之一（見“播放操作卡”下）。\n" +
"3.結束你又被檢查過的你把你的過程中表現出任何線索卡的身份。歡迎來記錄你的notesheet，你會看到在其他玩家的回合發生了什麼，例如。\n" +
"4.除非你是準備做的指控（見“製作的指控”），現在輪到你結束。地方，你只是打在棄牌堆操作卡。玩家到你的左邊，現在需要輪到他。\n" +
"\n" +
"玩動作卡\n" +
"有五種不同類型的行動牌。要發揮行動卡（除專用提示），簡單地從你的手牌，並把它正面朝上放在桌上在你面前。\n" +
"\n" +
"*從任何目的地提提意見\n" +
"決定哪些目標將是你的建議的一部分。如果目標是比你有不同，交流您的當前目標標記所需的目的地。如果其他球員有這個目標標記，給該玩家你的回報。如果需要的標記是由托盤，用你的標記交換它。一旦所期望的目標標記是你面前，讓你的建議（見“製作建議”）。\n" +
"\n" +
"*建立從當前的目標的建議（或移動）\n" +
"你可能只會使從其目標標記是當前之前，你或者你可以交換目標標記另一個目的地的建議 - 但如果你這樣做，你最終輪到你沒有作出建議（請參閱“使一個建議”）。\n" +
"\n" +
"* SNOOP\n" +
"選擇一個對手將他的整只手，面朝下，放在桌子上。隨便選一個卡，並看著它，照顧沒有其他玩家看到它的身份。返回卡給對手誰再拿起他的整只手。\n" +
"\n" +
"* ALL SNOOP意味著每個球員會下來把他的整只手的臉轉向卡上標註的球員。每個玩家再探聽上提供給他的手。\n" +
"\n" +
"*超級SLEUTH（不適用於1.0版）\n" +
"朗讀卡，並顯示給你的對手。每個反過來，現在必須告訴你一個線索卡指定的功能。 （例如，“讓我在南方一個目標。”）如果一個球員沒有指定類型的卡，他說明不了什麼。\n" +
"\n" +
"*私人提示\n" +
"通過這個牌面向下一個對手誰選了，它讀取自己。隨後，他返回此卡，以及請求的類型（或舉辦這種類型的，如果是由私人提示牌指示所有卡）中的一個線索卡。如果對手沒有卡請求的類型，他只返回私人提示卡。他們研究後返回線索卡（S）的對手。重要提示：玩“私人提示”牌的地方後，在棄牌堆，面朝下\n" +
"\n" +
"\n" +
"結束輪到你了\n" +
"當你發揮了動作卡，將其正面在棄牌堆，除非你扮演一個私人提示。這些卡的身份必須保密的對手，所以把他們失望。\n" +
"\n" +
"製作建議\n" +
"\n" +
"提出一個建議，名嫌疑人，車輛，其標誌是在你的目標。\n" +
"\n" +
"例如：“我認為，梅教授正行駛在熱氣球，大峽谷。”\n" +
"\n" +
"整個遊戲提出建議將幫助你確定 - 通過排除法 - 這三張牌組成的解決方案。\n" +
"\n" +
"證明一個建議真或假\n" +
"只要您撥打一個建議，你的對手，反過來，試圖證明其錯誤。先行先試是站在你左邊的球員。該玩家看自己的牌，看看你剛剛任命的三張牌人在那裡。如果是的話，他必須證明給你看，並沒有其他人。如果玩家有多個命名的卡，他選擇只是一個給你看。如果對手有沒有，你叫的牌，那麼機會來證明你的建議假通行證，反過來，在左邊的下一個玩家。\n" +
"\n" +
"只要任何一個對手展示你的你被點名的卡之一，它證明了這種卡不能成為解決方案的一部分。結束輪到你用你的notesheet檢查過此卡。 （有些球員也覺得有幫助，以紀念誰發現該卡球員的首字母）。如果沒有人能證明你的建議假的，你既可以結束輪到你或進行指控。\n" +
"\n" +
"有關建議特別提示\n" +
"當你提出一個建議，你可以，如果你願意的話​​，說出一個，你握在手裡的牌或更多。這可以幫助查明信息或誤導你的對手。\n" +
"\n" +
"\n" +
"製作指控\n" +
"\n" +
"當你認為你已經想通了這三張牌組成的解決方案，您應就輪到你的指控。你可以這樣做你玩一個動作卡後，或者如果你確信你知道解決方案，您可以製作的指控沒有發揮作用卡。這樣做，通過命名你相信會在解決方案中的三個要素。說，“我控訴作案的（犯罪嫌疑人）在行駛到（目的地）在（車輛），他/她。”開始然後，小心，沒有人看，看解決方案的三個線索卡。\n" +
"\n" +
"注：在一個建議，你的名字目標必須和以前一樣，你的目標標記。在指控中，您可以指定任何目標。還記得你可以讓每場比賽只有一個罪名。\n" +
"\n" +
"獲獎\n" +
"\n" +
"如果你的指控是正確的（即是，你被點名的三個要素是在解決方案），顯示其他玩家的牌，並聲稱你們的勝利。大偵探的工作！你贏了！\n" +
"\n" +
"如果你的指責是不正確？\n" +
"偷偷返回解決方案面朝下的三張牌。\n" +
"要小心，不要脫口而出的任何解決方案的一部分。\n" +
"你留在遊戲中，但不再做進一步的劇本，所以你不能贏。\n" +
"你繼續努力，以證明你的對手的建議虛假。\n" +
"對手可能仍然與你交換目的地標記如常。");
            this.rulesArea.setCaretPosition(0);
            this.backButton.setText("回去");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
    }

    public void setInGame(boolean inGame)
    {
        this.inGame = inGame;
    }

    public JButton getBackButton()
    {
        return this.backButton;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rulesArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        titleLabel.setText("Rules");

        rulesArea.setEditable(false);
        rulesArea.setColumns(20);
        rulesArea.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rulesArea.setLineWrap(true);
        rulesArea.setRows(5);
        rulesArea.setText("PLAY\n\nThe dealer plays first. Play passes to the left. On your turn, you:\n1. Take the top Action card from the Draw Pile and add it to your hand.\n2. Play one of your two Action cards (see \"Playing Action Cards\" below).\n3. Conclude your turn by checking off the identity of any Clue cards you were shown during your turn. Feel free to keep notes on your notesheet, such as what you see happening during other players' turns.\n4. Unless you are ready to make an Accusation (see \"Making an Accusation\"), your turn now ends. Place the Action card you just played on the discard pile. The player to your left now takes his turn.\n\nPlaying Action Cards\nThere are five different types of Action cards. To play an Action card (except a Private Tip), simply take the card from your hand and place it face up on the table in front of you.\n\n* MAKE A SUGGESTION from any destination\nDecide which Destination will be part of your Suggestion. If the destination is different than the one you are in, exchange your current Destination Marker for the desired destination. If another player has this Destination Marker, give that player yours in return. If the desired marker is by the tray, exchange it with your marker. once the desired Destination Marker is before you, make your Suggestion(see \"Making a Suggestion\").\n\n* MAKE A SUGGESTION from current destination (or move)\nYou may only make a Suggestion from the destination whose Destination Marker is currently before you OR you can exchange the Destination Marker for another - but if you do so, you end your turn without making a Suggestion (see \"Making a Suggestion\").\n\n* SNOOP\nSelect an opponent to lay his entire hand, face down, on the table. Pick any one card and look at it, taking care that no other player sees its identity. Return the card to the opponent who then picks up his entire hand.\n\n* ALL SNOOP means that each player will place his entire hand face down towards the player indicated on the card. Each player then snoops on the hand offered to him.\n\n* SUPER SLEUTH (Not Available in Version 1.0)\nRead aloud the card and show it to your opponents. Each, in turn, must now show you one Clue card with the specified feature. (For example, \"Show me a destination in the south.\")  If a player doesn't have a card of the kind specified, he shows nothing.\n\n* PRIVATE TIP\nPass this card face down to an opponent who picks it up and reads it to himself. He then returns this card, along with one Clue card of the type requested (or all cards held of this type, if so instructed by the Private Tip card). If the opponent has no cards of the type requested, he returns only the Private Tip card. Return Clue card(s) to the opponent after studying them. IMPORTANT: After playing a \"Private Tip\" card place, it under the discard pile, face-down\n\n\nEnding your Turn\nAfter you have played an Action card, place it face up in the discard pile, unless you played a Private Tip. The identity of these cards needs to be kept secret from your opponents, so place them down.\n\nMaking a Suggestion\n\nTo make a Suggestion, name a Suspect, Vehicle and the Destination whose marker is before you.\n\nExample: \"I suggest that Professor Plum is traveling in the Hot Air Balloon, to the Grand Canyon.\"\n\nMaking Suggestions throughout the game will help you to determine - by process of elimination - which three cards comprise the SOLUTION.\n\nProving a Suggestion True or False\nAs soon as you make a Suggestion, your opponents, in turn, try to prove it false. The first to try is the player on your left. That player looks at his cards to see if one of the three cards you just named is there. If so, he must show it to you and no one else. If the player has more than one of the cards named, he selects just one to show you. If that opponent has none of the cards that you named, then the chance to prove your Suggestion false passes, in turn, to the next player on the left.\n\nAs soon as any opponent shows you one of the cards you named, it is proof that this card cannot be part of the solution. End your turn by checking off this card on your notesheet. (Some players also find it helpful to mark the initials of the player who showed the card.) If no one is able to prove your Suggestion false, you may either end your turn or make an Accusation.\n\nSpecial Note about Suggestions\nWhen you make a Suggestion, you may, if you wish, name one or more of the cards that you hold in your hand. This can help to pinpoint information or to mislead your opponents.\n\n\nMaking an Accusation\n\nWhen you think you have figured out which three cards comprise the Solution, you should make an Accusation on your turn. You may do so after you play an Action card, or if you are convinced you know the Solution, you may make an Accusation without playing an Action card. Do so by naming the three elements you believe will be in found in the Solution. Begin by saying, \"I accuse (Suspect) of committing the crime. He/she in traveling to (Destination) in the (Vehicle).\" Then, taking care that no one else sees, look at the three Clue cards of the Solution.\n\nNote: In a Suggestion, the Destination you name must be the same as the Destination Marker before you. In an Accusation, you may name any destination. Also remember that you may make only one Accusation per game.\n\nWinning\n\nIf your Accusation is correct (that is, the three elements you named are in the Solution), show the other players the cards and claim your victory. Great detective work! You win!\n\nIf your Accusation is incorrect...\nSecretly return all three cards of the Solution face-down.\nBe careful not to blurt out any part of the solution.\nYou remain in the game but make no further plays, so you cannot win.\nYou continue to try to prove your opponents' Suggestions false.\nOpponents may still exchange Destination markers with you as usual.");
        rulesArea.setCaretPosition(0);
        jScrollPane1.setViewportView(rulesArea);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                backButtonMouseEntered(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backButtonActionPerformed(evt);
            }
        });
        backButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                backButtonKeyPressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(48, 48, 48)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(backButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 708, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(titleLabel))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(titleLabel)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 429, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(backButton)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (!this.inGame)
        {
            this.frame.removePanel(this);
            this.frame.createMainMenuPanel();
        }
        else
        {
            System.out.println("Closed rules");
            this.layerPane.remove(this.layerPane.getIndexOf(this));
            this.layerPane.repaint();
            this.layerPane.validate();
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void backButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backButtonKeyPressed
        this.backButton.requestFocus();
    }//GEN-LAST:event_backButtonKeyPressed

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        this.backButton.requestFocus();
    }//GEN-LAST:event_backButtonMouseEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea rulesArea;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
