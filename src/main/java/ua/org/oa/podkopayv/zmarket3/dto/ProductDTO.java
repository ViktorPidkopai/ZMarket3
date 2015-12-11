package ua.org.oa.podkopayv.zmarket3.dto;

import ua.org.oa.podkopayv.zmarket3.model.Product;

public class ProductDTO {

    private long id;
    private String category;
    private String name;
    private int price;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.category = product.getCategory().getTitle();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;

        ProductDTO that = (ProductDTO) o;

        if (getId() != that.getId()) return false;
        if (getPrice() != that.getPrice()) return false;
        if (getCategory() != null ? !getCategory().equals(that.getCategory()) : that.getCategory() != null)
            return false;
        return !(getName() != null ? !getName().equals(that.getName()) : that.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
