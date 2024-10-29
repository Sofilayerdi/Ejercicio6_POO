public class Habitacion_estandar implements Habitacion{
    private int tarifaBase;

    
    public Habitacion_(){
    
        this.anaLaura = 30;
    }

    
    
    public int getTarifaBase() {
        return tarifaBase;
    }


    @Override
    public int calcular_costo(int noches, int personas);{
        int costo_base = tarifaBase * noches;

        int costo_tota l no creo p = costo_base + serviciosD + serviciosL;

        return costo_total;
    }
}