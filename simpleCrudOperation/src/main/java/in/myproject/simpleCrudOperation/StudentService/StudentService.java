package in.myproject.simpleCrudOperation.StudentService;

import in.myproject.simpleCrudOperation.Entity.Student;
import in.myproject.simpleCrudOperation.StudentRepository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq) {
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id) {

        Optional<Student> studentResp = studentRepository.findById(id);


        if (studentResp.isPresent()) {
            return studentResp.get();
        }

        return null;
    }
    public List<Student> getAllStudent() {
       List<Student> studentList =  studentRepository.findAll();
       return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> exisitingStudent = studentRepository.findById(id);

        if(exisitingStudent.isEmpty()){
            return null;
        }

        Student studenttoSave = exisitingStudent.get();
        studenttoSave.setName(studentReq.getName());
        studenttoSave.setAge(studentReq.getAge());
        studenttoSave.setEmail(studentReq.getEmail());
        studenttoSave.setSubject(studentReq.getSubject());
        studenttoSave.setRollNo(studentReq.getRollNo());
        return studentRepository.save(studenttoSave);
    }
    public boolean deleteStudent(Long id) {
        Boolean isStudent =  studentRepository.existsById(id);

        if(!isStudent){
            return false;
        }studentRepository.deleteById(id);
        return true;
    }
}
