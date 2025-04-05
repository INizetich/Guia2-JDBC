package org.Nize.Utilities;

public class Utilities {



    public static void mostrarCargando() {
        try {
            for (int i = 0; i < 5; i++) {  // 5 ciclos de la animación
                // Primera etapa: .
                System.out.print("Cerrando sesión: .  \r");
                Thread.sleep(250);

                // Segunda etapa: ..
                System.out.print("Cerrando sesión: .. \r");
                Thread.sleep(250);

                // Tercera etapa: ...
                System.out.print("Cerrando sesión: ...\r");
                Thread.sleep(250);

                // "Borrar" los puntos (volver a 0)
                System.out.print("Cerrando sesión:    \r");
                Thread.sleep(250);
            }
            // Limpiar la línea al final
            System.out.print("Cierre de sesión: completado.   \n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void limpiarPantalla() {
        // Imprime 50 líneas vacías para simular la limpieza de pantalla
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
