package eHotel.entities;
public class RentalAgreement{
    String agreement_id;
    String start_date;
    String end_date;
    String guest_id;
    String host_id;
    String property_id;

    public RentalAgreement(String agreement_id, String start_date, String end_date, String guest_id, String host_id, String property_id) {
        this.agreement_id = agreement_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.guest_id = guest_id;
        this.host_id = host_id;
        this.property_id = property_id;
    }

    public String getAgreement_id() {
        return agreement_id;
    }

    public void setAgreement_id(String agreement_id) {
        this.agreement_id = agreement_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id;
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

    @Override
    public String toString() {
        return "RentalAgreement{" +
                "agreement_id='" + agreement_id + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", guest_id='" + guest_id + '\'' +
                ", host_id='" + host_id + '\'' +
                ", property_id='" + property_id + '\'' +
                '}';
    }
}