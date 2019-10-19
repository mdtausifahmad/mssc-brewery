package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * User: MD.Ahmad
 * Date: 9/21/2019 3:59 PM
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID id);

    void createCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    void deleteCustomer(UUID id);
}
