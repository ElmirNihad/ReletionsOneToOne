package org.example.relations.Controller;

import org.example.relations.Dto.DtoCustomer;
import org.example.relations.Dto.DtoCustomerIU;

import java.util.List;

public interface İcustomerController {

    public DtoCustomer getCustomerbyid(Long id);

    public DtoCustomer saveCustomer(DtoCustomerIU customer);

    public List<DtoCustomer> getallcustomerbyid();

    public DtoCustomer updateCustomer(Long id ,DtoCustomerIU customerIU);
}
