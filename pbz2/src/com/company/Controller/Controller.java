package com.company.Controller;

import com.company.Main.Main;
import com.company.Model.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    public Connection conn = Main.returnCon();
    private List<Data> list = new ArrayList<>();
    private List<Data> listTwo = new ArrayList<>();

    public List<Data> getAreas() throws SQLException {
        list.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM sotrudnik");
             ResultSet rs = preparedStatementInner.executeQuery();
            while (rs.next()) {
                list.add(new Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        return list;
    }

    public void deleteArea(String fio) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM sotrudnik WHERE fio = ?");
        preparedStatement.setString(1, fio);
        preparedStatement.executeUpdate();
    }

    public void changeArea(String updated, String doljnost, String fio) throws SQLException {
        if (updated.equals("A")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sotrudnik SET fio = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }
        if (updated.equals("B")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sotrudnik SET vozrast = ? WHERE fio = ?");

            preparedStatement.setInt(1, Integer.parseInt(doljnost));
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("C")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sotrudnik SET pol = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("D")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sotrudnik SET cempol = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("E")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sotrudnik SET doljnost = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("F")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sotrudnik SET podrazdelenie = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("G")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE sotrudnik SET razriad = ? WHERE fio = ?");

            preparedStatement.setInt(1, Integer.parseInt(doljnost));
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

    }

    public void addArea(String fio, String vozrast, String pol, String cempol, String doljnost, String podrazdelenie, String razriad) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO sotrudnik(fio, vozrast, pol, cempol, " +
                "doljnost, podrazdelenie, razriad) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setString(1, fio);
        preparedStatement.setInt(2, Integer.parseInt(vozrast));
        preparedStatement.setString(3, pol);
        preparedStatement.setString(4, cempol);
        preparedStatement.setString(5, doljnost);
        preparedStatement.setString(6, podrazdelenie);
        preparedStatement.setInt(7, Integer.parseInt(razriad));

        preparedStatement.executeUpdate();
    }



    public List<Data> getAreasTwo() throws SQLException {
        listTwo.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("SELECT * FROM history");
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            listTwo.add(new Data(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6)));
        }
        return listTwo;
    }

    public void deleteAreaTwo(String fio) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM history WHERE fio = ?");
        preparedStatement.setString(1, fio);
        preparedStatement.executeUpdate();
    }

    public void addAreaTwo(String fio, String startrab, String endrab, String olddoljnost, String oldpodrazdelenie, String oldrazriad) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO history(fio, startrab, endrab, olddoljnost, " +
                "oldpodrazdelenie, oldrazriad) VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1, fio);
        preparedStatement.setString(2, startrab);
        preparedStatement.setString(3, endrab);
        preparedStatement.setString(4, olddoljnost);
        preparedStatement.setString(5, oldpodrazdelenie);
        preparedStatement.setString(6, oldrazriad);

        preparedStatement.executeUpdate();
    }

    public void changeAreaTwo(String updated, String doljnost, String fio) throws SQLException {
        if (updated.equals("A")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE history SET fio = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }
        if (updated.equals("B")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE history SET startrab = ? WHERE fio = ?");

            preparedStatement.setDate(1, Date.valueOf(doljnost));
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("C")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE history SET endrab = ? WHERE fio = ?");

            preparedStatement.setDate(1, Date.valueOf(doljnost));
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("D")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE history SET olddoljnost = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("E")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE history SET oldpodrazdelenie = ? WHERE fio = ?");

            preparedStatement.setString(1, doljnost);
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }

        if (updated.equals("F")) {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE history SET oldrazriad = ? WHERE fio = ?");

            preparedStatement.setInt(1, Integer.parseInt(doljnost));
            preparedStatement.setString(2, fio);
            preparedStatement.executeUpdate();

        }
    }


    public List<Data> getAreasThree(String podrazdelenie) throws SQLException {
        list.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("select podrazdelenie, raspisanie.raspisanie, doljnost, kolichestvo from raspisanie " +
                "join podrazdelenie  on raspisanie.raspisanie = podrazdelenie.raspisanie where podrazdelenie = ?");
        preparedStatementInner.setString(1, podrazdelenie);
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            list.add(new Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return list;
    }

    public List<Data> getAreasFour(String pol) throws SQLException {
        list.clear();
        if (pol.equals("ж")) {
            PreparedStatement preparedStatementInner = conn.prepareStatement("select fio, pol, vozrast from sotrudnik where vozrast>55 and pol=?");
            preparedStatementInner.setString(1, pol);
            ResultSet rs = preparedStatementInner.executeQuery();

            while (rs.next()) {
                list.add(new Data(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        }
        if (pol.equals("м")) {
            PreparedStatement preparedStatementInner = conn.prepareStatement("select fio, pol, vozrast from sotrudnik where vozrast>60 and pol=?");
            preparedStatementInner.setString(1, pol);
            ResultSet rs = preparedStatementInner.executeQuery();

            while (rs.next()) {
                list.add(new Data(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        }
           return list;
    }

    public List<Data> getAreasFive(String vozrast, String doljnost) throws SQLException {
        list.clear();
        PreparedStatement preparedStatementInner = conn.prepareStatement("select fio, vozrast from sotrudnik where vozrast<? and doljnost = ?");
        preparedStatementInner.setInt(1, Integer.parseInt(vozrast));
        preparedStatementInner.setString(2, doljnost);
        ResultSet rs = preparedStatementInner.executeQuery();
        while (rs.next()) {
            list.add(new Data(rs.getString(1), rs.getString(2)));
        }
        return list;
    }
}
