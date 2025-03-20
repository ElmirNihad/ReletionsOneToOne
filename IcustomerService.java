package org.example.relations.Service;

import org.example.relations.Dto.DtoCustomer;
import org.example.relations.Dto.DtoCustomerIU;

import java.util.List;

public interface IcustomerService {

    public DtoCustomer getCustomerbyid(Long id);

    public DtoCustomer saveCustomer(DtoCustomerIU customer);

    public List<DtoCustomer> getallcustomerbyid();

    public DtoCustomer updateCustomer(Long id ,DtoCustomerIU customerIU);

}
