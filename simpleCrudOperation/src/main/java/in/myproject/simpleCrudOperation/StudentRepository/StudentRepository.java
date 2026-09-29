package in.myproject.simpleCrudOperation.StudentRepository;


import in.myproject.simpleCrudOperation.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    }
