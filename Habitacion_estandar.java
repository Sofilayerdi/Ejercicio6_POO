public class Habitacion_estandar implements Habitacion{
    private int tarifaBase;

    
    public Habitacion_estandar(){
        this.tarifaBase = 30;
    }
    
    public int getTarifaBase() {
        return tarifaBase;
    }

    @Override
    public int calcular_costo(int noches, int personas){
        int costo_base = (tarifaBase * noches);
        int costo_total = (costo_base);
    
        return costo_total;
    }
}