/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sises.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import ucr.ac.cr.sises.modelo.RegisterStudent;
import ucr.ac.cr.sises.modelo.Student;
import ucr.ac.cr.sises.vista.FrmStudent;
import ucr.ac.cr.sises.vista.PanelStudent;
import ucr.ac.cr.sises.vista.PanelTable;

/**
 *
 * @author galagarza
 */
public class ControllerStudent implements ActionListener, MouseListener{
    
    private RegisterStudent registerStudent;
    private FrmStudent frmStudent;
    private PanelStudent panelStudent;
    private PanelTable panelTable;
    private Student student;

    public ControllerStudent() {
        this.frmStudent=new FrmStudent();
        this.frmStudent.setController(this);
        this.registerStudent=new RegisterStudent();
        this.panelStudent=this.frmStudent.getPanelStudent();
        this.panelTable=this.frmStudent.getPanelTable();
        this.panelTable.setTable(this.registerStudent.getMatrizEstudiantes());
        this.frmStudent.setVisible(true);
        this.panelStudent.loadCarnet(this.registerStudent.getComboCarnet());
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toString()) {
            case "add":
                this.student=this.panelStudent.getStudent();
                FrmStudent.message(this.registerStudent.add(student));
                this.panelStudent.loadCarnet(this.registerStudent.getComboCarnet());
                this.panelTable.setTable(this.registerStudent.getMatrizEstudiantes());
                this.panelStudent.clean();
                break;
            case "edit":
                this.student=this.panelStudent.getStudent();
                FrmStudent.message(this.registerStudent.edit(student));
                 this.panelTable.setTable(this.registerStudent.getMatrizEstudiantes());
                this.panelStudent.clean();
                break;
            case "delete":
                this.student=this.panelStudent.getStudent();
                FrmStudent.message(this.registerStudent.delete(this.student));
                this.panelStudent.loadCarnet(this.registerStudent.getComboCarnet());
                this.panelTable.setTable(this.registerStudent.getMatrizEstudiantes());
                this.panelStudent.clean();
                
                break;
               case "comboCarnets":
                   this.student=this.registerStudent.search(this.panelStudent.getComboCarnet());
                   this.panelStudent.setStudent(student);
                
                break;
            case "close":
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String[] dataRow=this.panelTable.getRow();
        this.student=this.registerStudent.search(dataRow[0]);
        this.panelStudent.setStudent(student);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
}
