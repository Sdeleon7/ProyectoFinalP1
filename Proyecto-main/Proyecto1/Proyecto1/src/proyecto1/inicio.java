
package proyecto1;
import proyecto1.Login;
import com.sun.jdi.connect.spi.Connection;
import java.util.Scanner;


public class inicio {
    
    public static void main(String[] args) {
        Conection conexion = new Conection();
        java.sql.Connection connection = conexion.getConnection();
        CAlumnos1 alumnos = new CAlumnos1(connection);
        Login login = new Login(connection);
       
        Scanner scanner = new Scanner(System.in);
          
        System.out.println("Inicio de Sesion");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        
        if (login.iniciarSesion(usuario, contrasena)) {
            System.out.println("Inicio de sesión exitoso.");

            
            System.out.println("Menu:");
            System.out.println("1. Insertar alumno");
            System.out.println("2. Leer alumnos");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("Ingrese el numero de la opcion que desea realizar:");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    insertarAlumno(alumnos, scanner);
                    break;
                case 2:
                    alumnos.leerAlumnos();
                    break;
                case 3:
                    actualizarAlumno(alumnos, scanner);
                    break;
                case 4:
                    eliminarAlumno(alumnos, scanner);
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } else {
            System.out.println("Credenciales incorrectas. Por favor, intentalo de nuevo.");
        }
        
        scanner.close();
    }
        
      
    
    public static void insertarAlumno(CAlumnos1 alumnos, Scanner scanner) {
        System.out.println("Ingrese el carnet:");
        int carnet = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Ingrese el primer nombre:");
        String primerNombre = scanner.nextLine();
        
        System.out.println("Ingrese el segundo nombre:");
        String segundoNombre = scanner.nextLine();
        
        System.out.println("Ingrese el tercer nombre:");
        String tercerNombre = scanner.nextLine();
        
        System.out.println("Ingrese el primer apellido:");
        String primerApellido = scanner.nextLine();
        
        System.out.println("Ingrese el segundo apellido:");
        String segundoApellido = scanner.nextLine();
        
        System.out.println("Ingrese el tercer apellido:");
        String tercerApellido = scanner.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento DIA/mes/Anio");
        String fechaNacimiento = scanner.nextLine();
        
        System.out.println("Ingrese la direccion:");
        String direccion = scanner.nextLine();
        
        System.out.println("Ingrese el semestre:");
        int semestre = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Ingrese la facultad:");
        String facultad = scanner.nextLine();
        
        alumnos.insertarAlumno(carnet, primerNombre, segundoNombre, tercerNombre, primerApellido, segundoApellido, tercerApellido, fechaNacimiento, direccion, semestre, facultad);
    }
    
public static void actualizarAlumno(CAlumnos1 alumnos, Scanner scanner) {
    System.out.println("Ingrese el carnet del alumno que desea actualizar:");
    int carnet = scanner.nextInt();
    scanner.nextLine(); 

    System.out.println("¿Qué campo desea actualizar?");
    System.out.println("1. Primer nombre");
    System.out.println("2. Segundo nombre");
    System.out.println("3. Tercer nombre");
    System.out.println("4. Primer apellido");
    System.out.println("5. Segundo apellido");
    System.out.println("6. Tercer apellido");
    System.out.println("7. Fecha de nacimiento");
    System.out.println("8. Direccion");
    System.out.println("9. Semestre");
    System.out.println("10. Facultad");
    System.out.println("Ingrese el número de la opción que desea actualizar:");
    int opcion = scanner.nextInt();
    scanner.nextLine(); 

    String nuevoValor;
    switch (opcion) {
        case 1:
            System.out.println("Ingrese el nuevo primer nombre:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "primer_nombre", nuevoValor);
            break;
        case 2:
            System.out.println("Ingrese el nuevo segundo nombre:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "segundo_nombre", nuevoValor);
            break;
        case 3:
            System.out.println("Ingrese el nuevo tercer nombre:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "tercer_nombre", nuevoValor);
            break;
        case 4:
            System.out.println("Ingrese el nuevo primer apellido:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "primer_apellido", nuevoValor);
            break;
        case 5:
            System.out.println("Ingrese el nuevo segundo apellido:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "segundo_apellido", nuevoValor);
            break;
        case 6:
            System.out.println("Ingrese el nuevo tercer apellido:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "tercer_apellido", nuevoValor);
            break;
        case 7:
            System.out.println("Ingrese la nueva fecha de nacimiento dia/mes/anio):");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "fecha_de_nacimiento", nuevoValor);
            break;
        case 8:
            System.out.println("Ingrese la nueva dirección:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "direccion", nuevoValor);
            break;
        case 9:
            System.out.println("Ingrese el nuevo semestre:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "semestre", nuevoValor);
            break;
        case 10:
            System.out.println("Ingrese la nueva facultad:");
            nuevoValor = scanner.nextLine();
            alumnos.actualizarAlumno(carnet, "facultad", nuevoValor);
            break;
        default:
            System.out.println("Opcion no válida.");
    }
}

    public static void eliminarAlumno(CAlumnos1 alumnos, Scanner scanner) {
        System.out.println("Ingrese el carnet del alumno que desea eliminar:");
        int carnet = scanner.nextInt();
        scanner.nextLine(); 
        
        alumnos.eliminarAlumno(carnet);
    }
}