package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDto> getBeer(@PathVariable("id") UUID id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customerDto.getId().toString());

        return  new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("id") UUID id, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") UUID id){
        customerService.deleteCustomer(id);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public  ResponseEntity<List>  validationError(ConstraintViolationException e){

        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach( constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}
