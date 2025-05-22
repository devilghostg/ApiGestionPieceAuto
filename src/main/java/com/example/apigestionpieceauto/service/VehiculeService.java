package com.example.apigestionpieceauto.service;

import com.example.apigestionpieceauto.Entity.Vehicule;
import com.example.apigestionpieceauto.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {


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

    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
    Optional<Vehicule> existingVehicule = vehiculeRepository.findById(id);

    if (existingVehicule.isPresent()) {
        Vehicule v = existingVehicule.get();

        v.setMarque(vehicule.getMarque());
        v.setModele(vehicule.getModele());
        v.setImmatriculation(vehicule.getImmatriculation());
        v.setAnnee(vehicule.getAnnee());

        return vehiculeRepository.save(v);
    } else {
        throw new RuntimeException("Véhicule non trouvé avec l'id : " + id);
    }
}

}
