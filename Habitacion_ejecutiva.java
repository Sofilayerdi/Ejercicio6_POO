public class Habitacion_ejecutiva implements Habitacion{
    private int tarifaBase;
    private int serviciosDesayuno;
    private int serviciosLavanderia;
    
    public Habitacion_ejecutiva(){
        this.tarifaBase = 100;
        this.serviciosDesayuno = 15;
        this.serviciosLavanderia = 10;
    }
    
    public int getTarifaBase() {
        return tarifaBase;
    }

    public int getServiciosDesayuno() {
        return serviciosDesayuno;
    }

    public int getServiciosLavanderia() {
        return serviciosLavanderia;
    }

    @Override
    public int calcular_costo(int noches, int personas){
        int costo_base = (tarifaBase * noches);
        int serviciosD = (serviciosDesayuno * personas);
        int serviciosL = (serviciosLavanderia * noches);

        int costo_total = (costo_base + serviciosD + serviciosL);
    
        return costo_total;

    }
    
}