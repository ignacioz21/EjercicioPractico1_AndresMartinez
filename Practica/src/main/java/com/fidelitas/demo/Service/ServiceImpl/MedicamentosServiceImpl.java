/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fidelitas.demo.Service.ServiceImpl;

import com.fidelitas.demo.DAO.MedicamentosDAO;
import com.fidelitas.demo.Domain.Medicamentos;
import com.fidelitas.demo.Service.MedicamentosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicamentosServiceImpl implements MedicamentosService {
    
    @Autowired
    private MedicamentosDAO medicamentosDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Medicamentos> getMedicamentos(int idCategorias) {
        var lista = categoriaDao.findAll();
        return lista;
    }

    @Transactional(readOnly = true)
    public Medicamentos getMedicamento(Medicamentos medicamentos) {
        try {
            return medicamentosDAO.findById(medicamentos.getIDMedicamentos()).orElse(null); //Posible error 
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    @Transactional
    public void save(Medicamentos medicamentos) {
        categoriaDao.save(medicamentos);
    }

    @Override
    @Transactional
    public void delete(Medicamentos medicamentos) {
        categoriaDao.delete(medicamentos);
    }
    
}