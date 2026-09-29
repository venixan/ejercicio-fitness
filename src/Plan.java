public abstract class Plan implements Cobrable {
    protected String nombreCliente;
    protected String rut;
    protected int mesesInscritos;

    public Plan() {
    }

    public Plan(String nombreCliente, String rut, int mesesInscritos) {
        setNombreCliente(nombreCliente);
        setRut(rut);
        setMesesInscritos(mesesInscritos);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente == null || nombreCliente.isBlank()){
            throw new IllegalArgumentException("Error el nombre dle cliente no debe estar en blanco.");
        }
        this.nombreCliente = nombreCliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut == null || rut.isBlank()){
            throw new IllegalArgumentException("Error EL rut del usuario no debe estar en blanco.");
        }
        this.rut = rut;
    }

    public int getMesesInscritos() {
        return mesesInscritos;
    }

    public void setMesesInscritos(int mesesInscritos) {
        if (mesesInscritos <0 && mesesInscritos>24){
            throw new IllegalArgumentException("ERROR!! los meses inscritos deben estar entre 0 y 24 meses.");
        }
        this.mesesInscritos = mesesInscritos;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", rut='" + rut + '\'' +
                ", mesesInscritos=" + mesesInscritos +
                '}';
    }
}
