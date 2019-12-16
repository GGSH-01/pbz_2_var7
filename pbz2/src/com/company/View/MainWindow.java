package com.company.View;

import com.company.Controller.Controller;
import com.company.Model.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MainWindow {

    private List<Data> areas;
    private Controller controller;
    private JFrame containerOne = new JFrame() {};
    private JFrame containerThree = new JFrame() {};
    private JFrame containerFour = new JFrame() {};
    private JFrame containerFive = new JFrame() {};
    private JFrame containerSix = new JFrame() {};

    private JButton button11 = new JButton("редактирование сотрудников");
    private JButton button12 = new JButton("редактирование истории");
    private JButton button13 = new JButton("просмотр распиания подразделения");
    private JButton button14 = new JButton("Просмотр пенсионеров");
    private JButton button15 = new JButton("сотрудники младше возраста");
    private JButton button21 = new JButton("Удалить сотрудника");
    private JButton button22 = new JButton("Добавить сотрудника");
    private JButton button23 = new JButton("Редакртировать поле");
    private JButton button31 = new JButton("Удалить запись");
    private JButton button32 = new JButton("Добавить запись");
    private JButton button33 = new JButton("Редакртировать поле");
    private JButton button41 = new JButton("Поиск расписания у подразделения");
    private JButton button51 = new JButton("Поиск");
    private JButton button52 = new JButton("подчистить");
    private JButton button61 = new JButton("Поиск");



    private JTextField textField1 = new JTextField("",4);
    private JTextField textField2 = new JTextField("",4);
    private JTextField textField3 = new JTextField("",4);
    private JTextField textField4 = new JTextField("",4);
    private JTextField textField5 = new JTextField("",4);
    private JTextField textField6 = new JTextField("",4);
    private JTextField textField7 = new JTextField("",4);
    private JTextField textField8 = new JTextField("",4);

    private JTextField textField11 = new JTextField("",4);
    private JTextField textField12 = new JTextField("",4);
    private JTextField textField13 = new JTextField("",4);
    private JTextField textField14 = new JTextField("",4);
    private JTextField textField15 = new JTextField("",4);
    private JTextField textField16 = new JTextField("",4);
    private JTextField textField17 = new JTextField("",4);

    private JTextField textField21 = new JTextField("",10);

    private JTextField textField31 = new JTextField("",4);
    private JTextField textField32 = new JTextField("",10);
    private String[] items = {
        "м",
        "ж"
    };
    private JComboBox comboBox = new JComboBox(items);

    public MainWindow() throws SQLException {

        JFrame container = new JFrame() {};
        container.setVisible(true);
        container.setBounds(500, 200, 300, 300);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.setLayout(new GridLayout(5, 1, 10, 10));


        container.add(button11);
        button11.addActionListener(new ButtonEventOne());
        container.add(button12);
        button12.addActionListener(new ButtonEventFive());
        container.add(button13);
        button13.addActionListener(new ButtonEventNine());
        container.add(button14);
        button14.addActionListener(new ButtonEventEleven());
        container.add(button15);
        button15.addActionListener(new ButtonEventTwelve());
    }








    class  ButtonEventOne extends Controller implements ActionListener  {
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();
            containerOne.setVisible(true);
            containerOne.setBounds(200, 300, 1000, 500);
            containerOne.setLayout(new GridLayout(2, 1, 1, 3));
            JPanel panelOne = new JPanel();
            int rows = 0;
            PreparedStatement preparedStatementInner = null;
            try {
                preparedStatementInner = conn.prepareStatement("SELECT * FROM sotrudnik");
                ResultSet rs = preparedStatementInner.executeQuery();
                while (rs.next()) {
                    rows++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JTable table = new JTable(rows,7);
            DefaultTableModel model = (DefaultTableModel) table.getModel();




            JScrollPane scrollPane = new JScrollPane(table);
            String tabletext1 = "ФИО", tabletext2 = "Возраст", tabletext3 = "Пол",
                    tabletext4 = "Семейное положение", tabletext5 = "Должность", tabletext6 = "Подразделение", tabletext7 = "Разряд";
            TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(0);
            TableColumn column2 = table.getTableHeader().getColumnModel().getColumn(1);
            TableColumn column3 = table.getTableHeader().getColumnModel().getColumn(2);
            TableColumn column4 = table.getTableHeader().getColumnModel().getColumn(3);
            TableColumn column5 = table.getTableHeader().getColumnModel().getColumn(4);
            TableColumn column6 = table.getTableHeader().getColumnModel().getColumn(5);
            TableColumn column7 = table.getTableHeader().getColumnModel().getColumn(6);

            column1.setHeaderValue(tabletext1);
            column2.setHeaderValue(tabletext2);
            column3.setHeaderValue(tabletext3);
            column4.setHeaderValue(tabletext4);
            column5.setHeaderValue(tabletext5);
            column6.setHeaderValue(tabletext6);
            column7.setHeaderValue(tabletext7);




            panelOne.add(button21);
            button21.addActionListener(new ButtonEventTwo(table, model));

            panelOne.add(button22);
            button22.addActionListener(new ButtonEventThree(table, model));

            panelOne.add(textField1);
            panelOne.add(textField2);
            panelOne.add(textField3);
            panelOne.add(textField4);
            panelOne.add(textField5);
            panelOne.add(textField6);
            panelOne.add(textField8);


            panelOne.add(button23);
            button23.addActionListener(new ButtonEventFour(table, model));

            panelOne.add(textField7);

            containerOne.add(panelOne);



            containerOne.add(scrollPane);

            try {
                areas = controller.getAreas();
                table.removeAll();
                int y = 0, x = 0;
                for (Data data: areas) {
                    table.setValueAt(String.valueOf(data.getFio()), x, y);
                    y++;
                    table.setValueAt(String.valueOf(data.getVozrast()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getPol()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getCempol()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getDoljnost()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getPodrazdelenie()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getRazriad()),x,y);
                    y = 0;
                    x++;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }



        }

    }





    class  ButtonEventTwo extends ButtonEventOne implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventTwo (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();
            int selectRow;
            selectRow = table.getSelectedRow();
            Object valueRow;
            valueRow = table.getValueAt(selectRow,0);
            try {
                controller.deleteArea(valueRow.toString());
                model.removeRow(selectRow);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(valueRow);

        }
    }






    class  ButtonEventThree implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventThree (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();

            String[] rowData = new String[] {textField1.getText(),textField2.getText(),textField3.getText() ,
                    textField4.getText(), textField5.getText(), textField6.getText(), textField8.getText()};

            try {
                controller.addArea(textField1.getText(),textField2.getText(),textField3.getText() ,
                        textField4.getText(), textField5.getText(), textField6.getText(), textField8.getText());

                    model.addRow(rowData);


            } catch (SQLException ex) {
                System.out.println("govno");
                ex.printStackTrace();
            }

        }
    }




    class  ButtonEventFour implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventFour (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();
            int selectedColumn = table.getSelectedColumn();
            int selectedRow = table.getSelectedRow();
            Object valueRow;
            valueRow = table.getValueAt(selectedRow,0);

            try {
                controller.changeArea(
                        table.getColumnName(selectedColumn),
                        textField7.getText(),
                        valueRow.toString());
                areas = controller.getAreas();
                model.setValueAt(textField7.getText(), selectedRow, selectedColumn);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
    }



////////////////////////////////////////начало второй кнопочки


    class  ButtonEventFive extends Controller implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();
            containerThree.setVisible(true);
            containerThree.setBounds(200, 300, 1000, 500);
            containerThree.setLayout(new GridLayout(2, 1, 1, 3));
            JPanel panelOne = new JPanel();
            int rows = 0;
            PreparedStatement preparedStatementInner = null;
            try {
                preparedStatementInner = conn.prepareStatement("SELECT * FROM history");
                ResultSet rs = preparedStatementInner.executeQuery();
                while (rs.next()) {
                    rows++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JTable table = new JTable(rows,6);
            DefaultTableModel model = (DefaultTableModel) table.getModel();


            panelOne.add(button31);
            button31.addActionListener(new ButtonEventSix(table, model));

            panelOne.add(button32);
            panelOne.add(textField11);
            panelOne.add(textField12);
            panelOne.add(textField13);
            panelOne.add(textField14);
            panelOne.add(textField15);
            panelOne.add(textField17);
            button32.addActionListener(new ButtonEventSeven(table, model));

            panelOne.add(button33);
            button33.addActionListener(new ButtonEventEight(table, model));
            panelOne.add(textField16);




            JScrollPane scrollPane = new JScrollPane(table);
            String tabletext1 = "ФИО", tabletext2 = "Старт Работы", tabletext3 = "Конец работы",
                    tabletext4 = "Пред должность", tabletext5 = "Пред подразделение", tabletext6 = "Пред разряд";
            TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(0);
            TableColumn column2 = table.getTableHeader().getColumnModel().getColumn(1);
            TableColumn column3 = table.getTableHeader().getColumnModel().getColumn(2);
            TableColumn column4 = table.getTableHeader().getColumnModel().getColumn(3);
            TableColumn column5 = table.getTableHeader().getColumnModel().getColumn(4);
            TableColumn column6 = table.getTableHeader().getColumnModel().getColumn(5);

            column1.setHeaderValue(tabletext1);
            column2.setHeaderValue(tabletext2);
            column3.setHeaderValue(tabletext3);
            column4.setHeaderValue(tabletext4);
            column5.setHeaderValue(tabletext5);
            column6.setHeaderValue(tabletext6);

            containerThree.add(scrollPane);

            containerThree.add(panelOne);



            containerThree.add(scrollPane);

            try {
                areas = controller.getAreasTwo();
                table.removeAll();
                int y = 0, x = 0;
                for (Data data: areas) {
                    table.setValueAt(String.valueOf(data.getFio()), x, y);
                    y++;
                    table.setValueAt(String.valueOf(data.getStartrab()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getEndrab()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getOlddoljnost()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getOldpodrazdelenie()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getOldrazriad()),x,y);
                    y = 0;
                    x++;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
    }




    class  ButtonEventSix implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventSix (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {

            Controller controller = new Controller();
            int selectRow;
            selectRow = table.getSelectedRow();
            Object valueRow;
            valueRow = table.getValueAt(selectRow,0);
            try {
                controller.deleteAreaTwo(valueRow.toString());
                model.removeRow(selectRow);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(valueRow);


        }
    }


    class  ButtonEventSeven implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventSeven (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();

            String[] rowData = new String[] {textField11.getText(),textField12.getText(),textField13.getText() ,
                    textField14.getText(), textField15.getText(), textField17.getText()};

            try {
                controller.addAreaTwo(textField11.getText(),textField12.getText(),textField13.getText() ,
                        textField14.getText(), textField15.getText(), textField17.getText());

                model.addRow(rowData);


            } catch (SQLException ex) {
                System.out.println("govno");
                ex.printStackTrace();
            }
        }
    }


    class  ButtonEventEight implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventEight (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {

            Controller controller = new Controller();
            int selectedColumn = table.getSelectedColumn();
            int selectedRow = table.getSelectedRow();
            Object valueRow;
            valueRow = table.getValueAt(selectedRow,0);

            try {
                controller.changeAreaTwo(
                        table.getColumnName(selectedColumn),
                        textField16.getText(),
                        valueRow.toString());
                areas = controller.getAreas();
                model.setValueAt(textField16.getText(), selectedRow, selectedColumn);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }



        }
    }




    ///////////////////////////////////////////начало третьей кнопочки


    class  ButtonEventNine extends Controller implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();
            containerFour.setVisible(true);
            containerFour.setBounds(200, 300, 1000, 500);
            containerFour.setLayout(new GridLayout(3, 1, 1, 3));
            JPanel panelOne = new JPanel();
            int rows = 0;
            PreparedStatement preparedStatementInner = null;
            try {
                preparedStatementInner = conn.prepareStatement("select podrazdelenie, raspisanie.raspisanie, doljnost, kolichestvo from raspisanie inner join podrazdelenie  on raspisanie.raspisanie = podrazdelenie.raspisanie;");
                ResultSet rs = preparedStatementInner.executeQuery();
                while (rs.next()) {
                    rows++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JTable table = new JTable(rows, 4);
            DefaultTableModel model = (DefaultTableModel) table.getModel();



            panelOne.add(button41);
            button41.addActionListener(new ButtonEventTen(table, model));

            panelOne.add(textField21);


            JScrollPane scrollPane = new JScrollPane(table);
            String tabletext1 = "подразделение", tabletext2 = "расписание", tabletext3 = "дожность",
                    tabletext4 = "количество";
            TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(0);
            TableColumn column2 = table.getTableHeader().getColumnModel().getColumn(1);
            TableColumn column3 = table.getTableHeader().getColumnModel().getColumn(2);
            TableColumn column4 = table.getTableHeader().getColumnModel().getColumn(3);


            column1.setHeaderValue(tabletext1);
            column2.setHeaderValue(tabletext2);
            column3.setHeaderValue(tabletext3);
            column4.setHeaderValue(tabletext4);


            containerFour.add(scrollPane);

            containerFour.add(panelOne);

            containerFour.add(scrollPane);
        }
    }



    class  ButtonEventTen implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventTen (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();


            try {
                areas = controller.getAreasThree(textField21.getText());
                table.removeAll();
                int y = 0, x = 0;
                for (Data data: areas) {
                    table.setValueAt(String.valueOf(data.getPodrazdelenie()), x, y);
                    y++;
                    table.setValueAt(String.valueOf(data.getRaspisanie()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getDoljnost()),x,y);
                    y++;
                    table.setValueAt(String.valueOf(data.getKolichestvo()),x,y);
                    y = 0;
                    x++;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    //////////////////////////////////////////////// начало четвертой кнопочки

    class  ButtonEventEleven extends Controller implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();
            containerFive.setVisible(true);
            containerFive.setBounds(200, 300, 1000, 500);
            containerFive.setLayout(new GridLayout(2, 1, 1, 3));
            int rows = 0;
            PreparedStatement preparedStatementInner = null;
            try {
                preparedStatementInner = conn.prepareStatement("select fio, pol, podrazdelenie from sotrudnik where vozrast>55 and pol='Ж'");
                ResultSet rs = preparedStatementInner.executeQuery();
                while (rs.next()) {
                    rows++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JTable table = new JTable(0, 3);
            DefaultTableModel model = (DefaultTableModel) table.getModel();


            JScrollPane scrollPane = new JScrollPane(table);
            String tabletext1 = "фио", tabletext2 = "пол", tabletext3 = "возраст";

            TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(0);
            TableColumn column2 = table.getTableHeader().getColumnModel().getColumn(1);
            TableColumn column3 = table.getTableHeader().getColumnModel().getColumn(2);



            column1.setHeaderValue(tabletext1);
            column2.setHeaderValue(tabletext2);
            column3.setHeaderValue(tabletext3);

            JPanel panelTwo = new JPanel();
            panelTwo.add(comboBox);
            panelTwo.add(button61);
            button61.addActionListener(new ButtonEventFourteen(table, model));

            containerFive.add(panelTwo);
            containerFive.add(scrollPane);
        }
    }


    class  ButtonEventFourteen extends Controller implements ActionListener {
        private JTable table;
        private DefaultTableModel model;

        public ButtonEventFourteen(JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }

        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();

            int rows = 0;
            PreparedStatement preparedStatementInner = null;
            try {
                preparedStatementInner = conn.prepareStatement("SELECT * FROM sotrudnik");
                ResultSet rs = preparedStatementInner.executeQuery();
                while (rs.next()) {
                    rows++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            model.setRowCount (0);
            model.setRowCount(rows);
            try {
                areas = controller.getAreasFour(comboBox.getSelectedItem().toString());
                table.removeAll();
                int y = 0, x = 0;
                for (Data data : areas) {
                    table.setValueAt(String.valueOf(data.getFio()), x, y);
                    y++;
                    table.setValueAt(String.valueOf(data.getPol()), x, y);
                    y++;
                    table.setValueAt(String.valueOf(data.getVozrast()), x, y);
                    y = 0;
                    x++;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }


//////////////////////////////////////////////////// начало пятой кнопочки

    class  ButtonEventTwelve extends Controller implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();
            containerSix.setVisible(true);
            containerSix.setBounds(200, 300, 1000, 500);
            containerSix.setLayout(new GridLayout(2, 1, 1, 3));
            JPanel panelOne = new JPanel();
            int rows = 0;
            PreparedStatement preparedStatementInner = null;
            try {
                preparedStatementInner = conn.prepareStatement("select fio, vozrast from sotrudnik where vozrast<40 and doljnost = 'Секретарь'");
                ResultSet rs = preparedStatementInner.executeQuery();
                while (rs.next()) {
                    rows++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            JTable table = new JTable(0, 2);
            DefaultTableModel model = (DefaultTableModel) table.getModel();



            panelOne.add(button51);
            button51.addActionListener(new ButtonEventThirteen(table, model));

            panelOne.add(new JLabel("младше возраста:"));
            panelOne.add(textField31);
            panelOne.add(new JLabel("занимает должность::"));
            panelOne.add(textField32);


            JScrollPane scrollPane = new JScrollPane(table);
            String tabletext1 = "ФИО", tabletext2 = "Возраст";
            TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(0);
            TableColumn column2 = table.getTableHeader().getColumnModel().getColumn(1);


            column1.setHeaderValue(tabletext1);
            column2.setHeaderValue(tabletext2);



            containerSix.add(scrollPane);

            containerSix.add(panelOne);

            containerSix.add(scrollPane);
        }
    }


    class  ButtonEventThirteen extends Controller implements ActionListener {
        private JTable table;
        private DefaultTableModel model;
        public ButtonEventThirteen (JTable table, DefaultTableModel model) {
            this.model = model;
            this.table = table;
        }
        public void actionPerformed(ActionEvent e) {
            Controller controller = new Controller();

            int rows = 0;
            PreparedStatement preparedStatementInner = null;
            try {
                preparedStatementInner = conn.prepareStatement("SELECT * FROM sotrudnik");
                ResultSet rs = preparedStatementInner.executeQuery();
                while (rs.next()) {
                    rows++;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            model.setRowCount (0);
            model.setRowCount(rows);

            try {
                areas = controller.getAreasFive(textField31.getText(), textField32.getText());

                int y = 0, x = 0;
                for (Data data: areas) {
                    table.setValueAt(String.valueOf(data.getFio()), x, y);
                    y++;
                    table.setValueAt(String.valueOf(data.getVozrast()),x,y);
                    y = 0;
                    x++;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }


}

