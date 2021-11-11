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
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Dimension implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @Column(name = "parent_id")
    Long parent;

    @NotNull
    @Column(name = "type_code")
    String typeCode;

    @NotNull
    String code;

    @NotNull
    String name;

    @NotNull
    @Column(name = "is_closed")
    Boolean isClosed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dimension dimension = (Dimension) o;
        return id != null && Objects.equals(id, dimension.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
