public class Veterinaria {

    String mascota;
    String categoria;
    double kilos;
    int anios;

    public Veterinaria(String mascota, String categoria, double kilos, int anios) {
        this.mascota = mascota;
        this.categoria = categoria;
        this.kilos = kilos;
        this.anios = anios;
    }

    public int obtenerTarifa() {
        int costo;

        if (kilos > 25) {
            costo = 55000;
        } else if (kilos > 10) {
            costo = 45000;
        } else {
            costo = 35000;
        }

        return costo + (anios >= 8 ? 12000 : 0);
    }

    public String mostrarDatos() {
        return String.format(
            "%s (%s, %.1f kg, %d años)",
            mascota, categoria, kilos, anios
        );
    }

    public boolean cambiarPeso(double nuevoPeso) {
        if (nuevoPeso <= 0) {
            System.out.println("El peso debe ser mayor que cero.");
            return false;
        }

        kilos = nuevoPeso;
        return true;
    }

    public boolean cambiarEdad(int nuevaEdad) {
        if (nuevaEdad < 0) {
            System.out.println("La edad no puede ser negativa.");
            return false;
        }

        anios = nuevaEdad;
        return true;
    }

    public static void main(String[] args) {

        Veterinaria[] registro = new Veterinaria[4];

        registro[0] = new Veterinaria("Luna", "perro", 28.5, 9);
        registro[1] = new Veterinaria("Michi", "Gato", 4.2, 3);
        registro[2] = new Veterinaria("Rocky", "Perro", 12.0, 5);
        registro[3] = new Veterinaria("Pepa", "Conejo", 2.1, 1);

        int recaudo = 0;

        for (Veterinaria ficha : registro) {
            int precio = ficha.obtenerTarifa();

            System.out.println(
                ficha.mostrarDatos() + " - Consulta: $" + precio
            );

            recaudo += precio;
        }

        System.out.println("RECAUDACION TOTAL: $" + recaudo);

        System.out.println("\nPrueba de validacion para Michi:");
        registro[1].cambiarPeso(-3);
        System.out.println(registro[1].mostrarDatos());
    }
}
