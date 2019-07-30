package common;

public enum BROWSERS {
    CHROME("chrome"), FIREFOX("firefox");

    String name;

    BROWSERS(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
