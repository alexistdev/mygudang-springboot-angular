package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VendorRepository extends CrudRepository<Vendor, UUID> {

}
