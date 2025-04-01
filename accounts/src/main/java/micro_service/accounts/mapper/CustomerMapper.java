package micro_service.accounts.mapper;

import micro_service.accounts.dto.CustomerDto;
import micro_service.accounts.entity.Customer;

public class CustomerMapper{
    public static CustomerDto mapToCustomerDto(Customer customer,CustomerDto customerDto){
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer){
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
