package eHotel.entities;

public class Pricing{
    private float price;
    private String host_id;
    private Integer number_of_guest;
    private String home_type;
    private String pricing_rule;
    private String amenity;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getHost_id() {
        return host_id;
    }

    public void setHost_id(String host_id) {
        this.host_id = host_id;
    }

    public Integer getNumber_of_guest() {
        return number_of_guest;
    }

    public void setNumber_of_guest(Integer number_of_guest) {
        this.number_of_guest = number_of_guest;
    }

    public String getHome_type() {
        return home_type;
    }

    public void setHome_type(String home_type) {
        this.home_type = home_type;
    }

    public String getPricing_rule() {
        return pricing_rule;
    }

    public void setPricing_rule(String pricing_rule) {
        this.pricing_rule = pricing_rule;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }
}