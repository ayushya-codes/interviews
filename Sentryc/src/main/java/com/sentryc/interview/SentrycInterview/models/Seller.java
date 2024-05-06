package com.sentryc.interview.SentrycInterview.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.URL;

import java.util.Objects;

/**
 * @Author Ayushya
 */
@Entity
@Table(name = "seller_infos", schema = "public")
@Getter
@Setter
//REFERS to SELLER_INFOS TABLE
public class Seller {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller that = (Seller) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
