public class PlanPersonalizado extends Plan {
    private int horasEntrenador;
    private boolean incluyeNutricionista;

    public PlanPersonalizado() {
    }

    public PlanPersonalizado(String nombreCliente, String rut, int mesesInscritos, int horasEntrenador, boolean incluyeNutricionista) {
        super(nombreCliente, rut, mesesInscritos);
        setHorasEntrenador(horasEntrenador);
        setIncluyeNutricionista(incluyeNutricionista);
    }

    public int getHorasEntrenador() {
        return horasEntrenador;
    }

    public void setHorasEntrenador(int horasEntrenador) {
        if (horasEntrenador <0){
            throw new IllegalArgumentException("Error el entrenador debe ser mayor o igual a 0.");
        }
        this.horasEntrenador = horasEntrenador;
    }

    public boolean isIncluyeNutricionista() {
        return incluyeNutricionista;
    }

    public void setIncluyeNutricionista(boolean incluyeNutricionista) {
        this.incluyeNutricionista = incluyeNutricionista;
    }

    @Override
    public double calcularTarifaFinal() {
        int precioBase = 35000;
        double tarifaNormal = (precioBase* mesesInscritos);
        int entrenador = 10000 * horasEntrenador;
        double subtotal = tarifaNormal + entrenador;

        if (incluyeNutricionista){
            return subtotal + 15000;
        }else {
            return subtotal;
        }
    }
}
