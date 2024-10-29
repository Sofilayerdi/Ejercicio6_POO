public class Habitacion_ejecutiva implements Habitacion{
    private int tarifaBase;
    private int serviciosDesayuno;
    private int serviciosLavanderia;
    
    public Habitacion_ejecutiva(){
        this.tarifaBase = 250;
        this.serviciosComida = 50;
        this.serviciosVIP = 30;
    }

    
    public int getTarifaBase() {
        return tarifaBase;
    }

    public int getServiciosComida() {
        return serviciosComida;
    }

    public int getServiciosVIP() {
        return serviciosVIP;
    }

    @Override
    public int calcular_costo(int noches);{
        int costo_base = tarifaBase * noches;
        int serviviosC = serviciosComida * noches;

        int costo_total = costo_base + serviciosC + serviciosVIP;

        return costo_total;
    }
}