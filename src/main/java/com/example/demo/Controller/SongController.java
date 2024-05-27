package com.example.demo.Controller;

import com.example.demo.Entity.Song;
import com.example.demo.Repository.SongRepository;
import com.example.demo.SongNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/song")
public class SongController {
    @Autowired
    private SongRepository repository;

    @GetMapping("/{id}")
    public Song findById(@PathVariable long id){
        return repository.findById(id).orElseThrow(SongNotFoundException::new);
    }

    @GetMapping("/")
    public Collection<Song> findSongs(){
        return repository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Song updateSong(@PathVariable("id") final Long id, @RequestBody final Song song){
        if(!repository.existsById(id)) {
            throw new SongNotFoundException();
        }
        song.setId(id);
        return repository.save(song);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Song createSong(@RequestBody Song song){
        return repository.save(song);
    }
}
