package com.carlocayos.rest;

import com.carlocayos.dto.DogDTO;
import com.carlocayos.service.DogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/api/dogs")
@Api("/api/dogs")
public class DogController
{
    @Autowired
    private DogServiceImpl service;

    /**
     * Call this REST API via
     * (curl -i -X GET "http://localhost:8080/api/dogs/hello")
     *
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Say hello \uD83D\uDC4B \uD83D\uDC36", notes = "Just say hello", response = Map.class)
    public Map helloDog()
    {
        Map map = new HashMap<String, String>();
        map.put("Hello", "Dog");
        return map;
    }

    /**
     * Call this REST API via
     * (curl -i -X GET "http://localhost:8080/api/dogs")
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all dogs \uD83C\uDF2D \uD83D\uDC3E \uD83D\uDC36", notes = "Retrieving the collection of dogs", response = DogDTO[].class)
    @ApiResponses({@ApiResponse(code = 200, message = "Success", response = DogDTO[].class)})
    public List<DogDTO> getDogs()
    {
        return service.findAll();
    }

    /**
     * Call this REST API via
     * (curl -H 'Content-Type: application/json' -X POST -d '{"name": "Ghost", "breed":"Wolf", "age":2}' http://localhost:8080/api/dogs)
     *
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a dog \uD83C\uDF70 \uD83D\uDC36", notes = "Creating a new dog", response = DogDTO.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Success", response = DogDTO[].class)})
    public DogDTO createDog(@Valid @RequestBody DogDTO dto)
    {
        return service.create(dto);
    }

    /**
     * Call this REST API via
     * (curl -H 'Content-Type: application/json' -X PUT -d '{"name": "Hachiko2", "breed":"Shiba Inu2", "age":6}' http://localhost:8080/api/dogs/1)
     *
     * @param id
     * @param dto
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update dog \uD83C\uDF56 \uD83D\uDC36", notes = "Update an existing dog", response = DogDTO.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Success", response = DogDTO[].class)})
    public DogDTO updateDog(@PathVariable Long id, @Valid @RequestBody DogDTO dto)
    {
        return service.update(id, dto);
    }

    /**
     * Call this REST API via
     * (curl -i -X DELETE "http://localhost:8080/api/dogs/1")
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete dog \uD83D\uDE2D \uD83D\uDC36", notes = "Removing an existing dog", response = DogDTO.class)
    @ApiResponses({@ApiResponse(code = 204, message = "Success", response = DogDTO[].class)})
    public void deleteDog(@PathVariable Long id)
    {
        service.delete(id);
    }
}
