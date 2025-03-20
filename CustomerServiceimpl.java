package org.example.relations.Service;

import org.example.relations.Dto.DtoAdress;
import org.example.relations.Dto.DtoCustomer;
import org.example.relations.Dto.DtoCustomerIU;
import org.example.relations.Entity.Adress;
import org.example.relations.Entity.Customer;
import org.example.relations.Repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceimpl implements IcustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer getCustomerbyid(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAdress dtoAdress = new DtoAdress();

        Optional<Customer> optional = customerRepository.findById(id);

        if(optional.isPresent()){
            Customer custom = optional.get();
            Adress adress = optional.get().getAdress();

            BeanUtils.copyProperties(custom, dtoCustomer);
            BeanUtils.copyProperties(adress, dtoAdress);
            dtoCustomer.setAdress(dtoAdress);

            return dtoCustomer;
        }
        return null;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU customer) {
        Customer customer1 = new Customer();
        Adress adress = new Adress();

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAdress dtoAdress = new DtoAdress();

        BeanUtils.copyProperties(customer, customer1);
        BeanUtils.copyProperties(customer.getAdress(), adress);

        customer1.setAdress(adress);

        Customer saved = customerRepository.save(customer1);

        BeanUtils.copyProperties(saved, dtoCustomer);
        BeanUtils.copyProperties(saved.getAdress(), dtoAdress);
        dtoCustomer.setAdress(dtoAdress);

        return dtoCustomer;
    }

    @Override
    public List<DtoCustomer> getallcustomerbyid() {
        List<Customer> customerList = customerRepository.findAll();
        List<DtoCustomer> dtoCustomerList = new ArrayList<>();

        for (Customer customer : customerList) {
            DtoCustomer dtoCustomer = new DtoCustomer();
            DtoAdress dtoAdress = new DtoAdress();

            // Müştərinin adı və ünvanını DTO obyektlərinə köçürmək
            BeanUtils.copyProperties(customer, dtoCustomer);

            if (customer.getAdress() != null) {
                BeanUtils.copyProperties(customer.getAdress(), dtoAdress);
                dtoCustomer.setAdress(dtoAdress);
            }

            dtoCustomerList.add(dtoCustomer);
        }
        return dtoCustomerList;
    }

    @Override
    public DtoCustomer updateCustomer(Long id, DtoCustomerIU customerIU) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            // Müştərinin adı və digər məlumatları yeniləyirik
            customer.setName(customerIU.getName());


            // Ünvanı yeniləyirik (əgər varsa)
            if (customerIU.getAdress() != null) {
                Adress address = customer.getAdress();
                address.setDescription(customerIU.getAdress().getDescription());
                customer.setAdress(address);
            }

            // Yenilənmiş müştərini bazaya saxlayırıq
            Customer updatedCustomer = customerRepository.save(customer);

            // Yenilənmiş müştəriyi DTO formatında qaytarırıq
            DtoCustomer updatedDtoCustomer = new DtoCustomer();
            DtoAdress updatedDtoAdress = new DtoAdress();

            // Müştəri və ünvan məlumatlarını DTO obyektinə köçürürük
            BeanUtils.copyProperties(updatedCustomer, updatedDtoCustomer);
            if (updatedCustomer.getAdress() != null) {
                BeanUtils.copyProperties(updatedCustomer.getAdress(), updatedDtoAdress);
                updatedDtoCustomer.setAdress(updatedDtoAdress);
            }

            return updatedDtoCustomer;
        }
        return null;
    }


}
