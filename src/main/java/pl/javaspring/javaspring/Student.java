package pl.javaspring.javaspring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student
{
    private int idStudent;
    private String Imie;
    private String Nazwisko;
    private double Punkty;
    private int Oceny;
    private int GrupaID;
}
