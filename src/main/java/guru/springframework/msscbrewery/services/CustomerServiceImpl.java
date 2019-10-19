package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * User: MD.Ahmad
 * Date: 9/21/2019 4:00 PM
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void createCustomer(CustomerDto customerDto) {
        log.info("Customer Created");
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        log.info("Updated");
    }

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Tausif").build();
    }

    @Override
    public void deleteCustomer(UUID id) {
        log.info("Deleted");
    }
}
