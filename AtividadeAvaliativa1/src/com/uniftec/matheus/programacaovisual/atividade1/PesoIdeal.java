package com.uniftec.matheus.programacaovisual.atividade1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesoIdeal extends JFrame implements ActionListener {

    private JLabel lblHeight, lblGender, lblResult;
    private JTextField txtHeight;
    private JComboBox cboGender;
    private JButton btnCalc, btnClean, btnClose;
    private GridBagConstraints restrictions = new GridBagConstraints();
    protected JPanel pnlDados, pnlButtons, pnlWindow, pnlResult;

    public PesoIdeal() {

        this.setTitle("Calculadora Peso Ideal");
        this.setSize(600, 300);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        this.setLocation(d.width / 4, d.height / 4);
        this.setResizable(false);
        restrictions.fill = GridBagConstraints.BOTH;

        lblHeight = new JLabel("Altura:", JLabel.RIGHT);
        txtHeight = new JTextField(20);
        txtHeight.setToolTipText("Digite a altura");

        lblGender = new JLabel("Sexo:", JLabel.RIGHT);
        cboGender = new JComboBox();
        cboGender.setToolTipText("Selecione o sexo");
        cboGender.addItem("Masculino");
        cboGender.addItem("Feminino");

        btnCalc = new JButton("Calcular");
        btnCalc.setMnemonic('C');
        btnCalc.setToolTipText("Calcula o peso ideal");
        btnCalc.addActionListener(this);

        btnClean = new JButton("Limpar");
        btnClean.setMnemonic('L');
        btnClean.setToolTipText("Limpa os dados");
        btnClean.addActionListener(this);

        btnClose = new JButton("Fechar");
        btnClose.setMnemonic('F');
        btnClose.setToolTipText("Fecha o software");
        btnClose.addActionListener(this);

        lblResult = new JLabel("Resultado: ", JLabel.CENTER);

        pnlDados = new JPanel(new GridBagLayout());
        restrictions.insets = new Insets(8, 8, 8, 8);
        addGridBag(0, 0, lblHeight, pnlDados);
        addGridBag(1, 0, txtHeight, pnlDados);
        addGridBag(0, 1, lblGender, pnlDados);
        addGridBag(1, 1, cboGender, pnlDados);

        pnlButtons = new JPanel(new GridBagLayout());
        addGridBag(0, 0, btnCalc, pnlButtons);
        addGridBag(1, 0, btnClean, pnlButtons);
        addGridBag(2, 0, btnClose, pnlButtons);

        pnlResult = new JPanel(new GridBagLayout());
        addGridBag(0, 0, lblResult, pnlResult);

        pnlWindow = new JPanel(new GridBagLayout());
        addGridBag(0, 0, pnlDados, pnlWindow);
        addGridBag(0, 1, pnlButtons, pnlWindow);
        addGridBag(0, 2, pnlResult, pnlWindow);

        Container container = getContentPane();
        container.add(pnlWindow);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();

        if (origem == btnCalc) {
            if (txtHeight.getText().equals("")) {
                JOptionPane.showMessageDialog(
                        null,
                        "É necessário informar uma altura",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
                txtHeight.requestFocus();

            } else {
                float height, weight;
                String gender;

                try {
                    height = Float.parseFloat(txtHeight.getText().toString());
                    gender = cboGender.getSelectedItem().toString();

                    if (gender.equals("Masculino")) {

                        weight = (float) (72.6 * height) - 58;
                        lblResult.setText("Resultado: O peso ideal é " + weight + "kg");

                    } else if (gender.equals("Feminino")) {

                        weight = (float) ((62.1 * height) - 44.7);
                        lblResult.setText("Resultado: O peso ideal é " + weight + "kg");

                    }

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Altura inválida!",
                            "ERRO",
                            JOptionPane.ERROR_MESSAGE);
                    txtHeight.requestFocus();
                    txtHeight.selectAll();

                }
            }

        } else if (origem == btnClean) {
            txtHeight.setText("");
            lblResult.setText("Resultado: ");
            txtHeight.requestFocus();

        } else if (origem == btnClose) {
            Object[] options = {"Sim", "Não"};
            int retorno = JOptionPane.showOptionDialog(
                    null,
                    "Tem certeza que deseja sair do programa?",
                    "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (retorno == 0) {
                System.exit(0);
            }
        }
    }

    public void addGridBag(final int x, final int y, final Component obj, final JPanel pnl) {
        restrictions.gridx = x;
        restrictions.gridy = y;
        pnl.add(obj, restrictions);
    }

    public static void main(String[] args) {
        PesoIdeal window = new PesoIdeal();
        window.setVisible(true);
    }

}
