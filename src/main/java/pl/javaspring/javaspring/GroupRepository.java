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
public class GroupRepository
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Group> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM JavaDB.Group",
                BeanPropertyRowMapper.newInstance(Group.class));
    }

    public int save(Group grupa)
    {
        List<Group> newGroup = getAll();
        Collections.max(newGroup, Comparator.comparingInt(Group::getIDGroup));
        jdbcTemplate.update("INSERT INTO JavaDB.Group(IDGroup,NazwaGrupy,Ocena) VALUES(?,?,?)",
                newGroup.get(newGroup.size()-1).getIDGroup() + 1,
                grupa.getNazwaGrupy(),
                grupa.getOcena());
        return 1;
    }

    public int delete(int id)
    {
        return jdbcTemplate.update("delete from JavaDB.Group where IDGroup = ?",id);
    }


    public List<Student> getAllStudents(int id) {
        return jdbcTemplate.query("SELECT * FROM JavaDB.Student WHERE JavaDB.Student.GrupaID = ?",
                BeanPropertyRowMapper.newInstance(Student.class),id);
    }
    public double getFill(int id) {
        List<Student> newGroup = getAllStudents(id);
        return newGroup.size()/16.0;
    }
}
