package by.kustarev.ikbank.ibank.controller;

import by.kustarev.ikbank.ibank.model.Dimension;
import by.kustarev.ikbank.ibank.service.DimensionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/dictionary")
public class DimensionController {

    private final DimensionService dimensionService;

    @Autowired
    public DimensionController(DimensionService dimensionService) {
        this.dimensionService = dimensionService;
    }

    @GetMapping
    public String getAllDimensions(Model model) {
        List<Dimension> dimensions = dimensionService.findAll().stream()
                .sorted(Comparator.comparing(Dimension::getTypeCode))
                .collect(Collectors.toList());
        model.addAttribute("dimensions", dimensions);
        return "dimension";
    }

    @GetMapping("/create")
    public String createForm(Model model, Dimension dimension) {
        List<Dimension> dimensionTypes = dimensionService.getDimensionsByTypeCode("DIMENSION_TYPE");
        model.addAttribute("dimensionTypes", dimensionTypes);
        return "dimension-create";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        List<Dimension> dimensionTypes = dimensionService.getDimensionsByTypeCode("DIMENSION_TYPE");
        Dimension dimension = dimensionService.findById(id);
        model.addAttribute("dimensionTypes", dimensionTypes);
        model.addAttribute("dimension", dimension);
        return "dimension-update";
    }

    @PostMapping("/create")
    public String save(Dimension dimension) {
        dimensionService.save(dimension);
        return "redirect:/dictionary";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        dimensionService.deleteById(id);
        return "redirect:/dictionary";
    }

}
