package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.dto.FacilityDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.facility.Facility;
import com.casestudy.model.facility.FacilityType;
import com.casestudy.model.facility.RentType;
import com.casestudy.service.facility.IFacilityService;
import com.casestudy.service.facility.IFacilityTypeService;
import com.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("/list")
    public String showFacilityList(@PageableDefault(value = 5, sort = "facility_name", direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam(value = "facilityName", defaultValue = "") String facilityName,
                                   Model model) {
        List<FacilityType> facilityTypes = iFacilityTypeService.showListFacilityType();
        List<RentType> rentTypes = iRentTypeService.showListRentType();
        Page<Facility> facilities = iFacilityService.search(pageable, facilityName);
        model.addAttribute("facilityTypes", facilityTypes);
        model.addAttribute("rentTypes", rentTypes);
        model.addAttribute("facilityList", facilities);
        model.addAttribute("facilityName", facilityName);
        return "facility/list";
    }

    @GetMapping("/create")
    public String createFacility(Model model) {
        model.addAttribute("facilityTypes", iFacilityTypeService.showListFacilityType());
        model.addAttribute("rentTypes", iRentTypeService.showListRentType());
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";
    }

    @PostMapping("/add")
    public String saveFacility(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypes", iFacilityTypeService.showListFacilityType());
            model.addAttribute("rentTypes", iRentTypeService.showListRentType());
            return "facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.addNewFacility(facility);
            redirectAttributes.addFlashAttribute("mess", "Add new facility successfully!");
            return "redirect:/facility/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String editFacility(@PathVariable int id, Model model) {
        model.addAttribute("facilityTypes", iFacilityTypeService.showListFacilityType());
        model.addAttribute("rentTypes", iRentTypeService.showListRentType());
        model.addAttribute("facility", iFacilityService.findById(id));
        return "facility/edit";
    }

    @PostMapping("/update")
    public String updateFacility(@Validated @ModelAttribute("facility") FacilityDto facilityDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("facilityTypes", iFacilityTypeService.showListFacilityType());
            model.addAttribute("rentTypes", iRentTypeService.showListRentType());
            return "facility/edit";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.updateFacility(facility);
            redirectAttributes.addFlashAttribute("mess", "Update facility successfully!");
            return "redirect:/facility/list";
        }
    }

    @GetMapping("/delete")
    public String deleteFacility(@RequestParam int id, RedirectAttributes redirectAttributes){
        iFacilityService.deleteLogical(id);
        redirectAttributes.addFlashAttribute("mess", "Delete facility successfully!");
        return "redirect:/facility/list";
    }

    @GetMapping("/view")
    public String viewFacility(@RequestParam int id){
        iFacilityService.findById(id);
        return "redirect:/facility/list";
    }
}
