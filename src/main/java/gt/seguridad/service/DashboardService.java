package gt.seguridad.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.seguridad.enums.DashboardType;
import gt.seguridad.enums.LevelRiskType;
import gt.seguridad.pojo.Dashboard;
import gt.seguridad.pojo.DashboardMapa;
import gt.seguridad.pojo.Data;
import gt.seguridad.pojo.Evaluacion;
import gt.seguridad.pojo.MapaRiesgo;
import gt.seguridad.repository.riesgo.ClasificacionRiesgoRepository;
import gt.seguridad.repository.riesgo.EvaluacionRiesgoRepository;
import gt.seguridad.service.impl.IDashboardService;
import gt.seguridad.utils.ChartType;

@Service
public class DashboardService implements IDashboardService {
	
	@Autowired
	private EvaluacionRiesgoRepository evaluacionRiesgoRepository;
	@Autowired
	private ClasificacionRiesgoRepository clasificacionRiesgoRepository;

	@Override
	public List<Data> getInfoDashboard(Integer selectedType) {
		try {
			switch (DashboardType.find(selectedType)) {
			case TIPO_RIESGO:
				return evaluacionRiesgoRepository.getInfoDashboardRiesgo();
			case TIPO_IMPACTO:
				return evaluacionRiesgoRepository.getInfoDashboardImpacto();
			case TIPO_BRECHA:
				return evaluacionRiesgoRepository.getInfoDashboardBrecha();
			case TIPO_TRATAMIENTO:
				return evaluacionRiesgoRepository.getInfoDashboardTratamiento();
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}
	
	@Override
	public List<MapaRiesgo> getInfoDashBoardMapa(String arquitectura) {
		try {
			return clasificacionRiesgoRepository.getDataMapa(arquitectura);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	@Override
	public Dashboard generateDashboard(Integer selectedType) {
		Dashboard dashboard = new Dashboard();
		try {
			List<Data> data = getInfoDashboard(selectedType);
			List<Evaluacion> evaluaciones = new ArrayList<>();
			Evaluacion evaluacion = new Evaluacion();
			
			Integer total = 0;
			Integer totalCritico = 0;
			Integer totalAlto = 0;
			Integer totalMedio = 0;
			Integer totalBajo = 0;
			
			Integer critico = 0;
			Integer alto = 0;
			Integer medio = 0;
			Integer bajo = 0;
			Integer totalEvaluacion = 0;
			
			for(Data value: data) {
				totalCritico = totalCritico + value.getTotalCritico();
				totalAlto = totalAlto + value.getTotalAlto();
				totalMedio = totalMedio + value.getTotalMedio();
				totalBajo = totalBajo + value.getTotalBajo();
				
				switch (LevelRiskType.find(value.getNivelRiesgo())) {
				case CRITICO:
					critico++;
					break;
				case ALTO:
					alto++;
					break;
				case MEDIO:
					medio++;
					break;
				case BAJO:
					bajo++;
					break;

				default:
					break;
				}
			}
			
			totalEvaluacion = critico + alto + medio + bajo;
			total = totalCritico + totalAlto + totalBajo + totalMedio;
			
			
			if(totalEvaluacion != 0) {
				evaluaciones.add(new Evaluacion("Critico", critico, Double.valueOf((critico * 100) / totalEvaluacion)));
				evaluaciones.add(new Evaluacion("Alto", alto, Double.valueOf((alto * 100) / totalEvaluacion)));
				evaluaciones.add(new Evaluacion("Medio", medio, Double.valueOf((medio * 100) / totalEvaluacion)));
				evaluaciones.add(new Evaluacion("Bajo", bajo, Double.valueOf((bajo * 100) / totalEvaluacion)));
			}
			
			evaluacion = evaluaciones.stream().max(Comparator.comparing(Evaluacion::getTotal)).get();
					
			
			dashboard.setPieChart(ChartType.getPie(title(selectedType), evaluaciones, evaluacion));
			dashboard.setLineChart(ChartType.getLine(title2(selectedType), evaluaciones, data));
			dashboard.setResultado(evaluacion.getNivelRiesgo());
			dashboard.setEvaluacion(evaluaciones);
			dashboard.setData(data);
			dashboard.setTotal(total);
			dashboard.setPorcentajeTotal(Double.valueOf(100.00));
			dashboard.setTotalCritico(totalCritico);
			dashboard.setTotalAlto(totalAlto);
			dashboard.setTotalMedio(totalMedio);
			dashboard.setTotalBajo(totalBajo);
			dashboard.setTotalPorcentajeCritico(Double.valueOf((totalCritico * 100) / total));
			dashboard.setTotalPorcentajeAlto(Double.valueOf((totalAlto * 100) / total));
			dashboard.setTotalPorcentajeMedio(Double.valueOf((totalMedio * 100) / total));
			dashboard.setTotalPorcentajeBajo(Double.valueOf((totalBajo * 100) / total));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dashboard;
	}
	
	private String title(Integer selectedType) {
		String title = "";
		switch (DashboardType.find(selectedType)) {
		case TIPO_RIESGO:
			title = "Grafica por Tipo de Riesgo";
			break;
		case TIPO_BRECHA:
			title = "Grafica por Tipo de Brecha";
			break;
		case TIPO_IMPACTO:
			title = "Grafica por Tipo de Impacto";
			break;
		case TIPO_TRATAMIENTO:
			title = "Grafica por Tipo de Tratamiento";
			break;
		default:
			break;
		}
		return title;
	}
	
	private String title2(Integer selectedType) {
		String title = "";
		switch (DashboardType.find(selectedType)) {
		case TIPO_RIESGO:
			title = "Cantidad de riesgos por Tipo de Riesgo";
			break;
		case TIPO_BRECHA:
			title = "Cantidad de riesgos por Tipo de Brecha";
			break;
		case TIPO_IMPACTO:
			title = "Cantidad de riesgos por Tipo de Impacto";
			break;
		case TIPO_TRATAMIENTO:
			title = "Cantidad de riesgos por Tipo de Tratamiento";
			break;
		default:
			break;
		}
		return title;
	}
	
	@Override
	public DashboardMapa generateDashboardMapa(String arquitectura) {
		DashboardMapa dashboard = new DashboardMapa();
		try {
			List<MapaRiesgo> data = clasificacionRiesgoRepository.getDataMapa(arquitectura);
			List<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();
			Evaluacion evaluacion = new Evaluacion();
			
			Integer critico = 0;
			Integer alto = 0;
			Integer medio = 0;
			Integer bajo = 0;
			Integer totalEvaluacion = 0;
			
			for(MapaRiesgo value: data) {				
				switch (LevelRiskType.findById(value.getIdClasificacionRiesgo())) {
					case CRITICO: 
						switch (LevelRiskType.find(value.getColorD())) {
							case CRITICO: critico = critico + value.getCritico(); break;
							case ALTO: alto = alto + value.getCritico(); break;
							case MEDIO: medio = medio + value.getCritico(); break;
							case BAJO: bajo = bajo + value.getCritico(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorC())) {
							case CRITICO: critico = critico + value.getAlto(); break;
							case ALTO: alto = alto + value.getAlto(); break;
							case MEDIO: medio = medio + value.getAlto(); break;
							case BAJO: bajo = bajo + value.getAlto(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorB())) {
							case CRITICO: critico = critico + value.getMedio(); break;
							case ALTO: alto = alto + value.getMedio(); break;
							case MEDIO: medio = medio + value.getMedio(); break;
							case BAJO: bajo = bajo + value.getMedio(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorA())) {
							case CRITICO: critico = critico + value.getBajo(); break;
							case ALTO: alto = alto + value.getBajo(); break;
							case MEDIO: medio = medio + value.getBajo(); break;
							case BAJO: bajo = bajo + value.getBajo(); break;
							default:break;
						}
						break;						
					case ALTO: 
						switch (LevelRiskType.find(value.getColorD())) {
							case CRITICO: critico = critico + value.getCritico(); break;
							case ALTO: alto = alto + value.getCritico(); break;
							case MEDIO: medio = medio + value.getCritico(); break;
							case BAJO: bajo = bajo + value.getCritico(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorC())) {
							case CRITICO: critico = critico + value.getAlto(); break;
							case ALTO: alto = alto + value.getAlto(); break;
							case MEDIO: medio = medio + value.getAlto(); break;
							case BAJO: bajo = bajo + value.getAlto(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorB())) {
							case CRITICO: critico = critico + value.getMedio(); break;
							case ALTO: alto = alto + value.getMedio(); break;
							case MEDIO: medio = medio + value.getMedio(); break;
							case BAJO: bajo = bajo + value.getMedio(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorA())) {
							case CRITICO: critico = critico + value.getBajo(); break;
							case ALTO: alto = alto + value.getBajo(); break;
							case MEDIO: medio = medio + value.getBajo(); break;
							case BAJO: bajo = bajo + value.getBajo(); break;
							default:break;
						}
					break;	
					case MEDIO: 
						switch (LevelRiskType.find(value.getColorD())) {
							case CRITICO: critico = critico + value.getCritico(); break;
							case ALTO: alto = alto + value.getCritico(); break;
							case MEDIO: medio = medio + value.getCritico(); break;
							case BAJO: bajo = bajo + value.getCritico(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorC())) {
							case CRITICO: critico = critico + value.getAlto(); break;
							case ALTO: alto = alto + value.getAlto(); break;
							case MEDIO: medio = medio + value.getAlto(); break;
							case BAJO: bajo = bajo + value.getAlto(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorB())) {
							case CRITICO: critico = critico + value.getMedio(); break;
							case ALTO: alto = alto + value.getMedio(); break;
							case MEDIO: medio = medio + value.getMedio(); break;
							case BAJO: bajo = bajo + value.getMedio(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorA())) {
							case CRITICO: critico = critico + value.getBajo(); break;
							case ALTO: alto = alto + value.getBajo(); break;
							case MEDIO: medio = medio + value.getBajo(); break;
							case BAJO: bajo = bajo + value.getBajo(); break;
							default:break;
						}
						break;	
					case BAJO:
						switch (LevelRiskType.find(value.getColorD())) {
							case CRITICO: critico = critico + value.getCritico(); break;
							case ALTO: alto = alto + value.getCritico(); break;
							case MEDIO: medio = medio + value.getCritico(); break;
							case BAJO: bajo = bajo + value.getCritico(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorC())) {
							case CRITICO: critico = critico + value.getAlto(); break;
							case ALTO: alto = alto + value.getAlto(); break;
							case MEDIO: medio = medio + value.getAlto(); break;
							case BAJO: bajo = bajo + value.getAlto(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorB())) {
							case CRITICO: critico = critico + value.getMedio(); break;
							case ALTO: alto = alto + value.getMedio(); break;
							case MEDIO: medio = medio + value.getMedio(); break;
							case BAJO: bajo = bajo + value.getMedio(); break;
							default:break;
						}
						switch (LevelRiskType.find(value.getColorA())) {
							case CRITICO: critico = critico + value.getBajo(); break;
							case ALTO: alto = alto + value.getBajo(); break;
							case MEDIO: medio = medio + value.getBajo(); break;
							case BAJO: bajo = bajo + value.getBajo(); break;
							default:break;
						}
						break;
					default:break;
				}
			}
			
			totalEvaluacion = critico + alto + medio + bajo;
			
			if(totalEvaluacion != 0) {
				evaluaciones.add(new Evaluacion("Critico", critico, Double.valueOf((critico * 100) / totalEvaluacion)));
				evaluaciones.add(new Evaluacion("Alto", alto, Double.valueOf((alto * 100) / totalEvaluacion)));
				evaluaciones.add(new Evaluacion("Medio", medio, Double.valueOf((medio * 100) / totalEvaluacion)));
				evaluaciones.add(new Evaluacion("Bajo", bajo, Double.valueOf((bajo * 100) / totalEvaluacion)));
				
				evaluacion = evaluaciones.stream().max(Comparator.comparing(Evaluacion::getTotal)).get();
			}
			
			
			dashboard.setData(data);
			dashboard.setEvaluacion(evaluaciones);
			dashboard.setResultado(evaluacion.getNivelRiesgo());
			dashboard.setPieChart(ChartType.getPie(null, evaluaciones, evaluacion));
			dashboard.setRadarChart(ChartType.getRadar(evaluaciones));
			dashboard.setBarChart(ChartType.getBar(evaluaciones));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dashboard;
	}

	

	
}
