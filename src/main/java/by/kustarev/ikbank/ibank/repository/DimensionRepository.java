package by.kustarev.ikbank.ibank.repository;

import by.kustarev.ikbank.ibank.model.Dimension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DimensionRepository extends JpaRepository<Dimension, Long> {

    List<Dimension> getDimensionsByTypeCode(String typeCode);
}
