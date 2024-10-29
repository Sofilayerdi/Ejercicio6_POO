import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reservas{
    private String nombre;
    private String habitacion; 
    private int noches;
    private int personas;
    private int costoTotal;
    private Date fecha;

    public Reservas(String nombre, String habitacion, int noches, int personas, Date fecha, int costoTotal){
        this.nombre = nombre;
        this.habitacion = habitacion;
        this.noches = noches;
        this.personas = personas;
        this.fecha = fecha;
        this.costoTotal = costoTotal;
    }



    public String getNombre() {
        return nombre;
    }
    public String getHabitacion() {
        return habitacion;
    }
    public int getNoches() {
        return noches;
    }
    public int getPersonas() {
        return personas;
    }
    public int getCostoTotal() {
        return costoTotal;
    }
    public Date getFecha() {
        return fecha;
    }

    public ArrayList<Reservas> listaReservas(){
        String archivoCSV = "Reservas.csv";

        ArrayList<Reservas> reservas = new ArrayList<>();
        String linea;
        String separador = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(separador);
                String nombre = datos[0];
                String habitacion = datos[1];
                int noches = Integer.parseInt(datos[2]);
                int personas = Integer.parseInt(datos[3]);
                int costo_total = Integer.parseInt(datos[4]);
                String fecha = datos[5];

                Reservas reserva = new Reservas(nombre, habitacion, noches, personas, costo_total, fecha);
                reservas.add(reserva);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reservas;
    }

    public void GuardarReservass(List<Reservas> reserva) {
        String archivoCSV = "Reservas.csv";
        try (FileWriter writer = new FileWriter(archivoCSV)) {
            for (Reservas reserva : reservas) {
                writer.append(reserva.getNombre());
                writer.append(",");
                writer.append(reserva.getHabitacion());
                writer.append(",");
                writer.append(String.valueOf(reserva.getNoches()));
                writer.append(",");
                writer.append(String.valueOf(reserva.getPersonas()));
                writer.append(",");
                writer.append(String.valueOf(reserva.getCosto_total()));
                writer.append(",");
                writer.append(reserva.getFecha());
                writer.append("\n");
            }
        } catch (IOException e) {

        }
    }


}