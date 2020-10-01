package eHotel.connections;

import eHotel.entities.Guest;
import eHotel.entities.Property;
import eHotel.entities.RentalAgreement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import eHotel.entities.Room;


public class  PostgreSqlConn{

    Connection db = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement st = null;
    String sql;


    public void getConn(){

        try {

            Class.forName("org.postgresql.Driver");

            db = DriverManager.getConnection("jdbc:postgresql://yourdb", "youruser", "yourpassword");

        }catch(Exception e) {
            System.out.print("error catched");
        }
    }

    public void closeDB() {
        try {
            if(rs != null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(st!=null){
                st.close();
            }
            if(db!=null){
                db.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void Register(String roleType, String user_id, String first_name){
        getConn();

        try {
            st = db.createStatement();
            if (roleType.equals("guest")){
                sql = "insert into ehotel.guest (guest_id, first_name) values('" + user_id + "','" + first_name + "') ";
            }else if (roleType.equals("host")){
                sql = "insert into ehotel.host (host_id, first_name) values('" + user_id + "','" + first_name + "') ";
            }else{
                sql = "insert into ehotel.employee (employee_id, first_name) values('" + user_id + "','" + first_name + "') ";
            }
            st.executeQuery(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return;

    }
    public ArrayList<Property> getAllAvaProperties() {
        getConn();
        ArrayList<Property> Properties = new ArrayList<Property>();

        try {
            // avaliability = true
            ps = db.prepareStatement("select * from ehotel.property where avaliability = ? ORDER BY property_id ASC");
            ps.setBoolean(1, true);
            rs = ps.executeQuery();
            while (rs.next()) {
                String property_id = rs.getString("property_id");
                String host_id = rs.getString("host_id");
                String property_type = rs.getString("property_type");
                String city = rs.getString("city");
                String avaliable_date = rs.getString("avaliable_date");
                Float price = rs.getFloat("price");
                Boolean avaliability = rs.getBoolean("avaliability");
                Property property = new Property(property_id, host_id, city, property_type, avaliable_date, price, avaliability );
                Properties.add(property);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return Properties;
    }

    public ArrayList<Property> getAllUnavaProperties() {
        getConn();
        ArrayList<Property> Properties = new ArrayList<Property>();

        try {
            // avaliability = true
            ps = db.prepareStatement("select * from ehotel.property where avaliability = ? ORDER BY property_id ASC");
            ps.setBoolean(1, false);
            rs = ps.executeQuery();
            while (rs.next()) {
                String property_id = rs.getString("property_id");
                String host_id = rs.getString("host_id");
                String property_type = rs.getString("property_type");
                String city = rs.getString("city");
                String avaliable_date = rs.getString("avaliable_date");
                Float price = rs.getFloat("price");
                Boolean avaliability = rs.getBoolean("avaliability");
                Property property = new Property(property_id, host_id, city, property_type, avaliable_date, price, avaliability );
                Properties.add(property);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return Properties;
    }


    public void addNewProperty(Property newProperty){
        getConn();
        try{
            st = db.createStatement();
            sql = "insert into ehotel.property (property_id , host_id ,city  ,property_type  ,avaliable_date , price, avaliability)" +
                    " values ('"
                    + newProperty.getProperty_id() + "','"
                    + newProperty.getHost_id() + "','"
                    + newProperty.getCity() + "','"
                    + newProperty.getProperty_type() + "','"
                    + newProperty.getAvaliable_date() + "',"
                    + newProperty.getPrice() + "," + true
                    + ")";

            System.out.print(sql);
            st.executeUpdate(sql);

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            closeDB();
        }
    }


    public ArrayList<Property> getPropertyByHost(String host_id) {
        getConn();
        ArrayList<Property> Properties = new ArrayList<>();

        try {
            ps = db.prepareStatement("select * from ehotel.property where host_id=?");
            ps.setString(1, host_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String property_id = rs.getString("property_id");
                String host_id_db = rs.getString("host_id");
                String property_type = rs.getString("property_type");
                String city = rs.getString("city");
                String avaliable_date = rs.getString("avaliable_date");
                Float price = rs.getFloat("price");
                Boolean avaliability =rs.getBoolean("avaliability");
                Property property = new Property(property_id, host_id_db, city, property_type, avaliable_date, price, avaliability );
                Properties.add(property);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return Properties;
    }

    public void addNewAgreement(RentalAgreement newAgreement){
        getConn();
        try{
            st = db.createStatement();
            sql = "insert into ehotel.RentalAgreement (agreement_id  ,guest_id  ,property_id  ,host_id , start_date, end_date )" +
                    " values ('"
                    + newAgreement.getAgreement_id() + "','"
                    + newAgreement.getGuest_id() + "','"
                    + newAgreement.getProperty_id() + "','"
                    + newAgreement.getHost_id() + "','"
                    + newAgreement.getStart_date() + "','"
                    + newAgreement.getEnd_date()
                    +"')" ;
            System.out.print(sql);
            st.executeUpdate(sql);

            setPropertyAvalibility(newAgreement.getProperty_id(), Boolean.FALSE);

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            closeDB();
        }
    }


    public ArrayList<RentalAgreement> getAgreementByGuest(String guest_id) {
        getConn();
        ArrayList<RentalAgreement> RentalAgreementList = new ArrayList<>();

        try {
            ps = db.prepareStatement("select * from ehotel.RentalAgreement where guest_id=?");
            ps.setString(1, guest_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String agreement_id = rs.getString("agreement_id");
                guest_id = rs.getString("guest_id");
                String property_id = rs.getString("property_id");
                String host_id = rs.getString("host_id");
                String start_date = rs.getString("start_date");
                String end_date = rs.getString("end_date");
                RentalAgreement agreement = new RentalAgreement(agreement_id  ,guest_id  ,property_id  ,host_id , start_date, end_date);
                RentalAgreementList.add(agreement);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return RentalAgreementList;
    }

    public void setPropertyAvalibility(String property_id, Boolean bl){
        getConn();
        ArrayList<RentalAgreement> RentalAgreementList = new ArrayList<>();

        try {
            ps = db.prepareStatement("update ehotel.property set avaliability= ? where property_id= ? ");
            ps.setBoolean(1, bl);
            ps.setString(2, property_id);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeDB();
        }
    }




    // connection to eHotel END



    public String getpwdbyUname(String param){
        getConn();

        String pwd = "";

        try{
            ps = db.prepareStatement("select employee_pass from ehotel.employee where employee_id=?");

            ps.setString(1, param);
            rs = ps.executeQuery();

            while(rs.next()) {
                pwd = rs.getString(1);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            closeDB();
        }
        return pwd;
    }


    public String[] getuserinforbycustSSN(String param){
        getConn();

        String[] pwd = new String[2];

        try{
            ps = db.prepareStatement("select * from ehotel.customer where customer_ssn=?");

            ps.setString(1, param);
            rs = ps.executeQuery();

            while(rs.next()) {
                pwd[0] = rs.getString(2);
                pwd[1] = rs.getString(3);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            closeDB();
        }
        return pwd;
    }

    public boolean insertNewCustomer(String[] param){
        getConn();


        try{
            st = db.createStatement();
            sql = "insert into ehotel.customer values('"+param[0]+"','"+param[1]+"','"+param[2]+"')";

            System.out.print(sql);

            st.executeUpdate(sql);

            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            closeDB();
        }
    }


    public String bookRoom(String custName, String roomno){
        getConn();
        String custSSN="";

        try{

            ps = db.prepareStatement("select customer_ssn from ehotel.customer where customer_name='"+custName+"'");
            rs = ps.executeQuery();

            while(rs.next()){
                custSSN = rs.getString("customer_ssn");
            }


            st = db.createStatement();
            sql = "update ehotel.room set customer_ssn='"+custSSN+"', room_status='booked' where room_no='"+roomno+"'";
            st.executeUpdate(sql);


            return custSSN;

        }catch(SQLException e){
            e.printStackTrace();
            return "";
        }finally {
            closeDB();
        }

    }

}

