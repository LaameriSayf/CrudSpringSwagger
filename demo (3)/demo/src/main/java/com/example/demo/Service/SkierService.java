package com.example.demo.Service;

import com.example.demo.Repository.SkierRepository;
import com.example.demo.entity.Skier;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkierService implements ISkier<Skier> {

    //@autowired ta3ml cablage entre interface et classe

    @Autowired
    SkierRepository sr;

    @Override
    public void addskier(@NonNull Skier s){
        sr.save(s);
    }

    @Override
    public List<Skier> getall(){
        return sr.findAll();
    }
    @Override
    public void delete(Long id){sr.deleteById(id);}
    @Override
    public Skier updateSkier(Skier s){
       return sr.save(s);
    }
}
