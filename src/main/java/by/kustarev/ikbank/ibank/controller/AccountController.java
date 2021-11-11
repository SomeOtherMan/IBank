package by.kustarev.ikbank.ibank.controller;

import by.kustarev.ikbank.ibank.model.Account;
import by.kustarev.ikbank.ibank.model.Dimension;
import by.kustarev.ikbank.ibank.service.AccountService;
import by.kustarev.ikbank.ibank.service.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final DimensionService dimensionService;

    @Autowired
    public AccountController(AccountService accountService, DimensionService dimensionService) {
        this.accountService = accountService;
        this.dimensionService = dimensionService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "account";
    }

    @GetMapping("/create")
    public String createForm(Model model, Account account) {
        List<Dimension> clients = dimensionService.getDimensionsByTypeCode("CLIENT");
        List<Dimension> currencies = dimensionService.getDimensionsByTypeCode("CURRENCY");
        List<Dimension> accountTypes = dimensionService.getDimensionsByTypeCode("ACCOUNT_TYPE");

        model.addAttribute("clients", clients);
        model.addAttribute("currencies", currencies);
        model.addAttribute("accountTypes", accountTypes);

        return "account-create";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        List<Dimension> clients = dimensionService.getDimensionsByTypeCode("CLIENT");
        List<Dimension> currencies = dimensionService.getDimensionsByTypeCode("CURRENCY");
        List<Dimension> accountTypes = dimensionService.getDimensionsByTypeCode("ACCOUNT_TYPE");
        Account account = accountService.findById(id);

        model.addAttribute("clients", clients);
        model.addAttribute("currencies", currencies);
        model.addAttribute("accountTypes", accountTypes);
        model.addAttribute("account", account);

        return "account-update";
    }

    @PostMapping("/create")
    public String save(Account account) {
        accountService.save(account);
        return "redirect:/account";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        accountService.deleteById(id);
        return "redirect:/account";
    }

}
