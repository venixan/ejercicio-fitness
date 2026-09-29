//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    ArrayList<Plan> planes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    while(true){
        try {
            System.out.println("1. Registrar Plan Estudiante.");
            System.out.println("2. Registrar Plan Personalizado");
            System.out.println("3. Buscar por rut.");
            System.out.println("4. Lista de todos los planes e ingresos." );
            System.out.println("0. Salir.");
            int opc = Integer.parseInt(sc.nextLine());

            if (opc == 1){
                System.out.println("Ingrese Nombre del Estudiante: ");
                String nomClienteEstudiante = sc.nextLine();

                System.out.println("Ingrese Meses Inscrito: ");
                int mesesInscrito = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese Rut del Estudiante: ");
                String rut = sc.nextLine();

                System.out.println("¿Tiene certificado? (false / true)");
                boolean certificado = Boolean.parseBoolean(sc.nextLine());

                PlanEstudiante nuevoPlan = new PlanEstudiante(nomClienteEstudiante,rut,mesesInscrito,certificado);
                planes.add(nuevoPlan);

                System.out.println("Plan estudiante agregado con éxito!!");
            } else if (opc == 2) {
                System.out.println("Ingrese Nombre del Estudiante: ");
                String nomClienteEstudiante = sc.nextLine();

                System.out.println("Ingrese Meses Inscrito: ");
                int mesesInscrito = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese Rut del Estudiante: ");
                String rut = sc.nextLine();

                System.out.println("Ingrese Horas del entrenador: ");
                int horasEntrenador = Integer.parseInt(sc.nextLine());

                System.out.println("¿Incuye nutricionista?");
                boolean nutricionista = Boolean.parseBoolean(sc.nextLine());

                PlanPersonalizado nuevoPlan = new PlanPersonalizado(nomClienteEstudiante,rut,mesesInscrito,horasEntrenador,nutricionista);
                planes.add(nuevoPlan);
                System.out.println("Plan personalizado agregado correctamente!");

            } else if (opc == 3) {
                System.out.println("Buscar PLan por rut");
                System.out.println("Ingrese Rut a buscar: ");
                String rutBuscar = sc.nextLine();

                boolean encontrado = false;
                for (Plan p : planes){
                    if (p.getRut().equals(rutBuscar)){
                        System.out.println("PLan Encontrado con exitoo!");
                        System.out.println("Cliente: "+p.getNombreCliente());
                        System.out.println("Meses Inscritos" + p.getMesesInscritos());
                        System.out.println("Tarifa Final: $" + p.calcularTarifaFinal());
                        encontrado = true;
                        break;
                    }
                }

                if(!encontrado){
                    System.out.println("No se encontró ningún plan registrado con el rut: " + rutBuscar);
                }
            } else if (opc == 4) {
                System.out.println("Lista de todos los planes e ingresos.");

                if (planes.isEmpty()){ //is.Empty es cuando esta vacio, asi le muestro el mensaje de una
                    System.out.println("No hoay planes registrados en el sistema actual.");
                }else{
                    double totalIngresos = 0; //esta variable la creo fuera, ya que si lo creo dentro se reinicara automaticamente cada vez que se ingrese a esa opción

                    for(Plan p : planes){
                        double tarifaClientes = p.calcularTarifaFinal();
                        System.out.println("Cliente :" + p.getNombreCliente()+ "| Rut: " + p.getRut()+ "| Pago: $" + tarifaClientes);

                        totalIngresos = totalIngresos + tarifaClientes;
                    }
                }
            }else if (opc == 0){
                System.out.println("Hasta luego!");
                break;
            }else{
                System.out.println("ERROR debe ingresar un número del 0 al 4.");
            }

        }catch (Exception ex){
            System.out.println("Error, ingrese una opción válida");
            sc.nextLine(); //para que podamos limpiar el error sino queda en un bucle infinito.
        }
    }
}
