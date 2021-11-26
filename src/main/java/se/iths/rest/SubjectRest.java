package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        Subject result = subjectService.createSubject(subject);
        if (result != null) {
            return Response.ok(subject).status(Response.Status.CREATED).build();
        } else {
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("kunde inte skapa ämnet, kontrollera din json!")
                            .type(MediaType.TEXT_PLAIN_TYPE).build()
            );
        }
    }

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        return Response.ok(foundSubject).build();
    }

    @Path("")
    @GET
    public Response getAllSubjects() {
        List<Subject> foundSubjects = subjectService.getAllSubjects();
        if (!foundSubjects.isEmpty()) {
            return Response.ok(foundSubjects).build();
        } else {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                            .entity("hittade inga kurser")
                            .type(MediaType.TEXT_PLAIN_TYPE).build()
            );
        }
    }

    @Path("getbysubject")
    @GET
    public Response findSubjectInfoByName(@QueryParam("subject") String subject) {
        if (subject == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("subject parameter är oblikatoriskt")
                            .type(MediaType.TEXT_PLAIN_TYPE).build()
            );
        }
        List<Subject> foundSubjects = subjectService.findSubjectInfoByName(subject);
        return Response.ok(foundSubjects).build();
    }

    @Path("getallitemssortedbycategorycriteria")
    @GET
    public List<Subject> getAllSubjectsSortedByCategoryCriteria() {
        return subjectService.getAllSubjectsSortedByCategoryCriteria();
    }

}
