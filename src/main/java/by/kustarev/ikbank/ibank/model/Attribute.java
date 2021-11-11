package by.kustarev.ikbank.ibank.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Attribute implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "dimension_id")
    Dimension dimension;

    @NotNull
    String code;

    @NotNull
    String value;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ref_id")
    Dimension reference;

    @NotNull
    @Column(name = "date_attr")
    Date dateAttr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Attribute attribute = (Attribute) o;
        return id != null && Objects.equals(id, attribute.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
