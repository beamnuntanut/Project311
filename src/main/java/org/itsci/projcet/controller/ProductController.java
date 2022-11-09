package org.itsci.project.controller;

import org.itsci.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    private String title = "สินค้า";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProduct(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("products", productService.getProducts());
        return "product/list";
    }

    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("product", new Product());
        return "product/product-form";
    }

    @RequestMapping(path="/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "product/product-form";
        } else {
            Product productEntity = productService.getProduct(product.getId());
            if (productEntity != null) {
                productService.updateProduct(productEntity, product);
            } else {
                productService.saveProduct(product);
            }
            return "redirect:/product/list";
        }
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable ("id") int id, Model model) {
        Product product = productService.getProduct(Integer.valueOf(id));
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("product", product);
        return "product/product-form";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

}
