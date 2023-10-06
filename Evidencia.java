import java.util.Scanner;
import java.time.Instant;
import java.util.ArrayList;

//*****************************************************//
//  Programa Realizado por Juan Antonio Flores         //
//*****************************************************//

final class Paciente {
    private long id;
    private String nombre;

    public Paciente(String nombre) {
        this.id = Instant.now().getEpochSecond();
        this.nombre = nombre;
    }

    public void getInfo() {
        System.out.println(this.id + " - " + this.nombre);
    }
}

final class Doctor {
    private long id;
    private String nombre, especialidad;

    public Doctor(String nombre, String especialidad) {
        this.id = Instant.now().getEpochSecond();
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public void getInfo() {
        System.out.println(this.id + " - " + this.nombre + " - " + this.especialidad);
    }
}

final class Cita {
    private long id;
    private String fecha, hora, motivo, idPaciente, idDoctor;

    public Cita(String fecha, String hora, String motivo, String idPaciente, String idDoctor) {
        this.id = Instant.now().getEpochSecond();
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
    }

    public void getInfo() {
        System.out.println(this.id + " - " + this.fecha + " - " + this.hora + " - " + this.motivo + " - "
                + this.idPaciente + " - " + this.idDoctor);
    }
}

public class Evidencia {

    public static String askInput(Scanner inputScanner, String inputMessage) {
        System.out.print("\n" + inputMessage + ": ");
        String keyboardInput = inputScanner.nextLine();
        return keyboardInput;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Inicio de sesión consultorio");

        String userName = askInput(inputScanner, "Ingrese su usuario");
        String userPass = askInput(inputScanner, "Ingrese su contraseña");

        if (!userName.equals("jzaher") || !userPass.equals("admin")) {
            System.out.println("***** Credenciales incorrectas *****");
            System.exit(0);
        }

        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        ArrayList<Cita> citas = new ArrayList<Cita>();

        while (true) {
            System.out.println("\nMenú principal (elija una opción)");
            System.out.println("- 1. Agregar un doctor");
            System.out.println("- 2. Agregar un paciente");
            System.out.println("- 3. Agregar una cita");
            System.out.println("- 4. Mostrar información guardada");
            System.out.println("- 5. Salir de la aplicación");

            String userText = askInput(inputScanner, "Ingrese el número de opción");

            if (userText.equals("5")) {
                break;
            }

            switch (userText) {
                case "1":
                    String doctorNombre = askInput(inputScanner, "Ingrese el nombre del Doctor");
                    String doctorEspecialidad = askInput(inputScanner, "Ingrese la especialidad nombre");
                    doctores.add(new Doctor(doctorNombre, doctorEspecialidad));
                    break;
                case "2":
                    String pacienteNombre = askInput(inputScanner, "Ingrese el nombre del Paciente");
                    pacientes.add(new Paciente(pacienteNombre));
                    break;
                case "3":
                    String citaFecha = askInput(inputScanner, "Ingrese la fecha");
                    String citaHora = askInput(inputScanner, "Ingrese la hora");
                    String citaMotivo = askInput(inputScanner, "Ingrese el motivo");
                    String citaPaciente = askInput(inputScanner, "Ingrese el ID del paciente");
                    String citaDoctor = askInput(inputScanner, "Ingrese el ID del doctor");
                    citas.add(new Cita(citaFecha, citaHora, citaMotivo, citaPaciente, citaDoctor));
                    break;
                case "4":
                    System.out.println("***** Listado de pacientes *****");
                    pacientes.forEach((n) -> n.getInfo());
                    System.out.println("***** Listado de doctores *****");
                    doctores.forEach((n) -> n.getInfo());
                    System.out.println("***** Listado de citas *****");
                    citas.forEach((n) -> n.getInfo());
                    break;
                default:
                    System.out.println("***** Opción inválida *****");
                    break;
            }
        }

        inputScanner.close();
    }
}
