package ro.rarom.rezervaribilete.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.rarom.rezervaribilete.model.Spectacol;
import ro.rarom.rezervaribilete.service.SpectacolService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("spectacole")
@RestController
public class SpectacolController {
    //aici definesc endpoint-urile si legaturile cu metodele din Service

    private final SpectacolService spectacolService;

    @GetMapping
    public List<Spectacol> getAll() {
        return spectacolService.getAllSpectacole();
    }

    @GetMapping("{id}")  //http://host:port/spectacole/2
    public Spectacol getById(@PathVariable int id) {
        return spectacolService.getById(id);
    }
}
