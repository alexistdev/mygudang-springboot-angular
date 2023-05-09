package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.Vendor;
import com.alexistdev.mygudang.repository.VendorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    private Date date= new Date();

    private static AtomicLong idCounter = new AtomicLong();

    public Vendor save(Vendor vendor){
        Long codeId = idCounter.getAndIncrement();
        if(codeId == 0L){
            codeId = 1L;
        }
        vendor.setCreatedAt(date);
        vendor.setUpdatedAt(date);
        vendor.setCode(String.valueOf(codeId));
        return vendorRepository.save(vendor);
    }

    public Vendor findOne(UUID id){
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if(!vendor.isPresent()){
            return null;
        }
        return vendor.get();
    }

    public Iterable<Vendor> findAll(){
        return vendorRepository.findAll();
    }

    public void removeOne(UUID id){
        vendorRepository.deleteById(id);
    }
}
