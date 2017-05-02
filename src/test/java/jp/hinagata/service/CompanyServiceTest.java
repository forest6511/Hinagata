package jp.hinagata.service;

import jp.hinagata.BaseTest;
import jp.hinagata.model.entity.CompanyEntity;
import jp.hinagata.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
public class CompanyServiceTest extends BaseTest {
    @Autowired
    SampleService sampleService;

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void shouldSaveCompany() {
        String name = "TEST123";
        String zip = "11235";
        String address = "hinagata-hill 6511 NY";
        long id = sampleService.saveCompany(name, zip, address);

        // Keep testing data on CI?
        log.info("COMP ID = [{}]", id);

        Optional<CompanyEntity> entity = Optional.ofNullable(companyRepository.findOne(id));
        assertThat(true, is(entity.isPresent()));
        assertThat(name, is(entity.get().getName()));
        assertThat(address, is(entity.get().getAddress()));

    }
}
