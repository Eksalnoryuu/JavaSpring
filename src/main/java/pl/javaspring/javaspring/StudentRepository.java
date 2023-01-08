package pl.javaspring.javaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class StudentRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM Student ",
                BeanPropertyRowMapper.newInstance(Student.class));
    }

    public int save(Student student)
    {
        List<Student> newStudent = getAll();
        Collections.max(newStudent, Comparator.comparingInt(Student::getIdStudent));
        jdbcTemplate.update("INSERT INTO Student(idStudent,Imie,Nazwisko,Punkty,Oceny, GrupaID) VALUES(?,?,?,?,?,?)",
                newStudent.get(newStudent.size() -1).getIdStudent() + 1,
                student.getImie(),
                student.getNazwisko(),
                student.getPunkty(),
                student.getOceny(),
                student.getGrupaID());
        return 1;
    }

    public int getOcena(int id)
    {
        Student newStudent = jdbcTemplate.queryForObject("SELECT idStudent, Imie, Nazwisko, Punkty, Oceny FROM Student WHERE idStudent = ?",BeanPropertyRowMapper.newInstance(Student.class) , id);
        return newStudent.getOceny();
    }

    public int delete(int id)
    {
        return jdbcTemplate.update("DELETE FROM Student WHERE idStudent=?",id);
    }

    public double getAllOcena()
    {
        List<Student> NewStudent = jdbcTemplate.query("SELECT * FROM Student ",
                BeanPropertyRowMapper.newInstance(Student.class));
        double returnValue = 0;
        for(int i = 0; i < NewStudent.size(); i++)
        {
            returnValue += NewStudent.get(i).getOceny();
        }
        returnValue /= NewStudent.size();
        return returnValue;
    }
}
