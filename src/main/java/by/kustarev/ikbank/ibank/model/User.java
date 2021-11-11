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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @NotNull
    String login;

    @NotNull
    String password;

    @NotNull
    String email;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    Dimension role;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Dimension client;

    @NotNull
    @Column(name = "is_active")
    Boolean isActive;

    @NotNull
    @Column(name = "created_on")
    Date createdOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
