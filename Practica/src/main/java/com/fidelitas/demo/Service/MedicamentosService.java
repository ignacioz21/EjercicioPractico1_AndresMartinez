/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fidelitas.demo.Service;

import com.fidelitas.demo.Domain.Medicamentos;
import java.util.List;

public interface MedicamentosService {
    
    public List<Medicamentos> getMedicamentos(int idCategorias);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Medicamento medicamentos);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Medicamento medicamentos));
}
