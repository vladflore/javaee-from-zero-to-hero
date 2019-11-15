import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.vladflore.javaeezerotohero.dto.EmployeeDto;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

public class Stepdefs {

    public static final String EMPLOYEES_JSON = "employees.json";
    private final WireMockServer mockServer = new WireMockServer(options().dynamicPort());
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final URI uri = Objects.requireNonNull(getClass().getClassLoader().getResource(EMPLOYEES_JSON)).toURI();
    private final String jsonString = new String(Files.readAllBytes(Paths.get(uri)));

    private List<EmployeeDto> employees;

    public Stepdefs() throws IOException, URISyntaxException {
    }

    @When("the employees are returned to the consumer")
    public void theEmployeesAreReturnedToTheConsumer() throws IOException, JAXBException {
        mockServer.start();
        configureFor("localhost", mockServer.port());
        stubFor(get(urlEqualTo("/emps/api/v1/employees")).willReturn(aResponse().withBody(jsonString)));

        HttpGet httpGet = new HttpGet("http://localhost:" + mockServer.port() + "/emps/api/v1/employees");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();

        String jsonString = EntityUtils.toString(entity);

        employees = Arrays.asList(new ObjectMapper().readValue(jsonString, EmployeeDto[].class));

        mockServer.stop();
    }

    @Then("the country of each employee is in upper-case")
    public void theCountryOfEachEmployeeIsInUpperCase() {
        List<String> countries = employees.stream().map(employee -> employee.getAddress().getCountry()).collect(Collectors.toList());
        Optional<String> first = countries.stream().filter(country -> !country.equals(country.toUpperCase())).findFirst();
        assertThat(first.isPresent()).isFalse();
    }
}
