package in.myproject.simpleCrudOperation.StudentController;

import in.myproject.simpleCrudOperation.Entity.Student;
import in.myproject.simpleCrudOperation.StudentService.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity <Student> createStudent(@RequestBody Student student) {

        Student creatStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(creatStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable("id") Long id) {

        Student studentResp = studentService.getStudent(id);

        if(studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> studentsList = studentService.getAllStudent();

        if(studentsList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok(studentsList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity <Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student studentReq) {
        Student studentResp = studentService.updateStudent(id, studentReq);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> deleteStudent(@PathVariable("id") Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok("Record is deleted successfully");

    }
}