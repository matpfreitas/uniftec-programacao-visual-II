package com.uniftec.matheus.atividade2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    private JLabel lblValue1, lblValue2, lblResult;
    private JTextField txtValue1, txtValue2;
    private JRadioButton rbAdd, rbSub, rbMult, rbDiv;
    private ButtonGroup rbGroup;
    private JCheckBox cbResult;
    private JButton btnCalc, btnClean;
    private GridBagConstraints restrictions = new GridBagConstraints();
    protected JPanel pnlData, pnlRadioButtons, pnlCheckBox, pnlButtons, pnlResult, pnlFrame;


    public Calculadora() {

        this.setTitle("Calculadora");
        this.setSize(500, 400);
        this.setLocation(300, 100);
        this.setResizable(true);
        restrictions.fill = GridBagConstraints.BOTH;

        lblValue1 = new JLabel("Valor 1:", JLabel.RIGHT);
        txtValue1 = new JTextField(20);
        txtValue1.setToolTipText("Digite o primeiro valor");

        lblValue2 = new JLabel("Valor 2:", JLabel.RIGHT);
        txtValue2 = new JTextField(20);
        txtValue2.setToolTipText("Digite o segundo valor");

        rbGroup = new ButtonGroup();
        rbAdd = new JRadioButton("Somar");
        rbGroup.add(rbAdd);
        rbSub = new JRadioButton("Subtrair");
        rbGroup.add(rbSub);
        rbMult = new JRadioButton("Multiplicar");
        rbGroup.add(rbMult);
        rbDiv = new JRadioButton("Dividir");
        rbGroup.add(rbDiv);

        cbResult = new JCheckBox("Mostrar resultado na tela");

        btnCalc = new JButton("Calcular");
        btnCalc.setMnemonic('C');
        btnCalc.setToolTipText("Realiza o cálculo selecionado");
        btnCalc.addActionListener(this);

        btnClean = new JButton("Limpar");
        btnClean.setMnemonic('L');
        btnClean.setToolTipText("Limpa os dados");
        btnClean.addActionListener(this);

        lblResult = new JLabel("Resultado: ", JLabel.CENTER);

        pnlData = new JPanel(new GridBagLayout());
        restrictions.insets = new Insets(8, 8, 8, 8);
        addGridBag(0, 0, lblValue1, pnlData);
        addGridBag(1, 0, txtValue1, pnlData);
        addGridBag(0, 1, lblValue2, pnlData);
        addGridBag(1, 1, txtValue2, pnlData);

        pnlRadioButtons = new JPanel(new GridBagLayout());
        addGridBag(0, 0, rbAdd, pnlRadioButtons);
        addGridBag(1, 0, rbSub, pnlRadioButtons);
        addGridBag(0, 1, rbMult, pnlRadioButtons);
        addGridBag(1, 1, rbDiv, pnlRadioButtons);

        pnlCheckBox = new JPanel(new GridBagLayout());
        addGridBag(0, 0, cbResult, pnlCheckBox);

        pnlButtons = new JPanel(new GridBagLayout());
        addGridBag(0, 0, btnCalc, pnlButtons);
        addGridBag(1, 0, btnClean, pnlButtons);

        pnlResult = new JPanel(new GridBagLayout());
        addGridBag(0, 0, lblResult, pnlResult);

        pnlFrame = new JPanel(new GridBagLayout());
        addGridBag(0, 0, pnlData, pnlFrame);
        addGridBag(0, 1, pnlRadioButtons, pnlFrame);
        addGridBag(0, 2, pnlCheckBox, pnlFrame);
        addGridBag(0, 3, pnlButtons, pnlFrame);
        addGridBag(0, 4, pnlResult, pnlFrame);

        Container container = getContentPane();
        container.add(pnlFrame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void addGridBag(final int x, final int y, final Component obj, final JPanel pnl) {
        restrictions.gridx = x;
        restrictions.gridy = y;
        pnl.add(obj, restrictions);
    }

    public static void main(String[] args) {
        Calculadora window = new Calculadora();
        window.setVisible(true);
    }
}
