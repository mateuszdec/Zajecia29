package org.javastart.demo.service;

import org.javastart.demo.model.Address;
import org.javastart.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    public Address findOne(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
