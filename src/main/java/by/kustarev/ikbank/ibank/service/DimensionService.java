package by.kustarev.ikbank.ibank.service;

import by.kustarev.ikbank.ibank.model.Dimension;
import by.kustarev.ikbank.ibank.repository.DimensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimensionService {

    private final DimensionRepository dimensionRepository;

    @Autowired
    public DimensionService(DimensionRepository dimensionRepository) {
        this.dimensionRepository = dimensionRepository;
    }

    public List<Dimension> getDimensionsByTypeCode(String typeCode) {
        return dimensionRepository.getDimensionsByTypeCode(typeCode);
    }

    public List<Dimension> findAll() {
        return dimensionRepository.findAll();
    }

    public void save(Dimension dimension) {
        dimensionRepository.save(dimension);
    }

    public Dimension findById(Long id) {
        return dimensionRepository.getById(id);
    }

    public void deleteById(Long id) {
        dimensionRepository.deleteById(id);
    }


}
