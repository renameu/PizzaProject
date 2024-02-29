package org.pizzas.repositories;

import org.pizzas.Models.User;
import org.pizzas.data.interfaces.IDB;
import org.pizzas.repositories.interfaces.IPizzeriaRepository;

import java.sql.*;


public class PizzeriaRepository implements IPizzeriaRepository {
    private final IDB db;


    private static volatile PizzeriaRepository instance;
    private PizzeriaRepository(IDB db){
        this.db = db;
    }

    public static PizzeriaRepository getInstance(IDB db) {
        if (instance == null) {
            synchronized (PizzeriaRepository.class) {
                if (instance == null) {
                    instance = new PizzeriaRepository(db);
                }
            }
        }
        return instance;
    }

    public boolean createUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO public.users(\n" +
                    " name, age, email, cash)\n" +
                    "\tVALUES ( ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user.getName());
            st.setInt(2, user.getAge());
            st.setString(3, user.getEmail());
            st.setInt(4, user.getCash());
            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public String getPizzas() {
        String menu = "";
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, type, size, description, price\n" +
                    "\tFROM public.pizzas;";
            Statement statement = con.createStatement();

            ResultSet resultSet =  statement.executeQuery(sql);
            while (resultSet.next()){
                menu += resultSet.getInt("id") + " | " + resultSet.getString("type") + "\n\t " + resultSet.getInt("size") +
                        "sm\n\tDescription: " +
                        resultSet.getString("description") + "\n\tprice: " + resultSet.getDouble("price") + " " + "tenge " + "\n";
            }

            return menu;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean order(int id, int pizza){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO public.purchasehistory(\n" +
                    "\t userid, pizza, data)\n" +
                    "\tVALUES ( ?, ?, CURRENT_TIMESTAMP);";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, pizza);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return false;
    }


    @Override
    public String GetFullOrderDescription(int orderId) {
        Connection con = null;
        String menu = "";
        try {
            con = db.getConnection();
            String sql = "SELECT orderid, userid, pizza, data\n" +
                    "\tFROM public.purchasehistory WHERE orderid = ?;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                menu += resultSet.getInt("orderid") + " | " + "user id: "
                        + resultSet.getInt("userid")+  " | pizza id: "
                        + resultSet.getInt("pizza") + " | time: "
                        + resultSet.getTime("data")
                        + "\n";
            }

            return menu;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return "";
    }

}
