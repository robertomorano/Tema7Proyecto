package crud.interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import crud.dao.ProfesoresDao;
import crud.entidades.Profesores;

public class PrincipalProfesores {
	static Scanner sc = new Scanner(System.in);
	static ProfesoresDao pDao = new ProfesoresDao();

	public static void main(String[] args) {
		int opcion = 0;
		Profesores prof = null;
		ArrayList<Profesores> profesores = new ArrayList<>();

		if (pDao.getConexion() != null) {
			do {
				menu();
				opcion = sc.nextInt();
				sc.nextLine();
				switch (opcion) {
				case 1 -> {
					// Leer datos y crear objeto Profesor
					prof = crearProfesor();
					// Usar la funcion para insertarlo e nla base de datos
					pDao.create(prof);

				}
				case 2 -> {
					//Obtener la lista de profesores
					profesores = pDao.listProfesores();
					//Funcion para iterar los profesores y mostrarlos por pantalla
					iterarProfesores(profesores);
					System.out.println("--------------------------------------");
				}
				case 3 -> {
					//Obtener un profresor con un id determinado
					prof = pDao.selectProfesor(pedirId());
					System.out.println(prof);
					System.out.println("--------------------------------------");
				}
				case 4 -> {
					//Pedir el nuevo email al usuario
					String email = "";
					System.out.println("email del profesor");
					email = sc.nextLine();
					//Llamar a la funcion update para cambiar el email
					pDao.updateEmail(pedirId(), email);
				}
				case 5 -> {
					//Pedir el nuevo email al usuario
					String especialidad = "";
					System.out.println("especialidad del profesor");
					especialidad = sc.nextLine();
					//Llamar a la funcion update para cambiar la especialidad
					pDao.updateEspecialidad(pedirId(), especialidad);
				}
				case 6 -> {
					//Funcion para eliminar a un profesor
					pDao.delete(pedirId());
				}
				case 0 -> {
					System.out.println("Salir");
				}
				}

			} while (opcion != 0);
		}
		System.out.println("Cerrado");
	}

	static void menu() {
		System.out.println("1. Crear profesor.\r\n" + "2. Listar todos los profesores.\r\n"
				+ "3. Buscar profesor por id.\r\n" + "4. Modificar email.\r\n" + "5. Modificar especialidad \n"
				+ "6. Eliminar profesor.\r\n" + "0. Salir.\r\n" + "");
	}

	private static Profesores crearProfesor() {
		// Varuiables para guardar datos

		String nombre = "";
		String apellidos = "";
		String especialidad = "";
		String email = "";
		Profesores nuevo;

		// Pedir datos al usuario
		System.out.println("Nombre del profesor");
		nombre = sc.nextLine();
		System.out.println("Apellidos del profesor");
		apellidos = sc.nextLine();
		System.out.println("Especialidad del profesor");
		especialidad = sc.nextLine();
		System.out.println("email del profesor");
		email = sc.nextLine();

		// Crear objeto profesor
		nuevo = new Profesores(nombre, apellidos, especialidad, email);
		return nuevo;

	}

	private static int pedirId() {
		int id = 0;
		System.out.println("Id del profesor");
		id = sc.nextInt();
		return id;
	}

	private static void iterarProfesores(ArrayList<Profesores> profesores) {
		for (Profesores prof : profesores) {
			System.out.println(prof);
		}
	}

}
