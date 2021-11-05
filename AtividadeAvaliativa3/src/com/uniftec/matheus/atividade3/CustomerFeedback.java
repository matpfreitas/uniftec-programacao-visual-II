package com.uniftec.matheus.atividade3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerFeedback extends JFrame implements ActionListener {

    private JLabel lblService1, lblService2, lblReasons;
    private JComboBox cboService1, cboService2;
    private JTextArea suggestionsArea = new JTextArea(10, 10);
    private JButton btnVerify;
    private JPopupMenu menuPopup;
    private JMenuItem itemCleanPopup;
    private GridBagConstraints restrictions = new GridBagConstraints();
    private JPanel pnlService, pnlReasons, pnlCustomerFeedback;

    public CustomerFeedback() {

        this.setTitle("Avaliação do Atendimento");
        this.setSize(600, 400);
        this.setLocation(500, 100);
        this.setResizable(true);
        restrictions.fill = GridBagConstraints.BOTH;


        lblService1 = new JLabel("Atendimento 1:");
        cboService1 = new JComboBox();
        cboService1.setToolTipText("Selecione a nota para o nosso atendimento 1");
        cboService1.addItem("0");
        cboService1.addItem("1");
        cboService1.addItem("2");
        cboService1.addItem("3");
        cboService1.addItem("4");
        cboService1.addItem("5");

        lblService2 = new JLabel("Atendimento 2:");
        cboService2 = new JComboBox();
        cboService2.setToolTipText("Selecione a nota para o nosso atendimento 2");
        cboService2.addItem("0");
        cboService2.addItem("1");
        cboService2.addItem("2");
        cboService2.addItem("3");
        cboService2.addItem("4");
        cboService2.addItem("5");

        lblReasons = new JLabel("Motivo que te levou a dar esta nota:");
        suggestionsArea.setLineWrap(true);
        suggestionsArea.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(suggestionsArea);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        menuPopup = new JPopupMenu();
        itemCleanPopup = new JMenuItem("Limpar");
        itemCleanPopup.setMnemonic('L');
        itemCleanPopup.setToolTipText("Apagar o texto digitado");
        itemCleanPopup.addActionListener(this);
        menuPopup.add(itemCleanPopup);

        btnVerify = new JButton("Verificar");
        btnVerify.setMnemonic('V');
        btnVerify.setToolTipText("Calcula a média dos atendimentos");
        btnVerify.addActionListener(this);

        pnlService = new JPanel(new GridBagLayout());
        restrictions.insets = new Insets(8, 8, 8, 8);
        addGridBag(0, 0, lblService1, pnlService);
        addGridBag(1, 0, cboService1, pnlService);
        addGridBag(0, 1, lblService2, pnlService);
        addGridBag(1, 1, cboService2, pnlService);

        pnlReasons = new JPanel(new GridBagLayout());
        addGridBag(0, 0, lblReasons, pnlReasons);
        addGridBag(0, 1, sp, pnlReasons);
        addGridBag(0, 2, btnVerify, pnlReasons);

        pnlCustomerFeedback = new JPanel(new GridBagLayout());
        addGridBag(0, 0, pnlService, pnlCustomerFeedback);
        addGridBag(0, 1, pnlReasons, pnlCustomerFeedback);

        Container container = getContentPane();
        container.add(pnlCustomerFeedback);

        suggestionsArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent event) {
                if (event.isPopupTrigger())
                    menuPopup.show(event.getComponent(), event.getX(), event.getY());
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object origin = event.getSource();

        if (origin == btnVerify) {

            float service1, service2, average;

            service1 = Float.parseFloat(cboService1.getSelectedItem().toString());
            service2 = Float.parseFloat(cboService2.getSelectedItem().toString());

            average = (service1 + service2) / 2;

            if (average >= 4) {

                String messageText = "Parabéns pelo atendimento!";

                if (!suggestionsArea.getText().equals("")) {

                    messageText = messageText + "\nMotivo: " + suggestionsArea.getText().toString();
                }

                JOptionPane.showMessageDialog(
                        null,
                        messageText,
                        "Avaliação do Atendimento",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if ((average >= 2) && (average < 4)) {

                String messageText = "Atendimento Regular!";

                if (!suggestionsArea.getText().equals("")) {

                    messageText = messageText + "\nMotivo: " + suggestionsArea.getText().toString();
                }

                JOptionPane.showMessageDialog(
                        null,
                        messageText,
                        "Avaliação do Atendimento",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {

                String messageText = "Melhorar urgentemente o atendimento!";

                if (!suggestionsArea.getText().equals("")) {

                    messageText = messageText + "\nMotivo: " + suggestionsArea.getText().toString();
                }

                JOptionPane.showMessageDialog(
                        null,
                        messageText,
                        "Avaliação do Atendimento",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (origin == itemCleanPopup) {
            suggestionsArea.setText("");
            suggestionsArea.requestFocus();
        }

    }

    public void addGridBag(final int x, final int y, final Component obj, final JPanel pnl) {
        restrictions.gridx = x;
        restrictions.gridy = y;
        pnl.add(obj, restrictions);
    }

    public static void main(String[] args) {
        CustomerFeedback window = new CustomerFeedback();
        window.setVisible(true);
        window.pack();
    }
}
