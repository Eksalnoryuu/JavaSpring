package pl.javaspring.javaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Students")
public class StudentController
{
    @Autowired
    StudentRepository studentRepository;
    @GetMapping("/test")
    public int Test()
    {
        return 1;
    }
    @GetMapping("/Student")
    public List<Student> getAll()
    {
        return studentRepository.getAll();
    }
    @PostMapping("/AddStudent")
    public int add(@RequestBody Student students)
    {
        System.out.println(students);
        return studentRepository.save(students);
    }
    @GetMapping("/Ocena{id}")
    public int getOcena(@PathVariable("id") int id)
    {
        return studentRepository.getOcena(id);
    }
    @DeleteMapping ("/DStudent{id}")
    public int deleteStudent(@PathVariable("id") int id)
    {
        return studentRepository.delete(id);
    }
    @GetMapping("/StudentOcenaAll")
    public double getAllOcena()
    {
        return studentRepository.getAllOcena();
    }
}
