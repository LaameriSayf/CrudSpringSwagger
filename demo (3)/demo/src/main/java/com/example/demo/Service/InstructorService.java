package com.example.demo.Service;

import com.example.demo.Repository.InstructorRepository;
import com.example.demo.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService implements IInstructor<Instructor> {

    @Autowired
    InstructorRepository ir;

    @Override
    public List<Instructor> getall() {

        return ir.findAll() ;
    }

    @Override
    public void add(Instructor instructor) {
        ir.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return ir.save(instructor);
    }

    @Override
    public void delete(Long id) {
        ir.deleteById(id);
    }
}
