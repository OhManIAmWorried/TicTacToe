package Graphics.Panels;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.CS.CS_Ginger;
import Graphics.CS.CS_Milk;
import Graphics.CS.ColorScheme;
import Graphics.Menu;

public class SettingsPanel extends JPanel {

    private JPanel higherpan;
    private JPanel lowerpan;
    private JPanel cspan;
    private JPanel modepan;
    private JPanel offpan;
    private JPanel onpan;

    private JLabel cslabel;
    private JLabel offlabel;
    private JLabel onlabel;

    private JButton returnbtn;
    private JButton confirmbtn;

    private String[] csnames;
    private ColorScheme[] csschemes;
    private JList cslist;

    private JCheckBox xfirstcheckb;
    private JTextField hosttxtf;
    private JTextField porttxtf;

    private int csindex;
    private ColorScheme cs;
    private ColorScheme tmpcs;

    private void addAll(){
        setLayout(new GridLayout(2,1));
        add(higherpan);
        add(lowerpan);

        higherpan.setLayout(new GridLayout(1,2));
        higherpan.add(cspan);
        higherpan.add(modepan);

        cspan.setLayout(new GridLayout(2,1));
        cspan.add(cslabel);
        cspan.add(new JScrollPane(cslist));

        modepan.setLayout(new GridLayout(2,1));
        modepan.add(offpan);
        modepan.add(onpan);

        offpan.setLayout(new GridLayout(2,1));
        offpan.add(offlabel);
        offpan.add(xfirstcheckb);

        onpan.setLayout(new GridLayout(3,1));
        onpan.add(onlabel);
        onpan.add(hosttxtf);
        onpan.add(porttxtf);

        lowerpan.setLayout(new GridLayout(1,2));
        lowerpan.add(returnbtn);
        lowerpan.add(confirmbtn);
    }

    private void setDefaults(int index) {
        cslabel.setHorizontalAlignment(SwingConstants.CENTER);
        offlabel.setHorizontalAlignment(SwingConstants.CENTER);
        onlabel.setHorizontalAlignment(SwingConstants.CENTER);
        tmpcs = Menu.getMenu().getCs();
        csindex = index;
        cslist.setVisibleRowCount(10);
        cslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cslist.setSelectedIndex(index);
        cslist.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        csindex = cslist.getSelectedIndex();
                        updateColors();
                    }
                }
        );
    }

    private void createComponents(){
        higherpan = new JPanel();
        lowerpan = new JPanel();
        cspan = new JPanel();
        modepan = new JPanel();
        offpan = new JPanel();
        onpan = new JPanel();
        cslabel = new JLabel("Color Scheme");
        offlabel = new JLabel("Offline mode");
        onlabel = new JLabel("Online mode");
        returnbtn = new JButton("Return to Menu");
        confirmbtn = new JButton("Confirm");
        csnames = new String[]{"CS_Milk","CS_Ginger"};
        csschemes = new ColorScheme[]{new CS_Milk(), new CS_Ginger()};
        cslist = new JList(csnames);
        xfirstcheckb = new JCheckBox("X first");
        hosttxtf = new JTextField("host: ");
        porttxtf = new JTextField("port: ");
    }

    public SettingsPanel(int index){
        createComponents();
        setDefaults(index);
        addAll();
        updateColors();

        returnbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().setCS(tmpcs);
                Menu.getMenu().updateColors();
                Menu.getMenu().clShow("1");                    //Shows menu
            }
        });

        confirmbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().setCS(cs);
                Menu.getMenu().setCSIndex(csindex);
                Menu.getMenu().clShow("1");
            }
        });
    }

    private void Confirm(){

    }

    public void updateColors(){
        cs = csschemes[csindex];
        if (Menu.getMenu() != null) Menu.getMenu().setCS(cs);
        if (Menu.getMenu() != null) Menu.getMenu().updateColors();
        returnbtn.setBackground(cs.BUTTON_BG);
        returnbtn.setForeground(cs.BUTTON_FG);
        confirmbtn.setBackground(cs.BUTTON_BG);
        confirmbtn.setForeground(cs.BUTTON_FG);
        cslist.setBackground(cs.TEXTFIELD_BG);
        cslist.setForeground(cs.TEXTFIELD_FG);
        cslabel.setForeground(cs.LABEL_FG);
        offlabel.setForeground(cs.LABEL_FG);
        onlabel.setForeground(cs.LABEL_FG);
        offpan.setBackground(cs.CONTPANEL_BG);
        onpan.setBackground(cs.CONTPANEL_BG);
        cspan.setBackground(cs.CONTPANEL_BG);
        xfirstcheckb.setBackground(cs.CONTPANEL_BG);
        xfirstcheckb.setForeground(cs.LABEL_FG);
        setBorder(new MatteBorder(5, 5, 5, 5, cs.CONTPANEL_BG));
        cspan.setBorder(new MatteBorder(5, 2, 5, 5, cs.CONTPANEL_BG));
        modepan.setBorder(new MatteBorder(5, 5, 5, 2, cs.CONTPANEL_BG));
    }

    public void setTmpCS(ColorScheme that){tmpcs = that;}
}
