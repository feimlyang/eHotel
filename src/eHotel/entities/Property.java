
package eHotel.entities;

public class Property {

    private String property_id;
    private String host_id;
    private Integer house_num;
    private String street;
    private String city;
    private String province;
    private String property_type;
    private String room_type;
    private String accommodate;
    private String amenity;
    private String avaliable_date;
    private Boolean avaliability;
    private String property_location;
    private Float price;

    public Property(String property_id, String host_id, String city, String property_type, String avaliable_date, Float price, Boolean avaliability) {
        this.property_id = property_id;
        this.city = city;
        this.property_type = property_type;
        this.avaliable_date = avaliable_date;
        this.price = price;
        this.host_id = host_id;
        this.avaliability = avaliability;
    }

    public Boolean getAvaliability() {
        return avaliability;
    }

    public void setAvaliability(Boolean avaliability) {
        this.avaliability = avaliability;
    }

    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }


    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public Integer getHouse_num() {
        return house_num;
    }

    public void setHouse_num(Integer house_num) {
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

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getAccommodate() {
        return accommodate;
    }

    public void setAccommodate(String accommodate) {
        this.accommodate = accommodate;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getAvaliable_date() {
        return avaliable_date;
    }

    public void setAvaliable_date(String avaliable_date) {
        this.avaliable_date = avaliable_date;
    }

    public String getProperty_location() {
        return property_location;
    }

    public void setProperty_location(String property_location) {
        this.property_location = property_location;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Property{" +
                "property_id='" + property_id + '\'' +
                "host_id=" + host_id + '\'' +
                //", house_num=" + house_num +
                //", street='" + street + '\'' +
                ", city='" + city + '\'' +
                //", province='" + province + '\'' +
                ", property_type='" + property_type + '\'' +
                //", room_type='" + room_type + '\'' +
                //", accommodate='" + accommodate + '\'' +
                //", amenity='" + amenity + '\'' +
                ", avaliable_date='" + avaliable_date + '\'' +
                ", avaliability=" + avaliability +
                //", property_location='" + property_location + '\'' +
                ", price=" + price +
                '}';
    }
}