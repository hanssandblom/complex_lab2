Example json for creating a student

{
"firstName": "dfgd",
"lastName": "dfgd",
"email": "hans@hans.se",
"phoneNumber": "56756" (phoneNumber is optional)
}

Example json for creating a teacher

{
"teacherName": "Skol Vaktis"
}

Example json for creating a subject

{
"subject": "Geografi"
}

Sample data is populated when started, /util/SampleDataGenerator.

Root URI http://localhost:8080/student-management-system/api/v1/subjects/

Possible end-points:

`createSubject` POST done at Root with sample json.

`getAllSubjects` GET done at Root.

`findSubjectById` GET done at Root followed by id #.

Root URI http://localhost:8080/student-management-system/api/v1/teachers/

Possible end-points:

(lab requirement, creates list of students and teacher)
`findSubjectInfoByName` GET done at Root followed by getbysubject. Query "subject" and enter name to search for, ex Matte.

`createTeacher` POST done at Root with sample json.

`getTeacher` GET done at Root followed by id #.

`getAllTeacherss` GET done at Root.

Root URI http://localhost:8080/student-management-system/api/v1/students/

Possible end-points:

`createStudent` POST done at Root with sample json.

`deleteStudent` DEL done at Root followed by id #.

`getAllStudentsByLastName` GET done at Root followed by getallbylastname. Query "lastName" and enter name to search for.

`getAllStudents` GET done at Root.

`getStudent` GET done at Root followed by id #.

`updateFirstName` PATCH done at Root followed by updatefirstname and id #. (/updatefirstname/1) Query "firstName" and enter new name.

`updateLastName` PATCH done at Root followed by updatelastname and id #. (/updatelastname/1) Query "lastName" and enter new name.

`updateEmail` PATCH done at Root followed by updateemail and id #. (/updateemail/1) Query "email" and enter new email.

`updatePhoneNumber` PATCH done at Root followed by phonenumber and id #. (/phonenumber/1) Query "phoneNumber" and enter new phonenumber.

