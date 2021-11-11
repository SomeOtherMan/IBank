package by.kustarev.ikbank.ibank.controller;

import by.kustarev.ikbank.ibank.service.AccTurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acc_turn")
public class AccTurnController {

    private final AccTurnService accTurnService;

    @Autowired
    public AccTurnController(AccTurnService accTurnService) {
        this.accTurnService = accTurnService;
    }

}
