package gt.seguridad.service.impl;

import java.util.List;

import gt.seguridad.pojo.Dashboard;
import gt.seguridad.pojo.DashboardMapa;
import gt.seguridad.pojo.Data;
import gt.seguridad.pojo.MapaRiesgo;

public interface IDashboardService {
	public List<MapaRiesgo> getInfoDashBoardMapa(String arquitectura);
	public List<Data> getInfoDashboard(Integer selectedType, String idArquitectura);
	public Dashboard generateDashboard(Integer selectedType, String idArquitectura);
	public DashboardMapa generateDashboardMapa(String arquitectura);
}
