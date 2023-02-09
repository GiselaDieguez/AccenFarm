package com.acc.accenfarm.service;

import com.acc.accenfarm.model.Chicken;
import com.acc.accenfarm.repository.IChickenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChickenService {
    @Autowired
    private IChickenRepository iChickenRepository;

    public Chicken saveChicken (Chicken chicken){
        if(chicken.getId() == null) {
            return iChickenRepository.save(chicken);
        }
        return null;
    }

    public Page<Chicken> getAllChicken(Integer page, Integer size, Boolean enablePagination){
        return iChickenRepository.findAll(enablePagination ? PageRequest.of(page, size) : Pageable.unpaged());
    }

    public Optional<Chicken> findById(Integer Id) {
        return iChickenRepository.findById(Id);
    }

    public void deleteChicken(Integer Id) {
        iChickenRepository.deleteById(Id);
    }

    public Chicken editChicken(Chicken chicken) { //cambiar esto por el objeto dto, agregar else y lanzar excepcion throw new exception
        if(chicken.getId() != null && iChickenRepository.existsById(chicken.getId())){
            return iChickenRepository.save(chicken);
        }
        return null;
    }

    public boolean existById(Integer Id) {
        return iChickenRepository.existsById((Id));
    }
}
