/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fidelitas.demo.Controllers;

import com.fidelitas.demo.Domain.Medicamentos;
import com.fidelitas.demo.Service.MedicamentosService;
//import com.fidelitas.demo.Service.ServiceImpl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentosController {
    
    @Autowired
    private MedicamentosService medicamentosService;
    
    @GetMapping("/litado")
        private String listado(Model model) {
        var medicamentos = medicamentosService.getMedicamentos();
        model.addAttribute("medicamentos", medicamentos);
        model.addAttribute("totalMedicamentos",medicamentos.size());
        return "/medicamento/listado";
    }
    
     @GetMapping("/nuevo")
    public String medicamentoNuevo(Medicamentos medicamentos) {
        return "/medicamento/modifica";
    }

//    @Autowired
//    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String medicamentoGuardar(Medicamentos medicamentos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {  
        /*
        if (!imagenFile.isEmpty()) {
            medicamentosService.save(medicamentos);
            medicamentos.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "medicamentos", 
                            medicamentos.getID()));
        }
        */
        medicamentosService.save(medicamentos);
        return "redirect:/medicamento/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String medicamentosEliminar(Medicamentos medicamentos) {
        medicamentosService.delete(medicamentos);
        return "redirect:/medicamento/listado";
    }

    @GetMapping("/modificar/{ID}")
    public String medicamentoModificar(Medicamentos medicamento, Model model) {
        medicamento = medicamentosService.getMedicamento(medicamento);
        model.addAttribute("medicamento", medicamento);
        return "/medicamento/modifica";
    }

}
