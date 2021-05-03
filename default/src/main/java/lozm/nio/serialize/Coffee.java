package lozm.nio.serialize;


import java.io.Serializable;

public class Coffee implements Serializable {

    private String name;
    private String size;
    private int price;
    private Description description = new Description("desc name", "desc contents", "desc secret");
    private transient String secret;

    class Description implements Serializable {
        String name;
        String contents;
        transient String secret;

        public Description(String name, String contents, String secret) {
            this.name = name;
            this.contents = contents;
            this.secret = secret;
        }
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public Description getDescription() {
        return description;
    }

    public String getSecret() {
        return secret;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
