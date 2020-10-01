package eHotel.entities;

public class Guest{
    private String host_id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String house_num;
    private String street;
    private String city;
    private String province;
    private String email;
    private String phones_number;

    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getHouse_num() {
        return house_num;
    }

    public void setHouse_num(String house_num) {
        this.house_num = house_num;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhones_number() {
        return phones_number;
    }

    public void setPhones_number(String phones_number) {
        this.phones_number = phones_number;
    }


//    host_id VARCHAR(30) NOT NULL,
//    first_name VARCHAR(20) NOT NULL,
//    middle_name VARCHAR(20),
//    last_name varchar(20) NOT NULL,
//    house_num VARCHAR(20) NOT NULL,
//    street VARCHAR(20) NOT NULL,
//    city VARCHAR(20) NOT NULL,
//    province VARCHAR(20) NOT NULL,
//    email VARCHAR(255) NOT NULL,
//    phones_number VARCHAR(20) NOT NULL,
//    PRIMARY KEY (host_id)
}