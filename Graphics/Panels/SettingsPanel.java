package Graphics.Panels;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.CS.*;
import Graphics.Menu;

public class SettingsPanel extends JPanel {

    private JPanel higherpan;
    private JPanel lowerpan;
    private JPanel cspan;
    private JPanel modepan;
    private JPanel offpan;
    private JPanel onpan;
    private JPanel iconpan;

    private JLabel cslabel;
    private JLabel offlabel;
    //private JLabel onlabel;
    //private JLabel hostlabel;
    //private JLabel portlabel;

    private JButton returnbtn;
    private JButton confirmbtn;

    private String[] csnames;
    private ColorScheme[] csschemes;
    private JList cslist;

    private JRadioButton xfirstrbtn;
    private JRadioButton ofirstrbtn;
    private ButtonGroup rgroup1;

    //private JTextField hosttxtf;
    //private JTextField porttxtf;

    private int csindex;
    private ColorScheme cs;
    private ColorScheme tmpcs;
    private boolean ofirst;
    private boolean tmpofirst;

    private void addAll(){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(higherpan);
        add(lowerpan);

        higherpan.setLayout(new GridLayout(1,2));
        higherpan.add(cspan);
        higherpan.add(modepan);

        cspan.setLayout(new BorderLayout());
        cspan.add(cslabel,BorderLayout.PAGE_START);
        cspan.add(new JScrollPane(cslist),BorderLayout.CENTER);

        modepan.setLayout(new BorderLayout());
        modepan.add(offpan,BorderLayout.PAGE_START);
        modepan.add(onpan,BorderLayout.CENTER);

        iconpan.setLayout(new GridLayout(1,2));
        iconpan.add(ofirstrbtn);
        iconpan.add(xfirstrbtn);

        offpan.setLayout(new GridLayout(2,1));
        offpan.add(offlabel);
        offpan.add(iconpan);

        onpan.setLayout(new GridLayout(5,1));
        //onpan.add(onlabel);
        //onpan.add(hostlabel);
    //    onpan.add(hosttxtf);
        //onpan.add(portlabel);
    //    onpan.add(porttxtf);

        lowerpan.setLayout(new GridLayout(1,2));
        lowerpan.add(returnbtn);
        lowerpan.add(confirmbtn);
    }

    private void setDefaults(int index) {
        higherpan.setSize(400,210);
        lowerpan.setSize(400,40);
        cslabel.setHorizontalAlignment(SwingConstants.CENTER);
        offlabel.setHorizontalAlignment(SwingConstants.CENTER);
        //onlabel.setHorizontalAlignment(SwingConstants.CENTER);
        tmpcs = Menu.getMenu().getCs();
        csindex = index;
        rgroup1 = new ButtonGroup();
        rgroup1.add(ofirstrbtn);
        rgroup1.add(xfirstrbtn);
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
        iconpan = new JPanel();
        cslabel = new JLabel("Color Scheme");
        offlabel = new JLabel(/*"Offline mode"*/"Game settings:");
        //onlabel = new JLabel("Online mode");
        //hostlabel = new JLabel("host address:");
        //portlabel = new JLabel("port address:");
        returnbtn = new JButton("Return to Menu");
        confirmbtn = new JButton("Confirm");
        csnames = new String[]{"CS_Milk","CS_Ginger","CS_Brown","CS_Coffee","CS_Sea"};
        csschemes = new ColorScheme[]{new CS_Milk(), new CS_Ginger(), new CS_Brown(), new CS_Coffee(), new CS_Sea()};
        cslist = new JList(csnames);
        if (Menu.getMenu() != null) ofirst = Menu.getMenu().getOFirst();
        ofirstrbtn = new JRadioButton("O First",ofirst);
        xfirstrbtn = new JRadioButton("X first",!ofirst);
    //    hosttxtf = new JTextField();
    //    porttxtf = new JTextField();
    }

    public void updateVariables(){
        tmpofirst = Menu.getMenu().getOFirst();
        tmpcs = Menu.getMenu().getCs();
    }

    public SettingsPanel(int index){
        ofirst = true;
        createComponents();
        setDefaults(index);
        addAll();
        updateColors();

        returnbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().setCS(tmpcs);
                ofirst = tmpofirst;
                cslist.setSelectedIndex(Menu.getMenu().getCSIndex());
                ofirstrbtn.setSelected(tmpofirst);
                Menu.getMenu().updateColors();
                Menu.getMenu().clShow("1");                    //Shows menu
            }
        });

        confirmbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getMenu().setCS(cs);
                Menu.getMenu().setOFirst(ofirst);
                Menu.getMenu().setCSIndex(csindex);
                Menu.getMenu().clShow("1");
            }
        });

        ofirstrbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ofirst = true;
            }
        });

        xfirstrbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ofirst = false;
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
        //onlabel.setForeground(cs.LABEL_FG);
        //hostlabel.setForeground(cs.LABEL_FG);
        //portlabel.setForeground(cs.LABEL_FG);
        offpan.setBackground(cs.CONTPANEL_BG);
        onpan.setBackground(cs.CONTPANEL_BG);
        cspan.setBackground(cs.CONTPANEL_BG);
        ofirstrbtn.setBackground(cs.RADIOBUTTON_BG);
        ofirstrbtn.setForeground(cs.RADIOBUTTON_FG);
        xfirstrbtn.setBackground(cs.RADIOBUTTON_BG);
        xfirstrbtn.setForeground(cs.RADIOBUTTON_FG);
        setBorder(new MatteBorder(5, 5, 5, 5, cs.CONTPANEL_BG));
        cspan.setBorder(new MatteBorder(5, 2, 5, 5, cs.CONTPANEL_BG));
        modepan.setBorder(new MatteBorder(5, 5, 5, 2, cs.CONTPANEL_BG));
        returnbtn.setBorder(new MatteBorder(2, 2, 0, 4, cs.CONTPANEL_BG));
        confirmbtn.setBorder(new MatteBorder(2, 4, 0, 2, cs.CONTPANEL_BG));
        lowerpan.setBackground(cs.CONTPANEL_BG);
        setBackground(cs.CONTPANEL_BG);
    }
}
