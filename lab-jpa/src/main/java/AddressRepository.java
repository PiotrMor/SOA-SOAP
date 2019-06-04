import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "address")
public class AddressRepository {
    private String street;
    private String city;

    public AddressRepository() {
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

    @Override
    public String toString() {
        return "AddressRepository{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
