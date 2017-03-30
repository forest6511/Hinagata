package jp.hinagata.service;

import jp.hinagata.model.entity.CompanyEntity;
import jp.hinagata.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {

    private final static Logger logger = LoggerFactory.getLogger(SampleService.class);

    @Autowired
    CompanyRepository companyRepository;

    @Transactional(rollbackForClassName={"Exception"}, propagation= Propagation.REQUIRED)
    public long saveCompany(String name, String zip, String address){

        CompanyEntity entity = new CompanyEntity();
        entity.setName(name);
        entity.setZip(zip);
        entity.setAddress(address);
        companyRepository.save(entity);
        return entity.getId();
    }
}
