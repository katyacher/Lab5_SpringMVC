package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Jewel;

@Service
public class JewelService {

    @Autowired
    private JewelRepository jewelRepository;

    public List<Jewel> findAll() {
        return jewelRepository.findAll();
    }

    public Jewel findById(Long id) {
        return jewelRepository.findById(id).orElse(null);
    }

    public Jewel insert(Jewel jewel) {
        return jewelRepository.save(jewel);
    }

    public void update(Long id, Jewel updatedJewel) {
		if (jewelRepository.existsById(id)) {
			updatedJewel.setId(id);
            jewelRepository.save(updatedJewel);
        }
	}

    public void delete(Long id) {
        jewelRepository.deleteById(id);
    
    
    }
    /** поиск ювелирных изделий по опред. цене */
    public Jewel searchUpTo(int upToPrice) {
        return jewelRepository.findByPrice(upToPrice);
    }
}