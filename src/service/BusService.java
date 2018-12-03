package service;


import notentity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import repository.BusRepository;

import java.util.Collection;
import java.util.List;

@Component
public class BusService {
    @Autowired
    private BusRepository productRepository;

    @Transactional
    public void add(Bus bus) {
        productRepository.save(bus);
    }

    @Transactional(readOnly=true)
    public List<Bus> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void addAll(Collection<Bus> buses) {
        for (Bus bus : buses) {
            productRepository.save(bus);
        }
    }

    @Transactional(readOnly=true)
    public List<Bus> findByNumberIs(String number) {
        return productRepository.findByNumberIs(number);
    }

    @Transactional(readOnly=true)
    public List<Bus> findByNumberContainingIgnoreCase(String searchString) {
        return productRepository.findByNumberContainingIgnoreCase(searchString);
    }
}
