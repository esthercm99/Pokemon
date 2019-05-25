package keyboard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Keyboard {
	/* A continuación se realizará las siguientes funciones de teclado:
	 * 		- Cerrar teclado.
	 * 		- Lectura de un carácter.
	 * 		- Lectura de una cadena.
	 * 		- Lectura de un boolean (ambas opciones, las funciones se llamarán igual):
	 * 			> Con mensajes pasados por parámetros, se introducirá 1 o 2.
	 * 			> Con un mensaje pasado por parámetro, se introducirá 's' o 'n'. 
	 * 		- Entrada de datos numéricos:
	 * 			. Lectura de un número cualquiera: Se podrá introduce valores positivos, 
	 * 			  negativos, enteros, decimales, y con cualquier rango-
	 * 				> Byte
	 * 				> Short
	 * 				> Int
	 * 				> Long
	 * 				> Float
	 * 				> Double
	 * 			· Lectura de un número que sea mayor / menor / igual.
	 * 			· Lectura de un número que debe estar entre un valor mínimo y máximo. */
	
//	Lo primero de todo antes de crear funciones de teclado hay que abrir el teclado para que funcione correctamente.
	static Scanner keyboard = new Scanner(System.in);
	
//	- Cerrar teclado: Se usará al finalizar el programa, cuando ya no se utilice más el teclado.
	public static void closeKeyboard() {
		keyboard.close();			// Se cierra el teclado para que no gaste recursos.	
	}
	
//	- Lectura de un carácter:
	/* 1. El usuario introducirá por teclado un carácter.
	 * 2. Mientras lo que ha introducido el usuario no sea un carácter, este le volverá a pedir de nuevo un carácter hasta que lo introduzca.*/
	public static char readCharacter() {
		String ch;
		boolean exit;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. El usuario introducirá por teclado un carácter.
		do {
			exit = true;				// Se reiniciará el valor a true por si falla al introducir un carácter.

			ch = readString();			// Se introducirá un carácter.
			
//			2. Mientras lo que ha introducido el usuario no sea un carácter, este le volverá a pedir de nuevo un carácter hasta que lo introduzca.
			if (ch.length() > 1) {		// Si la longitud de la cadena es mayor que uno entonces significa que no ha introducido un carácter.
				exit = false;			// No saldremos del bucle, es decir, al introducir mal el dato se le volverá a pedir.
				System.out.printf("%sError, introduce un carácter.%s%n", RED, RESET);
			}		
		} while (!exit);				// Si no ha fallado al introducir el dato, el valor exit quedará en true por lo que saldrá del bucle.
		
		return ch.charAt(0);
	}
	public static char readCharacter(String message) {			// Esta función servirá para mostrarle mensajes al usuario antes de introducir lo que se lo pide.
		String ch;
		boolean exit;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. El usuario introducirá por teclado un carácter.
		do {
			exit = true;					// Se reiniciará el valor a true por si falla al introducir un carácter.
			ch = readString(message);		// Se introducirá un carácter.
			
//			2. Mientras lo que ha introducido el usuario no sea un carácter, este le volverá a pedir de nuevo un carácter hasta que lo introduzca.
			if (ch.length() > 1) {		// Si la longitud de la cadena es mayor que uno entonces significa que no ha introducido un carácter.
				exit = false;			// No saldremos del bucle, es decir, al introducir mal el dato se le volverá a pedir.
				System.out.printf("%sError, introduce un carácter.%s%n", RED, RESET);
			}		
		} while (!exit);				// Si no ha fallado al introducir el dato, el valor exit quedará en true por lo que saldrá del bucle.
		
		return ch.charAt(0);
	}

//	- Lectura de una cadena.
	/* 1. El usuario introducirá por teclado una palabra / frase / carácter/es / número/s.
	 * 2. Mientras que el usuario no introduzca nada, se le volverá a pedir que introduzca una palabra / frase / carácter/es / número/s.*/
	public static String readString() {
		boolean exit;
		String str;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
		//	1. El usuario introducirá por teclado una palabra / frase / carácter/es / número/s.
		do {
			exit = true;						// Se reiniciará el valor a true por si falla al introducir una cadena.
			str = keyboard.nextLine();			// Se introducirá una cadena.
//			2. Mientras que el usuario no introduzca nada, se le volverá a pedir que introduzca una palabra / frase / carácter/es / número/s.
			if (str.isEmpty()) {
				exit = false;
				System.out.printf("%s%s%s%n", RED, "No has introducido nada", RESET);
			}
		} while (!exit);						// Si no ha fallado al introducir el dato, el valor exit quedará en true por lo que saldrá del bucle.
		 
		return str;
	}
	public static String readString(String message) {		// Esta función servirá para mostrarle mensajes al usuario antes de introducir lo que se lo pide.
		boolean exit;
		String str;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
			
//		1. El usuario introducirá por teclado una palabra / frase / carácter/es / número/s.
		do {
			exit = true;						// Se reiniciará el valor a true por si falla al introducir una cadena.
			System.out.print(message);
			str = keyboard.nextLine();			// Se introducirá una cadena.
//			2. Mientras que el usuario no introduzca nada, se le volverá a pedir que introduzca una palabra / frase / carácter/es / número/s.
			if (str.isEmpty()) {
				exit = false;
				System.out.printf("%s%s%s%n", RED, "No has introducido nada", RESET);
			}
		} while (!exit);						// Si no ha fallado al introducir el dato, el valor exit quedará en true por lo que saldrá del bucle.
		 
		return str;
	}
	
//	- Lectura de un boolean (ambas opciones, las funciones se llamarán igual):

//	> Con mensajes pasados por parámetros, se introducirá 1 o 2.
	/* 1. Se le muestra el mensaje con dos opciones.
	 * 2. El usuario deberá de introducir 1 o 2 para escoger una opción.
	 * 	 2.1. Mientras no se introduzca 1 o 2, se le vuelve a pedir.
	 * 3. Se le devolverá "true" si ha escogido la primera opción o "false" si ha escogido la segundo opción.*/
	public static boolean readBoolean(String message1, String message2, String message3) {
		boolean exit;
		byte option = 0;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. Se le muestra el mensaje con dos opciones.
		System.out.printf("%s%n\t1. %s%n\t2. %s", message1, message2, message3);
			
		do {
			exit = true;
//			2. El usuario deberá de introducir 1 o 2 para escoger una opción.
			System.out.printf("%nEscoge 1 o 2: ");
			exit = true;
			try {
				option = keyboard.nextByte();
			} catch (InputMismatchException e) {
		        System.out.printf("%sError, introduce un número entre 1 o 2%s%n", RED, RESET);		// Saldrá cuando no introduzca un número.
		        exit = false;
		        cleanBuffer();
			}
			
//			2.1. Mientras no se introduzca 1 o 2, se le vuelve a pedir.
			if (option != 1 && option != 2) {
				exit = false;
			}
		} while (!exit);
		
//		3. Se le devolverá "true" si ha escogido la primera opción o "false" si ha escogido la segundo opción.
		return option==1;
	}

//  > Con un mensaje pasado por parámetro, se introducirá 's' o 'n'. 
	/* 1. Se le muestra el mensaje.
	 * 2. El usuario deberá de introducir 's' o 'n' para decir "si" o "no".
	 * 	 2.1. Mientras no se introduzca 's' o 'n', se le vuelve a pedir.
	 * 3. Se le devolverá "true" si ha escogido 's' o "false" si ha escogido 'n'.*/
	public static boolean readBoolean(String message) {
		char option = 0;
		boolean exit, result;
		
		do {
			exit = true;
			
//			1. Se le muestra el mensaje.
			System.out.printf("%s (s/n):", message);			
//			2. El usuario deberá de introducir 's' o 'n' para decir "si" o "no".
			option = readCharacter();
			
//			2.1. Mientras no se introduzca 's' o 'n', se le vuelve a pedir.
			if (option != 's' && option != 'n' && option != 'S' && option != 'N') {
				exit = false;
			}
		} while (!exit);
		
//		3. Se le devolverá "true" si ha escogido la primera opción o "false" si ha escogido la segundo opción.
		if (option == 's' || option == 'S') {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

//	- Entrada de datos numéricos:
//	- Lectura de un número cualquiera: Se podrá introduce valores positivos, negativos, enteros, decimales, y con cualquier rango.	
	/* 1. Se le pide al usuario que introduzca un número.
	 * 	1.1. Mientras no introduzca un número o se salga del rango numérico, se le mostrará un mensaje de error hasta que lo introduzca un número.*/	
//	 > Byte: 	Nº Entero
	public static byte readByte() {
		boolean exit;
		byte number = 0;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		do {
			exit = true;
//			1. Se le pide al usuario que introduzca un número.
			try {
				number = keyboard.nextByte();
//			1.1. Mientras no introduzca un número o se salga del rango numérico, se le mostrará un mensaje de error hasta que lo introduzca un número.
			} catch (InputMismatchException e) {
		        System.out.printf("%sError, introduce un número entero entre -128 y 127%s%n", RED, RESET);
		        exit = false;
			} finally {
		        cleanBuffer();
			}
		} while (!exit);
		
		return number;
	}
//	 > Short: 	Nº Entero
	public static short readShort() {
		boolean exit;
		short number = 0;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";

		do {
			exit = true;
//			1. Se le pide al usuario que introduzca un número.
			try {
				number = keyboard.nextShort();
//			1.1. Mientras no introduzca un número o se salga del rango numérico, se le mostrará un mensaje de error hasta que lo introduzca un número.
			} catch (InputMismatchException e) {
		        System.out.printf("%sError, introduce un número entero entre -32.768 y 32.767%s%n", RED, RESET);
		        exit = false;
			} finally {
		        cleanBuffer();
			}
		} while (!exit);
		
		return number;
	}
//	 > Int: 	Nº Entero
	public static int readInt() {
		boolean exit;
		int number = 0;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
		do {
			exit = true;
//			1. Se le pide al usuario que introduzca un número.
			try {
				number = keyboard.nextInt();
//			1.1. Mientras no introduzca un número o se salga del rango numérico, se le mostrará un mensaje de error hasta que lo introduzca un número.
			} catch (InputMismatchException e) {
		        System.out.printf("%sError, introduce un número entero entre -2147483648 y 2147483647%s%n", RED, RESET);
		        exit = false;
			} finally {
		        cleanBuffer();
			}
		} while (!exit);
		
		return number;
	}
//	 > Long: 	Nº Entero
	public static long readLong() {
		boolean exit;
		long number = 0;		
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
		do {
			exit = true;
//			1. Se le pide al usuario que introduzca un número.
			try {
				number = keyboard.nextLong();
//			1.1. Mientras no introduzca un número o se salga del rango numérico, se le mostrará un mensaje de error hasta que lo introduzca un número.
			} catch (InputMismatchException e) {
		        System.out.printf("%sError, introduce un número entero entre -9 · 10¹⁸ y 9 · 10¹⁸%s%n", RED, RESET);
		        exit = false;
			} finally {
		        cleanBuffer();
			}
		} while (!exit);
		
		return number;
	}
//	 > Float: 	Nº Decimal
	public static float readFloat() {
		boolean exit;
		float number = 0;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";

		do {
			exit = true;
//			1. Se le pide al usuario que introduzca un número.
			try {
				number = keyboard.nextFloat();
//			1.1. Mientras no introduzca un número o se salga del rango numérico, se le mostrará un mensaje de error hasta que lo introduzca un número.
			} catch (InputMismatchException e) {
		        System.out.printf("%sError, introduce un número entre -3,4 · 10³⁸ y 3,4 · 10³⁸%s%n", RED, RESET);
		        exit = false;
			} finally {
		        cleanBuffer();
			}
		} while (!exit);
		
		return number;
	}
//	 > Double: 	Nº Decimal
	public static double readDouble() {
		boolean exit;
		double number = 0;
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
		do {
			exit = true;
//			1. Se le pide al usuario que introduzca un número.
			try {
				number = keyboard.nextDouble();
//			1.1. Mientras no introduzca un número o se salga del rango numérico, se le mostrará un mensaje de error hasta que lo introduzca un número.
			} catch (InputMismatchException e) {
		        System.out.printf("%sError, introduce un número entre -1,79 · 10³º⁸ y 1,79 · 10³º⁸%s%n", RED, RESET);
		        exit = false;
			} finally {
		        cleanBuffer();
			}
		} while (!exit);
		
		return number;
	}

//	- Lectura de un número que sea mayor / menor / igual.
	public static enum LimitType {
		GREATER, LESS, GREATER_EQUAL, LESS_EQUAL
	}
	/* IGUAL PARA TODOS LOS 6 TIPOS:
	 * 1. Se comprueba el tipo de comparación que se quiere hacer.
	 * 2. El usuario introduce un número.
	 * 3. Se comparará el número introducido con el rango.
	 * 	3.1. Si lo introduce correctamente se le devuelve el valor introducido.
	 * 	3.2. Si se sale del rango o sea de tipo EXCLUDED e introduzca el número rango se le vuelve a pedir.*/
	public static byte readLimit(byte number_range, LimitType typeComparation) {
		boolean exit;
		byte number = 0;
		String message = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
		do {
//			1. Se comprueba el tipo de comparación que se quiere hacer.
			switch(typeComparation) {	
				case GREATER:
//					2. El usuario introduce un número.					
					System.out.printf("Introduce un número mayor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readByte();
//					3. Se comparará el número introducido con el rango.
//					3.1. Si lo introduce correctamente se le devuelve el valor introducido.
					if (number > number_range) {
						exit = true;
//					3.2. Si se sale del rango o sea de tipo EXCLUDED e introduzca el número rango se le vuelve a pedir.
					} else {
						if (number == number_range) {
							message = "El número " + number + " no puede ser igual que el rango, sino mayor." ;
						} else {
							message = "El número " + number + " no es mayor que " + number_range;
						}
						exit = false;
					}
					break;
				case LESS:
//					2. El usuario introduce un número.
					System.out.printf("Introduce un número menor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readByte();
//					3. Se comparará el número introducido con el rango.
//					3.1. Si lo introduce correctamente se le devuelve el valor introducido.
					if (number < number_range) {
						exit = true;
//					3.2. Si se sale del rango o sea de tipo EXCLUDED e introduzca el número rango se le vuelve a pedir.
					} else {
						if (number == number_range) {
							message =  "El número " + number + " no puede ser igual que el rango, sino menor.";
						} else {
							message = "El número " + number + " no es menor que " + number_range;
						}
						exit = false;
					}
					break;
				case GREATER_EQUAL:
//					2. El usuario introduce un número.
					System.out.printf("Introduce un número mayor/igual de %d: ", number_range);
					number = readByte();
//					3. Se comparará el número introducido con el rango.
//					3.1. Si lo introduce correctamente se le devuelve el valor introducido.
					if (number >= number_range) {
						exit = true;
//					3.2. Si se sale del rango o sea de tipo EXCLUDED e introduzca el número rango se le vuelve a pedir.
					} else {
						message = "El número " + number + " no es mayor/igual que " + number_range;
						exit = false;
					}
					break;
				case LESS_EQUAL:
//					2. El usuario introduce un número.
					System.out.printf("Introduce un número menor/igual de %d: ", number_range);
					number = readByte();
//					3. Se comparará el número introducido con el rango.
					if (number <= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es menor/igual que " + number_range;
						exit = false;
					}
					break;
				default:
					message = "Error";
					exit = false;
					break;
			}
			
			if (!exit) {
				System.out.println(RED + message + RESET);
			}
		} while (!exit);
		
		return number;
	}
	public static short readLimit(short number_range, LimitType typeComparation) {
		boolean exit;
		short number = 0;
		String message = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
		do {
//			1. Se comprueba el tipo de comparación que se quiere hacer.
			switch(typeComparation) {
				case GREATER:
//					2. El usuario introduce un número.
					System.out.printf("Introduce un número mayor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readShort();
//					3. Se comparará el número introducido con el rango.
//					3.1. Si lo introduce correctamente se le devuelve el valor introducido.
					if (number > number_range)
						exit = true;
					else {
						if (number == number_range) {
							message = "El número " + number + " no puede ser igual que el rango, sino mayor." ;
						} else {
							message = "El número " + number + " no es mayor que " + number_range;
						}
						exit = false;
					}
					break;
				case LESS:
//					2. El usuario introduce un número.
					System.out.printf("Introduce un número menor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readShort();
//					3. Se comparará el número introducido con el rango.
					if (number < number_range)
						exit = true;
					else {
						if (number == number_range) {
							message =  "El número " + number + " no puede ser igual que el rango, sino menor.";
						} else {
							message = "El número " + number + " no es menor que " + number_range;
						}
						exit = false;
					}
					break;
				case GREATER_EQUAL:
//					2. El usuario introduce un número.
					System.out.printf("Introduce un número mayor/igual de %d: ", number_range);
					number = readShort();
//					3. Se comparará el número introducido con el rango.
					if (number >= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es mayor/igual que " + number_range;
						exit = false;
					}
					break;
				case LESS_EQUAL:
//					2. El usuario introduce un número.
					System.out.printf("Introduce un número menor/igual de %d: ", number_range);
					number = readShort();
//					3. Se comparará el número introducido con el rango.
					if (number <= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es menor/igual que " + number_range;
						exit = false;
					}
					break;
				default:
					message = "Error";
					exit = false;
					break;
			}
			
			if (!exit) {
				System.out.println(RED + message + RESET);
			}
		} while (!exit);
		
		return number;
	}
	public static int readLimit(int number_range, LimitType typeComparation) {
		boolean exit;
		int number = 0;
		String message = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		/* 1. Se comprueba el tipo de comparación que se quiere hacer.
		 * 2. El usuario introduce un número.
		 * 3. Se comparará el número introducido con el rango.*/
		do {
//			1. Se comprueba el tipo de comparación que se quiere hacer.
			switch(typeComparation) {
//			2. El usuario introduce un número.
			
//			3. Se comparará el número introducido con el rango.
				case GREATER:
					System.out.printf("Introduce un número mayor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readInt();
					
					if (number > number_range)
						exit = true;
					else {
						if (number == number_range) {
							message = "El número " + number + " no puede ser igual que el rango, sino mayor." ;
						} else {
							message = "El número " + number + " no es mayor que " + number_range;
						}
						exit = false;
					}
					break;
				case LESS:
					System.out.printf("Introduce un número menor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readInt();
					
					if (number < number_range)
						exit = true;
					else {
						if (number == number_range) {
							message =  "El número " + number + " no puede ser igual que el rango, sino menor.";
						} else {
							message = "El número " + number + " no es menor que " + number_range;
						}
						exit = false;
					}
					break;
				case GREATER_EQUAL:
					System.out.printf("Introduce un número mayor/igual de %d: ", number_range);
					number = readInt();
					
					if (number >= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es mayor/igual que " + number_range;
						exit = false;
					}
					break;
				case LESS_EQUAL:
					System.out.printf("Introduce un número menor/igual de %d: ", number_range);
					number = readInt();
					
					if (number <= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es menor/igual que " + number_range;
						exit = false;
					}
					break;
				default:
					message = "Error";
					exit = false;
					break;
			}
			
			if (!exit) {
				System.out.println(RED + message + RESET);
			}
		} while (!exit);
		
		return number;
	}
	public static long readLimit(long number_range, LimitType typeComparation) {
		boolean exit;
		int number = 0;
		String message = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		/* 1. Se comprueba el tipo de comparación que se quiere hacer.
		 * 2. El usuario introduce un número.
		 * 3. Se comparará el número introducido con el rango.*/
		do {
//			1. Se comprueba el tipo de comparación que se quiere hacer.
			switch(typeComparation) {
//			2. El usuario introduce un número.
			
//			3. Se comparará el número introducido con el rango.
				case GREATER:
					System.out.printf("Introduce un número mayor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readInt();
					
					if (number > number_range)
						exit = true;
					else {
						if (number == number_range) {
							message = "El número " + number + " no puede ser igual que el rango, sino mayor." ;
						} else {
							message = "El número " + number + " no es mayor que " + number_range;
						}
						exit = false;
					}
					break;
				case LESS:
					System.out.printf("Introduce un número menor de %1$d (no puede ser igual a %1$d): ", number_range);
					number = readInt();
					
					if (number < number_range)
						exit = true;
					else {
						if (number == number_range) {
							message =  "El número " + number + " no puede ser igual que el rango, sino menor.";
						} else {
							message = "El número " + number + " no es menor que " + number_range;
						}
						exit = false;
					}
					break;
				case GREATER_EQUAL:
					System.out.printf("Introduce un número mayor/igual de %d: ", number_range);
					number = readInt();
					
					if (number >= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es mayor/igual que " + number_range;
						exit = false;
					}
					break;
				case LESS_EQUAL:
					System.out.printf("Introduce un número menor/igual de %d: ", number_range);
					number = readInt();
					
					if (number <= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es menor/igual que " + number_range;
						exit = false;
					}
					break;
				default:
					message = "Error";
					exit = false;
					break;
			}
			
			if (!exit) {
				System.out.println(RED + message + RESET);
			}
		} while (!exit);
		
		return number;
	}
	public static double readLimit(double number_range, LimitType typeComparation) {
		boolean exit;
		double number = 0;
		String message = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		/* 1. Se comprueba el tipo de comparación que se quiere hacer.
		 * 2. El usuario introduce un número.
		 * 3. Se comparará el número introducido con el rango.*/
		do {
//			1. Se comprueba el tipo de comparación que se quiere hacer.
			switch(typeComparation) {
//			2. El usuario introduce un número.
			
//			3. Se comparará el número introducido con el rango.
				case GREATER:
					System.out.printf("Introduce un número mayor de %1$.2f (no puede ser igual a %1$.2f): ", number_range);
					number = readDouble();
					
					if (number > number_range)
						exit = true;
					else {
						if (number == number_range) {
							message = "El número " + number + " no puede ser igual que el rango, sino mayor." ;
						} else {
							message = "El número " + number + " no es mayor que " + number_range;
						}
						exit = false;
					}
					break;
				case LESS:
					System.out.printf("Introduce un número menor de %1$.2f (no puede ser igual a %1$.2f): ", number_range);
					number = readDouble();
					
					if (number < number_range)
						exit = true;
					else {
						if (number == number_range) {
							message =  "El número " + number + " no puede ser igual que el rango, sino menor.";
						} else {
							message = "El número " + number + " no es menor que " + number_range;
						}
						exit = false;
					}
					break;
				case GREATER_EQUAL:
					System.out.printf("Introduce un número mayor/igual de %.2f: ", number_range);
					number = readDouble();
					
					if (number >= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es mayor/igual que " + number_range;
						exit = false;
					}
					break;
				case LESS_EQUAL:
					System.out.printf("Introduce un número menor/igual de %.2f: ", number_range);
					number = readDouble();
					
					if (number <= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es menor/igual que " + number_range;
						exit = false;
					}
					break;
				default:
					message = "Error";
					exit = false;
					break;
			}
			
			if (!exit) {
				System.out.println(RED + message + RESET);
			}
		} while (!exit);
		
		return number;
	}
	public static float readLimit(float number_range, LimitType typeComparation) {
		boolean exit;
		float number = 0;
		String message = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		/* 1. Se comprueba el tipo de comparación que se quiere hacer.
		 * 2. El usuario introduce un número.
		 * 3. Se comparará el número introducido con el rango.*/
		do {
//			1. Se comprueba el tipo de comparación que se quiere hacer.
			switch(typeComparation) {
//			2. El usuario introduce un número.
//			3. Se comparará el número introducido con el rango.
				case GREATER:
					System.out.printf("Introduce un número mayor de %1$.2f (no puede ser igual a %1$.2f): ", number_range);
					number = readFloat();
					
					if (number > number_range)
						exit = true;
					else {
						if (number == number_range) {
							message = "El número " + number + " no puede ser igual que el rango, sino mayor." ;
						} else {
							message = "El número " + number + " no es mayor que " + number_range;
						}
						exit = false;
					}
					break;
				case LESS:
					System.out.printf("Introduce un número menor de %1$.2f (no puede ser igual a %1$.2f): ", number_range);
					number = readFloat();
					
					if (number < number_range)
						exit = true;
					else {
						if (number == number_range) {
							message =  "El número " + number + " no puede ser igual que el rango, sino menor.";
						} else {
							message = "El número " + number + " no es menor que " + number_range;
						}
						exit = false;
					}
					break;
				case GREATER_EQUAL:
					System.out.printf("Introduce un número mayor/igual de %.2f: ", number_range);
					number = readFloat();
					
					if (number >= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es mayor/igual que " + number_range;
						exit = false;
					}
					break;
				case LESS_EQUAL:
					System.out.printf("Introduce un número menor/igual de %.2f: ", number_range);
					number = readFloat();
					
					if (number <= number_range)
						exit = true;
					else {
						message = "El número " + number + " no es menor/igual que " + number_range;
						exit = false;
					}
					break;
				default:
					message = "Error";
					exit = false;
					break;
			}
			
			if (!exit) {
				System.out.println(RED + message + RESET);
			}
		} while (!exit);
		
		return number;
	}
	
//	- Lectura de un número que debe estar entre un valor mínimo y máximo.
	public static enum RangeType{
		BOTH_INCLUDED, BOTH_EXCLUDED, MININCLUDED_MAXEXCLUDED, MINEXCLUDED_MAXINCLUDED;
	}
	/* IGUAL PARA TODOS LOS 6 TIPOS:
	 * 1. Antes de empezar, se comprueba que el límite mínimo no es mayor que el límite máximo.
	 * 	1.1. Si es mayor el mínimo que el máximo se le informará con un mensaje de error y devolverá 0.
	 * 	1.2. Si los límites establecidos son correctos entonces se continúa con el programa.
	 * 2. El usuario introducirá un número.
	 * 	2.1. Si ese número se pasa del límite se le avisará y lo vovlerá a intentar hasta que lo introduzca correctamente.*/
	public static byte readRange(byte value_min, byte value_max, RangeType limit) {
		byte number = 0;
		boolean exit = true;
		String message = "Error. El número debe de estar entre", aux = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. Antes de empezar, se comprueba que el límite mínimo no es mayor que el límite máximo.
		try {
//			1.1. Si es mayor el mínimo que el máximo se le informará con un mensaje de error y devolverá 0.
			if (value_min >= value_max) {
				throw new IllegalArgumentException ("Error, no se puede introducir un número menor al valor máximo del mínimo");
//			1.2. Si los límites establecidos son correctos entonces se continúa con el programa.
			} else {
				do {
					System.out.printf("Introduce un número entre %d y %d: ", value_min, value_max);
//					2. El usuario introducirá un número.
					number = readByte();
					
//					2.1. Si ese número se pasa del límite se le avisará y lo vovlerá a intentar hasta que lo introduzca correctamente.
					switch(limit) {
						case BOTH_INCLUDED:
							if (number < value_min || number > value_max) {
								exit = false;
								aux = ", ambos incluidos.";
							}
							break;
						case BOTH_EXCLUDED:
							if (number <= value_min || number >= value_max) {
								exit = false;
								aux = ", ambos excluidos.";
							}				
							break;
						case MININCLUDED_MAXEXCLUDED:
							if (number < value_min || number >= value_max) {
								exit = false;
								aux = ", mínimo incluido y máximo excluido.";
							}
							break;
						case MINEXCLUDED_MAXINCLUDED:
							if (number <= value_min || number > value_max) {
								exit = false;
								aux = ", mínimo excluido y máximo incluido.";
							}	
							break;
					}
					
					if (!exit) {
						System.out.printf("%s%s %d y %d%s%s%n", RED, message, value_min, value_max, aux, RESET);
					}
					
				} while (!exit);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(RED + e.getMessage() + RESET);
		}
		
		return number;
	}
	public static short readRange(short value_min, short value_max, RangeType limit) {
		short number = 0;
		boolean exit = true;
		String message = "Error. El número debe de estar entre", aux = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. Antes de empezar, se comprueba que el límite mínimo no es mayor que el límite máximo.
		try {
//			1.1. Si es mayor el mínimo que el máximo se le informará con un mensaje de error y devolverá 0.
			if (value_min >= value_max) {
				throw new IllegalArgumentException ("Error, no se puede introducir un número menor al valor máximo del mínimo");
//			1.2. Si los límites establecidos son correctos entonces se continúa con el programa.
			} else {
				do {				
					exit = true;
					System.out.printf("Introduce un número entre %d y %d: ", value_min, value_max);
//					2. El usuario introducirá un número.
					number = readShort();
					
//					2.1. Si ese número se pasa del límite se le avisará y lo vovlerá a intentar hasta que lo introduzca correctamente.
					switch(limit) {
						case BOTH_INCLUDED:
							if (number < value_min || number > value_max) {
								exit = false;
								aux = ", ambos incluidos.";
							}
							break;
						case BOTH_EXCLUDED:
							if (number <= value_min || number >= value_max) {
								exit = false;
								aux = ", ambos excluidos.";
							}				
							break;
						case MININCLUDED_MAXEXCLUDED:
							if (number < value_min || number >= value_max) {
								exit = false;
								aux = ", mínimo incluido y máximo excluido.";
							}
							break;
						case MINEXCLUDED_MAXINCLUDED:
							if (number <= value_min || number > value_max) {
								exit = false;
								aux = ", mínimo excluido y máximo incluido.";
							}	
							break;
					}
					
					if (!exit) {
						System.out.printf("%s%s %d y %d%s%s%n", RED, message, value_min, value_max, aux, RESET);
					}
					
				} while (!exit);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(RED + e.getMessage() + RESET);
		}
		
		return number;
	}
	public static int readRange(int value_min, int value_max, RangeType limit) {
		int number = 0;
		boolean exit = true;
		String message = "Error. El número debe de estar entre", aux = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. Antes de empezar, se comprueba que el límite mínimo no es mayor que el límite máximo.
		try {
//			1.1. Si es mayor el mínimo que el máximo se le informará con un mensaje de error y devolverá 0.
			if (value_min >= value_max) {
				throw new IllegalArgumentException ("Error, no se puede introducir un número menor al valor máximo del mínimo");
//			1.2. Si los límites establecidos son correctos entonces se continúa con el programa.
			} else {
				do {				
					exit = true;
					System.out.printf("Introduce un número entre %d y %d: ", value_min, value_max);
//					2. El usuario introducirá un número.
					number = readInt();
					
//					2.1. Si ese número se pasa del límite se le avisará y lo vovlerá a intentar hasta que lo introduzca correctamente.
					switch(limit) {
						case BOTH_INCLUDED:
							if (number < value_min || number > value_max) {
								exit = false;
								aux = ", ambos incluidos.";
							}
							break;
						case BOTH_EXCLUDED:
							if (number <= value_min || number >= value_max) {
								exit = false;
								aux = ", ambos excluidos.";
							}				
							break;
						case MININCLUDED_MAXEXCLUDED:
							if (number < value_min || number >= value_max) {
								exit = false;
								aux = ", mínimo incluido y máximo excluido.";
							}
							break;
						case MINEXCLUDED_MAXINCLUDED:
							if (number <= value_min || number > value_max) {
								exit = false;
								aux = ", mínimo excluido y máximo incluido.";
							}	
							break;
					}
					
					if (!exit) {
						System.out.printf("%s%s %d y %d%s%s%n", RED, message, value_min, value_max, aux, RESET);
					}
					
				} while (!exit);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(RED + e.getMessage() + RESET);
		}
		
		return number;
	}
	public static long readRange(long value_min, long value_max, RangeType limit) {
		long number = 0;
		boolean exit = true;
		String message = "Error. El número debe de estar entre", aux = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. Antes de empezar, se comprueba que el límite mínimo no es mayor que el límite máximo.
		try {
//			1.1. Si es mayor el mínimo que el máximo se le informará con un mensaje de error y devolverá 0.
			if (value_min >= value_max) {
				throw new IllegalArgumentException ("Error, no se puede introducir un número menor al valor máximo del mínimo");
//			1.2. Si los límites establecidos son correctos entonces se continúa con el programa.
			} else {
				do {				
					exit = true;
					System.out.printf("Introduce un número entre %d y %d: ", value_min, value_max);
//					2. El usuario introducirá un número.
					number = readLong();
					
//					2.1. Si ese número se pasa del límite se le avisará y lo vovlerá a intentar hasta que lo introduzca correctamente.
					switch(limit) {
						case BOTH_INCLUDED:
							if (number < value_min || number > value_max) {
								exit = false;
								aux = ", ambos incluidos.";
							}
							break;
						case BOTH_EXCLUDED:
							if (number <= value_min || number >= value_max) {
								exit = false;
								aux = ", ambos excluidos.";
							}				
							break;
						case MININCLUDED_MAXEXCLUDED:
							if (number < value_min || number >= value_max) {
								exit = false;
								aux = ", mínimo incluido y máximo excluido.";
							}
							break;
						case MINEXCLUDED_MAXINCLUDED:
							if (number <= value_min || number > value_max) {
								exit = false;
								aux = ", mínimo excluido y máximo incluido.";
							}	
							break;
					}
					
					if (!exit) {
						System.out.printf("%s%s %d y %d%s%s%n", RED, message, value_min, value_max, aux, RESET);
					}
					
				} while (!exit);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(RED + e.getMessage() + RESET);
		}
		
		return number;
	}
	public static float readRange(float value_min, float value_max, RangeType limit) {
		float number = 0;
		boolean exit = true;
		String message = "Error. El número debe de estar entre", aux = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. Antes de empezar, se comprueba que el límite mínimo no es mayor que el límite máximo.
		try {
//			1.1. Si es mayor el mínimo que el máximo se le informará con un mensaje de error y devolverá 0.
			if (value_min >= value_max) {
				throw new IllegalArgumentException ("Error, no se puede introducir un número menor al valor máximo del mínimo");
//			1.2. Si los límites establecidos son correctos entonces se continúa con el programa.
			} else {
				do {				
					exit = true;
//					2. El usuario introducirá un número.
					number = readFloat();
					
//					2.1. Si ese número se pasa del límite se le avisará y lo vovlerá a intentar hasta que lo introduzca correctamente.
					switch(limit) {
						case BOTH_INCLUDED:
							if (number < value_min || number > value_max) {
								exit = false;
								aux = ", ambos incluidos.";
							}
							break;
						case BOTH_EXCLUDED:
							if (number <= value_min || number >= value_max) {
								exit = false;
								aux = ", ambos excluidos.";
							}				
							break;
						case MININCLUDED_MAXEXCLUDED:
							if (number < value_min || number >= value_max) {
								exit = false;
								aux = ", mínimo incluido y máximo excluido.";
							}
							break;
						case MINEXCLUDED_MAXINCLUDED:
							if (number <= value_min || number > value_max) {
								exit = false;
								aux = ", mínimo excluido y máximo incluido.";
							}	
							break;
					}
					
					if (!exit) {
						System.out.printf("%s%s %d y %d%s%s%n", RED, message, value_min, value_max, aux, RESET);
					}
					
				} while (!exit);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(RED + e.getMessage() + RESET);
		}
		
		return number;
	}
	public static double readRange(double value_min, double value_max, RangeType limit) {
		double number = 0;
		boolean exit = true;
		String message = "Error. El número debe de estar entre", aux = "";
		final String RED = "\u001B[31m", RESET = "\u001B[0m";
		
//		1. Antes de empezar, se comprueba que el límite mínimo no es mayor que el límite máximo.
		try {
//			1.1. Si es mayor el mínimo que el máximo se le informará con un mensaje de error y devolverá 0.
			if (value_min >= value_max) {
				throw new IllegalArgumentException ("Error, no se puede introducir un número menor al valor máximo del mínimo");
//			1.2. Si los límites establecidos son correctos entonces se continúa con el programa.
			} else {
				do {				
					exit = true;
//					2. El usuario introducirá un número.
					number = readDouble();
					
//					2.1. Si ese número se pasa del límite se le avisará y lo vovlerá a intentar hasta que lo introduzca correctamente.
					switch(limit) {
						case BOTH_INCLUDED:
							if (number < value_min || number > value_max) {
								exit = false;
								aux = ", ambos incluidos.";
							}
							break;
						case BOTH_EXCLUDED:
							if (number <= value_min || number >= value_max) {
								exit = false;
								aux = ", ambos excluidos.";
							}				
							break;
						case MININCLUDED_MAXEXCLUDED:
							if (number < value_min || number >= value_max) {
								exit = false;
								aux = ", mínimo incluido y máximo excluido.";
							}
							break;
						case MINEXCLUDED_MAXINCLUDED:
							if (number <= value_min || number > value_max) {
								exit = false;
								aux = ", mínimo excluido y máximo incluido.";
							}	
							break;
					}
					
					if (!exit) {
						System.out.printf("%s%s %d y %d%s%s%n", RED, message, value_min, value_max, aux, RESET);
					}
					
				} while (!exit);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(RED + e.getMessage() + RESET);
		}
		
		return number;
	}
	
	// Función extra, limpar buffer.
	public static void cleanBuffer(){
		keyboard.nextLine();	// Limpia la basura digital que queda del teclado.
	}	
}