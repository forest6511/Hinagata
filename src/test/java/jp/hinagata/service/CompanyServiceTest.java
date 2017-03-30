package jp.hinagata.service;

import jp.hinagata.ApplicationTest;
import jp.hinagata.model.entity.CompanyEntity;
import jp.hinagata.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@ActiveProfiles("test")
public class CompanyServiceTest {
    @Autowired
    SampleService sampleService;

    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void shouldSaveCompany(){
        String name = "TEST123";
        String zip = "11235";
        String address = "hinagata-hill 6511 NY";
        long id = sampleService.saveCompany(name, zip, address);

        Optional<CompanyEntity> entity = Optional.ofNullable(companyRepository.findOne(id));
        assertThat(true, is(entity.isPresent()));
        assertThat(name, is(entity.get().getName()));
        assertThat(address, is(entity.get().getAddress()));

    }
}
