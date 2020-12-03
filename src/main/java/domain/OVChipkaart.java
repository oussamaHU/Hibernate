package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "OVChipkaart")
@Table(name = "ov_chipkaart")
public class OVChipkaart {
    @Id
    @Column(name = "kaart_nummer")
    private int kaart_nummer;
    private Date geldig_tot;
    private int klasse;
    private double saldo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger_id;
    @ManyToMany()
            @JoinTable(name = "ov_chipkaart_product",
                    joinColumns = {@JoinColumn(name = "kaart_nummer")},
                    inverseJoinColumns = {@JoinColumn(name = "product_nummer")})

    List<Product> products = new ArrayList<Product>();



    public OVChipkaart(){

    }

    public OVChipkaart(int kaart_nummer, Date geldig_tot, int klasse, double saldo, Reiziger reiziger_id) {
        this.kaart_nummer = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger_id = reiziger_id;
    }
    public OVChipkaart(int kaart_nummer, Date geldig_tot, int klasse, double saldo) {
        this.kaart_nummer = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
    }


    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger_id() {
        return reiziger_id;
    }

    public void setReiziger_id(Reiziger reiziger_id) {
        this.reiziger_id = reiziger_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

//    @Override
//    public String toString() {
//        return "OVChipkaart{" +
//                "kaart_nummer=" + kaart_nummer +
//                ", geldig_tot=" + geldig_tot +
//                ", klasse=" + klasse +
//                ", saldo=" + saldo +
//                ", reiziger_id=" + reiziger_id +", products=" + products+
//                '}';
//    }


    public String OvString() {
        return "OVChipkaart{" +
                "kaart_nummer=" + kaart_nummer +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                '}';

    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Producten: %s product(en)", products.size()));
        for (Product product : products)
            stringBuilder.append("\n        ").append(product.ProductString());

        return String.format("%s\n    %s\n    %s",
                OvString(),
                reiziger_id != null ? reiziger_id.OwnString(): "geen reiziger",
                products.size() > 0 ? stringBuilder.toString() : "<Geen Producten>"
        );
    }

    }




