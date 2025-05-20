package com.example.apigestionpieceauto.service;

import com.example.apigestionpieceauto.Entity.Vehicule;
import com.example.apigestionpieceauto.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class VehiculeService {


    private VehiculeRepository vehiculeRepository;

    @Autowired
    public VehiculeService(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    public List<Vehicule> findAllVehicules() {
        return (List<Vehicule>) vehiculeRepository.findAll();
    }

    public Optional<Vehicule> findVehiculeById(Long id) {
        return vehiculeRepository.findById(id);
    }

    public Vehicule createVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

}
