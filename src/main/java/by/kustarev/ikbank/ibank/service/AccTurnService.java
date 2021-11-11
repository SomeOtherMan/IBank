package by.kustarev.ikbank.ibank.service;

import by.kustarev.ikbank.ibank.repository.AccTurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccTurnService {

    private final AccTurnRepository accTurnRepository;

    @Autowired
    public AccTurnService(AccTurnRepository accTurnRepository) {
        this.accTurnRepository = accTurnRepository;
    }

}
