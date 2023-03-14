public class Country {
    private String code;
    private String name;
    private int population;

    public Country(String code, String name, int population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return name + " (" + code + ") ma " + population + " ludności.";
    }
}
