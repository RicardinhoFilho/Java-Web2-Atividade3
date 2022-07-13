/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistencia;

/**
 *
 * @author User
 */
public interface IDAO<T> {
    
     public boolean novo(T vo);


    public T buscar(int id);

    public java.util.List<T> listaTodos();
}
