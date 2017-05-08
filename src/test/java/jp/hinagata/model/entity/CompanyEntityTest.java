package jp.hinagata.model.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import jp.hinagata.BaseTest;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CompanyEntityTest extends BaseTest {

    private JacksonTester<CompanyEntity> json;

    @Before
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        JacksonTester.initFields(this, mapper);
    }

    @Test
    public void serializeJson() throws IOException {
        String name = "TEST123";
        String zip = "11239";
        String address = "hinagata-spring-tutorial 6511 NY";

        CompanyEntity entity = new CompanyEntity();
        entity.setName(name);
        entity.setAddress(address);
        entity.setZip(zip);

        assertThat(json.write(entity))
                .extractingJsonPathStringValue("@.zip")
                .isEqualTo(zip);
    }

    @Test
    public void deserializeJson() throws IOException {

        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "TEST678");
        data.put("zip", "987654");
        data.put("address", "hinagata-spring-tutorial 6511 CA");

        //"{\"name\": \"" + name + "\", \"zip\": \"" + zip + "\", \"address\": \"" + address + "\"}";
        String company = new JSONObject(data).toString();

        CompanyEntity entity = new CompanyEntity();
        entity.setName(data.get("name"));
        entity.setAddress(data.get("address"));
        entity.setZip(data.get("zip"));

        ObjectContent<CompanyEntity> content =
                json.read(new ByteArrayInputStream(company.getBytes(StandardCharsets.UTF_8)));

        assertThat(content)
                .isEqualTo(entity);
    }

}
