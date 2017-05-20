package cart;

public class CDProduct {
    private String title;
    private String artist;
    private String country;
    private Float price;

    public CDProduct() {
        this.title = null;
        this.artist = null;
        this.country = null;
        this.price = 0f;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CDProduct product = (CDProduct) o;

        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (artist != null ? !artist.equals(product.artist) : product.artist != null) return false;
        if (country != null ? !country.equals(product.country) : product.country != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}