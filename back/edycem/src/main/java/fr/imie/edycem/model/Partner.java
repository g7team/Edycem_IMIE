package fr.imie.edycem.model;

import javax.persistence.*;

@Entity
@Table(name = "partner" )
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "financial_search")
    private Boolean financialSearch;

    @Column(name = "partnership_purpose")
    private String partnershipPurpose;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFinancial_search() {
        return financialSearch;
    }

    public void setFinancial_search(Boolean financialSearch) {
        this.financialSearch = financialSearch;
    }

    public String getPartnership_purpose() {
        return partnershipPurpose;
    }

    public void setPartnership_purpose(String partnershipPurpose) {
        this.partnershipPurpose = partnershipPurpose;
    }
}
