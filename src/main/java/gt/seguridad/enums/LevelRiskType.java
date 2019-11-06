package gt.seguridad.enums;

public enum LevelRiskType {
	
	CRITICO(4),
	ALTO(3),
	MEDIO(2),
	BAJO(1);
	
	
	private final Integer level;
	private LevelRiskType(Integer level) {
		this.level = level;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public static String find(Integer level) {
		for(LevelRiskType value: LevelRiskType.values()) {
			if(value.getLevel().equals(level)) {
				String nombre = value.name().toLowerCase();
				nombre = Character.toUpperCase(nombre.charAt(0)) + nombre.substring(1);
				return nombre;
			}
		}
		return null;
	}
	
	public static LevelRiskType findById(Integer level) {
		for(LevelRiskType value: LevelRiskType.values()) {
			if(value.getLevel().equals(level)) {
				return value;
			}
		}
		return null;
	}
	
	
	public static LevelRiskType find(String level) {
		for(LevelRiskType value: LevelRiskType.values()) {
			if(value.name().equalsIgnoreCase(level)) {
				return value;
			}
		}
		return null;
	}
}
