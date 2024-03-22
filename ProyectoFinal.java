import java.util.ArrayList;
//import java.util.Arrays
import java.util.List;
import java.util.Scanner;


public class ProyectoFinal {

//Objeto para leer datos por teclado
    public static Scanner leerDatoTeclado = new Scanner(System.in); 

//Declaración de las constantes que representan la posición en el array de un usuario
    public static final byte TIPO_DOCUMENTO_USUARIO = 0;
    public static final byte NUMERO_IDENTIFICACION_USUARIO = 1;
    public static final byte NOMBRES_USUARIO = 2;
    public static final byte APELLIDOS_USUARIO = 3;
    public static final byte CORREO_ELECTRONICO_USUARIO = 4;
    public static final byte DIRECCION_USUARIO = 5;
    public static final byte CIUDAD_USUARIO = 6;
    public static final byte TELEFONO_USUARIO = 7;
    public static final byte CONTRASENA = 8;

    //Lista que guardará los arrays de datos de los usuarios
    public static List<String[]> registro_usuarios = new ArrayList<>();
    //Array para ingresar los datos de los usuarios
    public static String[] usuario = new String[10];

//Método para mostrar el menú principal
    public static void mostrarMenuLoginRegistro(){
        boolean bool = true;
        int Oportunidad = 0;

        while(bool){

        System.out.println("\n Bienvenido a MyHotel...\n Mas que un lugar para descansar.");
        System.out.println("------------------------------------------------------------");

        System.out.println("Ingrese una opcion deseada\n1. Registrarse como cliente\n2. Iniciar Sesion\n3. Salir");

        int opcion = leerDatoTeclado.nextInt(); //Obtengo el valor desde consola

        switch (opcion) {
            case 1:
                System.out.println("Registrarse");
                solicitarDatosDeRegistro();
                break;

            case 2:
                System.out.println("Iniciar Sesion");
                
                while(Oportunidad < 3){
                    System.out.println("Ingrese su correo electrónico:");
                    String CorreoElectronico = leerDatoTeclado.next();
                    System.out.println("Ingrese su contraseña:");
                    String Contrasena = leerDatoTeclado.next();

                    boolean Resultado = iniciarSesionUsuario(CorreoElectronico, Contrasena);

                    if(Resultado){
                        System.out.println("Usuario logueado correctamente.");
                        break;
                    }else{
                        System.out.println("Usuario incorrecto. Intente una vez más.");
                        Oportunidad++;
                        if(Oportunidad == 3){
                            Oportunidad = 0;
                            System.out.println("No cuenta con más oportunidades");
                            break;
                        }
                    }
                }
                break;

            case 3:
                System.out.println("¡Hasta pronto!");
                System.exit(0);
                break;
        
            default: System.out.println("Opcion invalida, fin del proceso");
            bool  = false;
                break;
            }
        }
    }

    //Métodos para el registro del usuario

    public static void solicitarDatosDeRegistro(){
   
        boolean bool;

        System.out.println("---------------------------------------------");
        System.out.println("Formulario de registro");
        System.out.println("Para completar el registro, por favor");
        System.out.println("facilitar la siguiente informacion:");
        System.out.println("---------------------------------------------");

        System.out.println("Tipo de identificacion");
        String TipoIdentificacion;
        do{
            TipoIdentificacion = leerDatoTeclado.nextLine();
        }while(TipoIdentificacion.isBlank());

        System.out.println("Numero de identificacion");
        String NumIdentificacion;
        do{
        NumIdentificacion = leerDatoTeclado.next();
        }while(NumIdentificacion.isBlank());

        System.out.println("Nombres");
        String Nombres;
        do{
        Nombres = leerDatoTeclado.nextLine();
        }while(Nombres.isBlank());

        System.out.println("Apellidos");
        String Apellidos;
        do{
        Apellidos = leerDatoTeclado.nextLine();
        }while(Apellidos.isBlank());

        System.out.println("Correo electronico");
        String CorreoElectronico;
        do{
        CorreoElectronico = leerDatoTeclado.next();
        }while(CorreoElectronico.isBlank());

        System.out.println("Direccion de residencia");
        String Direccion;
        do{
        Direccion = leerDatoTeclado.nextLine();
        }while(Direccion.isBlank());

        System.out.println("Ciudad de residencia");
        String Ciudad;
        do{
        Ciudad = leerDatoTeclado.nextLine();
        }while(Ciudad.isBlank());

        System.out.println("Telefono de contacto");
        String Telefono;
        do{
        Telefono = leerDatoTeclado.next();
        }while(Telefono.isBlank());


        String Contrasena;
        String ConfirmacionContrasena;
        do{
        System.out.println("Contraseña");
        Contrasena = leerDatoTeclado.next();
        System.out.println("Confirmar Contraseña");
        ConfirmacionContrasena = leerDatoTeclado.next();
        bool = Contrasena.equals(ConfirmacionContrasena);

        if(!bool){
            System.out.println("Las contraseñas no coinciden, vuelva a ingresar la contraseña y su confirmación");
        }

        }while(!bool);

        

        registrarUsuario(TipoIdentificacion, NumIdentificacion, Nombres, Apellidos, CorreoElectronico, Direccion, Telefono, Contrasena, Ciudad);
    }

    public static void registrarUsuario(String TipoIdentificacion, String NumIdentificacion, String Nombres, String Apellidos, String CorreoElectronico, String Direccion, String Telefono, String Contrasena, String Ciudad){
        

        usuario[TIPO_DOCUMENTO_USUARIO] = TipoIdentificacion;
        usuario[NUMERO_IDENTIFICACION_USUARIO] = NumIdentificacion;
        usuario[NOMBRES_USUARIO] = Nombres;
        usuario[APELLIDOS_USUARIO] = Apellidos;
        usuario[CORREO_ELECTRONICO_USUARIO] = CorreoElectronico;
        usuario[DIRECCION_USUARIO] = Direccion;
        usuario[CIUDAD_USUARIO] = Ciudad;
        usuario[TELEFONO_USUARIO] = Telefono;
        usuario[CONTRASENA] = Contrasena;

        registro_usuarios.add(usuario);
    }


//Métodos para el inicio de sesión de un usuario

    public static boolean iniciarSesionUsuario(String CorreoElectronico, String Contrasena){
        
        boolean bandera = false;
        //Recorrido de la lista de usuarios
        for(int i = 0; i < registro_usuarios.size(); i++){{
            if(CorreoElectronico.equals(usuario[CORREO_ELECTRONICO_USUARIO]) && Contrasena.equals(usuario[CONTRASENA])){
                bandera = true;
            }
        }}
        
        return bandera;
    }

//Método Principal
    public static void main(String[] args){

        mostrarMenuLoginRegistro();

        //Se libera memoria
        leerDatoTeclado.close();
    }

}
