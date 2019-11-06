/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.seguridad.utils;

/**
 *
 * @author ejmorales
 */
public class UrlPath {
    
    public static final String GENERALES = "/generales";
    public static final String RIESGO = "/riesgo";
    public static final String EVALUACION = "/evaluacion" + RIESGO;
    public static final String DASHBOARD = "/dashboard";
   
    
    public static final String GUARDAR = "/save";
    public static final String LISTAR = "/list";
    public static final String DELETE = "/delete";
    public static final String FIND = "/find";
    public static final String NO_EVALUADOS = LISTAR + "/not/use";
    public static final String LISTAR_EVALUADOS = LISTAR + "/evaluados";
    
    public static final String TIPO = "/tipo";
    public static final String GENERADOR = "/generador";
    public static final String TRATAMIENTO = "/tratamiento";
    public static final String BRECHA = "/brecha";
    public static final String IMPACTO = "/impacto";
    public static final String CLASIFICACION = "/clasificacion";
    public static final String ARQUITECTURA = "/arqui";
    public static final String APP = "/app";
    public static final String ACTIVO = "/activo";
    public static final String RESPONSABLE = "/responsable";
    public static final String ADD = "/add";
    public static final String CAPA = "/capa";
    public static final String SOLUCION = "/solucion";
    public static final String PICK_LIST = "/picklist";
    
    public static final String SAVE_PICK_LIST = PICK_LIST + GUARDAR;
    public static final String RIESGO_CAPA = RIESGO + CAPA;
    public static final String TRATAMIENTO_RIESGO= TRATAMIENTO + RIESGO;
    public static final String LIST_CLASIFICACION = LISTAR + CLASIFICACION;
    public static final String GENERALES_ADD = GENERALES + ADD;
    public static final String TIPO_TRATAMIENTO = TIPO + TRATAMIENTO;
    public static final String GENERADOR_RIESGO = GENERADOR + RIESGO;
    public static final String TIPO_BRECHA = TIPO + BRECHA;
    public static final String TIPO_IMPACTO = TIPO + IMPACTO;
    public static final String TIPO_RIESGO = TIPO + RIESGO;
    public static final String ARQUITECTURA_APP = ARQUITECTURA + APP;

}
