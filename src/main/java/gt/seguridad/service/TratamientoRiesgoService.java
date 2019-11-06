package gt.seguridad.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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
import gt.seguridad.model.catalogos.Solucion;
import gt.seguridad.model.riesgo.EvaluacionRiesgo;
import gt.seguridad.model.riesgo.TratamientoRiesgo;
import gt.seguridad.pojo.PickList;
import gt.seguridad.repository.catalogos.ArquitecturaAplicacionRepository;
import gt.seguridad.repository.catalogos.SolucionRepository;
import gt.seguridad.repository.riesgo.EvaluacionRiesgoRepository;
import gt.seguridad.repository.riesgo.TratamientoRiesgoRepository;
import gt.seguridad.service.impl.ITratamientoService;

@Service
public class TratamientoRiesgoService implements ITratamientoService {
	
	@Autowired
	private TratamientoRiesgoRepository tratamientoRiesgoRepository;
	@Autowired
	private EvaluacionRiesgoRepository evaluacionRiesgoRepository;
	@Autowired
	private SolucionRepository solucionRepository;
	@Autowired
	private ArquitecturaAplicacionRepository arquitecturaAplicacionRepository;
	@Autowired
	private EvaluacionRiesgoService evaluacionRiesgoService;

	@Override
	public void save(TratamientoRiesgo tratamiento) throws Exception {
		try {
			Long id = tratamientoRiesgoRepository.getId();
			if(tratamiento.getIdTratamientoRiesgo() == null)
				tratamiento.setIdTratamientoRiesgo(id.intValue());
			tratamientoRiesgoRepository.save(tratamiento);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void delete(TratamientoRiesgo tratamiento) throws Exception {
		try {
			Long id = tratamientoRiesgoRepository.getId();
			if(tratamiento.getIdTratamientoRiesgo() == null)
				tratamiento.setIdTratamientoRiesgo(id.intValue());
			tratamientoRiesgoRepository.delete(tratamiento);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Solucion> listTratamientosTarget(Integer correlativo) {
		try {
			return solucionRepository.listTratamientosTarget(correlativo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Solucion> listTratamientosSource(Integer correlativo) {
		try {
			return solucionRepository.listTratamientosSource(correlativo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	@Override
	public void save(PickList<Solucion> data) throws Exception {
		try {
			//tratamientoRiesgoRepository.deleteTratamientos(data.getId());
			List<TratamientoRiesgo> tratamientos = tratamientoRiesgoRepository.listByCorrelativo(data.getId());
			
			
			 tratamientoRiesgoRepository.delete(tratamientos);
			
		
			for(Solucion solucion: data.getTarget()) {
				TratamientoRiesgo tratamiento = new TratamientoRiesgo();
				Long id = tratamientoRiesgoRepository.getId();
				if(tratamiento.getIdTratamientoRiesgo() == null)
					tratamiento.setIdTratamientoRiesgo(id.intValue());
				tratamiento.setCorrelativo(evaluacionRiesgoRepository.findByIdRiesgo(data.getId()));
				tratamiento.setIdSolucion(solucion);				
				tratamientoRiesgoRepository.save(tratamiento);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public ByteArrayOutputStream document() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			
			List<ArquitecturaAplicacion> arquitecturas = arquitecturaAplicacionRepository.findAll();
			
			for(ArquitecturaAplicacion arquitectura: arquitecturas) {
				List<EvaluacionRiesgo> evaluaciones = evaluacionRiesgoService.listEvaluadosAplica(arquitectura.getIdArquitectura());
				
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
					

					sheet.setColumnWidth(4, calculateColumnWidth(35));
					sheet.setColumnWidth(10, calculateColumnWidth(35));
					
					for (int x = 0; x < sheet.getRow(1).getPhysicalNumberOfCells(); x++) {
				        if(x != 4 && x != 10) {
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
		cellStyleWrap.setVerticalAlignment(VerticalAlignment.TOP);
		cellStyleWrap.setAlignment(HorizontalAlignment.LEFT);
		
		Cell cell = row.createCell(cellCount);		
		cell.setCellValue(evaluacion.getIdRiesgo().getId());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getIdentificador());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getNivel());
		cell.setCellStyle(createStyleData(sheet, null, evaluacion.getNivel(), "complex"));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdTipoTratamiento().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getNombre());
		cell.setCellStyle(cellStyleWrap);
		
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
		cell.setCellValue(evaluacion.getIdRiesgo().getIdResponsable().getNombre());
		cell.setCellStyle(createStyleData(sheet));		
						
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getIdGeneradorRiesgo().getNombre());
		cell.setCellStyle(createStyleData(sheet));
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(evaluacion.getIdRiesgo().getAccionCorrectiva());
		cell.setCellStyle(cellStyleWrap);
		
		cell = row.createCell(++cellCount);
		cell.setCellValue(getSoluciones(evaluacion));
		cell.setCellStyle(cellStyleWrap);
		
		cell = row.createCell(++cellCount);
		cell.setCellValue("");
		
		cell = row.createCell(++cellCount);
		cell.setCellValue("");
		
		
	}
	
	public String getSoluciones(EvaluacionRiesgo evaluacion) {
		
		if(evaluacion.getSoluciones().isEmpty()) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator<Solucion> it = evaluacion.getSoluciones().iterator();
		while(it.hasNext()) {
			Solucion solucion = it.next();
			
			sb.append("* ");
			sb.append(solucion.getNombre());
			if(it.hasNext()) {
				sb.append(", ");
			}else {
				sb.append(".");
			}
		}
		return sb.toString();
	}
	
	public void writeCellHeader(Row row, CellStyle cellStyle) {
		int cellCount = 0;
		
		Cell cell = row.createCell(cellCount);		
		cell.setCellValue("ID");
		cell.setCellStyle(cellStyle);
		
		cell = row.createCell(++cellCount);
		cell.setCellValue("Clasificacion del Riesgo");
		cell.setCellStyle(cellStyle);
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Nivel de Riesgo");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Tratamiento del Riesgo");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Riesgo");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Clasificacion");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Tipo de Riesgo");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Tipo de Impacto");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Responsable");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Generador del Riesgo");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Accion Correctiva");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Solucion");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Fecha limite para aplicar accion correctiva");
		
		cell = row.createCell(++cellCount);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Observacion Seguimiento");
					
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
