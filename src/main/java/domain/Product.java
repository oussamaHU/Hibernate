package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Product")
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "product_nummer")
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private double prijs;
    @ManyToMany(mappedBy = "products")
    private List<OVChipkaart> Ovkaarten = new ArrayList<>();

    public String ProductString() {
        return "product{" +
                "product_nummer=" + product_nummer +
                ", naam=" + naam +
                ", beschrijving=" + beschrijving +
                ", prijs=" + prijs +
                '}';

    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("OVChipkaarten: %s ovkaart(en)", Ovkaarten.size()));
        for (OVChipkaart ovChipkaart : Ovkaarten)
            stringBuilder.append("\n        ").append(ovChipkaart.OvString());

        return String.format("%s\n    %s\n    ",
                ProductString(),
                Ovkaarten.size() > 0 ? stringBuilder.toString() : "<Geen Producten>"
        );
    }

    public Product(int product_nummer, String naam, String beschrijving, double prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public Product() {

    }


    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public List<OVChipkaart> getOvkaarten() {
        return Ovkaarten;
    }

    public void setOvkaarten(List<OVChipkaart> ovkaarten) {
        Ovkaarten = ovkaarten;
    }
}


