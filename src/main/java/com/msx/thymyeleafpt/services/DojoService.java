package com.msx.thymyeleafpt.services;

import com.msx.thymyeleafpt.models.Dojo;
import com.msx.thymyeleafpt.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private DojoRepository dojoRepo;

    public DojoService(DojoRepository dojoRepo){
        this.dojoRepo = dojoRepo;
    }

    public List<Dojo> findAllDojos(){
        return dojoRepo.findAll();
    }

    public Optional<Dojo> findDojoById(Long id){
        return dojoRepo.findById(id);
    }

    public Dojo addDojo(Dojo dojo){
        return dojoRepo.save(dojo);
    }

    public void updateDojo(Dojo dojo){
//        Optional<Dojo> dojoList = dojoRepo.findById(id);
        dojoRepo.save(dojo);

    }

    public void deleteDojo(Long id){
        dojoRepo.deleteById(id);
    }
    public long getCount(){
        return dojoRepo.count();
    }

}
