package com.sentryc.interview.SentrycInterview.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.URL;

import java.util.Objects;

/**
 * @Author Ayushya
 */
@Entity
@Table(name = "seller_infos")
public class SellerInformation {

    @Id
    @Column(name = "id")
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;

    @Column(name = "name", length = 2048)
    @NotBlank
    private String name;

    @Column(name = "url", length = 2048)
    @URL
    private String url;

    @Column(name = "country")
    private String country;

    @Column(name = "external_id")
    private String externalId;

    @OneToOne
    private MarketPlace marketPlace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerInformation that = (SellerInformation) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}