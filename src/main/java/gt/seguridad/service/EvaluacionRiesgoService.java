package gt.seguridad.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gt.seguridad.enums.LevelRiskType;
import gt.seguridad.model.catalogos.ArquitecturaAplicacion;
import gt.seguridad.model.riesgo.ClasificacionRiesgo;
import gt.seguridad.model.riesgo.EvaluacionRiesgo;
import gt.seguridad.model.riesgo.Riesgo;
import gt.seguridad.repository.catalogos.ArquitecturaAplicacionRepository;
import gt.seguridad.repository.riesgo.ClasificacionRiesgoRepository;
import gt.seguridad.repository.riesgo.EvaluacionRiesgoRepository;
import gt.seguridad.service.impl.IEvaluacionService;

@Service
public class EvaluacionRiesgoService implements IEvaluacionService {

	@Autowired
	private EvaluacionRiesgoRepository evaluacionRiesgoRepository;

	@Autowired
	private ClasificacionRiesgoRepository clasificacionRiesgoRepository;
	
	@Autowired
	private ArquitecturaAplicacionRepository arquitecturaAplicacionRepository;

	@Override
	public List<EvaluacionRiesgo> listEvaluadosAplica(Integer selectedArq) {
		try {
			/*
			 * List<EvaluacionRiesgo> evaluaciones = evaluacionRiesgoRepository.findAll(new
			 * Sort(Sort.Direction.ASC, "idRiesgo.idRiesgoCapa.idRiesgoCapa",
			 * "idRiesgo.idTipoRiesgo.idTipoRiesgo", "idRiesgo.idTipoImpacto.idTipoImpacto",
			 * "idRiesgo.idTipoBrecha.idTipoBrecha"));
			 */
			List<EvaluacionRiesgo> evaluaciones = evaluacionRiesgoRepository.listAllByArq(selectedArq);

			int count = 0;

			for (EvaluacionRiesgo eval : evaluacionRiesgoRepository.listAll()) {
				count++;
				if (eval.getIdArquitectura().getIdArquitectura().equals(selectedArq)) {
					break;
				}
			}

			for (EvaluacionRiesgo evaluacion : evaluaciones) {
				Riesgo riesgo = evaluacion.getIdRiesgo();
				riesgo.setId(count);
				if (count < 10) {
					riesgo.setIdentificador("R-00" + count);
				} else if (count < 100) {
					riesgo.setIdentificador("R-0" + count);
				}

				Integer value = evaluacion.getProbabilidad() * evaluacion.getImpacto();
				evaluacion.setCalificacion(value);
				ClasificacionRiesgo clasificacionP = getClasificacion("single", evaluacion.getProbabilidad());
				ClasificacionRiesgo clasificacionI = getClasificacion("single", evaluacion.getImpacto());
				ClasificacionRiesgo clasificacion = getClasificacion("calc", value);
				evaluacion.setNivel(clasificacion.getNombre());
				evaluacion.setNivelProbabilidad(clasificacionP.getNombre());
				evaluacion.setNivelImpacto(clasificacionI.getNombre());

				count++;
			}

			return evaluaciones;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	@Override
	public List<EvaluacionRiesgo> listEvaluaciones(Integer selectedArq) {
		try {
			/*
			 * List<EvaluacionRiesgo> evaluaciones = evaluacionRiesgoRepository.findAll(new
			 * Sort(Sort.Direction.ASC, "idRiesgo.idRiesgoCapa.idRiesgoCapa",
			 * "idRiesgo.idTipoRiesgo.idTipoRiesgo", "idRiesgo.idTipoImpacto.idTipoImpacto",
			 * "idRiesgo.idTipoBrecha.idTipoBrecha"));
			 */
			List<EvaluacionRiesgo> evaluaciones = evaluacionRiesgoRepository.listAllByArq(selectedArq);

			int count = 0;

			for (EvaluacionRiesgo eval : evaluacionRiesgoRepository.listAll()) {
				count++;
				if (eval.getIdArquitectura().getIdArquitectura().equals(selectedArq)) {
					break;
				}
			}

			for (EvaluacionRiesgo evaluacion : evaluaciones) {
				Riesgo riesgo = evaluacion.getIdRiesgo();
				riesgo.setId(count);
				if (count < 10) {
					riesgo.setIdentificador("R-00" + count);
				} else if (count < 100) {
					riesgo.setIdentificador("R-0" + count);
				}

				Integer value = evaluacion.getProbabilidad() * evaluacion.getImpacto();
				evaluacion.setCalificacion(value);
				ClasificacionRiesgo clasificacionP = getClasificacion("single", evaluacion.getProbabilidad());
				ClasificacionRiesgo clasificacionI = getClasificacion("single", evaluacion.getImpacto());
				ClasificacionRiesgo clasificacion = getClasificacion("calc", value);
				evaluacion.setNivel(clasificacion.getNombre());
				evaluacion.setNivelProbabilidad(clasificacionP.getNombre());
				evaluacion.setNivelImpacto(clasificacionI.getNombre());

				count++;
			}

			return evaluaciones;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	private ClasificacionRiesgo getClasificacion(String tipo, Integer value) {
		try {
			if (tipo.equalsIgnoreCase("single")) {
				return clasificacionRiesgoRepository.findOne(value);
			} else if (tipo.equalsIgnoreCase("calc")) {
				return clasificacionRiesgoRepository.getClasificacionRiesgo(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public EvaluacionRiesgo findEvaluacion(Integer idEvaluacionRiesgo) {
		try {
			return evaluacionRiesgoRepository.findOne(idEvaluacionRiesgo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void save(EvaluacionRiesgo evaluacion) throws Exception {
		try {
			Long id = evaluacionRiesgoRepository.getId();
			if (evaluacion.getCorrelativo() == null)
				evaluacion.setCorrelativo(id.intValue());
			evaluacionRiesgoRepository.save(evaluacion);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void delete(EvaluacionRiesgo evaluacion) throws Exception {
		try {
			evaluacionRiesgoRepository.delete(evaluacion);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public EvaluacionRiesgo findEvaluacionByRiesgo(Integer idRiesgo) {
		try {
			return evaluacionRiesgoRepository.findByIdRiesgo(idRiesgo);
		} catch (NoResultException nr) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ByteArrayOutputStream document() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			
			List<ArquitecturaAplicacion> arquitecturas = arquitecturaAplicacionRepository.findAll();
			
			for(ArquitecturaAplicacion arquitectura: arquitecturas) {
				List<EvaluacionRiesgo> evaluaciones = this.listEvaluaciones(arquitectura.getIdArquitectura());
				
				if(!evaluaciones.isEmpty()) {
					XSSFSheet sheet = workbook.createSheet(arquitectura.getNombre().toLowerCase());
					CellStyle cellStyleHeader = createStyleHeader(sheet);
					
					int rowCount = 0;
					Row row = sheet.createRow(++rowCount);
					writeCellHeader(row, cellStyleHeader);
					
					for(EvaluacionRiesgo evaluacion: evaluaciones) {
						Row rowData = sheet.createRow(++rowCount);												
						writeCellData(rowData, evaluacion, sheet);
						
					}
					

					sheet.setColumnWidth(1, calculateColumnWidth(35));
					
					for (int x = 0; x < sheet.getRow(1).getPhysicalNumberOfCells(); x++) {
				        if(x != 1) {
				        	sheet.autoSizeColumn(x);
				        }						
				  }
					
				}
			}
			
			workbook.write(baos);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		return baos;
	}
	
	private int calculateColumnWidth(int width) {
		if(width > 1) {
			int floor = (int)(Math.floorDiv(width, 5));
			int factor = (30*floor);
			int value = 450 + factor + ((width-1) *250);
			
			return value;
		}else {
			return 450;
		}
	}
	
	public void writeCellData(Row row, EvaluacionRiesgo evaluacion, XSSFSheet sheet) {
		int cellCount = 0;
		CellStyle cellStyleWrap = sheet.getWorkbook().createCellStyle();
		cellStyleWrap.setWrapText(true);
		
		Cell cell = row.createCell(cellCount);		
		cell.setCellValue(evaluacion.getIdRiesgo().getId());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getDescripcion());
		cell.setCellStyle(cellStyleWrap);
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdActivo().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getIdResponsable().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getIdentificador());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdClasificacion().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getIdTipoRiesgo().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getIdTipoImpacto().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getIdTipoBrecha().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getProbabilidad());
		cell.setCellStyle(createStyleData(sheet, evaluacion.getProbabilidad(), null,"simple"));
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getImpacto());
		cell.setCellStyle(createStyleData(sheet, evaluacion.getImpacto(), null, "simple"));
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getCalificacion());
		cell.setCellStyle(createStyleData(sheet, null, evaluacion.getNivel() ,"complex"));
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getNivel());
		cell.setCellStyle(createStyleData(sheet, null, evaluacion.getNivel(), "complex"));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdTipoTratamiento().getNombre());
		cell.setCellStyle(createStyleData(sheet));
	}
	
	public void writeCellHeader(Row row, CellStyle cellStyle) {
		int cellCount = 0;
		
		Cell cell = row.createCell(cellCount);		
		cell.setCellValue("ID");
		cell.setCellStyle(cellStyle);
		cell = row.createCell(++cellCount);
		cell.setCellValue("Descripcion del Riesgo");
		cell.setCellStyle(cellStyle);
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Activo Afectado");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Propietario");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Clasificacion del Riesgo");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Clasificacion");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Tipo de Riesgo");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Tipo de impacto");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Brecha");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Probabilidad");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Impacto");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Resultado");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Nivel de Riesgo");
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Tratamiento del Riesgo");
	}
	
	private CellStyle createStyleHeader(XSSFSheet sheet) {
		CellStyle cellStyleHeader = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 12);
		cellStyleHeader.setFont(font);
		cellStyleHeader.setAlignment(HorizontalAlignment.CENTER);
		cellStyleHeader.setVerticalAlignment(VerticalAlignment.CENTER);
		return cellStyleHeader;
		
	}
	
	private CellStyle createStyleData(XSSFSheet sheet) {
		CellStyle cellStyleHeader = sheet.getWorkbook().createCellStyle();		
		cellStyleHeader.setAlignment(HorizontalAlignment.CENTER);
		cellStyleHeader.setVerticalAlignment(VerticalAlignment.CENTER);
		return cellStyleHeader;
		
	}
	
	private CellStyle createStyleData(XSSFSheet sheet, Integer value, String type, String tipo) {
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		if(tipo == "simple") {
			switch (value) {
			case 1: 
				cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				break;
			case 2:
				cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				break;
			case 3:
				cellStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				break;
			case 4:
				cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				break;
			default:
				break;
			}
		}else {
			switch (LevelRiskType.find(type)) {
			case BAJO:
				cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);				
				break;
			case MEDIO:
				cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);				
				break;
			case ALTO:
				cellStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);				
				break;
			case CRITICO:
				cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);				
				break;
			default:
				break;
			}
		}
		cellStyle.setFont(font);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		return cellStyle;
		
	}
}
