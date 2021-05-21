package kz.iitu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class RestfulController {
    @Autowired
    private RestfulRepo restfulRepo;

   @GetMapping("/students")
    public Iterable<Restful> list(){
        return restfulRepo.findAll();
    }

    @GetMapping("/students/{id}")
    Restful getStudentById(@PathVariable("id") long id){
        return restfulRepo.findById(id).get();
    }

    @PostMapping("/")
    public long add(@RequestBody Restful restful){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy:MM:dd");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime.format(form);
        restful.setDate(date);
        restfulRepo.save(restful);
        return restful.getId();
    }
    @PutMapping("/students/update/{id}")
    Restful update(@RequestBody Restful restful , @PathVariable long id){

        return restfulRepo.findById(id).map(restful1 -> {
            restful1.setName(restful.getName());
            restful1.setPassword(restful.getPassword());
            return restfulRepo.save(restful1);
        }).orElseGet(() ->{
            restful.setId(id);
            return restfulRepo.save(restful);
        });

    }
    @DeleteMapping("/students/{id}")
    public void delete(@PathVariable("id")long id){
        restfulRepo.deleteById(id);
    }
}
