package com.nrahul32.controllerDemo.controller;

import com.nrahul32.controllerDemo.dto.IdeaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/demo_app/v1"})
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
     * localhost:8080/demo_app/v1/ideas/1
     *
     * @param id
     * @return IdeaDTO
     */

    @GetMapping(value = {"/ideas/{id}"})
    public ResponseEntity getIdeaOfId(@PathVariable(name="id") int id) {
        return new ResponseEntity(IDEA_MAP.get(id), HttpStatus.OK);
    }

    /**
     * CRUD
     *
     * Create - POST    - @PostMapping
     * Read   - GET     - @GetMapping
     * Update - UPDATE  - @PutMapping
     * Delete - DELETE  - @DeleteMapping
     *
     */

    /**
     * Create an Idea
     * POST
     * localhost:8080/demo_app/v1/ideas
     *
     * BODY:
     * {
     *     "id":5,
     *     "title":"new",
     *     "author":"me",
     *     "description":"new idea added via post"
     * }
     *
     * RequestBody is needed to map the JSON passed in request to the IdeaDTO object
     * Consumes indicates this method only accepts JSON in request body
     */
    @PostMapping(value = {"/ideas"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createIdea(@RequestBody IdeaDTO ideaDTO) {
        IDEA_MAP.put(ideaDTO.getId(), ideaDTO);
        return new ResponseEntity(ideaDTO, HttpStatus.OK);
    }

    /**
     * Update an Idea
     * PUT
     * localhost:8080/demo_app/v1/idea/1
     *
     * BODY:
     * {
     *     "id":1,
     *     "title":"new",
     *     "author":"me",
     *     "description":"new idea added via post"
     * }
     *
     * PathVariable is needed to get the id from the request path
     * RequestBody is needed to map the JSON passed in request to the IdeaDTO object
     * Consumes indicates this method only accepts JSON in request body
     * Produces indicates this method only accepts JSON in response body
     */
    @PutMapping(value = {"/ideas/{id}"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateIdea(@PathVariable(name="id") int id, @RequestBody IdeaDTO ideaDTO) {
        IDEA_MAP.put(id, ideaDTO);
        return new ResponseEntity(ideaDTO, HttpStatus.OK);
    }

    /**
     * Delete an idea based on the id
     * DELETE
     * localhost:8080/demo_app/v1/ideas/1
     *
     * @param id
     */

    @DeleteMapping(value = {"/ideas/{id}"})
    public ResponseEntity DeleteOfId(@PathVariable(name="id") int id) {
        IDEA_MAP.remove(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    /**
     * Gets all the ideas
     *
     * GET
     * localhost:8080/demo_app/v1/ideas
     */
    @GetMapping(value = {"/ideas"})
    public ResponseEntity fetchAllIdeas() {
        List<IdeaDTO> ideas = new ArrayList<>();
        for(IdeaDTO idea : IDEA_MAP.values()) {
            ideas.add(idea);
        }
        return  new ResponseEntity(ideas, HttpStatus.OK);
    }
}
