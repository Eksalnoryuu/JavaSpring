package pl.javaspring.javaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController
{
    @Autowired
    GroupRepository groupRepository;
    @GetMapping("/Grupy")
    public List<Group> getAll()
    {
        return groupRepository.getAll();
    }
    @PostMapping("/AddGroup")
    public int add(@RequestBody Group grupa)
    {
        return groupRepository.save(grupa);
    }
    @DeleteMapping ("/DGroup{id}")
    public int deleteGroup(@PathVariable("id") int id)
    {
        return groupRepository.delete(id);
    }
   @GetMapping("/GrupyStudents{id}")
   public List<Student> getAllStudents(@PathVariable("id") int id)
   {
        return groupRepository.getAllStudents(id);
   }
    @GetMapping("/GrupyFill{id}")
    public double getFill(@PathVariable("id") int id)
    {
        return groupRepository.getFill(id);
    }
}
