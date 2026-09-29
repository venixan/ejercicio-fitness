public class PlanEstudiante extends Plan {
    private boolean tieneCertificado;

    public PlanEstudiante() {
    }

    public PlanEstudiante(String nombreCliente, String rut, int mesesInscritos, boolean tieneCertificado) {
        super(nombreCliente, rut, mesesInscritos);
       setTieneCertificado(tieneCertificado);
    }

    public boolean isTieneCertificado() {
        return tieneCertificado;
    }

    public void setTieneCertificado(boolean tieneCertificado) {
        this.tieneCertificado = tieneCertificado;
    }

    @Override
    public double calcularTarifaFinal() {
        int precioBase = 25000;
        double tarifaNormal = mesesInscritos * precioBase;
        if (tieneCertificado){
            return tarifaNormal - (tarifaNormal*0.15);
        }else {
            return tarifaNormal;
        }
    }
}
