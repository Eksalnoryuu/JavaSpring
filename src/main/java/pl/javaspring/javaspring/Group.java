package pl.javaspring.javaspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group
{
    private int IDGroup;
    private String NazwaGrupy;
    private int Ocena;
}
