package com.deml.PracticaDEML20240730.Controlador;


import com.deml.PracticaDEML20240730.Modelo.ProductoDEML;
import com.deml.PracticaDEML20240730.Servicios.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/Productos")
public class ProductoDEMLController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<ProductoDEML> productos = productoService.buscarTodosPaginados(pageable);
        model.addAttribute("productos", productos);

        int totalPages = productos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "Productos/index";
    }

    @GetMapping("/create")
    public String create(ProductoDEML producto){
        return "Productos/create";
    }

    @PostMapping("/save")
    public String save(ProductoDEML productoDEML, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(productoDEML);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "Productos/create";
        }

        productoService.crearOEditar(productoDEML);
        attributes.addFlashAttribute("msg", "Producto creado correctamente");
        return "redirect:/Productos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model){
        ProductoDEML productoDEML = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoDEML);
        return "Productos/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        ProductoDEML productoDEML = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoDEML);
        return "Productos/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model){
        ProductoDEML productoDEML = productoService.buscarPorId(id).get();
        model.addAttribute("producto", productoDEML);
        return "Productos/delete";
    }

    @PostMapping("/delete")
    public String delete(ProductoDEML productoDEML, RedirectAttributes attributes){
        productoService.eliminarPorId(productoDEML.getId());
        attributes.addFlashAttribute("msg", "Producto eliminado correctamente");
        return "redirect:/Productos";
    }

}
