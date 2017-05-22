/**
 * Created by Solanid on 22.5.2017.
 */
public class City {
    private int id;
    private String name;
    private String countryCode;
    private String district;

    public City(int id, String name, String countryCode, String district) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }
}
