package gt.seguridad.enums;

public enum DashboardType {
	
	TIPO_RIESGO(1),
	TIPO_IMPACTO(2),
	TIPO_BRECHA(3),
	TIPO_TRATAMIENTO(4);
	
	private final Integer tipo;
	private DashboardType(Integer tipo) {
		this.tipo = tipo;
	}
	
	public Integer getTipo() {
		return tipo;
	}
	
	public static DashboardType find(Integer tipo) {
		for(DashboardType value: DashboardType.values()) {
			if(value.getTipo().equals(tipo)) {
				return value;
			}
		}
			
		return null;
	}
	
	
	

}
