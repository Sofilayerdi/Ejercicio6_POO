public class Suite_presidencial implements Habitacion{
    private int tarifaBase;
    private int serviciosComida;
    private int serviciosVIP;
    
    public Suite_presidencial(){
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
    public int calcular_costo(int noches, int personas){
        int costo_base = (tarifaBase * noches);
        int serviciosC = (serviciosComida * noches);

        int costo_total = (costo_base + serviciosC + serviciosVIP);

        return costo_total;
    }
}