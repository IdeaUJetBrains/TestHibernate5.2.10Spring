package service;

import java.util.Collection;
import java.util.List;

import entity.Entitybus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import repository.EntitybusRepository;

@Component
public class EntitybusService {
    @Autowired
    private EntitybusRepository productRepository;

    @Transactional
    public void add(Entitybus entitybus) {
        productRepository.save(entitybus);
    }

    @Transactional(readOnly=true)
    public List<Entitybus> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void addAll(Collection<Entitybus> entitybuses) {
        for (Entitybus entitybus : entitybuses) {
            productRepository.save(entitybus);
        }
    }

    @Transactional(readOnly=true)
    public List<Entitybus> findByEnumberIs(String enumber) {
        return productRepository.findByEnumberIs(enumber);
    }

    @Transactional(readOnly=true)
    public List<Entitybus> findByEnumberContainingIgnoreCase(String searchString) {
        return productRepository.findByEnumberContainingIgnoreCase(searchString);
    }
}
