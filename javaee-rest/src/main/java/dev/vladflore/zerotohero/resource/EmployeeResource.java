package dev.vladflore.zerotohero.resource;

import dev.vladflore.zerotohero.repository.EmployeeRepository;
import dev.vladflore.zerotohero.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("employees")
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveEmployees() {
        return Response.ok(employeeService.loadEmployees()).build();
    }

}
