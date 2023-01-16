package ro.rarom.rezervaribilete.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.rarom.rezervaribilete.model.Spectacol;
import ro.rarom.rezervaribilete.service.SpectacolService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("spectacole")
@RestController
public class SpectacolController {
    //aici definesc endpoint-urile si legaturile cu metodele din Service

    private final SpectacolService spectacolService;

    //lista spectacole
    @GetMapping
    public List<Spectacol> getAll() {
        return spectacolService.getAllSpectacole();
    }

    //cautare spectacol dupa id
    @GetMapping("{id}")  //http://host:port/spectacole/2
    public Spectacol getById(@PathVariable int id) {
        return spectacolService.getById(id);
    }

//adaugare spectacol
    @PostMapping    //http://host:port/spectacole
    public Spectacol add(@RequestBody Spectacol spectacol) {
        return spectacolService.add(spectacol);
    }

    //sterge spectacol
    @DeleteMapping("{id}") //http://host:port/spectacole/3
    public Spectacol deleteByid(@PathVariable long id) {
        return spectacolService.deleteById(id);
    }

    //update spectacol
    @PutMapping("{id}")
    public Spectacol update(@PathVariable long id, @RequestBody Spectacol spectacol) {
        return spectacolService.update(id,spectacol);
    }



}


