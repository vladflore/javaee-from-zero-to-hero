package dev.vladflore.javaeezerotohero.resource;

import dev.vladflore.javaeezerotohero.entity.Gender;
import dev.vladflore.javaeezerotohero.mapper.EmployeeMapper;
import dev.vladflore.javaeezerotohero.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Path("employees")
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    public Response retrieveEmployeesByGender(@QueryParam("gender") Gender gender) {
    public Response retrieveEmployeesByGender(@QueryParam("gender") @DefaultValue("MALE") Gender gender) {
        if (gender == null) {
            return Response.ok(Collections.emptyList()).build();
        }
        return Response.ok(EmployeeMapper.INSTANCE.employeeToEmployeeDto(employeeService.loadEmployees(gender))).build();
    }

}
