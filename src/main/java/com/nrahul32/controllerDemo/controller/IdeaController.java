package com.nrahul32.controllerDemo.controller;

import com.nrahul32.controllerDemo.dto.IdeaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/demo_app"})
public class IdeaController {

    /**
     * This will act as in memory storage of ideas
     */
    private static final Map<Integer, IdeaDTO> IDEA_MAP = new HashMap<>();

    public IdeaController() {
        IdeaDTO idea1 = new IdeaDTO(1, "Great idea", "This is really great!", "Rahul");
        IdeaDTO idea2 = new IdeaDTO(2, "Bad idea", "This is a bad one", "Unknown");

        IDEA_MAP.put(idea1.getId(), idea1);
        IDEA_MAP.put(idea2.getId(), idea2);
    }

    /**
     * Search an idea based on the id
     * GET
     * localhost:8080/demo_app/ideas/1
     *
     * @param id
     * @return IdeaDTO
     */

    @GetMapping(value = {"/ideas/{id}"})
    public ResponseEntity getIdeaOfId(@PathVariable(name="id") int id) {
        return new ResponseEntity(IDEA_MAP.get(id), HttpStatus.OK);
    }
}
