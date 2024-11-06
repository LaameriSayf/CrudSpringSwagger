package com.example.demo.Controller;

import com.example.demo.Service.SkierService;
import com.example.demo.entity.Skier;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skier")
@Tag(name="Gestion Skier ")

public class SkierController {

    @Autowired
    SkierService ss;
//lki yabvda andi double imlementation ala nafes interfaces nesta3ml @Primary
    @Operation(description = "Ajouter nouveau skier")
    @PostMapping("/add")
    public ResponseEntity<?> addskier(@RequestBody Skier s){
        try{
            ss.addskier(s);
            return ResponseEntity.ok("l'ajout est effectuer avec succes");
        }catch (Exception e){
            return ResponseEntity.status(400).body("Probléme avec l'ajout");
        }

    }

    @GetMapping("/getall")
    public List<Skier> getall(){
        List ll=ss.getall();

        return ll;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSkier(@PathVariable Long id){
        if (id==null){
            System.out.println("id n'est pas saisir");
        }
        try {
            ss.delete(id);
            return ResponseEntity.ok("Le skier est supprimer avec succes");
        }catch (Exception e){
            return ResponseEntity.status(400).body("la suppresion est echouer");
        }
    }

    @PutMapping("/update/{id}")
    public Skier UpdateSkier(@PathVariable @NonNull long id,@RequestBody Skier s){
      List<Skier> l=getall();
        for (Skier b:l) {
            if (b.getNumSkier()==id)return s;
        }
        return ss.updateSkier(s);
    }





}
