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
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotNull
    String iban;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "acc_type_id")
    Dimension accType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "currency_id")
    Dimension currency;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    Dimension client;

    @NotNull
    Boolean isClosed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return id != null && Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
