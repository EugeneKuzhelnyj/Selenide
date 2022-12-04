package entity;

import java.util.Objects;

public class Product {
    private int id;
    private String key;
    private String name;
    private String full_name;

    public Product(int id, String key, String name, String full_name) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.full_name = full_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(key, product.key) && Objects.equals(name, product.name) && Objects.equals(full_name, product.full_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, name, full_name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }

}
