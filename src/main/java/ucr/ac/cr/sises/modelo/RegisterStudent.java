/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sises.modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author galagarza
 */
public class RegisterStudent {

    ArrayList<Student> listStudents;

    public RegisterStudent() {
        this.listStudents = new ArrayList<>();
    }

    public String add(Student student) {
        if (student != null) {
            if (this.search(student.getCarnet()) == null) {
                this.listStudents.add(student);
                return "Student added successfully.";
            } else {
                return "The student is registered.";
            }
        }
        return "Error adding student";
    }
    
    public String edit(Student studentEdit){
        if (this.search(studentEdit.getCarnet()) != null) {
            this.delete(studentEdit);
            this.add(studentEdit);
            return "Student successfully modified.";
        }
        return "Error when modified student.";
    }

    public String delete(Student studentDel) {

        for (int i = 0; i < this.listStudents.size(); i++) {
            if (listStudents.get(i).getCarnet().equalsIgnoreCase(studentDel.getCarnet())) {
                this.listStudents.remove(i);
                return "Student successfully eliminated.";
            }
        }
        return "Error when deleting student.";
    }

    public Student search(String carnet) {
        for (Student student : listStudents) {
            if (student.getCarnet().equalsIgnoreCase(carnet)) {
                return student;
            }
        }
        return null;
    }

    public String[] getComboCarnet() {
        String[] carnets = new String[this.listStudents.size()];
        for (int i = 0; i < this.listStudents.size(); i++) {
            carnets[i] = this.listStudents.get(i).getCarnet();
        }
        return carnets;
    }

    public String[][] getMatrizEstudiantes() {
        String[][] matriz = null;
        if (listStudents.size() >= 1) {
            matriz = new String[this.listStudents.size()][5];
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (j == 2) {
                        matriz[i][j] = String.valueOf(this.calcularEdad(this.listStudents.get(i).getFechaNacimiento()));
                    } else {
                        matriz[i][j] = this.listStudents.get(i).getDataStudent(j);
                    }
                }
            }

        }
        return matriz;
    }

    public int calcularEdad(Date fechaNacimiento) {
        // Obtener la fecha actual
        LocalDate nacimiento = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();

        // Calcular la diferencia de años
        long años = ChronoUnit.YEARS.between(nacimiento, fechaActual);

        return (int) años;
    }

}
