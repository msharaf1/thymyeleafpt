package com.msx.thymyeleafpt.services;

import com.msx.thymyeleafpt.models.Ninja;
import com.msx.thymyeleafpt.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepo;

    public NinjaService(NinjaRepository ninjaService){
        this.ninjaRepo = ninjaService;
    }

    public List<Ninja> showAllNinja(){
        return ninjaRepo.findAll();
    }

    public Optional<Ninja> showNinjaById(Long id){
        return ninjaRepo.findById(id);
    }

    public void addNinja(Ninja ninja){
        ninjaRepo.save(ninja);
    }

    public void upDate(Ninja ninja){
        ninjaRepo.save(ninja);
    }

    public void deleteByIdNinja(Long id){
        ninjaRepo.deleteById(id);
    }
}
