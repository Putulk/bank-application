package micro_service.accounts.service;

import micro_service.accounts.dto.CustomerDto;
import micro_service.accounts.entity.Customer;

public interface IAccountsService{
    /**
     *
     * @param customerDto- CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber --> Input mobile number
     * @return Account details based on given mobileNumber
     */
    CustomerDto getAccountDetails(String mobileNumber);

    /**
     *
     * @param customerDto --> CustomerDto object
     * @return boolean indicating if the update of Account Details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber --> Input mobileNumber
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
