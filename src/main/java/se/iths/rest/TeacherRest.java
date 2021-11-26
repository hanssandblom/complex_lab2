package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("")
    @POST
    public Response createTeacher(Teacher teacher) {
        Teacher result = teacherService.createTeacher(teacher);
        if (result != null) {
            return Response.ok(teacher).status(Response.Status.CREATED).build();
        } else {
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("kunde inte skapa läraten, kontrollera din json!")
                            .type(MediaType.TEXT_PLAIN_TYPE).build()
            );
        }
    }

    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.findTeacherById(id);
        return Response.ok(foundTeacher).build();
    }

    @Path("")
    @GET
    public Response getAllTeachers() {
        List<Teacher> foundTeachers = teacherService.getAllTeachers();
        if (!foundTeachers.isEmpty()) {
            return Response.ok(foundTeachers).build();
        } else {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("hittade inga lärare")
                            .type(MediaType.TEXT_PLAIN_TYPE).build()
            );
        }
    }

}
