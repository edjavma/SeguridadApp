package gt.seguridad.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gt.seguridad.pojo.Dashboard;
import gt.seguridad.pojo.DashboardMapa;
import gt.seguridad.service.DashboardService;
import gt.seguridad.utils.UrlPath;

@RestController
@RequestMapping(value = UrlPath.DASHBOARD)
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(value = "/generar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Dashboard generar(@RequestParam("selectedType") Integer selectedType) {
		try {
			return dashboardService.generateDashboard(selectedType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/generar/mapa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public DashboardMapa generar(@RequestParam(value = "idArquitectura", required = false) String idArquitectura) {
		try {
			if(idArquitectura == null) {
				idArquitectura = "";
			}else if(idArquitectura.equalsIgnoreCase("undefined")) {
				idArquitectura = "";
			}
			return dashboardService.generateDashboardMapa(idArquitectura);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
